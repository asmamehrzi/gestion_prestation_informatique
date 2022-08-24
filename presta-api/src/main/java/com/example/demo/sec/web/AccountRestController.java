package com.example.demo.sec.web;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.sec.JWTUtil;
import com.example.demo.sec.jwt.JwtProvider;
import com.example.demo.sec.model.AppRole;
import com.example.demo.sec.model.AppUser;
import com.example.demo.sec.repository.AppUserReository;
import com.example.demo.sec.service.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.FORBIDDEN;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class
AccountRestController {

    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private AppUserReository appUserReository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private PasswordEncoder encoder;

    public AccountRestController() {
    }


    @GetMapping(path = "/users")
    public List<AppUser> appusers() {
        return accountService.listUsers();
    }

    @PostMapping(path = "/users/register")
    public AppUser saveUser(@RequestBody AppUser appUser) {
        return accountService.addNewUser(appUser);
    }

    @PostMapping(path = "users/roles", consumes = "application/json", produces = "application/json")
    public AppRole saveRole(@RequestBody AppRole appRole) {

        return accountService.addNewRole(appRole);
    }

    @PostMapping(path = "users/addRoleToUser")
    public void addRoleToUser(@RequestBody RoleUserForm roleUserForm) {
        accountService.addRoleToUser(roleUserForm.getUsername(), roleUserForm.getRolename());
    }

    @GetMapping(path = "users/refreshToken")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String authToken = request.getHeader(JWTUtil.AUTH_HEADER);
        if (authToken != null && authToken.startsWith(JWTUtil.PREFIX)) {
            try {
                String jwt = authToken.substring(JWTUtil.PREFIX.length());
                Algorithm algorithm = Algorithm.HMAC256(JWTUtil.SECRET);
                JWTVerifier jwtVerifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = jwtVerifier.verify(jwt);
                String username = decodedJWT.getSubject();
                AppUser appUser = accountService.loadUserByUsername(username);

                String jwtAccessToken = JWT.create()
                        .withSubject(appUser.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis() + JWTUtil.EXPIRE_ACCESS_TOKEN))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles", appUser.getAppRoles().stream().map(r -> r.getRoleName()).collect(Collectors.toList()))
                        .sign(algorithm);
                Map<String, String> idToken = new HashMap<>();
                idToken.put("accesstoken", jwtAccessToken);
                idToken.put("refreshtoken", jwt);
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), idToken);
            } catch (Exception e) {
                //  throw e;
                response.setHeader("error", e.getMessage());
                response.setStatus(FORBIDDEN.value());
                Map<String, String> error = new HashMap<>();
                error.put("error_message", e.getMessage());
                response.setContentType(MimeTypeUtils.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }

        } else {
            throw new RuntimeException("Refresh token required!");
        }
    }

    @GetMapping(path = "/users/profile")
    public AppUser profile(Principal principal) {
        return accountService.loadUserByUsername(principal.getName());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<AppUser> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok().body(accountService.getUserById(id).getBody());
    }

    @DeleteMapping("users/delete/{id}")
    public String deleteUser(@PathVariable(value = "id") Long Id) {
        return accountService.deleteUser(Id);
    }

  /*  @PostMapping("/login")
    public Map<String, Object> loginHandler(@RequestBody Login body){
        try {
            UsernamePasswordAuthenticationToken authInputToken =
                    new UsernamePasswordAuthenticationToken(body.getUsername(), body.getPassword());

            authenticationManager.authenticate(authInputToken);

            String token = jwtProvider.generateJwtToken(body.getUsername());

            return Collections.singletonMap("jwt-token", token);
        }catch (AuthenticationException authExc){
            throw new RuntimeException("Invalid Login Credentials");
        }
    }*/
    @PostMapping("/register")
    public Map<String, Object> registerHandler(@RequestBody AppUser user){
        String encodedPass = encoder.encode(user.getPassword());
        user.setPassword(encodedPass);
        user = appUserReository.save(user);
        String token = jwtProvider.generateJwtToken(user.getUsername());
        return Collections.singletonMap("jwt-token", token);
    }

    @Data
    class RoleUserForm {
        private String username;
        private String rolename;
    }
}
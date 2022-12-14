package com.example.demo.sec.filters;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.sec.JWTUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.FORBIDDEN;

@Slf4j
public class JWTAuthorizationFilter extends OncePerRequestFilter{
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers,authorization");
        response.addHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Origin, Access-Control-Allow-Credentials, authorization");
        if(request.getMethod().equals("OPTIONS")){
            response.setStatus(HttpServletResponse.SC_OK);
        }
       else if(request.getServletPath().equals("/api/login") || request.getServletPath().equals("/users/refreshToken")){
           filterChain.doFilter(request,response);
             return;
       }else{
           String authorizationToken=request.getHeader(JWTUtil.AUTH_HEADER);
           if(authorizationToken!=null && authorizationToken.startsWith(JWTUtil.PREFIX)){
               try{
                   String jwt=authorizationToken.substring(JWTUtil.PREFIX.length());
                   Algorithm algorithm=Algorithm.HMAC256(JWTUtil.SECRET);
                   JWTVerifier jwtVerifier=JWT.require(algorithm).build();
                   DecodedJWT decodedJWT=jwtVerifier.verify(jwt);
                   String username=decodedJWT.getSubject();
                   String[] roles=decodedJWT.getClaim("roles").asArray(String.class);
                   Collection<GrantedAuthority> authorities=new ArrayList<>();
                   for(String r:roles){
                       authorities.add(new SimpleGrantedAuthority(r));
                   }
                   UsernamePasswordAuthenticationToken authenticationToken=
                           new UsernamePasswordAuthenticationToken(username,null,authorities);
                   SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                   filterChain.doFilter(request,response);
               } catch (Exception e){
                   log.error("Error logging in : {}",e.getMessage());
                   response.setHeader("error",e.getMessage());
                   response.setStatus(FORBIDDEN.value());
                   //response.sendError(FORBIDDEN.value());
                   Map<String, String> error = new HashMap<>();
                   error.put("error_message",e.getMessage());
                   response.setContentType(MimeTypeUtils.APPLICATION_JSON_VALUE);
                   new ObjectMapper().writeValue(response.getOutputStream(), error);
               }
           }
          else{
               filterChain.doFilter(request,response);
                    return;
           }
       }

    }
}

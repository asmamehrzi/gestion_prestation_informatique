package com.example.demo.sec;


public class JWTUtil {
    public  static  final String SECRET="mySecret";
    public  static final String AUTH_HEADER="Authorization";
    public static final long EXPIRE_ACCESS_TOKEN=20*60*1000;
    public static final long EXPIRE_REFRESH_TOKEN=40*60*1000;
    public static final String PREFIX="Bearer ";

}

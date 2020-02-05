package com.aconcaguasf.prestamosapp.security;

public class JwtProperties {
    public static final String SECRET = "JWTClave";
    public static final int EXPIRATION_TIME = 864_000_000; // 10 dias
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}

package com.adniyo.CentricGateway.security;

public class SecurityConstants {
	public static final String SECRET = System.getenv().get("SECRET");
	public static final long EXPIRATION_TIME = Long.parseLong(System.getenv().get("EXPIRATION_TIME"));
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String SIGN_UP_URL = "/users/sign-up";
}
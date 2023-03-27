package com.ev.workshop.api.tractorworkshop.Utilities;

public class JwtUtils
{
    public static String SECURITY_KEY = "strongKey"; 
    public static String JWT_PREFIX = "bearer"; 
    public static String JWT_HEADER_PREFIX = "Authorization"; 
    public static long JWT_TOKEN_TIMEOUT = 60*5000;
}

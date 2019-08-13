package com.course.config;

import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;



public class TestConfig {
    public static String loginUrl="http://localhost:8888/v1/login";
    public static String updateUserInfoUrl;
    public static String getUserListUrl;
    public static String getUserInfoUrl;
    public static String addUserUrl;
    public static CloseableHttpClient defaultHttpClient;
    public static CloseableHttpClient httpClient;
    public static CookieStore store;
}

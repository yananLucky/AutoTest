package com.course.config;

import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;



public class TestConfig {
    public static String loginUrl="http://localhost:8888/v1/login";
    public static String updateUserInfoUrl="http://localhost:8888/v1/updateUserInfo";
    public static String getUserListUrl="http://localhost:8888/v1/getUserInfo";
    public static String getUserInfoUrl="http://localhost:8888/v1/getUserInfo";
    public static String addUserUrl="http://localhost:8888/v1/addUser";
    public static CloseableHttpClient defaultHttpClient;
    public static CloseableHttpClient httpClient;
    public static CookieStore store;
}

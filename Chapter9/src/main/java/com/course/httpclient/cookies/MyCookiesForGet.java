package com.course.httpclient.cookies;

import org.apache.http.client.methods.HttpGet;
import org.testng.annotations.BeforeTest;

import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {
    private String url;
    private ResourceBundle bundle;

    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url=bundle.getString("test.url");
    }

    public void testGetCookies(){
        String result;
        HttpGet get=new HttpGet();

    }
}

package com.course6666.httpclient.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyHttpClient {
    @Test
    public void test1() throws IOException {
        //store response result
        String result;
        HttpGet get=new HttpGet("http://www.baidu.com");
        HttpClient client=new DefaultHttpClient() ;
        HttpResponse response=client.execute(get);
        result= EntityUtils.toString(response.getEntity());
        System.out.println(result);

    }
}

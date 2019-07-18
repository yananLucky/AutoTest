package com.course6666.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {
    private String url;
    private ResourceBundle bundle;
    private CookieStore store;

    @BeforeTest
    public void beforeTest() {
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }

    @Test
    public void testGetCookies() throws IOException {
        String result;
        System.out.println(this.url + bundle.getString("getCookies.uri"));
        HttpGet get = new HttpGet(this.url + bundle.getString("getCookies.uri"));
        DefaultHttpClient client = new DefaultHttpClient();
        //CloseableHttpClient client= HttpClientBuilder.create().build();
        HttpResponse resonse = client.execute(get);
        result = EntityUtils.toString(resonse.getEntity(),"gb2312");
        System.out.println(result);
         this.store=client.getCookieStore();
         List<Cookie> cookieList=store.getCookies();
         for(Cookie cookie:cookieList){
             String name=cookie.getName();
             String value=cookie.getValue();
             System.out.println("cookie info: "+name+" "+value);
         }
    }
    @Test(dependsOnMethods = {"testGetCookies"})
    public void testGetWithCookies() throws IOException {
        String uri=bundle.getString("test.get.with.cookies");
        String testUrl=this.url+uri;
        HttpGet get=new HttpGet(testUrl);
        DefaultHttpClient client=new DefaultHttpClient();
        client.setCookieStore(this.store);
        HttpResponse response=client.execute(get);
        int statusCode=response.getStatusLine().getStatusCode();
        if(statusCode==200){
            String result=EntityUtils.toString(response.getEntity(),"gb2312");
            System.out.println("result: "+result);
        }
        System.out.println("statusCode: "+statusCode);

    }

}

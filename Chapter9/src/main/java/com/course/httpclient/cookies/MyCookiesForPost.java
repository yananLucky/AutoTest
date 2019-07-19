package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {
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
    public void testPostWithCookies() throws IOException {
        String uri=bundle.getString("test.post.with.cookies");
        String testUrl=this.url+uri;
        /**
         * 声明post对象
         * 声明client
         * 添加参数
         * 设置cookies
         * 设置header
         * 添加参数到方法中
         * 执行client
         */
        DefaultHttpClient client=new DefaultHttpClient();
        HttpPost post=new HttpPost(testUrl);
        JSONObject param=new JSONObject();
        param.put("name","huhansan");
        param.put("age","18");
        post.setHeader("Content-Type","application/json");
        StringEntity entity=new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        String result;
        client.setCookieStore(this.store);
        HttpResponse response=client.execute(post);
        result=EntityUtils.toString(response.getEntity(),"utf-8");
        JSONObject resultJson=new JSONObject(result);
        String success=(String)resultJson.get("huhansan");
        System.out.println("success:  "+success);
        Assert.assertEquals("success",success);

    }
}

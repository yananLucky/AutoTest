package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.InterfaceName;
import com.course.model.LoginCase;
import com.course.utils.ConfigFile;
import com.course.utils.DatabaseUtil;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class LoginTest {
    @BeforeTest(groups = "loginTrue",description = "测试前准备工作")
    public void beforeTest(){
        TestConfig.defaultHttpClient= HttpClientBuilder.create().build();
        //TestConfig.getUserInfoUrl= ConfigFile.getUrl(InterfaceName.GETUSERINFO);
        //TestConfig.addUserUrl=ConfigFile.getUrl(InterfaceName.ADDUSERINFO);
        //TestConfig.getUserListUrl=ConfigFile.getUrl(InterfaceName.GETUSERLIST);
       // System.out.println("enm:"+TestConfig.loginUrl);
        //TestConfig.loginUrl=ConfigFile.getUrl(InterfaceName.LOGIN);
       // TestConfig.updateUserInfoUrl=ConfigFile.getUrl(InterfaceName.UPDATEUSERINFO);

        //
    }
    @Test(groups = "loginTrue",description = "用户登录成功接口测试")
    public void loginTrue() throws IOException {
        SqlSession session= DatabaseUtil.getSqlSession();
        LoginCase loginCase=session.selectOne("loginCase",1);
        System.out.println("loginTrue:"+loginCase.toString());
        System.out.println("loginUrl:"+TestConfig.loginUrl);

        //下边的代码为写完接口的测试代码
        String result = getResult(loginCase);
        //处理结果，就是判断返回结果是否符合预期
        Assert.assertEquals(loginCase.getExpected(),result);
        System.out.println("loginTrue end");

    }

    private String getResult(LoginCase loginCase) throws IOException {
        HttpPost post=new HttpPost(TestConfig.loginUrl);
        JSONObject param =new JSONObject();

        param.put("userName",loginCase.getUserName());
        param.put("password",loginCase.getPassword());
        post.setHeader("content-type","application/json");
        System.out.println("param:"+param.toString());
        StringEntity entity=new StringEntity(param.toString());
        post.setEntity(entity);
        String result;
        HttpResponse response=TestConfig.defaultHttpClient.execute(post);
        result= EntityUtils.toString(response.getEntity(),"utf-8");
        HttpClientContext httpClientContext=HttpClientContext.create();;
        TestConfig.store=httpClientContext.getCookieStore();
        // TestConfig.store=TestConfig.defaultHttpClient.getCookieStore();
        System.out.println("login result:"+result);
        return result;
    }

    @Test(groups = "loginFalse",description = "用户登录失败接口测试")
    public void loginFalse() throws IOException {
        SqlSession session=DatabaseUtil.getSqlSession();
        LoginCase loginCase=session.selectOne("loginCase",2);
        System.out.println(loginCase.toString());
        System.out.println(TestConfig.loginUrl);
    }

/*    public static void main(String[] args) {
        CloseableHttpClient httpClient= HttpClientBuilder.create().build();
    }*/
}

package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.GetUserListCase;
import com.course.model.User;
import com.course.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class GetUserInfoListTest {

    @Test(dependsOnGroups="loginTrue",description = "获取")
    public void getUserListInfo() throws IOException {
        SqlSession session= DatabaseUtil.getSqlSession();
        GetUserListCase getUserListCase=session.selectOne("getUserListCase",1);
        System.out.println("获取getUserList库中取出的内容"+getUserListCase.toString());
        System.out.println("getUserListUrl:"+ TestConfig.getUserListUrl);
        //发送请求获取结果
        JSONArray resultJson=getJsongResult(getUserListCase);

        //验证
        List<User> userList=session.selectList(getUserListCase.getExpacted(),getUserListCase);
        for (User u:userList){
            System.out.println("userListInfo:"+u.toString());

        }
        JSONArray userListJson=new JSONArray(userList);
        Assert.assertEquals(userListJson.length(),resultJson.length());

        for(int i=0;i<resultJson.length();i++){
            JSONObject expect=(JSONObject) resultJson.get(i);
            JSONObject actual =(JSONObject) userListJson.get(i);
            Assert.assertEquals(actual.toString(),expect.toString());
        }


    }

    public JSONArray getJsongResult(GetUserListCase getUserListCase) throws IOException {
        HttpPost post=new HttpPost(TestConfig.getUserListUrl);
        post.setHeader("content-type","application/json");
        JSONObject param=new JSONObject();
        param.put("userName",getUserListCase.getUserName());
        param.put("sex",getUserListCase.getSex());
        param.put("age",getUserListCase.getAge());
        StringEntity entity=new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        HttpClientContext httpClientContext=HttpClientContext.create();;
        TestConfig.store=httpClientContext.getCookieStore();
        String result;
        HttpResponse response=TestConfig.defaultHttpClient.execute(post);
        result= EntityUtils.toString(response.getEntity());
        JSONArray jsonArray=new JSONArray(result);
        return jsonArray;
    }
}

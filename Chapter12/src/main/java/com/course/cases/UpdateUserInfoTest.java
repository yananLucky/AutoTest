package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.UpdateUserInfoCase;
import com.course.model.User;
import com.course.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class UpdateUserInfoTest {

    @Test(dependsOnGroups = "loginTrue",description = "更新删除用户信息")
    public void updateUserInfo() throws IOException {
        SqlSession session= DatabaseUtil.getSqlSession();
        UpdateUserInfoCase updateUserInfoCase=session.selectOne("updateUserInfoCase",1);
        System.out.println("updateUserInfoCaseSql:"+updateUserInfoCase.toString());
        System.out.println(TestConfig.updateUserInfoUrl);
        int result=getResult(updateUserInfoCase);
        User user=session.selectOne(updateUserInfoCase.getExpected(),updateUserInfoCase);
        Assert.assertNotNull(user);
        Assert.assertNotNull(result);


    }
    @Test(dependsOnGroups = "loginTrue",description = "删除用户信息")
    public void deleteUser() throws IOException {
        SqlSession session=DatabaseUtil.getSqlSession();
        UpdateUserInfoCase updateUserInfoCase=session.selectOne("updateUserInfoCase",2);

        System.out.println("updateUserInfoCasesql:"+updateUserInfoCase.toString());
        System.out.println(TestConfig.updateUserInfoUrl);
        int result=getResult(updateUserInfoCase);
        User user=session.selectOne(updateUserInfoCase.getExpected(),updateUserInfoCase);
        Assert.assertNotNull(user);
        Assert.assertNotNull(result);

    }

    public int getResult(UpdateUserInfoCase updateUserInfoCase) throws IOException {
        HttpPost post=new HttpPost(TestConfig.updateUserInfoUrl);
        JSONObject param=new JSONObject();
        param.put("userName",updateUserInfoCase.getUserName());
        param.put("id",updateUserInfoCase.getId());
        param.put("age",updateUserInfoCase.getAge());
        param.put("sex",updateUserInfoCase.getSex());
        param.put("isDelete",updateUserInfoCase.getIsDelete());
        param.put("permission",updateUserInfoCase.getPermission());
        post.setHeader("content-type","application/json");
        StringEntity entity=new StringEntity(param.toString());
        post.setEntity(entity);
        HttpClientContext context=new HttpClientContext();
        context.setCookieStore(TestConfig.store);
        HttpResponse response=TestConfig.defaultHttpClient.execute(post,context);
        String result;
        result=EntityUtils.toString(response.getEntity(),"utf-8");
        return Integer.parseInt(result);

    }


}

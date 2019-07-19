package com.course.testng.groups;

import org.testng.annotations.*;

public class GroupsOnMethod {

    @Test(groups = "server")
    public void test1(){
        System.out.println("server group 1111");
    }

    @Test(groups = "server")
    public void test2(){
        System.out.println("server group 2222");
    }
    @Test(groups = "client")
    public void test3(){
        System.out.println("client group 11111");
    }
    @BeforeGroups("server")
public void beforeGroupOnServer(){
    System.out.println("这是服务端组运行之前的方法");
}
@AfterGroups("server")
    public void afterGroupOnServer(){
        System.out.println("这是服务端组运行之后的方法");
    }

    @BeforeGroups("client")
    public void beforeGroupOnClient(){
        System.out.println("这是客户端组运行之前的方法");
    }
    @AfterGroups("client")
    public void afterGroupOnClient(){
        System.out.println("这是客户端组运行之后的方法");
    }


}

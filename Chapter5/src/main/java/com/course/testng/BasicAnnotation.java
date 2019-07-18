package com.course6666.testng;

import org.testng.annotations.*;

public class BasicAnnotation {
    @Test
    public void testCase1(){
        System.out.println("这是case1");

    }
    @Test
    public void testCase2(){
        System.out.println("这是case2");
    }

    @BeforeMethod
    public void beforeMethodTest(){
        System.out.println("这是在测试方法前执行的");
    }
    @AfterMethod
    public void afterMethodTest(){
        System.out.println("这是在测试方法后执行的");
    }
    @BeforeClass
    public void beforeClassMethod(){
        System.out.println("这是在类执行前执行的");
    }
    @AfterClass
    public void afterClassMethod(){
        System.out.println("这是在类执行后执行的");
    }
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("测试套件前执行");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("测试套件后执行");
    }

}

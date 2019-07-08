package com.course.testng.MultiThread;

import org.testng.annotations.Test;

public class MultiThreadOnAnnotation {
    @Test(invocationCount = 10,threadPoolSize=3)
    public void test(){
        System.out.println("hello world");
        System.out.println("Thread Id: "+Thread.currentThread().getId());
    }

}

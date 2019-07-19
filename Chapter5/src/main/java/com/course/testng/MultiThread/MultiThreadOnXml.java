package com.course.testng.MultiThread;

import org.testng.annotations.Test;

public class MultiThreadOnXml {
    @Test
    public void test1() {
        System.out.println("1Thread Id: " + Thread.currentThread().getId());
    }

    @Test
    public void test2() {
        System.out.println("2Thread Id: " + Thread.currentThread().getId());
    }

    @Test
    public void test3() {
        System.out.println("3Thread Id: " + Thread.currentThread().getId());
    }
}

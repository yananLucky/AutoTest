package com.course6666.testng;

import org.testng.annotations.Test;

public class IgnoreTest {

    @Test
    public void ignore1(){
        System.out.println("ignore1 run");
    }

    @Test(enabled = true)
    public void ignore2(){
        System.out.println("ignore2 run");
    }

}


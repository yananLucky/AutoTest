package com.course6666.testng.groups;

import org.testng.annotations.Test;

@Test(groups="stu")
public class GroupsOnClass1 {
    public void stu1(){
        System.out.println("class1中的stu1运行");
    }

    public void stu2(){
        System.out.println("class1中的stu2运行");
    }
}

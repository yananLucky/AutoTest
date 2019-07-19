package com.course.bean;

import lombok.Data;

@Data//生成bean的工具注释 idea中先添加lombok plugin
public class User {
    private String name;
    private String sex;
    private String age;
    private String userName;
    private String password;
}

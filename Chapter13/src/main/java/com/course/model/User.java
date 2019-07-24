package com.course.model;

import lombok.Data;

@Data
public class User {
    private String userName;
    private int id;
    private String password;
    private String age;
    private String sex;
    private String isDelete;

}

package com.course.model;

import lombok.Data;

@Data
public class AddUserCase {
    private String expected;
    private String userName;
    private String age;
    private String sex;
    private String permission;
    private String isDelete;
}

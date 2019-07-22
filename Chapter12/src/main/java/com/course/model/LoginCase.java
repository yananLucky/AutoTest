package com.course.model;

import lombok.Data;

@Data
public class LoginCase {
    private String expected;
    private String userName;
    private String password;
}

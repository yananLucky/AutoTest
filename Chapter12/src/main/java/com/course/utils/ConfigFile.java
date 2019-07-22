package com.course.utils;

import com.course.model.InterfaceName;

import java.util.ResourceBundle;

public class ConfigFile {
    //加载config file  可以省略配置文件类型会自动加载
    private static ResourceBundle bundle=ResourceBundle.getBundle("application");

    public static String getUrl(InterfaceName name){
        String address=bundle.getString("test.url");
        String uri="";
        String testUrl;
        testUrl=address+uri;
        if (name.equals(InterfaceName.GETUSERLIST)){
            uri=bundle.getString("getUserList.uri");
        }

        if (name.equals(InterfaceName.LOGIN)){
            uri=bundle.getString("login.uri");
        }
        if (name.equals(InterfaceName.UPDATEUSERINFO)){
            uri=bundle.getString("updateUserInfo.uri");
        }
        if (name.equals(InterfaceName.ADDUSERINFO)){
            uri=bundle.getString("addUser.uri");
        }
        if (name.equals(InterfaceName.GETUSERINFO)){
            uri=bundle.getString("getUserInfo.uri");
        }
        return testUrl;
    }
}

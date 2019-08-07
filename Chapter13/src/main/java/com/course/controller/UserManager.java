package com.course.controller;

import com.course.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import lombok.val;
//import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

@Log4j
@RestController
@Api(value = "v1",description = "用户管理系统")
@RequestMapping("v1")
public class UserManager {
    //private static Logger logger=Logger.getLogger(UserManager.class);
    @Autowired
    private SqlSessionTemplate template;
    @ApiOperation(value = "登录接口",httpMethod = "POST")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Boolean login(HttpServletResponse response, @RequestBody User user){
        System.out.println("addcookie");
        int i=template.selectOne("login",user);
        //Cookie cookie=new Cookie("login","true");
        //response.addCookie(cookie);
        //org.apache.log4j.Logger log = UserManager.log;
        // log.info("登录用户是： "+user.getUserName());
        //logger.info("登录用户是："+user.getUserName());
        log.info("查询到的结果是："+i);
        if(i==1){
            log.info("登录用户是："+user.getUserName());
            return true;
        }

        return false;
    }
    @ApiOperation(value = "添加用户接口",httpMethod = "POST")
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public boolean addUser(HttpServletRequest request,@RequestBody User user){
        Boolean x=verifyCookies(request);
        int result=0;
        if(x!=null){
            result= template.insert("addUser",user);
        }
        if (result>0){
            log.info("添加新用户数量："+result);
            return true;
        }
        return false;
    }
    @ApiOperation(value="获取用户信息列表接口",httpMethod = "POST")
    @RequestMapping(value = "/getUserInfo",method = RequestMethod.POST)
    public List<User> getUserInfo(HttpServletRequest request, @RequestBody User user){
        System.out.println("2222222");
        Boolean x=verifyCookies(request);
        System.out.println("xxxxx:"+x);
        if (x==true){
            List<User> users=template.selectList("getUserInfo",user);
            System.out.println("111111111111");
            log.info("getUserInfo 获取用户数量："+users.size());
            return users;
        }else {
            return null;
        }

    }
    @ApiOperation(value = "更新/删除用户信息",httpMethod = "POST")
    @RequestMapping(value = "/updateUserInfo",method = RequestMethod.POST)
    public int updateUser(HttpServletRequest request,@RequestBody User user){
        Boolean x=verifyCookies(request);
        int i=0;
        if (x==true){
            i=template.update("updateUserInfo",user);
        }
        log.info("更新数据的条目数量为："+i);
        return i;

    }

    private Boolean verifyCookies(HttpServletRequest request){
        Cookie[] cookies=request.getCookies();
        if(Objects.isNull(cookies)){
            log.info("cookies 为空");
            System.out.println("cookies 为空");
            return false;
        }
        for(Cookie cookie:cookies){
            System.out.println(cookie.getName());
            if (cookie.getValue().equals("true"));
            return true;
        }
        return false;
    }
}

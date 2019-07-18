package com.course6666.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value="/",description = "这是我全部的get方法")
public class MyGetMethod {
    @RequestMapping(value="/getCookies",method = RequestMethod.GET)
    @ApiOperation(value="通过这个方法获取get",httpMethod = "GET")
    public String getCookies(HttpServletResponse response){
        Cookie cookie =new Cookie("login","true");

        response.addCookie(cookie);
        return "恭喜你活的cookies信息成功";
    }
    @RequestMapping(value="/get/with/cookies",method = RequestMethod.GET)
    @ApiOperation(value="需要携带cookie才能访问的get请求",httpMethod = "GET")
    public String getWithCookies(HttpServletRequest request) {
        Cookie[] cookies=request.getCookies();
        if(Objects.isNull(cookies)){
            return "必须携带cookies来";
        }
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("login")&&cookie.getValue().equals("true")){
                return "这是一个需要携带cookies信息才能访问的get请求";
            }
        }
        return "必须携带cookies来1";
    }
    /**
     * 带参数的get请求
     * 第一种 url中带key=value
     */
    @RequestMapping(value = "/get/with/param",method=RequestMethod.GET)
    @ApiOperation(value="这是需要携带参数才能访问的get请求",httpMethod = "GET")
    public Map<String,Integer> getList(@RequestParam Integer start,@RequestParam Integer end){
        Map<String,Integer> myList=new HashMap<>();
        myList.put("鞋",400);
        myList.put("干脆面",1);
        myList.put("衬衫",300);
        return myList;
    }

    /**
     * 带参数的get请求
     * url:ip:port/get/with/param/10/20  只有路径和值
     */
    @ApiOperation(value="这是需要携带参数才能访问的get请求 无参",httpMethod = "GET")
    @RequestMapping(value="/get/with/param/{start}/{end}")
    public Map<String,Integer>  myGetList(@PathVariable Integer start, @PathVariable Integer end){
        Map<String,Integer> myList=new HashMap<>();
        myList.put("鞋",400);
        myList.put("干脆面",1);
        myList.put("衬衫",300);
        return myList;
    }
}

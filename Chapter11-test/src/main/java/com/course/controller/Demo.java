package com.course.controller;

import com.course.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1")
@Api(value = "v1",description = "这是我第一个版本的demo")
public class Demo {
    @Autowired
    private SqlSessionTemplate template;

     @RequestMapping(value="/getUserCount",method = RequestMethod.GET)
    @ApiOperation(value = "获取用户数",httpMethod = "GET")
    public int getUserCount(){
        return template.selectOne("getUserCount");
    }

    @RequestMapping(value="/addUser",method = RequestMethod.POST)
    @ApiOperation(value="插入用户",httpMethod = "POST")
    public int  addUser(@RequestBody User user){
        int result=template.insert("addUser",user);
        return result;
    }
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    @ApiOperation(value="更新用户",httpMethod = "POST")
    public int updateUser(@RequestBody User user){
         int result=template.update("updateUser",user);
         return result;
    }
}

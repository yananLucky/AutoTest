package com.course.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "v1",description = "这是我第一个版本的demo")
@RequestMapping("v1")
public class Demo {

    @Autowired //启动即加载
    private SqlSessionTemplate template;




    @RequestMapping(value="/getUserCount",method = RequestMethod.GET)
    @ApiOperation(value="可以获取到用户数",httpMethod = "GET")
    public int getUserCount(){
        System.out.println("执行sql语句");
        return template.selectOne("getUserCount");
    }

}

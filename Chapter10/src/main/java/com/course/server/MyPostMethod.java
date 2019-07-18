package com.course6666.server;

import com.course6666.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/", description = "这是我全部的post请求")
@RequestMapping("/v1")// IP和port后跟踪的路径
public class MyPostMethod {
    //变量用了存储cookies信息
    private static Cookie cookie;
    User user = new User();

    @RequestMapping(value = "/login", method = RequestMethod.POST)// 类的路径之后接续
    @ApiOperation(value = "登录接口，成功后获取cookies信息", httpMethod = "POST")
    public String login(HttpServletResponse response,
                        @RequestParam(value = "userName", required = true) String userName,//value中的userName是映射到前端的，可以跟定义的变量名不同
                        @RequestParam(value = "password", required = true) String password) {
        if (userName.equals("zhangsan") && password.equals("123456")) {
            cookie = new Cookie("login", "true");
            response.addCookie(cookie);
            return "恭喜你登录成功了！";
        }
        return "用户名或是密码错误";
    }

    @RequestMapping(value = "/getUserList", method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表", httpMethod = "POST")
    public String getUserList(HttpServletRequest request,
                              @RequestBody User u) {
        //获取cookies
        Cookie[] cookies = request.getCookies();
        //验证cookie的合法性
        for (Cookie c : cookies) {
            if (c.getName().equals("login") && c.getValue().equals( "true")
                    && u.getUserName().equals("zhangsan")
                    && u.getPassword().equals("123456")) {

                user.setName("lisi");
                user.setAge("18");
                return user.toString();
            }
        }
        return "参数不合法";
    }
}

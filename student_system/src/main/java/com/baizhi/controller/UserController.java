package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.result.Result;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("user")
public class UserController {


    @Autowired
    private UserService userService;



    //用户退出
    @RequestMapping("logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/back/login.jsp";
    }


    /**用户登录*/
    @RequestMapping("login")
    @ResponseBody
    public Result login(User user,String code,HttpSession session){
        Result result = new Result();
        try {
            User userDB = userService.login(user);
            session.setAttribute("user", userDB);
            return result.setMsg("登录成功").setStatus(true);
        } catch (RuntimeException e) {
            return result.setMsg(e.getMessage()).setStatus(false);
        }
    }

    /**用户注册*/
    @RequestMapping("register")
    @ResponseBody
    public Result register(User user,String code,HttpSession session) {
        Result result = new Result();
        try {
            userService.register(user);
            return result.setMsg("注册成功").setStatus(true);
        } catch (RuntimeException e) {
            return result.setMsg("用户名重复").setStatus(false);
        }
    }


}

package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.result.Result;
import com.baizhi.service.UserService;
import com.baizhi.utils.VerifyCodeUtils;
import org.apache.commons.lang3.StringUtils;
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


    //用户登录
    @RequestMapping("login")
    @ResponseBody
    public Result login(User user,String code,HttpSession session){
        Result result = new Result();
        String imageCode = (String) session.getAttribute("code");
        try{
            if(StringUtils.equalsIgnoreCase(imageCode,code)){
                User userDB = userService.login(user);
                session.setAttribute("user",userDB);
                return result.setMsg("登录成功").setStatus(true);
            }
            throw new RuntimeException("验证码输入错误~~~");
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus(false).setMsg("登录失败: "+e.getMessage());
        }
        return result;
    }

    //用户注册
    @RequestMapping("register")
    @ResponseBody
    public Result register(User user,String code,HttpSession session) {
        Result result = new Result();
        try {
            String imageCode = (String) session.getAttribute("code");
            if(imageCode.equalsIgnoreCase(code)){
                userService.register(user);
                return result.setMsg("注册成功").setStatus(true);
            }
            throw new RuntimeException("验证码输入错误~~");
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg("注册失败:"+e.getMessage()).setStatus(false);
        }
        return result;
    }


    //生成验证码
    @RequestMapping("getImage")
    public void getImage(HttpSession session, HttpServletResponse response) throws IOException {
        //1.获取随机数据
        String code = VerifyCodeUtils.generateVerifyCode(4);
        //2.将数字放入session
        session.setAttribute("code", code);
        //3.生成验证码图片
        VerifyCodeUtils.outputImage(220, 60, response.getOutputStream(), code);
    }
}

package com.baizhi.controller;

import com.baizhi.entity.Clazz;
import com.baizhi.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("clazz")
public class ClazzController {


    @Autowired
    private ClazzService clazzService;


    //添加班级的方法
    @RequestMapping("save")
    public String save(Clazz clazz){
        clazzService.save(clazz);
        return "redirect:/clazz/findAll";
    }

    //查询所有的方法
    @RequestMapping("findAll")
    public String findAll(Model model){
        List<Clazz> clazzes = clazzService.findAll();
        model.addAttribute("clazzs",clazzes);
        return "back/clazz/index";
    }

    @RequestMapping("findAllClazzJSON")
    @ResponseBody
    public List<Clazz> findAllClazzJSON(){
        return clazzService.findAll();
    }
}

package com.baizhi.controller;

import com.baizhi.entity.Group;
import com.baizhi.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("group")
public class GroupController {


    @Autowired
    private GroupService groupService;


    //根据班级id查询小组信息
    @RequestMapping("findByClazzId")
    @ResponseBody
    public List<Group> findByClazzId(String id){
        return groupService.findByClazzId(id);
    }


    //添加小组
    @RequestMapping("save")
    public String save(Group group){
        groupService.save(group);
        return "redirect:/group/findAll";
    }


    //查询所有小组的方法
    @RequestMapping("findAll")
    public String findAll(Model model){
        List<Group> groups = groupService.findAll();
        model.addAttribute("groups",groups);
        return "back/group/index";
    }

}

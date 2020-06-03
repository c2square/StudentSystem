package com.baizhi.controller;

import com.baizhi.entity.Student;
import com.baizhi.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("student")
@Slf4j
public class StudentController {


    @Autowired
    private StudentService studentService;

    //学生添加方法
    @RequestMapping("save")
    public String save(Student student,String[] tagIds){
        log.info("student: "+student);
        log.info("tagIds: ");
        for (String tagId : tagIds) {
            System.out.println(tagId);
        }
        studentService.save(student,tagIds);
        return "redirect:/student/findAll";
    }
    //学生查询所有 分页 模糊
    @RequestMapping("findAll")
    public String findAll(Integer pageNow,Integer rows,String searchCol,String searchValue,Model model){
        pageNow = pageNow==null?1:pageNow;
        rows  = rows==null?4:rows;
        List<Student> students = studentService.findAll(pageNow,rows,searchCol,searchValue);
        //总条数
        Integer counts = studentService.totalCounts(searchCol,searchValue);
        //计算总也数
        int totalPage = counts%rows==0?counts/rows:counts/rows+1;
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("pageNow",pageNow);
        model.addAttribute("students",students);
        model.addAttribute("searchValue",searchValue);
        model.addAttribute("searchCol",searchCol);
        return "back/student/index";
    }
}

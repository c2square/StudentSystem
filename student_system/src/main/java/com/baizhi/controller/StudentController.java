package com.baizhi.controller;

import com.baizhi.entity.Student;
import com.baizhi.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("student")
@Slf4j
public class StudentController {


    private Integer id;

    private StudentService studentService;
    @Autowired
    public void setStudentService(StudentService studentService){
        this.studentService = studentService;
    }

    //学生修改方法
    @RequestMapping("update/{id}")
    public String update(@PathVariable("id") Integer id, Model model){
        //System.out.println(id);
        //Student =
        this.id = id;
        Student student = studentService.update(id);
        System.out.println(student.getName());

        model.addAttribute("name", student.getName());
        model.addAttribute("age", student.getAge());
        model.addAttribute("bir", new SimpleDateFormat("yyyy-MM-dd").format(student.getBir()).toString());
        model.addAttribute("phone", student.getPhone());
        model.addAttribute("qq", student.getQq());
        model.addAttribute("attr", student.getAttr());
        model.addAttribute("starts", student.getStarts());
        model.addAttribute("mark", student.getMark());
        return "back/student/modify";
    }

    @RequestMapping("modify")
    public String modify(String name, String age, String bir,
                         String phone, String qq, String attr,
                         String starts, String mark){
        studentService.modify(name, age, bir, phone, qq, attr, starts, mark, id.toString());
        return "redirect:/student/findAll";
    }

    //学生添加方法
    @RequestMapping("save")
    public String save(Student student,String[] tagIds){
        try {
            studentService.save(student, tagIds);
            return "redirect:/student/findAll";
        } catch (Exception e) {
            System.out.println(e);
            return "redirect:/student/add.jsp";
        }

    }

    @RequestMapping("findAll")
    public String findAll(Integer pageNow,Integer rows,String searchCol,String searchValue,Model model){
        pageNow = pageNow==null?1:pageNow;
        rows  = rows==null?10:rows;
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

    //学生删除方法
    @RequestMapping("del/{id}")
    public String delete(@PathVariable("id") Integer id, Model model){

        this.id = id;
        Student student = studentService.del(id);
        System.out.println(student.getName());
        model.addAttribute("name", student.getName());
        model.addAttribute("age", student.getAge());
        model.addAttribute("bir", new SimpleDateFormat("yyyy-MM-dd").format(student.getBir()).toString());
        model.addAttribute("phone", student.getPhone());
        model.addAttribute("qq", student.getQq());
        model.addAttribute("attr", student.getAttr());
        model.addAttribute("starts", student.getStarts());
        model.addAttribute("mark", student.getMark());
        return "back/student/delete";
    }

    @RequestMapping("delete")
    public String delete(String name, String age, String bir,
                         String phone, String qq, String attr,
                         String starts, String mark){
        studentService.delete(name, age, bir, phone, qq, attr, starts, mark, id.toString());
        return "redirect:/student/findAll";
    }
}

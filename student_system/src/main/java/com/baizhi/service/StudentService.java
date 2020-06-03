package com.baizhi.service;

import com.baizhi.entity.Student;

import java.util.List;

public interface StudentService {

    //查询所有
    List<Student> findAll();

    //根据条件查询学生信息
    List<Student> findAll(String searchCol, String searchValue);

    //根据条件查询学生信息(并分页处理)
    List<Student> findAll(Integer pageNow, Integer rows, String searchCol, String searchValue);

    //定义条件查询返回的总条数
    Integer totalCounts(String searchCol, String searchValue);

    //保存学生信息同时保存学生标签信息
    void save(Student student,String[] tagIds);

    Student update(Integer id);

    void modify(String name, String age, String bir, String phone, String qq,
                String attr, String starts, String mark, String id);
}

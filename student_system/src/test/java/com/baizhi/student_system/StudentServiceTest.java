package com.baizhi.student_system;

import com.baizhi.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void testFindAll(){
        studentService.findAll().forEach(s ->{
            System.out.println("学生姓名:"+s.getName());
            s.getTags().forEach(tag ->{
                System.out.println("=====>标签信息:"+tag.getName());
            });
            System.out.println("=============================");
        });
    }
}

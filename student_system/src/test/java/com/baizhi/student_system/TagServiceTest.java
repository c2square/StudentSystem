package com.baizhi.student_system;

import com.baizhi.service.TagService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TagServiceTest {


    @Autowired
    private TagService tagService;


    @Test
    public void testFindByType(){
        tagService.findByType("班级").forEach(tag-> System.out.println("tag = " + tag));
    }
    
    @Test
    public void testFindAll(){
        tagService.findAll().forEach(tag-> System.out.println("tag = " + tag));
    }
    
    
}

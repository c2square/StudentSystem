package com.baizhi.student_system;

import com.baizhi.entity.Group;
import com.baizhi.service.GroupService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GroupServiceTest {


    @Autowired
    private GroupService groupService;

    @Test
    public void testFindAll(){
        Group group1 = new Group();
        group1.setName("2组").setContent("我们都是大神").setClazzid("1");
        groupService.save(group1);
        groupService.findAll().forEach(group-> System.out.println("group = " + group));

    }

}

package com.baizhi.student_system;

import com.baizhi.entity.Clazz;
import com.baizhi.service.ClazzService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClazzServiceTest {

    @Autowired
    private ClazzService clazzService;

    @Test
    public void testSave(){
        Clazz clazz = new Clazz();
        clazz.setName("2班");
        clazz.setTagid("3");
        clazzService.save(clazz);
    }

    @Test
    public void testFindAll(){
        clazzService.findAll().forEach(clazz-> System.out.println("clazz = " + clazz));

    }
}

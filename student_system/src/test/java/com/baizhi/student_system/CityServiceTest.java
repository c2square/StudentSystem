package com.baizhi.student_system;

import com.baizhi.entity.City;
import com.baizhi.service.CityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CityServiceTest {


    @Autowired
    private CityService cityService;
    
    
    @Test
    public void testFindAll(){
        City city1 = new City();
        city1.setName("天津");
        cityService.save(city1);
        cityService.findAll().forEach(city-> System.out.println("city = " + city));
    }
    
    
}

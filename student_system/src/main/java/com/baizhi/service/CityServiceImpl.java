package com.baizhi.service;

import com.baizhi.dao.CityDAO;
import com.baizhi.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CityServiceImpl implements CityService {


    @Autowired
    private CityDAO cityDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<City> findAll() {
        return cityDAO.findAll();
    }

    @Override
    public void save(City city) {
        //处理录入时间
        city.setCreatetime(new Date());
        //处理当前人数
        city.setNumbers(0);
        cityDAO.save(city);
    }
}

package com.baizhi.service;

import com.baizhi.entity.City;

import java.util.List;

public interface CityService {


    //查询所有
    List<City> findAll();

    //添加城市信息
    void save(City city);
}

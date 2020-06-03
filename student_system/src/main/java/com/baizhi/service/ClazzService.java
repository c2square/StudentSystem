package com.baizhi.service;

import com.baizhi.entity.Clazz;

import java.util.List;

public interface ClazzService {

    //查询所有方法
    List<Clazz> findAll();

    //添加方法
    void save(Clazz clazz);
}

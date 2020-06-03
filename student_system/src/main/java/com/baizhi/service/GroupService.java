package com.baizhi.service;

import com.baizhi.entity.Group;

import java.util.List;

public interface GroupService {


    //查询所有小组的方法
    List<Group> findAll();

    //添加小组
    void save(Group group);

    //根据班级id查询小组信息
    List<Group> findByClazzId(String id);
}

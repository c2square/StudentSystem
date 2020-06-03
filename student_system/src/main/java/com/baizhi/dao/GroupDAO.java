package com.baizhi.dao;

import com.baizhi.entity.Group;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GroupDAO extends BaseDAO<Group,String> {


    //根据班级id查询所有的小组信息
    List<Group> findByClazzId(String id);
}

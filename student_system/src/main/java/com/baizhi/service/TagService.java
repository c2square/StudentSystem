package com.baizhi.service;

import com.baizhi.entity.Tag;

import java.util.List;

public interface TagService {

    List<Tag> findAll();

    void save(Tag tag);

    //根据标签类型查询对应的标签信息
    List<Tag> findByType(String type);

}

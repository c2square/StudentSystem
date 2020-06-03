package com.baizhi.dao;

import com.baizhi.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TagDAO extends BaseDAO<Tag,String> {


    List<Tag> findByType(String type);
}

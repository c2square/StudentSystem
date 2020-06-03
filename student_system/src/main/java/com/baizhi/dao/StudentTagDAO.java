package com.baizhi.dao;

import com.baizhi.entity.StudentTag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StudentTagDAO extends BaseDAO<StudentTag,String> {
}

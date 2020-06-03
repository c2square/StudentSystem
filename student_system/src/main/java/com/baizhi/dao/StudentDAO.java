package com.baizhi.dao;

import com.baizhi.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentDAO extends BaseDAO<Student,String> {


    //根据执行列进行数据查询
    List<Student> find(@Param("col") String searchCol,@Param("val") String searchValue);

    //根据执行列进行数据查询并且分页
    List<Student> findByLikePage(@Param("start") Integer start,@Param("rows") Integer rows, @Param("col") String searchCol,@Param("val") String searchValue);


    //根据不同条件查询返回学生记录数
    Integer totalCounts(@Param("col") String searchCol,@Param("val") String searchValue);


    //根据小组id获取对应学生信息
    List<Student> findByGroupId(String id);

    void modify(String name, String age, String bir, String phone, String qq, String attr, String starts, String mark, String id);
}

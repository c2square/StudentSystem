package com.baizhi.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

//泛型一:代表操作对象的类型  泛型二:代表主键类型
public interface BaseDAO<T,K> {

    void save(T t);

    void update(T t);

    void delete(K k);

    T findById(K k);

    List<T> findAll();

    List<T> findByPage(@Param("start") Integer start,@Param("rows") Integer rows);

    Long findCounts();
}

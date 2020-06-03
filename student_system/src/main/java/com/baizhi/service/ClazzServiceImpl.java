package com.baizhi.service;

import com.baizhi.dao.ClazzDAO;
import com.baizhi.entity.Clazz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClazzServiceImpl implements ClazzService {


    @Autowired
    private ClazzDAO clazzDAO;


    @Override
    public void save(Clazz clazz) {
        clazzDAO.save(clazz);
    }

    @Override
    public List<Clazz> findAll() {
        return clazzDAO.findAll();
    }
}

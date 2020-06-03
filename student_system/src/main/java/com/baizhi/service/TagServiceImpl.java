package com.baizhi.service;

import com.baizhi.dao.TagDAO;
import com.baizhi.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDAO tagDAO;

    @Override
    public List<Tag> findByType(String type) {
        return tagDAO.findByType(type);
    }

    @Override
    public void save(Tag tag) {
        tag.setCreatetime(new Date());//设置标签的创建时间
        tagDAO.save(tag);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Tag> findAll() {
        return tagDAO.findAll();
    }
}

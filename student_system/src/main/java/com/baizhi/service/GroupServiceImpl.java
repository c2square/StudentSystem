package com.baizhi.service;

import com.baizhi.dao.GroupDAO;
import com.baizhi.dao.StudentDAO;
import com.baizhi.entity.Group;
import com.baizhi.entity.Student;
import com.baizhi.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupDAO groupDAO;


    @Autowired
    private StudentDAO studentDAO;


    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Group> findByClazzId(String id) {
        return groupDAO.findByClazzId(id);
    }

    @Override
    public void save(Group group) {
        groupDAO.save(group);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Group> findAll() {

        List<Group> groups = groupDAO.findAll();
        //如果组内的学生个数  = 组内学生某个标签之和 这个标签一定是组标签
        groups.forEach(group -> {
            //定义一个map结构  用来计数 key: 标签   值: 标签出现的次数
            Map<String,Integer> result = new HashMap<>();
            //根据组获取当前组内学生信息 1组  张三 帅哥 学渣  李四 帅哥 玩世不恭 王五 帅哥 不爱学习
            List<Student> students = studentDAO.findByGroupId(group.getId());

            students.forEach(student ->{
                List<Tag> tags = student.getTags();
                tags.forEach(tag->{
                    if(result.containsKey(tag.getName())){
                        result.put(tag.getName(),result.get(tag.getName())+1);
                    }else{
                        result.put(tag.getName(),1);
                    }
                });
            });

            //如果result中标签出现次数 = 组内学生个数
            result.forEach((k,v)->{
                if(students.size()==v){
                    group.getTags().add(k);
                }
            });
        });
        return groups;
    }
}

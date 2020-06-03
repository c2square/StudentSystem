package com.baizhi.service;

import com.baizhi.dao.CityDAO;
import com.baizhi.dao.StudentDAO;
import com.baizhi.dao.StudentTagDAO;
import com.baizhi.entity.City;
import com.baizhi.entity.Student;
import com.baizhi.entity.StudentTag;
import com.baizhi.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {




    @Autowired
    private StudentDAO studentDAO;

    @Autowired
    private StudentTagDAO studentTagDAO;

    @Autowired
    private CityDAO cityDAO;

    @Override
    public void save(Student student, String[] tagIds) {
        //计算年龄
        int age = DateUtil.getAge(student.getBir());
        student.setAge(age);
        //计算生肖和星座
        String attr = DateUtil.getYear(Integer.valueOf(new SimpleDateFormat("yyyy").format(student.getBir())));
        student.setAttr(attr);
        String starts = DateUtil.getConstellation(student.getBir());
        student.setStarts(starts);
        //保存学生
        studentDAO.save(student);
        //保存学生标签信息
        for (String tagId : tagIds) {
            StudentTag studentTag = new StudentTag();
            studentTag.setStudentid(student.getId());
            studentTag.setTagid(tagId);
            studentTagDAO.save(studentTag);
        }

        //更新城市人数信息
        City city = cityDAO.findById(student.getCityid());
        city.setNumbers(city.getNumbers()+1);
        cityDAO.update(city);
    }

    @Override
    public List<Student> findAll(Integer pageNow, Integer rows, String searchCol, String searchValue) {
        int start = (pageNow-1)*rows;
        return studentDAO.findByLikePage(start,rows,searchCol,searchValue);
    }

    @Override
    public List<Student> findAll(String searchCol, String searchValue) {
        return studentDAO.find(searchCol,searchValue);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public Integer totalCounts(String searchCol, String searchValue) {
        return studentDAO.totalCounts(searchCol,searchValue);
    }
}

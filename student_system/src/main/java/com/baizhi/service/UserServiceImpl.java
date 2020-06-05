package com.baizhi.service;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;


    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User login(User user) {
        User userDB = userDAO.findByName(user.getName());
        if(userDB!=null){
            if(StringUtils.equals(userDB.getPassword(),user.getPassword())){
                return userDB;
            }
            throw new RuntimeException("密码输入错误~~");
        }
        throw new RuntimeException("用户名不存在");
    }

    @Override
    public void register(User user) {
        User userDB = userDAO.findByName(user.getName());
        if (userDB != null) {
            throw new RuntimeException("当前用户名已被注册,请修改后再试!");
        }
        user.setStatus("激活");
        user.setRegtime(new Date());
        userDAO.save(user);
    }
}

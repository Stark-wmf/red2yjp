package com.red.red2.service.impl;

import com.red.red2.mapper.UserMapper;
import com.red.red2.been.User;
import com.red.red2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public void insertUser(String username, String password, String role, String company) {
        if(username == null&&password == null&&role == null&&company==null){

        }
        userMapper.insertUser(username,password,role,company);
    }
    @Override
    public int queryUserByUsername(String username) {
      int i =0;
      i = userMapper.IfUserExist(username);
           return i;
    }
    @Override
    public String queryRoleByUsername(String username) {
        return userMapper.getRole(username);
    }

    @Override
    public String queryPasswordByUsername(String username) {
        return userMapper.getPassword(username);
    }

    @Override
    public void modifyMessage(String newcompany, String username, String newpassword) {
        User user =userMapper.getUser(username);
        user.setCompany(newcompany);
        user.setPassword(newpassword);
        userMapper.modifyMessage(user);

    }
}

package com.red.red2.mapper;

import com.red.red2.been.User;

public interface UserMapper {
    String getRole(String username);
    User getUser(String username);
    void insertUser(String username,String password,String role,String company);
    int IfUserExist(String currusername);
    String getPassword(String username);
    int modifyMessage(User user);
}

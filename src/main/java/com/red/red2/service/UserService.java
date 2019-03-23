package com.red.red2.service;

public interface UserService {
    void insertUser(String username, String password, String role, String company);

    int queryUserByUsername(String username);

    String queryRoleByUsername(String username);

    String queryPasswordByUsername(String username);

    void modifyMessage(String newcompany, String username, String newpassword);
}

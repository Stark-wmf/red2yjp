package com.red.red2.controller;

import com.red.red2.annotation.Userq;
import com.red.red2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.xml.ws.Action;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @GetMapping("/login")
    public String adminLogin(String username, String password, HttpSession session){
        if(userService.queryUserByUsername(username)!=0&&userService.queryRoleByUsername(username)=="user"&&userService.queryPasswordByUsername(username)==password){
            session.setAttribute("role","user");
        }
        return "登陆成功！";
    }
    @Userq
    @PostMapping("/modifyMessage")
    public String modifyMessage(String newcompany,String username,String newpassword,HttpSession session){
        if (session.getAttribute("role")=="user"){
        userService.modifyMessage(newcompany,username,newpassword);
        return "修改用户 "+username+"新组织为： "+newcompany+"新密码为： "+newpassword;}
        return "用户未登录";
    }

}

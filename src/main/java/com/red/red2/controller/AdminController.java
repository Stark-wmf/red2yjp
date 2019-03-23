package com.red.red2.controller;

import com.red.red2.annotation.Adminq;
import com.red.red2.annotation.Authentication;
import com.red.red2.annotation.Cache;
import com.red.red2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.management.timer.Timer;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private  UserService userService;
    @Adminq
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String adminLogin(String username, String password, HttpSession session){
        if(userService.queryUserByUsername(username)!=0&&userService.queryRoleByUsername(username)=="admin"&&userService.queryPasswordByUsername(username)==password){
            session.setAttribute("role","admin");
        }
        return "管理员登陆成功！";
    }
    @Authentication
    @RequestMapping(value = "/insertuser",method = RequestMethod.POST)
    public void adminInsertUser(String username,String password,String role,String company){
    userService.insertUser(username,password,role,company);

    }
    @GetMapping("/welcome")
    @Authentication
    @Cache
    public String welcome(String name){
        System.out.println("我需要计算!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "welcome!"+name;
    }

}

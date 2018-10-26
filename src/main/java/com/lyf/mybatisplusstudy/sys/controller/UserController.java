package com.lyf.mybatisplusstudy.sys.controller;


import com.lyf.mybatisplusstudy.sys.entity.User;
import com.lyf.mybatisplusstudy.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/sys/user")
public class UserController {

    @Autowired
    IUserService iUserService;

    @ResponseBody
    @PostMapping(value = "/select")
    public List<User> select(String name) {
        List<User> peoples = iUserService.getUserList(name);
        return peoples;
    }

    @ResponseBody
    @PostMapping(value = "/selectOne")
    public User selectOne(int id) {
        User user = iUserService.selectUserByID(id);
        return user;
    }

    @ResponseBody
    @PostMapping(value = "/insert")
    public void insertUserInfo(User user) {
        iUserService.insertUserInfo(user);
    }

    @ResponseBody
    @PostMapping(value = "/update")
    public void updateUserInfo(User user) {
        iUserService.updateUserInfo(user);
    }

    @ResponseBody
    @PostMapping(value = "/delete")
    public void deleteUserInfo(long id) {
        iUserService.deleteUserInfo(id);
    }
}

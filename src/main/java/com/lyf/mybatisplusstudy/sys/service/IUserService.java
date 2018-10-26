package com.lyf.mybatisplusstudy.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyf.mybatisplusstudy.sys.entity.Student;
import com.lyf.mybatisplusstudy.sys.entity.User;

import java.util.List;


public interface IUserService extends IService<User> {

    List<User> getUserList(String userName);

    User selectUserByID(long id);

    int deleteUserInfo(long id);

    int insertUserInfo(User user);

    int updateUserInfo(User user);
}

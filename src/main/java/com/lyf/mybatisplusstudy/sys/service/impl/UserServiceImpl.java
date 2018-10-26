package com.lyf.mybatisplusstudy.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyf.mybatisplusstudy.sys.entity.User;
import com.lyf.mybatisplusstudy.sys.mapper.UserMapper;
import com.lyf.mybatisplusstudy.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2018-10-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getUserList(String userName) {
        List<User> users = userMapper.getUserList(userName);
        return users;
    }

    @Override
    public User selectUserByID(long iddd) {
        User user = userMapper.selectUserByID(iddd);
        return user;
    }

    @Override
    public int deleteUserInfo(long id) {
        userMapper.deleteUserInfo(id);
        return 0;
    }

    @Override
    public int insertUserInfo(User user) {
        userMapper.insertUserInfo(user);
        return 0;
    }

    @Override
    public int updateUserInfo(User user) {
        userMapper.updateUserInfo(user);
        return 0;
    }
}

package com.lyf.mybatisplusstudy.sys.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyf.mybatisplusstudy.sys.entity.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    List<User> getUserList(String userName);

    User selectUserByID(long id);

    int insertUserInfo(User user);

    int updateUserInfo(User user);

    int deleteUserInfo(long id);

}

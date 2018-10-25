package com.lyf.mybatisplusstudy;

import com.lyf.mybatisplusstudy.sys.entity.User;
import com.lyf.mybatisplusstudy.sys.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest

public class MybatisplusstudyApplicationTests {


    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        // 根据 entity 条件，查询全部记录
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

}

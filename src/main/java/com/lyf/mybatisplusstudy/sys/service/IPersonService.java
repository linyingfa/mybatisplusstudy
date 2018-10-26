package com.lyf.mybatisplusstudy.sys.service;

import com.lyf.mybatisplusstudy.sys.entity.Person;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author jobob
 * @since 2018-10-25
 */
public interface IPersonService extends IService<Person> {


    int insert(Person person);

    void delete();

    void update();

    List<Person> select();

    List<Person> select(int page, int size);
}

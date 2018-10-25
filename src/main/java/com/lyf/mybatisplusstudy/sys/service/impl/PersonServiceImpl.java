package com.lyf.mybatisplusstudy.sys.service.impl;

import com.lyf.mybatisplusstudy.sys.entity.Person;
import com.lyf.mybatisplusstudy.sys.mapper.PersonMapper;
import com.lyf.mybatisplusstudy.sys.service.IPersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements IPersonService {

    @Autowired
    PersonMapper personMapper;

    @Override
    public int insert(Person person) {
        int index = personMapper.insert(person);
        return index;
    }

    @Override
    public void delete() {
//        personMapper.deleteById();
//        personMapper.deleteByMap();
//        personMapper.delete();
//        personMapper.deleteBatchIds();
    }

    @Override
    public void update() {
//        personMapper.updateById();
//        personMapper.update();
    }

    @Override
    public List<Person> select() {
//        personMapper.selectById();
//        personMapper.selectBatchIds();
//        personMapper.selectByMap();
//        personMapper.selectOne();
//        personMapper.selectCount();
        List<Person> peoples = personMapper.selectList(null);
//        personMapper.selectMaps();
//        personMapper.selectObjs();
//        personMapper.selectPage();
//        personMapper.selectMapsPage();

        return peoples;
    }
}

package com.lyf.mybatisplusstudy.sys.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyf.mybatisplusstudy.sys.entity.Person;
import com.lyf.mybatisplusstudy.sys.mapper.PersonMapper;
import com.lyf.mybatisplusstudy.sys.model.MyPage;
import com.lyf.mybatisplusstudy.sys.model.ParamSome;
import com.lyf.mybatisplusstudy.sys.service.IPersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return 0;
    }

    @Override
    public void delete() {
        //personMapper.deleteById(Long.parseLong("32"));
//        Map<String, Object> map = new HashMap<>();
//        map.put("id", 31);
        //personMapper.deleteByMap(map);
//        personMapper.delete(new QueryWrapper<Person>().eq("id", 30));
        List<Integer> ids = new ArrayList<>();
        ids.add(28);
        ids.add(29);
        personMapper.deleteBatchIds(ids);
    }

    @Override//http://localhost:8080/sys/person/update
    public void update() {
        Person person = personMapper.selectById(1);
        person.setEmail("22222222223434343");
        //personMapper.updateById(person);
        personMapper.update(person, new UpdateWrapper<Person>().eq("id", 1));
    }

    //http://localhost:8080/sys/person/select
    @Override
    public List<Person> select() {

        //TODO 查出所有
        System.out.println("----- 普通查询 ------");
        List<Person> peoples1 = personMapper.selectList(null);
        List<Person> personw1 = personMapper.selectList(new QueryWrapper<Person>().eq("id", 1));
        List<Person> lambdaPersons = personMapper.selectList(new QueryWrapper<Person>().lambda().eq(Person::getId, 1));

        System.out.println("----- 带子查询(sql注入) ------");
        List<Person> plainUsers2 = personMapper.selectList(new QueryWrapper<Person>()
                .inSql("id", "select id from person where id = 1"));
        List<Person> lambdaUsers2 = personMapper.selectList(new QueryWrapper<Person>().lambda()
                .inSql(Person::getId, "select id from person where id = 2"));


        System.out.println("----- 带嵌套查询 ------");
        List<Person> plainUsers3 = personMapper.selectList(new QueryWrapper<Person>()
                .nested(i -> i.eq("id", 2L).or().eq("id", 1))
                .and(i -> i.ge("age", 23)));

        //ge大于等于 >=   eq  OR 嵌套
//        List<Person> lambdaUsers3 = personMapper.selectList(new QueryWrapper<Person>().lambda()
//                .nested(i -> i.eq(Person::getId, 2).or().eq(Person::getName, "530"))
//                .and(i -> i.ge(Person::getAge, 20)));

        //TODO 根据 ID 查询
        Person person = personMapper.selectById(1);

        //TODO 查询（根据ID 批量查询）
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        List<Person> peoples2 = personMapper.selectBatchIds(ids);

        //TODO  查询（根据 columnMap 条件）  表字段查询
        Map<String, Object> paramsmap = new HashMap<>();
        paramsmap.put("id", 1);
        paramsmap.put("age", 23);
        List<Person> peoples3 = personMapper.selectByMap(paramsmap);

        //TODO
        Person person1 = personMapper.selectOne(new QueryWrapper<Person>().eq("id", 1));

        //TODO  根据 Wrapper<实体对象> 条件，查询总记录数
        int count = personMapper.selectCount(new QueryWrapper<Person>());

        //TODO
        List<Map<String, Object>> mapList = personMapper.selectMaps(new QueryWrapper<Person>());

        List<Person> plainUsers4 = personMapper.selectList(new QueryWrapper<Person>()
                .apply("id = 2"));

        //TODO
        List<Object> pbj = personMapper.selectObjs(new QueryWrapper<Person>());

        //TODO
//


        //TODO
//        personMapper.selectMapsPage();

        return lambdaPersons;
    }

    @Override
    public List<Person> select(int mPage, int mSize) {
        //List<Person> personList = personMapper.mySelectPage();
        System.out.println("----- baseMapper 自带分页 ------");
        Page<Person> page = new Page<>(mPage, mSize);
//        IPage<Person> userIPage = personMapper.selectPage(page, new QueryWrapper<Person>()
//                .eq("email", "530810890@qq.com").eq("name", "林英发"));
        IPage<Person> userIPage = personMapper.selectPage(page, new QueryWrapper<Person>());
        System.out.println("总条数 ------> " + userIPage.getTotal());
        System.out.println("当前页数 ------> " + userIPage.getCurrent());
        System.out.println("当前每页显示数 ------> " + userIPage.getSize());
        List<Person> personList = userIPage.getRecords();
        System.out.println("----- baseMapper 自带分页 ------");

//        System.out.println("json 正反序列化 begin");
//        String json = JSON.toJSONString(page);
//        Page<Person> page1 = JSON.parseObject(json, TypeBuilder.newInstance(Page.class).addTypeParam(Person.class).build());
//        List<Person> personList2 = page1.getRecords();
//        System.out.println("json 正反序列化 end");


        System.out.println("----- 自定义 XML 分页 ------");
        MyPage<Person> myPage = new MyPage<Person>(mPage, mSize);
        MyPage<Person> userMyPage = personMapper.myselectpage(myPage);
        List<Person> personList2 = userMyPage.getRecords();
//        MyPage<Person> myPage = new MyPage<Person>(mPage, mSize).setSelectInt(20).setSelectStr("Jack");
//        ParamSome paramSome = new ParamSome(20, "Jack");
//        MyPage<Person> userMyPage = personMapper.mySelectPage(myPage, paramSome);
//        System.out.println("总条数 ------> " + userMyPage.getTotal());
//        System.out.println("当前页数 ------> " + userMyPage.getCurrent());
//        System.out.println("当前每页显示数 ------> " + userMyPage.getSize());
//        List<Person> personList2 = userMyPage.getRecords();
//        System.out.println("----- 自定义 XML 分页 ------");
        return personList2;
    }


}

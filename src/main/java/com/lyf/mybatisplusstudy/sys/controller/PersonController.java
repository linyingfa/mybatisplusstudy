package com.lyf.mybatisplusstudy.sys.controller;


import com.lyf.mybatisplusstudy.sys.entity.Person;
import com.lyf.mybatisplusstudy.sys.service.IPersonService;
import com.lyf.mybatisplusstudy.utils.Result;
import com.lyf.mybatisplusstudy.utils.ResultCode;
import com.lyf.mybatisplusstudy.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/sys/person")
public class PersonController {

    @Autowired
    IPersonService iPersonService;


    /**
     * /sys/person/insert
     *
     * @param person
     */
    @ResponseBody
    @PostMapping(value = "/insert")
    public void insert(Person person) {
        int index = iPersonService.insert(person);
    }

    @ResponseBody
    @PostMapping(value = "/delete")
    public void delete() {
        iPersonService.delete();
    }

    @ResponseBody
    @PostMapping(value = "/update")
    public void update() {
        iPersonService.update();
    }

    @ResponseBody
    @PostMapping(value = "/select")
    public Result select() {
        List<Person> peoples = iPersonService.select();
        Person p = peoples.get(0);


        /**
         * {
         "code": 0,
         "msg": "请求成功",
         "data": [
         {
         "id": 1,
         "name": "530",
         "age": 23,
         "email": "530810890@qq.com"
         }
         ]
         }
         */

        return ResultUtils.success(peoples);


        /**
         * {
         "code": 0,
         "msg": "请求成功",
         "data": {
         "id": 1,
         "name": "530",
         "age": 23,
         "email": "530810890@qq.com"
         }
         }
         */
//        return ResultUtils.success(p);

        /**
         * {
         "code": 10101,
         "msg": "验证码错误",
         "data": null
         }
         */
//        return ResultUtils.warn(ResultCode.PARAMETER_ERROR, "验证码错误");
    }

    @ResponseBody
    @PostMapping(value = "/selectpage")
    public List<Person> select(int page, int size) {
        List<Person> peoples = iPersonService.select(page, size);
        return peoples;
    }
}

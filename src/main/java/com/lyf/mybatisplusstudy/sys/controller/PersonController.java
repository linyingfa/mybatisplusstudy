package com.lyf.mybatisplusstudy.sys.controller;


import com.lyf.mybatisplusstudy.sys.entity.Person;
import com.lyf.mybatisplusstudy.sys.service.IPersonService;
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
    public List<Person> select() {
        List<Person> peoples = iPersonService.select();
        return peoples;
    }

    @ResponseBody
    @PostMapping(value = "/selectpage")
    public List<Person> select(int page, int size) {
        List<Person> peoples = iPersonService.select(page,size);
        return peoples;
    }
}

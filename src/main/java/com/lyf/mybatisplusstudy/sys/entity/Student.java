package com.lyf.mybatisplusstudy.sys.entity;

import lombok.Data;

import java.io.Serializable;


@Data
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private Integer age;

    private String sex;



    @Override
    public String toString() {
        return "Student{" +
        "name=" + name +
        ", age=" + age +
        ", sex=" + sex +
        "}";
    }
}

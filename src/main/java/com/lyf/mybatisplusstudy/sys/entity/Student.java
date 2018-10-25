package com.lyf.mybatisplusstudy.sys.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2018-10-25
 */
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private Integer age;

    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
        "name=" + name +
        ", age=" + age +
        ", sex=" + sex +
        "}";
    }
}

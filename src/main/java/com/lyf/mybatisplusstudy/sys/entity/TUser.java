package com.lyf.mybatisplusstudy.sys.entity;

import lombok.Data;

import java.time.LocalDate;
import java.io.Serializable;
import java.util.List;


@Data
public class TUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 生日
     */
    private LocalDate birthday;

    /**
     * 性别
     */
    private String sex;

    /**
     * 地址
     */
    private String address;

    // 用户创建的订单列表
    private List<Orders> ordersList;


    @Override
    public String toString() {
        return "TUser{" +
                "username=" + username +
                ", birthday=" + birthday +
                ", sex=" + sex +
                ", address=" + address +
                "}";
    }
}

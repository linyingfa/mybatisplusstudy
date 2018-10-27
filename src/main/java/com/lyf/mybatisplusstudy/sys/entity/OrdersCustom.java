package com.lyf.mybatisplusstudy.sys.entity;

import lombok.Data;

/**
 * Created by xiaolin on 2018/10/27.
 */
@Data
public class OrdersCustom extends Orders {
    // 添加用户的属性
    private String username;
    private String sex;
    private String address;

}

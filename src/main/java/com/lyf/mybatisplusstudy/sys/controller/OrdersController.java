package com.lyf.mybatisplusstudy.sys.controller;


import com.lyf.mybatisplusstudy.sys.entity.Orderdetail;
import com.lyf.mybatisplusstudy.sys.entity.Orders;
import com.lyf.mybatisplusstudy.sys.entity.OrdersCustom;
import com.lyf.mybatisplusstudy.sys.entity.TUser;
import com.lyf.mybatisplusstudy.sys.service.IOrdersService;
import com.lyf.mybatisplusstudy.sys.service.ITUserService;
import com.lyf.mybatisplusstudy.utils.Result;
import com.lyf.mybatisplusstudy.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2018-10-27
 */
@Controller
@RequestMapping("/sys/orders")
public class OrdersController {

    @Autowired
    IOrdersService iOrdersService;


    /**
     * resultType和resultMap实现一对一查询小结
     * <p>
     * TODO　实现一对一查询：
     * a.resultType：使用resultType实现较为简单，如果pojo中没有包括查询出来的列名，需要增加列名对应的属性，即可完成映射。
     * b.如果没有查询结果的特殊要求建议使用resultType。
     * c.resultMap：需要单独定义resultMap，实现有点麻烦，如果对查询结果有特殊的要求，
     * 使用resultMap可以完成将关联查询映射pojo的属性中。
     * d.resultMap可以实现延迟加载，resultType无法实现延迟加载。
     */
    @ResponseBody
    @PostMapping(value = "/findOrdersUser")
    public Result findOrdersUser() {
        List<OrdersCustom> ordersCustoms = iOrdersService.findOrdersUser();
        return ResultUtils.success(ordersCustoms);
    }

    /**
     * 查询订单关联查询用户信息
     */
    @ResponseBody
    @PostMapping(value = "/findOrdersUserResultMap")
    public Result findOrdersUserResultMap() {
        List<Orders> orders = iOrdersService.findOrdersUserResultMap();
        return ResultUtils.success(orders);
    }


    /**
     * 　mybatis使用resultMap的collection对关联查询的多条记录映射到一个list集合属性中。
     * 　使用resultType实现：将订单明细映射到orders中的orderdetails中，
     * 需要自己处理，使用双重循环遍历，去掉重复记录，将订单明细放在orderdetails中。
     */
    //TODO 一对多查询
    // 3.1. 需求：查询订单(关联用户)及订单明细；
    @ResponseBody
    @PostMapping(value = "/findOrdersAndOrderDetailResultMap")
    public Result findOrdersAndOrderDetailResultMap() {
        List<Orderdetail> orderdetails = iOrdersService.findOrdersAndOrderDetailResultMap();
        return ResultUtils.success(orderdetails);
    }


    //    4.1.需求：查询用户以及用户购买的商品信息
//    4.2.映射思路
//　　将用户信息映射到user中。
//    在user类中添加订单列表属性List<Orders> orderslist，将用户创建的订单映射到orderslist;
//　　在Orders中添加订单明细列表属性List<OrderDetail>orderdetials，将订单的明细映射到orderdetials;
//　　在OrderDetail中添加Items属性，将订单明细所对应的商品映射到Item；
//    resultType：
//            　　作用：将查询结果按照sql列名pojo属性名一致性映射到pojo中。
//            　　场合：
//            　 常见一些明细记录的展示，比如用户购买商品明细，将关联查询信息全部展示在页面时，
//           此时可直接使用resultType将每一条记录映射到pojo中，在前端页面遍历list（list中是pojo）即可。
//
//    resultMap：
//            使用association和collection完成一对一和一对多高级映射（对结果有特殊的映射要求）。
//    association：
//            　　作用：将关联查询信息映射到一个pojo对象中。
//            　　场合：
//            　 为了方便查询关联信息可以使用association将关联订单信息映射为用户对象的pojo属性中，
//               比如：查询订单及关联用户信息。
//
//            　 使用resultType无法将查询结果映射到pojo对象的pojo属性中，
//               根据对结果集查询遍历的需要选择使用resultType还是resultMap。
//
//    collection：
//
//            作用：将关联查询信息映射到一个list集合中。
//            场合：
//            为了方便查询遍历关联信息可以使用collection将关联信息映射到list集合中，
//            比如：查询用户权限范围模块及模块下的菜单，可使用collection将模块映射到模块list中，
//            将菜单列表映射到模块对象的菜单list属性中，这样的作的目的也是方便对查询结果集进行遍历查询。
//            如果使用resultType无法将查询结果映射到list集合中。
    //TODO 多对多查询
    @ResponseBody
    @PostMapping(value = "/findUserAndItemsResultMap")
    public Result findUserAndItemsResultMap() {
        List<TUser> tUsers = iOrdersService.findUserAndItemsResultMap();
        return ResultUtils.success(tUsers);
    }


}

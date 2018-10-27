package com.lyf.mybatisplusstudy.sys.service;

import com.lyf.mybatisplusstudy.sys.entity.Orderdetail;
import com.lyf.mybatisplusstudy.sys.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lyf.mybatisplusstudy.sys.entity.OrdersCustom;
import com.lyf.mybatisplusstudy.sys.entity.TUser;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author jobob
 * @since 2018-10-27
 */
public interface IOrdersService extends IService<Orders> {
    /**
     * 查询订单，关联查询用户信息
     */
    List<OrdersCustom> findOrdersUser();

    /**
     * 查询订单关联查询用户信息，使用reslutMap实现
     */
    List<Orders> findOrdersUserResultMap();

    /**
     * 查询订单（关联用户）以及订单明细
     */
    List<Orderdetail> findOrdersAndOrderDetailResultMap();

    /**
     * 查询用户及用户所购买的商品信息
     */
    public List<TUser> findUserAndItemsResultMap();
}

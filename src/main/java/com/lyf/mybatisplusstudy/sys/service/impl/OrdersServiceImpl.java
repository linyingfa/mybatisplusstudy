package com.lyf.mybatisplusstudy.sys.service.impl;

import com.lyf.mybatisplusstudy.sys.entity.Orderdetail;
import com.lyf.mybatisplusstudy.sys.entity.Orders;
import com.lyf.mybatisplusstudy.sys.entity.OrdersCustom;
import com.lyf.mybatisplusstudy.sys.entity.TUser;
import com.lyf.mybatisplusstudy.sys.mapper.OrdersMapper;
import com.lyf.mybatisplusstudy.sys.mapper.TUserMapper;
import com.lyf.mybatisplusstudy.sys.service.IOrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2018-10-27
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {

    @Autowired
    TUserMapper tUserMapper;

    @Autowired
    OrdersMapper ordersMapper;

    @Override
    public List<OrdersCustom> findOrdersUser() {
        List<OrdersCustom> ordersCustoms = ordersMapper.findOrdersUser();
        return ordersCustoms;
    }

    @Override
    public List<Orders> findOrdersUserResultMap() {
        List<Orders> orders = ordersMapper.findOrdersUserResultMap();
        return orders;
    }

    @Override
    public List<Orderdetail> findOrdersAndOrderDetailResultMap() {
        List<Orderdetail> orderdetails = ordersMapper.findOrdersAndOrderDetailResultMap();
        return orderdetails;
    }

    @Override
    public List<TUser> findUserAndItemsResultMap() {
        List<TUser> tUsers = ordersMapper.findUserAndItemsResultMap();
        return tUsers;
    }
}

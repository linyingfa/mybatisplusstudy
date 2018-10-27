package com.lyf.mybatisplusstudy.sys.service.impl;

import com.lyf.mybatisplusstudy.sys.entity.Orderdetail;
import com.lyf.mybatisplusstudy.sys.entity.Orders;
import com.lyf.mybatisplusstudy.sys.entity.OrdersCustom;
import com.lyf.mybatisplusstudy.sys.entity.TUser;
import com.lyf.mybatisplusstudy.sys.mapper.OrdersMapper;
import com.lyf.mybatisplusstudy.sys.mapper.TUserMapper;
import com.lyf.mybatisplusstudy.sys.service.ITUserService;
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
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {

}

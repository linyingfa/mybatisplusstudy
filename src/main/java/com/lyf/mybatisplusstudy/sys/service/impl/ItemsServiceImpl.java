package com.lyf.mybatisplusstudy.sys.service.impl;

import com.lyf.mybatisplusstudy.sys.entity.Items;
import com.lyf.mybatisplusstudy.sys.mapper.ItemsMapper;
import com.lyf.mybatisplusstudy.sys.service.IItemsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2018-10-27
 */
@Service
public class ItemsServiceImpl extends ServiceImpl<ItemsMapper, Items> implements IItemsService {

}

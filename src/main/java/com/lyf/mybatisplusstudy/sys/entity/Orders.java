package com.lyf.mybatisplusstudy.sys.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.List;


@Data
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键订单Id
     */
    private Integer id;

    /**
     * 下单用户id
     */
    private Integer userId;

    /**
     * 订单号
     */
    private String number;

    /**
     * 创建订单时间
     */
    private LocalDateTime createtime;

    /**
     * 备注
     */
    private String note;

    // 用户信息
    private TUser tuser;

    // 订单明细
    private List<Orderdetail> orderdetails;


    @Override
    public String toString() {
        return "Orders{" +
                "userId=" + userId +
                ", number=" + number +
                ", createtime=" + createtime +
                ", note=" + note +
                "}";
    }
}

package com.lyf.mybatisplusstudy.sys.entity;

import lombok.Data;

import java.io.Serializable;


@Data
public class Orderdetail implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 主鍵，訂單明细表Id
     */
    private Integer id;
    /**
     * 订单id
     */
    private Integer ordersId;

    /**
     * 商品id
     */
    private Integer itemsId;

    /**
     * 商品购买数量
     */
    private Integer itemsNum;

    // 明细对应的商品信息
    private Items items;

    @Override
    public String toString() {
        return "Orderdetail{" +
                "ordersId=" + ordersId +
                ", itemsId=" + itemsId +
                ", itemsNum=" + itemsNum +
                "}";
    }
}

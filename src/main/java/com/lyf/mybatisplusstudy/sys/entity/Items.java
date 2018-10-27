package com.lyf.mybatisplusstudy.sys.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.io.Serializable;

@Data
public class Items implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品表主键Id
     */
    private Integer id;

    /**
     * 商品名称
     */
    private String itemsname;


    /**
     * 商品定价
     */
    private Float price;

    /**
     * 商品描述
     */
    private String detail;

    /**
     * 商品图片
     */
    private String pic;

    /**
     * 生产日期
     */
    private LocalDateTime createtime;


    @Override
    public String toString() {
        return "Items{" +
                "itemsname=" + itemsname +
                ", price=" + price +
                ", detail=" + detail +
                ", pic=" + pic +
                ", createtime=" + createtime +
                "}";
    }
}

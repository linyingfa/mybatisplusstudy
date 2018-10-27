package com.lyf.mybatisplusstudy;

/**
 * Created by xiaolin on 2018/10/27.
 */
public class Tisp {

//todo     2.数据模型分析思路

//    (1).每张表记录的数据内容：分模块对每张表记录的内容进行熟悉，相当 于你学习系统 需求（功能）的过程;
//    (2).每张表重要的字段设置:非空字段、外键字段;
//    (3).数据库级别表与表之间的关系:外键关系;
//    (4).表与表之间的业务关系:在分析表与表之间的业务关系时一定要建立在某个业务意义基础上去分析。


//todo     3.针对订单商品模型的数据库思路分析：
//        用户表:t_user-->记录了购买商品的用户信息
//        订单表:orders-->记录了用户所创建的订单（购买商品的订单）
//        订单明细表:orderdetail-->记录了订单的详细信息即购买商品的信息
//        商品表:items-->记录了商品信息

//todo    表与表之间的业务关系：
//         在分析表与表之间的业务关系时需要建立 在某个业务意义基础上去分析。
//      　先分析数据级别之间有关系的表之间的业务关系：


//todo    t_user和orders：

//           t_user---->orders：一个用户可以创建多个订单，一对多

//　         orders--->t_user：一个订单只由一个用户创建，一对一

//todo    orders和orderdetail：
//
//         orders--->orderdetail： 一个订单可以包括多个订单明细，因为一个订单可以【购买多个商品】，
//                                每个商品的购买信息在orderdetail记录。
//                                一对多关系（一个订单可能存在多个商品，每个商品都有一个详情明细）

//　　     orderdetail--> orders：一个订单明细只能包括在一个订单中，一对一


//todo    orderdetail和itesm：
//
//            　　orderdetail--->itesms：一个订单明细只对应一个商品信息，一对一
//
//　             　items--> orderdetail:一个商品可以包括在多个订单明细 ，一对多

//todo    orders和items：
//
//            　　orders和items之间可以通过orderdetail表建立 关系。


}

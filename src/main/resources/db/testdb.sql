/*
Navicat MySQL Data Transfer

Source Server         : 530
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : testdb

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-10-30 19:22:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for items
-- ----------------------------
DROP TABLE IF EXISTS `items`;
CREATE TABLE `items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `itemsname` varchar(32) NOT NULL COMMENT '��Ʒ����',
  `price` float(10,1) NOT NULL COMMENT '��Ʒ����',
  `detail` text COMMENT '��Ʒ����',
  `pic` varchar(64) DEFAULT NULL COMMENT '��ƷͼƬ',
  `createtime` datetime NOT NULL COMMENT '��������',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of items
-- ----------------------------
INSERT INTO `items` VALUES ('1', '台式机', '3000.0', '该电脑质量非常好！', null, '2015-07-07 13:28:53');
INSERT INTO `items` VALUES ('2', '笔记本', '6000.0', '笔记本性能好，质量好！', null, '2015-07-08 13:22:57');
INSERT INTO `items` VALUES ('3', '背包', '200.0', '名牌背包，容量大质量好！', null, '2015-07-10 13:25:02');

-- ----------------------------
-- Table structure for orderdetail
-- ----------------------------
DROP TABLE IF EXISTS `orderdetail`;
CREATE TABLE `orderdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orders_id` int(11) NOT NULL COMMENT '订单id',
  `items_id` int(11) NOT NULL COMMENT '商品id',
  `items_num` int(11) DEFAULT NULL COMMENT '商品购买数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderdetail
-- ----------------------------
INSERT INTO `orderdetail` VALUES ('1', '1', '1', '1');
INSERT INTO `orderdetail` VALUES ('2', '1', '2', '3');
INSERT INTO `orderdetail` VALUES ('3', '2', '3', '4');
INSERT INTO `orderdetail` VALUES ('4', '3', '2', '3');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '下单用户id',
  `number` varchar(30) NOT NULL COMMENT '订单号',
  `createtime` datetime NOT NULL COMMENT '创建订单时间',
  `note` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '1', '1000010', '2015-06-04 13:22:35', null);
INSERT INTO `orders` VALUES ('2', '1', '1000011', '2015-07-08 13:22:41', null);
INSERT INTO `orders` VALUES ('3', '2', '1000012', '2015-07-17 14:13:23', null);
INSERT INTO `orders` VALUES ('4', '3', '1000012', '2015-07-16 18:13:23', null);
INSERT INTO `orders` VALUES ('5', '4', '1000012', '2015-07-15 19:13:23', null);
INSERT INTO `orders` VALUES ('6', '5', '1000012', '2015-07-14 17:13:23', null);
INSERT INTO `orders` VALUES ('7', '6', '1000012', '2015-07-13 16:13:23', null);

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('1', '530', '23', '530810890@qq.com');
INSERT INTO `person` VALUES ('2', '530', '24', '530810890@qq.com');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL COMMENT '用户名称',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `sex` char(1) DEFAULT NULL COMMENT '性别',
  `address` varchar(256) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '王五', null, '2', null);
INSERT INTO `t_user` VALUES ('2', '张三', '2014-07-10', '1', '北京市');
INSERT INTO `t_user` VALUES ('3', '张小明', null, '1', '河南郑州');
INSERT INTO `t_user` VALUES ('4', '陈小明', null, '1', '河南郑州');
INSERT INTO `t_user` VALUES ('5', '张三丰', null, '1', '河南郑州');
INSERT INTO `t_user` VALUES ('6', '陈小明', null, '1', '河南郑州');
INSERT INTO `t_user` VALUES ('7', '王五', null, null, null);
INSERT INTO `t_user` VALUES ('8', '小A', '2015-06-27', '2', '北京');
INSERT INTO `t_user` VALUES ('9', '小B', '2015-06-27', '2', '北京');
INSERT INTO `t_user` VALUES ('10', '小C', '2015-06-27', '1', '北京');
INSERT INTO `t_user` VALUES ('11', '小D', '2015-06-27', '2', '北京');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `test_id` bigint(20) NOT NULL COMMENT '主键ID',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `name` varchar(30) DEFAULT NULL COMMENT '名称',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `test_type` int(11) DEFAULT NULL COMMENT '测试下划线字段命名类型',
  `test_date` datetime DEFAULT NULL COMMENT '日期',
  `role` bigint(20) DEFAULT NULL COMMENT '测试',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号码',
  PRIMARY KEY (`test_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('0', '1', '雷锋', '1', '1', '2017-01-01 01:01:01', '1', '10010');
INSERT INTO `user` VALUES ('2', '1', '小马', '1', '1', '2017-03-03 01:01:01', '1', '10000');
INSERT INTO `user` VALUES ('3', '2', '麻花藤', '1', '1', '2017-03-03 01:01:01', '1', '10000');
INSERT INTO `user` VALUES ('4', '2', '东狗', '2', '1', '2017-03-03 01:01:01', '1', '10086');
INSERT INTO `user` VALUES ('5', '1', '王五', '2', '1', '2017-03-03 01:01:01', '1', '10010');

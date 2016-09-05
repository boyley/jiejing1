/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : locker

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2016-09-05 18:03:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for locker_action_log
-- ----------------------------
DROP TABLE IF EXISTS `locker_action_log`;
CREATE TABLE `locker_action_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `opt_type` enum('CX','QX') COLLATE utf8_bin DEFAULT NULL COMMENT '操作类型,CX:存箱，QX:取箱',
  `lease_id` int(11) DEFAULT NULL COMMENT '租箱/取箱id',
  `lease_info_id` int(11) DEFAULT NULL COMMENT '资料id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='操作记录';

-- ----------------------------
-- Records of locker_action_log
-- ----------------------------
INSERT INTO `locker_action_log` VALUES ('1', 'CX', '1', '1');
INSERT INTO `locker_action_log` VALUES ('2', 'CX', '1', '2');

-- ----------------------------
-- Table structure for locker_box
-- ----------------------------
DROP TABLE IF EXISTS `locker_box`;
CREATE TABLE `locker_box` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '箱子名称',
  `code` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '箱子编号',
  `cabinet_id` int(11) DEFAULT NULL COMMENT '柜子外键',
  `box_size_id` int(11) DEFAULT NULL COMMENT '箱子规格外键',
  `gate_lock_state` enum('OPEN','CLOSE','ERROR') COLLATE utf8_bin DEFAULT NULL COMMENT '门锁状态;OPEN:打开，CLOSE:关闭，ERROR：异常',
  `deposit_state` enum('Y','N','ERROR','ZY') COLLATE utf8_bin DEFAULT NULL COMMENT '存物状态Y:有存物，N：无存物，ERROR：异常,ZY:占用',
  `created_by` int(11) DEFAULT NULL COMMENT '创建人',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_modified_by` int(11) DEFAULT NULL COMMENT '最后的更新人',
  `last_modified_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
  `description` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  `status` enum('ENABLE','DISENABLE','ERROR') COLLATE utf8_bin DEFAULT NULL COMMENT '是否禁用: ENABLE:启用，DISENABLE:禁用，ERROR:错误异常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='箱子信息表';

-- ----------------------------
-- Records of locker_box
-- ----------------------------
INSERT INTO `locker_box` VALUES ('1', 'box1', 'box1', '1', '2', 'CLOSE', 'Y', '0', '2016-09-01 15:02:42', '0', '2016-09-01 15:02:42', 'description', 'ENABLE');
INSERT INTO `locker_box` VALUES ('2', 'box2', 'box2', '1', '3', 'OPEN', 'Y', '0', '2016-09-02 11:33:25', null, null, null, null);
INSERT INTO `locker_box` VALUES ('3', 'box3', 'box3', '1', '4', 'OPEN', 'ERROR', '0', '2016-09-02 11:34:03', null, null, null, null);
INSERT INTO `locker_box` VALUES ('4', 'box4', 'box4', '1', '2', 'CLOSE', 'Y', '0', '2016-09-01 15:02:42', '0', '2016-09-01 15:02:42', 'description', 'ENABLE');
INSERT INTO `locker_box` VALUES ('5', 'box5', 'box5', '1', '3', 'OPEN', 'Y', '0', '2016-09-02 11:33:25', null, null, null, null);
INSERT INTO `locker_box` VALUES ('6', 'box6', 'box6', '1', '4', 'OPEN', 'Y', '0', '2016-09-02 11:34:03', null, null, null, null);
INSERT INTO `locker_box` VALUES ('7', 'box7', 'box7', '1', '5', 'OPEN', 'Y', '0', '2016-09-02 17:50:01', null, '2016-09-02 17:50:01', null, null);

-- ----------------------------
-- Table structure for locker_box_charge_standard
-- ----------------------------
DROP TABLE IF EXISTS `locker_box_charge_standard`;
CREATE TABLE `locker_box_charge_standard` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `box_id` int(11) DEFAULT NULL COMMENT '箱子id',
  `charge_standard_id` int(11) DEFAULT NULL COMMENT '收费标准id',
  `created_by` int(11) DEFAULT NULL COMMENT '创建人',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_modified_by` int(11) DEFAULT NULL COMMENT '最后的更新人',
  `last_modified_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='收费关联表';

-- ----------------------------
-- Records of locker_box_charge_standard
-- ----------------------------
INSERT INTO `locker_box_charge_standard` VALUES ('1', '1', '1', '0', '2016-09-02 11:32:21', '0', '2016-09-02 11:32:21');
INSERT INTO `locker_box_charge_standard` VALUES ('2', '2', '2', null, '2016-09-02 11:44:46', null, null);
INSERT INTO `locker_box_charge_standard` VALUES ('3', '3', '3', null, '2016-09-02 11:44:53', null, null);
INSERT INTO `locker_box_charge_standard` VALUES ('4', '4', '1', null, '2016-09-02 11:44:59', null, null);
INSERT INTO `locker_box_charge_standard` VALUES ('5', '5', '2', null, '2016-09-02 11:45:08', null, null);
INSERT INTO `locker_box_charge_standard` VALUES ('6', '6', '3', null, '2016-09-02 11:45:46', null, null);

-- ----------------------------
-- Table structure for locker_cabinet
-- ----------------------------
DROP TABLE IF EXISTS `locker_cabinet`;
CREATE TABLE `locker_cabinet` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '柜子编码',
  `name` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '柜子名称',
  `region_id` int(11) DEFAULT NULL COMMENT '地址：道路/小区 编码',
  `lon` decimal(10,5) DEFAULT NULL COMMENT '地理经度',
  `lat` decimal(10,5) DEFAULT NULL COMMENT '地理纬度',
  `status` enum('ENABLE','DISENABLE','ERROR') COLLATE utf8_bin DEFAULT NULL COMMENT '是否禁用: ENABLE:启用，DISENABLE:禁用，ERROR:错误异常',
  `multiple` tinyint(1) DEFAULT NULL COMMENT '可多次使用',
  `voucher_verify` tinyint(1) DEFAULT NULL COMMENT '是否证件验证',
  `description` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  `created_by` int(11) DEFAULT NULL COMMENT '创建人',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_modified_by` int(11) DEFAULT NULL COMMENT '最后的更新人',
  `last_modified_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
  `open_time` datetime NOT NULL COMMENT '开机时间',
  `close_time` datetime NOT NULL COMMENT '关机时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='柜子信息表';

-- ----------------------------
-- Records of locker_cabinet
-- ----------------------------
INSERT INTO `locker_cabinet` VALUES ('1', 'code', 'name', '1', '3.00000', '3.00000', 'ENABLE', '0', '0', 'description', '0', '2016-09-01 15:02:42', '0', '2016-09-01 15:02:42', '2016-09-01 15:02:42', '2016-09-01 15:02:42');

-- ----------------------------
-- Table structure for locker_charge_standard
-- ----------------------------
DROP TABLE IF EXISTS `locker_charge_standard`;
CREATE TABLE `locker_charge_standard` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `charge_type` enum('TIME_HOUR','TIME_CYCLE') COLLATE utf8_bin DEFAULT NULL COMMENT '收费方式（TIME_HOUR:时间节点，TIME_CYCLE:时间段收费）',
  `cycle_time` int(11) DEFAULT NULL COMMENT '收费周期（小时）',
  `description` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  `created_by` int(11) DEFAULT NULL COMMENT '创建人',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_modified_by` int(11) DEFAULT NULL COMMENT '最后的更新人',
  `last_modified_date` datetime DEFAULT NULL COMMENT '最后一次更新时间',
  `default_box_size` int(11) DEFAULT NULL COMMENT '默认收费规格',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='收费标准';

-- ----------------------------
-- Records of locker_charge_standard
-- ----------------------------
INSERT INTO `locker_charge_standard` VALUES ('1', '30.00', 'TIME_CYCLE', '3', '小箱默认收费标准', '0', '2016-09-02 11:31:34', '0', '2016-09-02 11:31:34', '2');
INSERT INTO `locker_charge_standard` VALUES ('2', '40.00', 'TIME_CYCLE', '4', '中箱默认收费标准', '0', '2016-09-02 11:43:55', null, null, '3');
INSERT INTO `locker_charge_standard` VALUES ('3', '50.00', 'TIME_HOUR', '5', '大箱默认收费标准', '0', '2016-09-02 11:44:08', null, null, '4');
INSERT INTO `locker_charge_standard` VALUES ('4', '70.00', 'TIME_CYCLE', '5', '超大箱默认收费标准', '0', '2016-09-02 11:52:33', null, null, '5');

-- ----------------------------
-- Table structure for locker_lease_box
-- ----------------------------
DROP TABLE IF EXISTS `locker_lease_box`;
CREATE TABLE `locker_lease_box` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `created_by` int(11) DEFAULT NULL COMMENT '创建人',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_modified_by` int(11) DEFAULT NULL COMMENT '最后的更新人',
  `last_modified_date` datetime DEFAULT NULL COMMENT '最后一次更新时间',
  `cabinet_id` int(11) DEFAULT NULL COMMENT '存储柜id',
  `box_id` int(11) DEFAULT NULL COMMENT '存储箱id',
  `box_size_id` int(11) DEFAULT NULL COMMENT '存储箱规格id',
  `charge_standard_id` int(11) DEFAULT NULL COMMENT '计费标准id',
  `cabinet_name` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '存储柜名称',
  `cabinet_code` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '存储柜编码',
  `box_name` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '存储箱名称',
  `box_code` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '存储箱名称',
  `box_size_name` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '存储箱规格名称',
  `box_size_code` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '存储箱规格编码',
  `charge_type` enum('TIME_HOUR','TIME_CYCLE') COLLATE utf8_bin DEFAULT NULL COMMENT '收费方式（TIME_HOUR:时间节点，TIME_CYCLE:时间段收费）',
  `cycle_time` int(11) DEFAULT NULL COMMENT '收费周期（小时）',
  `price` decimal(9,2) DEFAULT NULL COMMENT '价格',
  `order_id` int(11) DEFAULT NULL COMMENT '订单id',
  `box_state` enum('DQ','YQ','ZY') COLLATE utf8_bin DEFAULT NULL COMMENT '箱状态DQ:待取，YQ：已取,ZY:占用',
  `check_type` int(11) DEFAULT NULL COMMENT '校验模式（引用sys_dictionary）',
  `timeout` int(11) DEFAULT NULL COMMENT '是否超时寄存,大于0表示超时，具体数值表示超时值',
  `fetch_time` datetime DEFAULT NULL COMMENT '取箱时间',
  `retreat_id` int(11) DEFAULT NULL COMMENT '补单id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='租箱记录';

-- ----------------------------
-- Records of locker_lease_box
-- ----------------------------
INSERT INTO `locker_lease_box` VALUES ('1', '0', '2016-09-05 14:25:44', '0', '2016-09-05 14:25:44', '1', '1', '2', '1', 'name', 'code', 'box1', 'box1', '小', 'Small', 'TIME_CYCLE', '3', '30.00', '1', 'DQ', '1', null, null, null);

-- ----------------------------
-- Table structure for locker_lease_info
-- ----------------------------
DROP TABLE IF EXISTS `locker_lease_info`;
CREATE TABLE `locker_lease_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `info_type` int(11) DEFAULT NULL COMMENT '资料类型（引用sys_dictionary）',
  `code` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '证件类型code',
  `name` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '资料名称',
  `info_content` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '资料内容',
  `info_file` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '资料文件',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='租/取箱资料';

-- ----------------------------
-- Records of locker_lease_info
-- ----------------------------
INSERT INTO `locker_lease_info` VALUES ('1', '8', 'HZ', '护照', '{\"name:\":\"张三\",\"no\":\"51000000000000xxxx\"}', null);
INSERT INTO `locker_lease_info` VALUES ('2', '7', 'SFZ', '身份证', '{\"name:\":\"张三\",\"no\":\"51000000000000xxxx\"}', null);

-- ----------------------------
-- Table structure for locker_order_handle
-- ----------------------------
DROP TABLE IF EXISTS `locker_order_handle`;
CREATE TABLE `locker_order_handle` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `created_by` int(11) DEFAULT NULL COMMENT '创建人',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_modified_by` int(11) DEFAULT NULL COMMENT '最后的更新人',
  `last_modified_date` datetime DEFAULT NULL COMMENT '最后一次更新时间',
  `order_id` int(11) DEFAULT NULL COMMENT '订单id',
  `action_type` int(11) DEFAULT NULL COMMENT '动作类型，关联sys_dictionary表',
  `description` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='订单处理';

-- ----------------------------
-- Records of locker_order_handle
-- ----------------------------

-- ----------------------------
-- Table structure for locker_region
-- ----------------------------
DROP TABLE IF EXISTS `locker_region`;
CREATE TABLE `locker_region` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '编码',
  `name` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '节点名称',
  `parent_id` int(11) DEFAULT NULL COMMENT '所属父节点id',
  `url` varchar(256) COLLATE utf8_bin DEFAULT NULL COMMENT '访问路径',
  `description` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  `created_by` int(11) DEFAULT NULL COMMENT '创建人',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_modified_by` int(11) DEFAULT NULL COMMENT '最后的更新人',
  `last_modified_date` datetime DEFAULT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='区域信息';

-- ----------------------------
-- Records of locker_region
-- ----------------------------

-- ----------------------------
-- Table structure for sys_account
-- ----------------------------
DROP TABLE IF EXISTS `sys_account`;
CREATE TABLE `sys_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `country_code` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '国家代码',
  `phone_no` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='账号信息';

-- ----------------------------
-- Records of sys_account
-- ----------------------------

-- ----------------------------
-- Table structure for sys_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `sys_dictionary`;
CREATE TABLE `sys_dictionary` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '字典编码',
  `name` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '字典名称',
  `value_type` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '字典值类型',
  `value` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '字典值',
  `description` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  `created_by` int(11) DEFAULT NULL COMMENT '创建人',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_modified_by` int(11) DEFAULT NULL COMMENT '最后的更新人',
  `last_modified_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
  `parent_id` int(11) DEFAULT NULL COMMENT '父节点id',
  `parent_code` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '父节点code',
  `editable` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否可编辑',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='字典表';

-- ----------------------------
-- Records of sys_dictionary
-- ----------------------------
INSERT INTO `sys_dictionary` VALUES ('1', 'box_size', '箱子规格', 'array', 'BOX_SIZE', '箱子规格，大，小，中，超大', null, '2016-09-02 11:37:12', null, null, null, null, '\0');
INSERT INTO `sys_dictionary` VALUES ('2', 'Small', '小', 'String', 'Small', '35mm*15mm*10mm', null, '2016-09-02 11:38:11', null, null, '1', 'box_size', '\0');
INSERT INTO `sys_dictionary` VALUES ('3', 'Medium', '中', 'String', 'Medium', '55mm*35mm*20mm', null, '2016-09-02 11:38:33', null, null, '1', 'box_size', '\0');
INSERT INTO `sys_dictionary` VALUES ('4', 'Large', '大', 'String', 'Large', '75mm*55mm*40mm', null, '2016-09-02 11:38:54', null, null, '1', 'box_size', '\0');
INSERT INTO `sys_dictionary` VALUES ('5', 'XLarge', '超大', 'String', 'XLarge', '95mm*75mm*60mm', null, '2016-09-02 11:53:16', null, '2016-09-02 11:53:16', null, 'box_size', '\0');
INSERT INTO `sys_dictionary` VALUES ('6', 'Info_type', '资料信息', 'String', 'Info', '护照，身份证，手机号，二维码等等资料信息', null, '2016-09-02 16:56:54', null, '2016-09-02 16:56:54', null, null, '\0');
INSERT INTO `sys_dictionary` VALUES ('7', 'SFZ', '身份证', 'String', 'SFZ', '身份证', null, '2016-09-02 16:57:36', null, '2016-09-02 16:57:36', null, 'Info_type', '\0');
INSERT INTO `sys_dictionary` VALUES ('8', 'HZ', '护照', 'String', 'HZ', '护照', null, '2016-09-02 17:15:20', null, '2016-09-02 17:15:20', null, 'Info_type', '\0');
INSERT INTO `sys_dictionary` VALUES ('9', 'RECEIPT', '小票', 'String', 'RECEIPT', '小票', null, '2016-09-02 17:15:36', null, '2016-09-02 17:15:36', null, 'Info_type', '\0');
INSERT INTO `sys_dictionary` VALUES ('10', 'PWD', '密码', 'String', 'PWD', '密码', null, '2016-09-02 17:16:25', null, '2016-09-02 17:16:25', null, 'Info_type', '\0');
INSERT INTO `sys_dictionary` VALUES ('11', 'SJH', '手机号', 'String', 'SJH', '手机号', null, '2016-09-05 14:00:17', null, '2016-09-05 14:00:17', null, 'Info_type', '\0');
INSERT INTO `sys_dictionary` VALUES ('12', 'order_source', '下单渠道', 'String', 'order_source', '下单渠道', null, '2016-09-05 14:43:39', null, '2016-09-05 14:43:39', null, null, '\0');
INSERT INTO `sys_dictionary` VALUES ('13', 'APP', 'APP', 'String', 'APP', 'APP', null, '2016-09-05 14:44:19', null, '2016-09-05 14:44:19', '12', 'order_source', '\0');
INSERT INTO `sys_dictionary` VALUES ('14', 'WeChat', '微信', 'String', 'WeChat', '微信', null, '2016-09-05 14:44:39', null, '2016-09-05 14:44:39', '12', 'order_source', '\0');
INSERT INTO `sys_dictionary` VALUES ('15', 'GKD', '工控端', 'String', 'GKD', '工控端', null, '2016-09-05 14:44:50', null, '2016-09-05 14:44:50', '12', 'order_source', '\0');
INSERT INTO `sys_dictionary` VALUES ('16', 'pay_type', '支付类型', 'String', 'pay_type', '支付类型', null, '2016-09-05 14:46:26', null, '2016-09-05 14:46:26', null, null, '\0');
INSERT INTO `sys_dictionary` VALUES ('17', 'XJPAY', '现金支付', 'String', 'XJPAY', '现金支付', null, '2016-09-05 14:47:35', null, '2016-09-05 14:47:35', '16', 'pay_type', '\0');
INSERT INTO `sys_dictionary` VALUES ('18', 'WXPAY', '微信支付', 'String', 'WXPAY', '微信支付', null, '2016-09-05 14:48:13', null, '2016-09-05 14:48:13', '16', 'pay_type', '\0');
INSERT INTO `sys_dictionary` VALUES ('19', 'ALIPAY', '支付宝支付', 'String', 'ALIPAY', '支付宝支付', null, '2016-09-05 14:49:25', null, '2016-09-05 14:49:25', '16', 'pay_type', '\0');
INSERT INTO `sys_dictionary` VALUES ('20', 'fethc_type', '提取验证', 'String', 'fethc_type', '提取验证', null, '2016-09-05 15:14:01', null, '2016-09-05 15:14:01', '20', null, '\0');
INSERT INTO `sys_dictionary` VALUES ('21', 'Receipt', '小票提取', 'String', 'Receipt', '小票提取', null, '2016-09-05 15:15:23', null, '2016-09-05 15:15:23', null, 'fethc_type', '\0');
INSERT INTO `sys_dictionary` VALUES ('22', 'PWD', '密码提取', 'String', 'PWD', '密码提取', null, '2016-09-05 15:15:37', null, '2016-09-05 15:15:37', null, 'fethc_type', '\0');
INSERT INTO `sys_dictionary` VALUES ('23', 'ID_Card', '证件提取', 'String', 'ID_Card', '证件提取', null, '2016-09-05 15:16:20', null, '2016-09-05 15:16:20', null, 'fethc_type', '\0');

-- ----------------------------
-- Table structure for sys_order
-- ----------------------------
DROP TABLE IF EXISTS `sys_order`;
CREATE TABLE `sys_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_num` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '订单号',
  `created_by` int(11) DEFAULT NULL COMMENT '创建人',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_modified_by` int(11) DEFAULT NULL COMMENT '最后的更新人',
  `last_modified_date` datetime DEFAULT NULL COMMENT '最后一次更新时间',
  `order_state` enum('DZF','YZF','YQX','YWC','YGB') COLLATE utf8_bin DEFAULT NULL COMMENT '订单状态DZF:待支付，YZF：已支付，YQX：已取消，YWC：已完成,YGB:已关闭',
  `order_source` int(11) DEFAULT NULL COMMENT '下单渠道',
  `price` decimal(9,2) DEFAULT NULL COMMENT '费用',
  `pay_price` decimal(9,2) DEFAULT NULL COMMENT '支付金额',
  `retreat_price` decimal(9,2) DEFAULT NULL COMMENT '找补金额',
  `pay_type` int(11) DEFAULT NULL COMMENT '支付方式,关联sys_dictionary表',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='订单表';

-- ----------------------------
-- Records of sys_order
-- ----------------------------
INSERT INTO `sys_order` VALUES ('1', '1473056743878', '0', '2016-09-05 14:25:44', '0', '2016-09-05 14:25:44', 'DZF', '1', '30.00', '500.00', '470.00', null);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account_id` int(11) DEFAULT NULL COMMENT '账号id',
  `name` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '姓名',
  `sex` enum('F','M','N') COLLATE utf8_bin DEFAULT NULL COMMENT 'male 雄性,female 雌性,null:未知',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_modified_date` datetime DEFAULT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户信息';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('2', '1', 'name', 'M', '2016-08-30 10:13:01', '2016-08-30 10:13:01');
INSERT INTO `sys_user` VALUES ('3', '2', 'name', 'M', '2016-08-30 10:17:31', '2016-08-30 10:17:31');

-- ----------------------------
-- Table structure for sys_user_extra
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_extra`;
CREATE TABLE `sys_user_extra` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `cert_type` int(11) DEFAULT NULL COMMENT '证件类型（引用sys_dictionary）',
  `num` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '证件号',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_modified_date` datetime DEFAULT NULL COMMENT '最后一次更新时间',
  `url` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '图片url',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户其他信息';

-- ----------------------------
-- Records of sys_user_extra
-- ----------------------------

-- ----------------------------
-- View structure for view_box_size
-- ----------------------------
DROP VIEW IF EXISTS `view_box_size`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost`  VIEW `view_box_size` AS SELECT DISTINCT
	DISTINCT locker_charge_standard.id,
	locker_box.cabinet_id cabinet_id,
	locker_box.box_size_id box_size_id,
	sys_dictionary.`code`,
	sys_dictionary.`name`,
	locker_charge_standard.price,
	sys_dictionary.description
FROM
	locker_box_charge_standard
INNER JOIN locker_box ON locker_box.id = locker_box_charge_standard.box_id
INNER JOIN locker_cabinet ON locker_box.cabinet_id = locker_cabinet.id
INNER JOIN locker_charge_standard ON locker_charge_standard.id = locker_box_charge_standard.charge_standard_id
INNER JOIN sys_dictionary ON locker_box.box_size_id = sys_dictionary.id
UNION
SELECT
	DISTINCT locker_charge_standard.id,
	locker_box.cabinet_id cabinet_id,
	locker_box.box_size_id box_size_id,
	sys_dictionary.`code`,
	sys_dictionary.`name`,
	locker_charge_standard.price,
	sys_dictionary.description
from locker_box
INNER JOIN locker_cabinet ON locker_box.cabinet_id = locker_cabinet.id
INNER JOIN sys_dictionary ON locker_box.box_size_id = sys_dictionary.id
INNER JOIN locker_charge_standard ON  locker_charge_standard.default_box_size = locker_box.box_size_id
WHERE locker_box.id NOT in (select box_id from locker_box_charge_standard) ;
SET FOREIGN_KEY_CHECKS=1;

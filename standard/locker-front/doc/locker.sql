/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : locker

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2016-09-01 11:00:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for action_log
-- ----------------------------
DROP TABLE IF EXISTS `action_log`;
CREATE TABLE `action_log` (
  `id` int(11) DEFAULT NULL COMMENT '主键',
  `opt_type` enum('CX','QX') COLLATE utf8_bin DEFAULT NULL COMMENT '操作类型,CX:存箱，QX:取箱',
  `lease_id` int(11) DEFAULT NULL COMMENT '租箱/取箱id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='操作记录';

-- ----------------------------
-- Records of action_log
-- ----------------------------

-- ----------------------------
-- Table structure for lease_box
-- ----------------------------
DROP TABLE IF EXISTS `lease_box`;
CREATE TABLE `lease_box` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `created_by` int(11) DEFAULT NULL COMMENT '创建人',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_modified_by` int(11) DEFAULT NULL COMMENT '最后的更新人',
  `last_modified_date` datetime DEFAULT NULL COMMENT '最后一次更新时间',
  `cabinet_id` int(11) DEFAULT NULL COMMENT '存储柜id',
  `box_id` int(11) DEFAULT NULL COMMENT '存储箱id',
  `box_size_id` int(11) DEFAULT NULL COMMENT '存储箱规格id',
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
  `box_state` enum('DQ','YQ') COLLATE utf8_bin DEFAULT NULL COMMENT '箱状态DQ:待取，YQ：已取',
  `check_type` int(11) DEFAULT NULL COMMENT '校验模式（引用sys_dictionary）',
  `timeout` int(11) DEFAULT NULL COMMENT '是否超时寄存,大于0表示超时，具体数值表示超时值',
  `fetch_time` datetime DEFAULT NULL COMMENT '取箱时间',
  `retreat_id` int(11) DEFAULT NULL COMMENT '补单id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='租箱记录';

-- ----------------------------
-- Records of lease_box
-- ----------------------------

-- ----------------------------
-- Table structure for lease_info
-- ----------------------------
DROP TABLE IF EXISTS `lease_info`;
CREATE TABLE `lease_info` (
  `id` int(11) DEFAULT NULL COMMENT '主键',
  `action_id` int(11) DEFAULT NULL COMMENT '操作记录id',
  `info_type` int(11) DEFAULT NULL COMMENT '资料类型（引用sys_dictionary）',
  `name` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '资料名称',
  `info_content` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '资料内容',
  `info_file` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '资料文件'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='租/取箱资料';

-- ----------------------------
-- Records of lease_info
-- ----------------------------

-- ----------------------------
-- Table structure for locker_box
-- ----------------------------
DROP TABLE IF EXISTS `locker_box`;
CREATE TABLE `locker_box` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '箱子编号',
  `cabinet_id` int(11) DEFAULT NULL COMMENT '柜子外键',
  `box_size_id` int(11) DEFAULT NULL COMMENT '箱子规格外键',
  `gate_lock_state` enum('OPEN','CLOSE','ERROR') COLLATE utf8_bin DEFAULT NULL COMMENT '门锁状态;OPEN:打开，CLOSE:关闭，ERROR：异常',
  `deposit_state` enum('Y','N','ERROR') COLLATE utf8_bin DEFAULT NULL COMMENT '存物状态Y:有存物，N：无存物，ERROR：异常',
  `created_by` int(11) DEFAULT NULL COMMENT '创建人',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_modified_by` int(11) DEFAULT NULL COMMENT '最后的更新人',
  `last_modified_date` datetime DEFAULT NULL COMMENT '最后一次更新时间',
  `description` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  `status` enum('ENABLE','DISENABLE','ERROR') COLLATE utf8_bin DEFAULT NULL COMMENT '是否禁用: ENABLE:启用，DISENABLE:禁用，ERROR:错误异常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='箱子信息表';

-- ----------------------------
-- Records of locker_box
-- ----------------------------

-- ----------------------------
-- Table structure for locker_box_size
-- ----------------------------
DROP TABLE IF EXISTS `locker_box_size`;
CREATE TABLE `locker_box_size` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '编码',
  `name` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '名称',
  `description` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  `created_by` int(11) DEFAULT NULL COMMENT '创建人',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_modified_by` int(11) DEFAULT NULL COMMENT '最后的更新人',
  `last_modified_date` datetime DEFAULT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='箱子规格';

-- ----------------------------
-- Records of locker_box_size
-- ----------------------------
INSERT INTO `locker_box_size` VALUES ('1', 'code', 'name', 'description', '1', '2016-08-30 09:19:19', '1', '2016-08-30 09:19:19');
INSERT INTO `locker_box_size` VALUES ('2', 'code', 'name', 'description', '1', '2016-08-30 17:30:49', '1', '2016-08-30 17:30:49');

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
  `last_modified_date` datetime DEFAULT NULL COMMENT '最后一次更新时间',
  `open_time` datetime DEFAULT NULL COMMENT '开机时间',
  `close_time` datetime DEFAULT NULL COMMENT '关机时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='柜子信息表';

-- ----------------------------
-- Records of locker_cabinet
-- ----------------------------

-- ----------------------------
-- Table structure for locker_charge_standard
-- ----------------------------
DROP TABLE IF EXISTS `locker_charge_standard`;
CREATE TABLE `locker_charge_standard` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cabinet_id` int(11) DEFAULT NULL COMMENT '柜子外键',
  `box_size_id` int(11) DEFAULT NULL COMMENT '箱子规格外键',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `charge_type` enum('TIME_HOUR','TIME_CYCLE') COLLATE utf8_bin DEFAULT NULL COMMENT '收费方式（TIME_HOUR:时间节点，TIME_CYCLE:时间段收费）',
  `cycle_time` int(11) DEFAULT NULL COMMENT '收费周期（小时）',
  `description` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  `created_by` int(11) DEFAULT NULL COMMENT '创建人',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_modified_by` int(11) DEFAULT NULL COMMENT '最后的更新人',
  `last_modified_date` datetime DEFAULT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='收费标准';

-- ----------------------------
-- Records of locker_charge_standard
-- ----------------------------

-- ----------------------------
-- Table structure for locker_fetch_box
-- ----------------------------
DROP TABLE IF EXISTS `locker_fetch_box`;
CREATE TABLE `locker_fetch_box` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `created_by` int(11) DEFAULT NULL COMMENT '创建人',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_modified_by` int(11) DEFAULT NULL COMMENT '最后的更新人',
  `last_modified_date` datetime DEFAULT NULL COMMENT '最后一次更新时间',
  `lease_box_id` int(11) DEFAULT NULL COMMENT '租箱记录id',
  `order_id` int(11) DEFAULT NULL COMMENT '补单id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='取箱记录';

-- ----------------------------
-- Records of locker_fetch_box
-- ----------------------------

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
  `box_state` enum('DQ','YQ') COLLATE utf8_bin DEFAULT NULL COMMENT '箱状态DQ:待取，YQ：已取',
  `cert_type` int(11) DEFAULT NULL COMMENT '证件类型（引用sys_dictionary）',
  `num` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '取箱证件号',
  `pwd` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '取箱密码',
  `timeout` int(11) DEFAULT NULL COMMENT '是否超时寄存,大于0表示超时，具体数值表示超时值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='租箱记录';

-- ----------------------------
-- Records of locker_lease_box
-- ----------------------------

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
  `id` int(11) DEFAULT NULL COMMENT '主键',
  `code` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '字典编码',
  `name` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '字典名称',
  `value_type` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '字典值类型',
  `value` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '字典值',
  `description` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  `created_by` int(11) DEFAULT NULL COMMENT '创建人',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_modified_by` int(11) DEFAULT NULL COMMENT '最后的更新人',
  `last_modified_date` datetime DEFAULT NULL COMMENT '最后一次更新时间',
  `parent_id` int(11) DEFAULT NULL COMMENT '父节点id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='字典表';

-- ----------------------------
-- Records of sys_dictionary
-- ----------------------------

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='订单表';

-- ----------------------------
-- Records of sys_order
-- ----------------------------

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
SET FOREIGN_KEY_CHECKS=1;

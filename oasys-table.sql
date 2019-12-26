/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : oasys

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 25/12/2019 22:49:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for aoa_attachment_list
-- ----------------------------
DROP TABLE IF EXISTS `aoa_attachment_list`;
CREATE TABLE `aoa_attachment_list` (
  `attachment_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '附件ID',
  `attachment_name` varchar(255) DEFAULT NULL COMMENT '附件名',
  `attachment_path` varchar(255) DEFAULT NULL COMMENT '附件路径',
  `attachment_shuffix` varchar(255) DEFAULT NULL COMMENT '附件后缀',
  `attachment_size` varchar(255) DEFAULT NULL COMMENT '附件大小',
  `attachment_type` varchar(255) DEFAULT NULL COMMENT '附件类型',
  `model` varchar(255) DEFAULT NULL COMMENT '模型',
  `upload_time` datetime DEFAULT NULL COMMENT '附件上传时间',
  `user_id` varchar(255) DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`attachment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=244 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_attends_list
-- ----------------------------
DROP TABLE IF EXISTS `aoa_attends_list`;
CREATE TABLE `aoa_attends_list` (
  `attends_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '考勤表ID',
  `attends_ip` varchar(20) DEFAULT NULL COMMENT '考勤表登录IP',
  `attends_remark` varchar(20) DEFAULT NULL COMMENT '考勤备注',
  `attends_time` datetime DEFAULT NULL COMMENT '考勤时间',
  `status_id` bigint(20) DEFAULT NULL COMMENT '考勤状态ID',
  `type_id` bigint(20) DEFAULT NULL COMMENT '考勤类型ID',
  `attends_user_id` bigint(20) DEFAULT NULL COMMENT '考勤用户ID',
  `attend_hmtime` varchar(255) DEFAULT NULL COMMENT '考勤时分',
  `week_ofday` varchar(255) DEFAULT NULL COMMENT '星期几',
  `holiday_days` double(255,0) DEFAULT '0' COMMENT '请假天数',
  `holiday_start` date DEFAULT NULL COMMENT '请假开始时间',
  PRIMARY KEY (`attends_id`),
  KEY `FKaxgqsm98npnl1rxysh9upfjee` (`attends_user_id`),
  CONSTRAINT `FKaxgqsm98npnl1rxysh9upfjee` FOREIGN KEY (`attends_user_id`) REFERENCES `aoa_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_bursement
-- ----------------------------
DROP TABLE IF EXISTS `aoa_bursement`;
CREATE TABLE `aoa_bursement` (
  `bursement_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '费用报销表ID',
  `all_money` double DEFAULT NULL COMMENT '总钱数',
  `allinvoices` int(11) DEFAULT NULL COMMENT '票据总数',
  `burse_time` datetime DEFAULT NULL COMMENT '报销日期',
  `financial_advice` varchar(255) DEFAULT NULL COMMENT '财务意见说明',
  `manager_advice` varchar(255) DEFAULT NULL COMMENT '经理意见及说明',
  `name` varchar(255) DEFAULT NULL COMMENT '相关客户',
  `type_id` bigint(20) DEFAULT NULL COMMENT '报销方式（现金，刷卡）',
  `operation_name` bigint(20) DEFAULT NULL COMMENT '报销人员',
  `pro_id` bigint(20) DEFAULT NULL COMMENT '流程主表ID',
  `user_name` bigint(20) DEFAULT NULL COMMENT '证明人',
  PRIMARY KEY (`bursement_id`),
  KEY `FKt3xu5y23deh0mtqkfk3ly6219` (`operation_name`),
  KEY `FK666vswh4nl3voq8qalu73v2sq` (`pro_id`),
  KEY `FKgnqp4eax31sh7mn3lt2su7olr` (`user_name`),
  CONSTRAINT `FK666vswh4nl3voq8qalu73v2sq` FOREIGN KEY (`pro_id`) REFERENCES `aoa_process_list` (`process_id`),
  CONSTRAINT `FKgnqp4eax31sh7mn3lt2su7olr` FOREIGN KEY (`user_name`) REFERENCES `aoa_user` (`user_id`),
  CONSTRAINT `FKt3xu5y23deh0mtqkfk3ly6219` FOREIGN KEY (`operation_name`) REFERENCES `aoa_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_catalog
-- ----------------------------
DROP TABLE IF EXISTS `aoa_catalog`;
CREATE TABLE `aoa_catalog` (
  `catalog_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '目录id',
  `catalog_name` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '目录名字',
  `parent_id` int(11) DEFAULT NULL COMMENT '判断id',
  `cata_user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`catalog_id`),
  KEY `FKbsk5nkjlqmd8j9rmkarse6j1x` (`cata_user_id`),
  CONSTRAINT `FKbsk5nkjlqmd8j9rmkarse6j1x` FOREIGN KEY (`cata_user_id`) REFERENCES `aoa_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_comment_list
-- ----------------------------
DROP TABLE IF EXISTS `aoa_comment_list`;
CREATE TABLE `aoa_comment_list` (
  `comment_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '评论列表ID',
  `comment` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `time` datetime DEFAULT NULL COMMENT '评论时间',
  `comment_user_id` bigint(20) DEFAULT NULL COMMENT '评论人归属人ID',
  `reply_id` bigint(20) DEFAULT NULL COMMENT '回复表ID',
  PRIMARY KEY (`comment_id`),
  KEY `FK2k00kkfhh93949ybod7qn56ax` (`comment_user_id`),
  KEY `FKeopff14rxco5thbwwlu7exglo` (`reply_id`),
  CONSTRAINT `FK2k00kkfhh93949ybod7qn56ax` FOREIGN KEY (`comment_user_id`) REFERENCES `aoa_user` (`user_id`),
  CONSTRAINT `FKeopff14rxco5thbwwlu7exglo` FOREIGN KEY (`reply_id`) REFERENCES `aoa_reply_list` (`reply_id`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_dept
-- ----------------------------
DROP TABLE IF EXISTS `aoa_dept`;
CREATE TABLE `aoa_dept` (
  `dept_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dept_addr` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '部门地址',
  `dept_fax` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '传真',
  `dept_name` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '部门名字',
  `dept_tel` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '部门电话',
  `email` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '部门email',
  `deptmanager` bigint(20) DEFAULT NULL COMMENT '部门领导ID',
  `end_time` datetime DEFAULT NULL COMMENT '部门下班时间',
  `start_time` datetime DEFAULT NULL COMMENT '部门上班时间',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_detailsburse
-- ----------------------------
DROP TABLE IF EXISTS `aoa_detailsburse`;
CREATE TABLE `aoa_detailsburse` (
  `detailsburse_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descript` varchar(255) DEFAULT NULL,
  `detailmoney` double NOT NULL,
  `invoices` int(11) DEFAULT NULL,
  `produce_time` datetime DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `bursment_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`detailsburse_id`),
  KEY `FKi02w0bghxr73fsc5sbpeyqdnn` (`bursment_id`),
  CONSTRAINT `FKi02w0bghxr73fsc5sbpeyqdnn` FOREIGN KEY (`bursment_id`) REFERENCES `aoa_bursement` (`bursement_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_director
-- ----------------------------
DROP TABLE IF EXISTS `aoa_director`;
CREATE TABLE `aoa_director` (
  `director_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '外部通讯录表ID',
  `address` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '用户地址',
  `company_number` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '公司电话',
  `email` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '用户邮箱',
  `image_path` int(11) DEFAULT NULL COMMENT '用户图像',
  `phone_number` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '用户电话',
  `pinyin` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '用户名拼音',
  `remark` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '备注',
  `sex` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '性别',
  `user_name` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '用户名',
  `user_id` bigint(20) DEFAULT NULL COMMENT '创建此外部通讯录用户ID',
  `companyname` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '公司名',
  PRIMARY KEY (`director_id`),
  KEY `FKi6pfdnqhbc6js940e2o1vape5` (`user_id`),
  CONSTRAINT `FKi6pfdnqhbc6js940e2o1vape5` FOREIGN KEY (`user_id`) REFERENCES `aoa_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_director_users
-- ----------------------------
DROP TABLE IF EXISTS `aoa_director_users`;
CREATE TABLE `aoa_director_users` (
  `director_users_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '目录用户表ID',
  `catelog_name` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '外部通讯录的目录名',
  `is_handle` int(11) DEFAULT NULL COMMENT '内外部要不用户0内部1外部',
  `director_id` bigint(20) DEFAULT NULL COMMENT '外部通讯录ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '被分享人用户ID',
  `share_user_id` bigint(20) DEFAULT NULL COMMENT '分享人ID（主动）',
  `sharetime` datetime DEFAULT NULL COMMENT '分享时间',
  PRIMARY KEY (`director_users_id`),
  KEY `FK675oqfmv4kx9w6bgi9rgsb8nw` (`director_id`),
  KEY `FK7hq4xk2ja9eka4210qkqq03hi` (`user_id`),
  KEY `FKibwkjvmp9383ltkfew1kyy6ny` (`share_user_id`),
  CONSTRAINT `FK675oqfmv4kx9w6bgi9rgsb8nw` FOREIGN KEY (`director_id`) REFERENCES `aoa_director` (`director_id`),
  CONSTRAINT `FK7hq4xk2ja9eka4210qkqq03hi` FOREIGN KEY (`user_id`) REFERENCES `aoa_user` (`user_id`),
  CONSTRAINT `FKibwkjvmp9383ltkfew1kyy6ny` FOREIGN KEY (`share_user_id`) REFERENCES `aoa_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_discuss_list
-- ----------------------------
DROP TABLE IF EXISTS `aoa_discuss_list`;
CREATE TABLE `aoa_discuss_list` (
  `discuss_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '讨论表ID',
  `attachment_id` int(11) DEFAULT NULL COMMENT '附件ID',
  `content` text COMMENT '内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status_id` bigint(20) DEFAULT NULL COMMENT '状态ID',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `type_id` bigint(20) DEFAULT NULL COMMENT '类型ID',
  `visit_num` int(11) DEFAULT NULL COMMENT '访问量',
  `discuss_user_id` bigint(20) DEFAULT NULL COMMENT '讨论归属人ID',
  `vote_id` bigint(20) DEFAULT NULL COMMENT '投票ID',
  `modify_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`discuss_id`),
  KEY `FKt8hvx0ai5fto20mmxmy2g8j4g` (`discuss_user_id`),
  KEY `FK17yi8arj4vjdr5mm5dhjov10j` (`vote_id`),
  CONSTRAINT `FK17yi8arj4vjdr5mm5dhjov10j` FOREIGN KEY (`vote_id`) REFERENCES `aoa_vote_list` (`vote_id`),
  CONSTRAINT `FKt8hvx0ai5fto20mmxmy2g8j4g` FOREIGN KEY (`discuss_user_id`) REFERENCES `aoa_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_evection
-- ----------------------------
DROP TABLE IF EXISTS `aoa_evection`;
CREATE TABLE `aoa_evection` (
  `evection_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '出差表ID',
  `type_id` bigint(20) DEFAULT NULL COMMENT '类型ID',
  `pro_id` bigint(20) DEFAULT NULL COMMENT '主表ID',
  `personnel_advice` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '人事意见',
  `manager_advice` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '领导意见',
  PRIMARY KEY (`evection_id`),
  KEY `FKql1c10e5u2vefisjqjbu2d5pa` (`pro_id`),
  CONSTRAINT `FKql1c10e5u2vefisjqjbu2d5pa` FOREIGN KEY (`pro_id`) REFERENCES `aoa_process_list` (`process_id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_evectionmoney
-- ----------------------------
DROP TABLE IF EXISTS `aoa_evectionmoney`;
CREATE TABLE `aoa_evectionmoney` (
  `evectionmoney_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '费用报销表ID',
  `financial_advice` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '财务意见',
  `manager_advice` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '经理意见',
  `money` double DEFAULT NULL COMMENT '钱数',
  `name` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '关联客户',
  `pro_id` bigint(20) DEFAULT NULL COMMENT '流程主表ID',
  `pro` int(255) DEFAULT NULL,
  PRIMARY KEY (`evectionmoney_id`),
  KEY `FKcpuubnshaf2cg47hns9m0h1dq` (`pro_id`),
  CONSTRAINT `FKcpuubnshaf2cg47hns9m0h1dq` FOREIGN KEY (`pro_id`) REFERENCES `aoa_process_list` (`process_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_file_list
-- ----------------------------
DROP TABLE IF EXISTS `aoa_file_list`;
CREATE TABLE `aoa_file_list` (
  `file_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '文件ID',
  `file_name` varchar(255) DEFAULT NULL COMMENT '文件名',
  `file_path` varchar(255) DEFAULT NULL COMMENT '文件路径',
  `file_shuffix` varchar(255) DEFAULT NULL COMMENT '文件后缀名',
  `content_type` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '文件类型',
  `model` varchar(255) DEFAULT NULL COMMENT '所属模块',
  `path_id` bigint(20) DEFAULT NULL COMMENT '路径表ID',
  `size` bigint(20) DEFAULT NULL COMMENT '文件大小',
  `upload_time` datetime DEFAULT NULL COMMENT '上传时间',
  `file_user_id` bigint(20) DEFAULT NULL COMMENT '文件关联用户表ID',
  `file_istrash` bigint(1) unsigned zerofill DEFAULT '0' COMMENT '是否是垃圾文件0不是1是',
  `file_isshare` bigint(20) DEFAULT NULL COMMENT '是否是分享文件',
  PRIMARY KEY (`file_id`),
  KEY `FKfshy9n300pqxjsweo9247jgqs` (`path_id`),
  KEY `FKlj6l9qroivus28aiqluue4bew` (`file_user_id`),
  CONSTRAINT `FKfshy9n300pqxjsweo9247jgqs` FOREIGN KEY (`path_id`) REFERENCES `aoa_file_path` (`path_id`),
  CONSTRAINT `FKlj6l9qroivus28aiqluue4bew` FOREIGN KEY (`file_user_id`) REFERENCES `aoa_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_file_path
-- ----------------------------
DROP TABLE IF EXISTS `aoa_file_path`;
CREATE TABLE `aoa_file_path` (
  `path_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '文件夹路径表ID',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '上级文件夹id',
  `path_name` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '文件夹名',
  `path_user_id` bigint(20) DEFAULT NULL COMMENT '创建文件夹用户id',
  `path_istrash` bigint(20) DEFAULT '0' COMMENT '文件夹是否是垃圾文件夹',
  PRIMARY KEY (`path_id`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_holiday
-- ----------------------------
DROP TABLE IF EXISTS `aoa_holiday`;
CREATE TABLE `aoa_holiday` (
  `holiday_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `leave_days` int(11) DEFAULT NULL,
  `type_id` bigint(20) DEFAULT NULL,
  `pro_id` bigint(20) DEFAULT NULL,
  `manager_advice` varchar(255) DEFAULT NULL,
  `personnel_advice` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`holiday_id`),
  KEY `FK1glo2wpb4kuiop1ymjxs0knxj` (`pro_id`),
  CONSTRAINT `FK1glo2wpb4kuiop1ymjxs0knxj` FOREIGN KEY (`pro_id`) REFERENCES `aoa_process_list` (`process_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_in_mail_list
-- ----------------------------
DROP TABLE IF EXISTS `aoa_in_mail_list`;
CREATE TABLE `aoa_in_mail_list` (
  `mail_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '内部邮件列表ID',
  `mail_content` text COMMENT '邮件内容',
  `mail_create_time` datetime DEFAULT NULL COMMENT '邮件创建时间',
  `mail_file_id` bigint(20) DEFAULT NULL COMMENT '邮件附件ID',
  `mail_title` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '邮件主题',
  `mail_type` bigint(20) DEFAULT NULL COMMENT '邮件类型(通知，公告，邮件）',
  `mail_in_push_user_id` bigint(20) DEFAULT NULL COMMENT '发件人ID',
  `in_receiver` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '收件人名字（可以是多个）',
  `mail_status_id` bigint(20) DEFAULT NULL COMMENT '邮件状态（一般，紧急，重要）',
  `mail_number_id` bigint(20) DEFAULT NULL COMMENT '外部邮件 账号ID',
  `mail_del` int(11) DEFAULT NULL COMMENT '邮箱是否已删除0未删除1已删除',
  `mail_push` int(11) DEFAULT NULL COMMENT '邮箱是否为新添加的',
  `mail_star` int(11) DEFAULT NULL COMMENT '邮件是否标记',
  PRIMARY KEY (`mail_id`),
  KEY `FK33o7j8f0xk8n8vrk576iktglc` (`mail_file_id`),
  KEY `FK933q7ouoddu584qg08rbvwvxi` (`mail_in_push_user_id`),
  KEY `FKghibt111d1yvc3f02x06sihjp` (`mail_number_id`),
  CONSTRAINT `FK33o7j8f0xk8n8vrk576iktglc` FOREIGN KEY (`mail_file_id`) REFERENCES `aoa_attachment_list` (`attachment_id`),
  CONSTRAINT `FK933q7ouoddu584qg08rbvwvxi` FOREIGN KEY (`mail_in_push_user_id`) REFERENCES `aoa_user` (`user_id`),
  CONSTRAINT `FKghibt111d1yvc3f02x06sihjp` FOREIGN KEY (`mail_number_id`) REFERENCES `aoa_mailnumber` (`mail_number_id`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_love_discuss_user
-- ----------------------------
DROP TABLE IF EXISTS `aoa_love_discuss_user`;
CREATE TABLE `aoa_love_discuss_user` (
  `discuss_id` bigint(20) NOT NULL COMMENT '讨论表ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `discuss_user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '讨论表中间表',
  PRIMARY KEY (`discuss_user_id`) USING BTREE,
  KEY `FKkl0fitgg3qixkg5gg9mmjp5e7` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_love_user
-- ----------------------------
DROP TABLE IF EXISTS `aoa_love_user`;
CREATE TABLE `aoa_love_user` (
  `reply_id` bigint(20) NOT NULL COMMENT '回复ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `reply_user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '回复中间表ID',
  PRIMARY KEY (`reply_user_id`),
  KEY `FK7fv96y8gbqcnb44qao4ey4rmn` (`user_id`),
  KEY `FKcuptpmm0l1e0b9pjv0xksqqai` (`reply_id`),
  CONSTRAINT `FK7fv96y8gbqcnb44qao4ey4rmn` FOREIGN KEY (`user_id`) REFERENCES `aoa_user` (`user_id`),
  CONSTRAINT `FKcuptpmm0l1e0b9pjv0xksqqai` FOREIGN KEY (`reply_id`) REFERENCES `aoa_reply_list` (`reply_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_mail_reciver
-- ----------------------------
DROP TABLE IF EXISTS `aoa_mail_reciver`;
CREATE TABLE `aoa_mail_reciver` (
  `pk_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '中间表主键ID',
  `is_read` int(11) NOT NULL COMMENT '是否已读默认未读0',
  `mail_id` bigint(20) DEFAULT NULL COMMENT '内部邮件ID',
  `mail_reciver_id` bigint(20) DEFAULT NULL COMMENT '内部用户ID',
  `is_star` int(11) DEFAULT NULL COMMENT '是否星标',
  `is_del` int(11) DEFAULT NULL COMMENT '是否真正删除',
  PRIMARY KEY (`pk_id`),
  KEY `FKj8ki52vm052q6qdal2rkh2c9q` (`mail_id`),
  KEY `FK65vdrbmq9hu4hrhvtw6slwxlc` (`mail_reciver_id`),
  CONSTRAINT `FK65vdrbmq9hu4hrhvtw6slwxlc` FOREIGN KEY (`mail_reciver_id`) REFERENCES `aoa_user` (`user_id`),
  CONSTRAINT `FKj8ki52vm052q6qdal2rkh2c9q` FOREIGN KEY (`mail_id`) REFERENCES `aoa_in_mail_list` (`mail_id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_mailnumber
-- ----------------------------
DROP TABLE IF EXISTS `aoa_mailnumber`;
CREATE TABLE `aoa_mailnumber` (
  `mail_number_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '邮箱账号表ID',
  `mail_account` varchar(255) NOT NULL COMMENT '邮箱账户',
  `mail_create_time` datetime DEFAULT NULL COMMENT '邮箱创建时间',
  `mail_des` varchar(255) DEFAULT NULL COMMENT '邮箱备注信息',
  `mail_type` bigint(20) DEFAULT NULL COMMENT '邮件账号类型',
  `mail_user_name` varchar(255) NOT NULL COMMENT '邮箱用户别名',
  `password` varchar(255) NOT NULL COMMENT '授权码',
  `status` bigint(20) DEFAULT NULL COMMENT '邮箱状态是否1有效2 无效',
  `mail_num_user_id` bigint(20) DEFAULT NULL COMMENT '邮箱用户ID',
  PRIMARY KEY (`mail_number_id`),
  KEY `FKn9qg20uba4xn2k5m62jrcyc6c` (`mail_num_user_id`),
  CONSTRAINT `FKn9qg20uba4xn2k5m62jrcyc6c` FOREIGN KEY (`mail_num_user_id`) REFERENCES `aoa_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_note_list
-- ----------------------------
DROP TABLE IF EXISTS `aoa_note_list`;
CREATE TABLE `aoa_note_list` (
  `note_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '笔记id',
  `content` varchar(15000) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '笔记内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status_id` bigint(20) DEFAULT NULL COMMENT '状态id',
  `title` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '笔记标题',
  `type_id` bigint(20) DEFAULT NULL COMMENT '类型id',
  `catalog_id` bigint(20) DEFAULT NULL COMMENT '目录id',
  `attach_id` bigint(20) DEFAULT NULL COMMENT '附件id',
  `is_collected` bigint(20) DEFAULT '0' COMMENT '是否收藏',
  `createman_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `receiver` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '笔记分享接收人名',
  PRIMARY KEY (`note_id`),
  KEY `FK3e1rxyyg851r231ln3ucnrg7q` (`catalog_id`),
  CONSTRAINT `FK3e1rxyyg851r231ln3ucnrg7q` FOREIGN KEY (`catalog_id`) REFERENCES `aoa_catalog` (`catalog_id`)
) ENGINE=InnoDB AUTO_INCREMENT=230 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_notepaper
-- ----------------------------
DROP TABLE IF EXISTS `aoa_notepaper`;
CREATE TABLE `aoa_notepaper` (
  `notepaper_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '便签表主键ID',
  `concent` text CHARACTER SET utf8mb4  COMMENT '便签内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建标签时间',
  `title` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '便签标题',
  `notepaper_user_id` bigint(20) DEFAULT NULL COMMENT '创建便签的用户ID',
  PRIMARY KEY (`notepaper_id`),
  KEY `FKsavcqw29haox5bu7y90it8jb7` (`notepaper_user_id`),
  CONSTRAINT `FKsavcqw29haox5bu7y90it8jb7` FOREIGN KEY (`notepaper_user_id`) REFERENCES `aoa_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_notice_list
-- ----------------------------
DROP TABLE IF EXISTS `aoa_notice_list`;
CREATE TABLE `aoa_notice_list` (
  `notice_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '通知表ID',
  `content` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '通知内容',
  `is_top` int(11) DEFAULT NULL COMMENT '该通知是否置顶',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `notice_time` datetime DEFAULT NULL COMMENT '发布通知的时间',
  `status_id` bigint(20) DEFAULT NULL COMMENT '状态ID',
  `title` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '通知标题',
  `type_id` bigint(20) DEFAULT NULL COMMENT '类型ID',
  `url` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '通知内的链接',
  `user_id` bigint(20) DEFAULT NULL COMMENT '发布通知用户ID',
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_notice_user_relation
-- ----------------------------
DROP TABLE IF EXISTS `aoa_notice_user_relation`;
CREATE TABLE `aoa_notice_user_relation` (
  `relatin_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '通知与用户的关联表主键ID',
  `is_read` int(11) DEFAULT NULL COMMENT '是否已读，默认为0，未读',
  `relatin_notice_id` bigint(20) DEFAULT NULL COMMENT '公布通知表的ID',
  `relatin_user_id` bigint(20) DEFAULT NULL COMMENT '登录人用户ID（即接收通知的用户ID）',
  PRIMARY KEY (`relatin_id`),
  KEY `FKhxq8glkpb5qi1smn5gu142rky` (`relatin_notice_id`),
  KEY `FK52evvby6j47j24624ydi0o221` (`relatin_user_id`),
  CONSTRAINT `FK52evvby6j47j24624ydi0o221` FOREIGN KEY (`relatin_user_id`) REFERENCES `aoa_user` (`user_id`),
  CONSTRAINT `FKhxq8glkpb5qi1smn5gu142rky` FOREIGN KEY (`relatin_notice_id`) REFERENCES `aoa_notice_list` (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=181 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_overtime
-- ----------------------------
DROP TABLE IF EXISTS `aoa_overtime`;
CREATE TABLE `aoa_overtime` (
  `overtime_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '加班表ID',
  `type_id` bigint(20) DEFAULT NULL COMMENT '类型ID',
  `pro_id` bigint(20) DEFAULT NULL COMMENT '主表ID',
  `personnel_advice` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '人事意见',
  `manager_advice` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '领导意见',
  PRIMARY KEY (`overtime_id`),
  KEY `FK5o36fvdsrrhvr9q4dvffxkuoc` (`pro_id`),
  CONSTRAINT `FK5o36fvdsrrhvr9q4dvffxkuoc` FOREIGN KEY (`pro_id`) REFERENCES `aoa_process_list` (`process_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_plan_list
-- ----------------------------
DROP TABLE IF EXISTS `aoa_plan_list`;
CREATE TABLE `aoa_plan_list` (
  `plan_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '计划表id',
  `create_time` datetime DEFAULT NULL COMMENT '计划创建时间',
  `end_time` datetime DEFAULT NULL COMMENT '计划结束时间',
  `label` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '标签',
  `plan_comment` varchar(5000) CHARACTER SET utf8mb4  DEFAULT '' COMMENT '计划评论',
  `plan_content` varchar(10000) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '计划内容',
  `plan_summary` varchar(800) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '计划总结',
  `start_time` datetime NOT NULL COMMENT '计划开始时间',
  `status_id` bigint(20) DEFAULT NULL COMMENT '计划的状态id',
  `title` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '计划标题',
  `type_id` bigint(20) DEFAULT NULL COMMENT '计划的类型id',
  `plan_user_id` bigint(20) DEFAULT NULL COMMENT '创建计划的用户ID',
  `attach_id` bigint(20) DEFAULT NULL COMMENT '计划的附件id',
  PRIMARY KEY (`plan_id`) USING BTREE,
  KEY `FKsqqfaj3e7rdl3jalr2sm0y4ln` (`plan_user_id`),
  CONSTRAINT `FKsqqfaj3e7rdl3jalr2sm0y4ln` FOREIGN KEY (`plan_user_id`) REFERENCES `aoa_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_position
-- ----------------------------
DROP TABLE IF EXISTS `aoa_position`;
CREATE TABLE `aoa_position` (
  `position_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '职位ID',
  `level` int(11) DEFAULT NULL COMMENT '职位层级',
  `name` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '职位名称',
  `describtion` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '职位描述',
  `deptid` bigint(20) DEFAULT NULL COMMENT '部门ID',
  PRIMARY KEY (`position_id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_process_list
-- ----------------------------
DROP TABLE IF EXISTS `aoa_process_list`;
CREATE TABLE `aoa_process_list` (
  `process_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流程主表ID',
  `apply_time` datetime DEFAULT NULL COMMENT '流程申请时间',
  `deeply_id` bigint(20) DEFAULT NULL COMMENT '紧急程度',
  `end_time` datetime DEFAULT NULL COMMENT '流程结束时间',
  `process_des` text CHARACTER SET utf8mb4  COMMENT '流程申请原因内容',
  `process_name` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '标题',
  `procsee_days` int(11) DEFAULT NULL COMMENT '流程总天数',
  `is_checked` int(10) DEFAULT NULL COMMENT '流程是否被驳回',
  `start_time` datetime DEFAULT NULL COMMENT '流程开始时间',
  `status_id` bigint(20) DEFAULT NULL COMMENT '流程申请状态ID',
  `type_name` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '流程申请类型',
  `pro_file_id` bigint(20) DEFAULT NULL COMMENT '流程附件ID',
  `process_user_id` bigint(20) DEFAULT NULL COMMENT '流程申请人ID',
  `shenuser` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '审核人的名字',
  PRIMARY KEY (`process_id`),
  KEY `FKiltoi9iw3vjixl6u4cd60fi1p` (`pro_file_id`),
  KEY `FKhtdg4du5ryotah5v1dgyjfh2t` (`process_user_id`),
  CONSTRAINT `FKhtdg4du5ryotah5v1dgyjfh2t` FOREIGN KEY (`process_user_id`) REFERENCES `aoa_user` (`user_id`),
  CONSTRAINT `FKiltoi9iw3vjixl6u4cd60fi1p` FOREIGN KEY (`pro_file_id`) REFERENCES `aoa_attachment_list` (`attachment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=137 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_receiver_note
-- ----------------------------
DROP TABLE IF EXISTS `aoa_receiver_note`;
CREATE TABLE `aoa_receiver_note` (
  `note_id` bigint(20) NOT NULL COMMENT '笔记id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '用户笔记关联表id',
  PRIMARY KEY (`id`),
  KEY `FK904cmor3q468pj3ft6mdrnqwk` (`user_id`),
  KEY `FKcx7spjjefkofw62v8yxmgjxao` (`note_id`),
  CONSTRAINT `FK904cmor3q468pj3ft6mdrnqwk` FOREIGN KEY (`user_id`) REFERENCES `aoa_user` (`user_id`),
  CONSTRAINT `FK_NOTE_LIST` FOREIGN KEY (`note_id`) REFERENCES `aoa_note_list` (`note_id`),
  CONSTRAINT `FK_USER` FOREIGN KEY (`user_id`) REFERENCES `aoa_user` (`user_id`),
  CONSTRAINT `FKcx7spjjefkofw62v8yxmgjxao` FOREIGN KEY (`note_id`) REFERENCES `aoa_note_list` (`note_id`)
) ENGINE=InnoDB AUTO_INCREMENT=260 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_regular
-- ----------------------------
DROP TABLE IF EXISTS `aoa_regular`;
CREATE TABLE `aoa_regular` (
  `regular_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '转正表ID',
  `advice` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '对公司产品的意见及建议',
  `deficiency` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '目前存在的不足',
  `dobetter` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '如何在本岗位作的更好',
  `experience` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '试用期、实习期的新的体会',
  `personnel_advice` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '人事建议',
  `pullulate` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '试用期及实习期在哪些方面有了成长',
  `understand` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '对本岗位的要求理解',
  `pro_id` bigint(20) DEFAULT NULL COMMENT '主表ID',
  `manager_advice` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '经理意见',
  `days` int(11) DEFAULT NULL COMMENT '实习天数',
  PRIMARY KEY (`regular_id`),
  KEY `FK96uphskhww1otsi3fe916dfor` (`pro_id`),
  CONSTRAINT `FK96uphskhww1otsi3fe916dfor` FOREIGN KEY (`pro_id`) REFERENCES `aoa_process_list` (`process_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_reply_list
-- ----------------------------
DROP TABLE IF EXISTS `aoa_reply_list`;
CREATE TABLE `aoa_reply_list` (
  `reply_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '回复表ID',
  `content` text COMMENT '回复内容',
  `replay_time` datetime DEFAULT NULL COMMENT '回复时间',
  `discuss_id` bigint(20) DEFAULT NULL COMMENT '讨论人ID',
  `reply_user_id` bigint(20) DEFAULT NULL COMMENT '回复人ID',
  PRIMARY KEY (`reply_id`),
  KEY `FK94s0c9f8hxomde6bede3d20y2` (`discuss_id`),
  KEY `FK2bn8fpyqw7mom14ks4kvrhtp9` (`reply_user_id`),
  CONSTRAINT `FK2bn8fpyqw7mom14ks4kvrhtp9` FOREIGN KEY (`reply_user_id`) REFERENCES `aoa_user` (`user_id`),
  CONSTRAINT `FK94s0c9f8hxomde6bede3d20y2` FOREIGN KEY (`discuss_id`) REFERENCES `aoa_discuss_list` (`discuss_id`)
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_resign
-- ----------------------------
DROP TABLE IF EXISTS `aoa_resign`;
CREATE TABLE `aoa_resign` (
  `resign_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '离职表ID',
  `financial_advice` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '财务意见',
  `is_finish` bit(1) DEFAULT NULL COMMENT '是否有未报销没完成',
  `nofinish` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '未完成事宜',
  `personnel_advice` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '人事意见及说明',
  `suggest` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '申请人的意见或建议',
  `hand_user` bigint(20) DEFAULT NULL COMMENT '相关人ID',
  `pro_id` bigint(20) DEFAULT NULL COMMENT '主表ID',
  `manager_advice` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '经理意见',
  PRIMARY KEY (`resign_id`),
  KEY `FK3t0d1mt9o7g5q59ha10e3mwpr` (`hand_user`),
  KEY `FKam7ii5j1kdforxq8s6q3mm13n` (`pro_id`),
  CONSTRAINT `FK3t0d1mt9o7g5q59ha10e3mwpr` FOREIGN KEY (`hand_user`) REFERENCES `aoa_user` (`user_id`),
  CONSTRAINT `FKam7ii5j1kdforxq8s6q3mm13n` FOREIGN KEY (`pro_id`) REFERENCES `aoa_process_list` (`process_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_reviewed
-- ----------------------------
DROP TABLE IF EXISTS `aoa_reviewed`;
CREATE TABLE `aoa_reviewed` (
  `reviewed_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '审核表ID',
  `advice` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '审核人意见',
  `reviewed_time` datetime DEFAULT NULL COMMENT '审核时间',
  `status_id` bigint(20) DEFAULT NULL COMMENT '审核状态ID',
  `pro_id` bigint(20) DEFAULT NULL COMMENT '主表ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '审核人ID',
  `del` int(11) DEFAULT NULL COMMENT '是否删除默认0，false',
  PRIMARY KEY (`reviewed_id`),
  KEY `FKevjvy6myxg1l0ibiuph3i7jw2` (`pro_id`),
  KEY `FK2iljei0wvy0cylwwyfh5dr9yk` (`user_id`),
  CONSTRAINT `FK2iljei0wvy0cylwwyfh5dr9yk` FOREIGN KEY (`user_id`) REFERENCES `aoa_user` (`user_id`),
  CONSTRAINT `FKevjvy6myxg1l0ibiuph3i7jw2` FOREIGN KEY (`pro_id`) REFERENCES `aoa_process_list` (`process_id`)
) ENGINE=InnoDB AUTO_INCREMENT=153 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_role_
-- ----------------------------
DROP TABLE IF EXISTS `aoa_role_`;
CREATE TABLE `aoa_role_` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '角色名',
  `role_value` int(11) DEFAULT NULL COMMENT '角色权限值',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_role_power_list
-- ----------------------------
DROP TABLE IF EXISTS `aoa_role_power_list`;
CREATE TABLE `aoa_role_power_list` (
  `pk_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `is_show` int(11) DEFAULT NULL COMMENT '是否显示 0-不显示1-显示',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`pk_id`),
  KEY `FK2f9f91f213gwtglofko5r429s` (`menu_id`),
  KEY `FK7b71lfkstl47tston4lrd8066` (`role_id`),
  CONSTRAINT `FK2f9f91f213gwtglofko5r429s` FOREIGN KEY (`menu_id`) REFERENCES `aoa_sys_menu` (`menu_id`),
  CONSTRAINT `FK7b71lfkstl47tston4lrd8066` FOREIGN KEY (`role_id`) REFERENCES `aoa_role_` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1405 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_schedule_list
-- ----------------------------
DROP TABLE IF EXISTS `aoa_schedule_list`;
CREATE TABLE `aoa_schedule_list` (
  `rc_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日程ID',
  `create_time` datetime DEFAULT NULL COMMENT '发布时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `filedescribe` varchar(255) DEFAULT NULL,
  `is_remind` int(11) DEFAULT NULL COMMENT '是否提醒',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `status_id` bigint(20) DEFAULT NULL COMMENT '状态ID',
  `title` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '日程标题',
  `type_id` bigint(20) DEFAULT NULL COMMENT '类型ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '日程所属人',
  `miaoshu` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '日程描述',
  `isreminded` int(11) DEFAULT NULL,
  PRIMARY KEY (`rc_id`),
  KEY `FKgcip21xf5ihmgm2bnh5o4jv15` (`user_id`),
  CONSTRAINT `FKgcip21xf5ihmgm2bnh5o4jv15` FOREIGN KEY (`user_id`) REFERENCES `aoa_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_schedule_user
-- ----------------------------
DROP TABLE IF EXISTS `aoa_schedule_user`;
CREATE TABLE `aoa_schedule_user` (
  `rc_id` bigint(20) NOT NULL COMMENT '日程管理表ID',
  `user_id` bigint(20) NOT NULL COMMENT '关联用户id',
  `sche_user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日程用户管理表id',
  PRIMARY KEY (`sche_user_id`),
  KEY `FKh6hw8vp7p2lgfovi0o7bhhlyp` (`user_id`),
  KEY `FKcmd578ftbv7i53l6mxbbva137` (`rc_id`),
  CONSTRAINT `FKcmd578ftbv7i53l6mxbbva137` FOREIGN KEY (`rc_id`) REFERENCES `aoa_schedule_list` (`rc_id`),
  CONSTRAINT `FKh6hw8vp7p2lgfovi0o7bhhlyp` FOREIGN KEY (`user_id`) REFERENCES `aoa_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_status_list
-- ----------------------------
DROP TABLE IF EXISTS `aoa_status_list`;
CREATE TABLE `aoa_status_list` (
  `status_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '状态表ID',
  `status_color` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '状态颜色(前端 class属性名）',
  `status_model` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '状态模型',
  `status_name` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '状态名',
  `sort_value` int(11) DEFAULT NULL COMMENT '状态排序值',
  `sort_precent` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '状态百分比',
  PRIMARY KEY (`status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_stay
-- ----------------------------
DROP TABLE IF EXISTS `aoa_stay`;
CREATE TABLE `aoa_stay` (
  `stay_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '住宿申请表ID',
  `day` int(11) DEFAULT NULL COMMENT '入驻天数',
  `hotel_name` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '入驻酒店',
  `leave_time` datetime DEFAULT NULL COMMENT '离开酒店时间',
  `stay_city` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '入驻城市',
  `stay_money` double DEFAULT NULL COMMENT '住宿标准',
  `stay_time` datetime DEFAULT NULL COMMENT '住宿开始时间',
  `evemoney_id` bigint(20) DEFAULT NULL COMMENT '出差费用表ID',
  `user_name` bigint(20) DEFAULT NULL COMMENT '住宿人员ID',
  PRIMARY KEY (`stay_id`),
  KEY `FK50vbdodv3kd8dixbmyf9ixyc` (`evemoney_id`),
  KEY `FKho0k9o03kbn6dd96l57xvcx3y` (`user_name`),
  CONSTRAINT `FK50vbdodv3kd8dixbmyf9ixyc` FOREIGN KEY (`evemoney_id`) REFERENCES `aoa_evectionmoney` (`evectionmoney_id`),
  CONSTRAINT `FKho0k9o03kbn6dd96l57xvcx3y` FOREIGN KEY (`user_name`) REFERENCES `aoa_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_subject
-- ----------------------------
DROP TABLE IF EXISTS `aoa_subject`;
CREATE TABLE `aoa_subject` (
  `subject_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`subject_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `aoa_sys_menu`;
CREATE TABLE `aoa_sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `is_show` int(11) DEFAULT NULL COMMENT '菜单是否显示',
  `menu_grade` int(11) DEFAULT NULL COMMENT '权限值分数',
  `menu_icon` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '菜单图标',
  `menu_name` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '菜单名',
  `menu_url` varchar(255) CHARACTER SET utf8mb4  NOT NULL COMMENT '菜单链接',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父级ID',
  `sort_id` int(11) DEFAULT NULL COMMENT '菜单排序ID',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_task_list
-- ----------------------------
DROP TABLE IF EXISTS `aoa_task_list`;
CREATE TABLE `aoa_task_list` (
  `task_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务表ID',
  `comment` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '任务评价',
  `end_time` datetime DEFAULT NULL COMMENT '任务结束时间',
  `is_cancel` int(11) DEFAULT '0' COMMENT '是否取消任务',
  `is_top` int(11) DEFAULT '0' COMMENT '任务是否置顶',
  `modify_time` datetime DEFAULT NULL COMMENT '任务修改时间',
  `publish_time` datetime DEFAULT NULL COMMENT '发布时间',
  `star_time` datetime DEFAULT NULL COMMENT '任务开始时间',
  `status_id` int(11) DEFAULT NULL COMMENT '任务状态ID',
  `task_describe` varchar(255) CHARACTER SET utf8mb4  NOT NULL COMMENT '任务描述',
  `ticking` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '任务结束后反馈',
  `title` varchar(255) CHARACTER SET utf8mb4  NOT NULL COMMENT '任务主题',
  `type_id` bigint(20) DEFAULT NULL COMMENT '任务类型ID',
  `task_push_user_id` bigint(20) DEFAULT NULL COMMENT '发布人ID',
  `reciverlist` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '接收人名',
  PRIMARY KEY (`task_id`),
  KEY `FK7qch0fh6s2y73dvngy1m87aw7` (`task_push_user_id`),
  CONSTRAINT `FK7qch0fh6s2y73dvngy1m87aw7` FOREIGN KEY (`task_push_user_id`) REFERENCES `aoa_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_task_logger
-- ----------------------------
DROP TABLE IF EXISTS `aoa_task_logger`;
CREATE TABLE `aoa_task_logger` (
  `logger_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志id主键',
  `create_time` datetime DEFAULT NULL COMMENT '任务日志创建时间',
  `logger_ticking` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '任务日志反馈内容',
  `task_id` bigint(20) DEFAULT NULL COMMENT '任务id外键',
  `username` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '任务日志生成人',
  `logger_statusid` int(11) DEFAULT NULL COMMENT '状态id',
  PRIMARY KEY (`logger_id`),
  KEY `FK5gu0thq54i7ujc6cict009h4y` (`task_id`),
  CONSTRAINT `FK5gu0thq54i7ujc6cict009h4y` FOREIGN KEY (`task_id`) REFERENCES `aoa_task_list` (`task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_task_user
-- ----------------------------
DROP TABLE IF EXISTS `aoa_task_user`;
CREATE TABLE `aoa_task_user` (
  `pk_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `status_id` bigint(20) DEFAULT NULL,
  `task_id` bigint(20) DEFAULT NULL,
  `task_recive_user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`pk_id`),
  KEY `FK2714kl5ywm5chya4dxte8c788` (`task_id`),
  KEY `FK654dfo0oouy3fk07fs7rqo4ld` (`task_recive_user_id`),
  CONSTRAINT `FK2714kl5ywm5chya4dxte8c788` FOREIGN KEY (`task_id`) REFERENCES `aoa_task_list` (`task_id`),
  CONSTRAINT `FK654dfo0oouy3fk07fs7rqo4ld` FOREIGN KEY (`task_recive_user_id`) REFERENCES `aoa_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_traffic
-- ----------------------------
DROP TABLE IF EXISTS `aoa_traffic`;
CREATE TABLE `aoa_traffic` (
  `traffic_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '交通费用明细表ID',
  `depart_name` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '出发城市',
  `depart_time` datetime DEFAULT NULL COMMENT '出发时间',
  `reach_name` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '到达城市',
  `seat_type` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '座位类型',
  `traffic_money` double DEFAULT NULL COMMENT '交通标准',
  `traffic_name` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '交通工具',
  `evemoney_id` bigint(20) DEFAULT NULL COMMENT '出差费用申请单ID',
  `user_name` bigint(20) DEFAULT NULL COMMENT '出差人员ID',
  PRIMARY KEY (`traffic_id`) USING BTREE,
  KEY `FKt5gk2fg5t802gnq8y03p9e7di` (`evemoney_id`),
  KEY `FKejkemcx58mfj2lgi2jo2rlih3` (`user_name`),
  CONSTRAINT `FKejkemcx58mfj2lgi2jo2rlih3` FOREIGN KEY (`user_name`) REFERENCES `aoa_user` (`user_id`),
  CONSTRAINT `FKt5gk2fg5t802gnq8y03p9e7di` FOREIGN KEY (`evemoney_id`) REFERENCES `aoa_evectionmoney` (`evectionmoney_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_type_list
-- ----------------------------
DROP TABLE IF EXISTS `aoa_type_list`;
CREATE TABLE `aoa_type_list` (
  `type_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '类型表ID',
  `type_color` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '类型进度颜色',
  `type_model` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '类型模块',
  `type_name` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '类型名',
  `sort_value` int(11) DEFAULT NULL COMMENT '排序值',
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_user
-- ----------------------------
DROP TABLE IF EXISTS `aoa_user`;
CREATE TABLE `aoa_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户表ID',
  `address` varchar(255) DEFAULT NULL COMMENT '用户的地址',
  `bank` varchar(255) DEFAULT NULL COMMENT '银行',
  `birth` datetime DEFAULT NULL COMMENT '生日',
  `eamil` varchar(255) DEFAULT NULL COMMENT '用户的邮箱',
  `father_id` bigint(20) DEFAULT NULL COMMENT '上司ID',
  `hire_time` datetime DEFAULT NULL COMMENT '入职时间',
  `user_idcard` varchar(255) DEFAULT NULL COMMENT '用户身份证',
  `img_path` varchar(255) DEFAULT NULL COMMENT '用户头像路径',
  `is_lock` int(11) DEFAULT NULL COMMENT '是否被禁用',
  `last_login_ip` varchar(255) DEFAULT NULL COMMENT '最后登录的IP',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录的时间',
  `modify_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `modify_user_id` bigint(20) DEFAULT NULL COMMENT '最后修改此用户的用户ID',
  `password` varchar(255) DEFAULT NULL COMMENT '用户密码',
  `real_name` varchar(255) DEFAULT NULL COMMENT '用户真实姓名',
  `salary` float(20,0) DEFAULT NULL COMMENT '用户薪水',
  `user_school` varchar(255) DEFAULT NULL COMMENT '用户的毕业院校',
  `sex` varchar(255) DEFAULT NULL COMMENT '性别',
  `theme_skin` varchar(255) DEFAULT NULL COMMENT '主题皮肤',
  `user_edu` varchar(255) DEFAULT NULL COMMENT '用户的学历',
  `user_name` varchar(255) DEFAULT NULL COMMENT '登录的用户名',
  `user_sign` varchar(255) DEFAULT NULL COMMENT '用户签名',
  `user_tel` varchar(255) DEFAULT NULL COMMENT '用户电话',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门表ID',
  `position_id` bigint(20) DEFAULT NULL COMMENT '职位表ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色表ID',
  `superman` int(11) DEFAULT NULL COMMENT '超人1代表超人0普通人默认为0',
  `holiday` int(11) DEFAULT NULL COMMENT '请假天数',
  `pinyin` varchar(255) DEFAULT NULL COMMENT '登录用户名的拼音',
  PRIMARY KEY (`user_id`),
  KEY `FKt0vmot9xfbgq14oyij0gwh3gh` (`dept_id`),
  KEY `FKadtg9xju7q1ijcyxlkl9gwv5t` (`position_id`),
  KEY `FKl738mmblfx0uia6671rl17cj9` (`role_id`),
  CONSTRAINT `FKadtg9xju7q1ijcyxlkl9gwv5t` FOREIGN KEY (`position_id`) REFERENCES `aoa_position` (`position_id`),
  CONSTRAINT `FKl738mmblfx0uia6671rl17cj9` FOREIGN KEY (`role_id`) REFERENCES `aoa_role_` (`role_id`),
  CONSTRAINT `FKt0vmot9xfbgq14oyij0gwh3gh` FOREIGN KEY (`dept_id`) REFERENCES `aoa_dept` (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_user_log
-- ----------------------------
DROP TABLE IF EXISTS `aoa_user_log`;
CREATE TABLE `aoa_user_log` (
  `log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户登录记录表id',
  `ip_addr` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT 'IP地址',
  `log_time` datetime DEFAULT NULL COMMENT '日志记录时间',
  `title` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '操作菜单名',
  `url` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '操作菜单url',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`log_id`),
  KEY `FKherb88q97dxbtcge09ii875qm` (`user_id`),
  CONSTRAINT `FKherb88q97dxbtcge09ii875qm` FOREIGN KEY (`user_id`) REFERENCES `aoa_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6036 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_user_login_record
-- ----------------------------
DROP TABLE IF EXISTS `aoa_user_login_record`;
CREATE TABLE `aoa_user_login_record` (
  `record_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `browser` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT '用户使用的浏览器',
  `ip_addr` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT 'IP地址',
  `login_time` datetime DEFAULT NULL COMMENT '登录时间',
  `session_id` varchar(255) CHARACTER SET utf8mb4  DEFAULT NULL COMMENT 'session_id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '登录用户ID',
  PRIMARY KEY (`record_id`),
  KEY `FKks6qpqj3ss4e4timjt0xok1p0` (`user_id`),
  CONSTRAINT `FKks6qpqj3ss4e4timjt0xok1p0` FOREIGN KEY (`user_id`) REFERENCES `aoa_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=532 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_vote_list
-- ----------------------------
DROP TABLE IF EXISTS `aoa_vote_list`;
CREATE TABLE `aoa_vote_list` (
  `vote_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '投票表ID',
  `end_time` datetime DEFAULT NULL COMMENT '投票结束时间',
  `selectone` int(11) DEFAULT NULL COMMENT '单选和多选',
  `start_time` datetime DEFAULT NULL COMMENT '投票开始时间',
  PRIMARY KEY (`vote_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_vote_title_user
-- ----------------------------
DROP TABLE IF EXISTS `aoa_vote_title_user`;
CREATE TABLE `aoa_vote_title_user` (
  `vote_title_user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '投票-标题-用户 表ID',
  `vote_id` bigint(20) DEFAULT NULL COMMENT '投票表ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户表ID',
  `title_id` bigint(20) DEFAULT NULL COMMENT '投票标题表ID',
  PRIMARY KEY (`vote_title_user_id`),
  KEY `FKb2pou179gr3wf10lx0wy6qrli` (`user_id`),
  KEY `FK79ia8m9w7faxi7wmth7or8mqg` (`title_id`),
  CONSTRAINT `FK79ia8m9w7faxi7wmth7or8mqg` FOREIGN KEY (`title_id`) REFERENCES `aoa_vote_titles` (`title_id`),
  CONSTRAINT `FKb2pou179gr3wf10lx0wy6qrli` FOREIGN KEY (`user_id`) REFERENCES `aoa_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb4 ;

-- ----------------------------
-- Table structure for aoa_vote_titles
-- ----------------------------
DROP TABLE IF EXISTS `aoa_vote_titles`;
CREATE TABLE `aoa_vote_titles` (
  `title_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '投票标题ID',
  `color` varchar(255) DEFAULT NULL COMMENT '投票进度颜色',
  `title` varchar(255) DEFAULT NULL COMMENT '投票标题',
  `vote_id` bigint(20) DEFAULT NULL COMMENT '投票表ID',
  PRIMARY KEY (`title_id`),
  KEY `FKnl21d99b8hc6gtfrrfsc9alge` (`vote_id`),
  CONSTRAINT `FKnl21d99b8hc6gtfrrfsc9alge` FOREIGN KEY (`vote_id`) REFERENCES `aoa_vote_list` (`vote_id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb4 ;

SET FOREIGN_KEY_CHECKS = 1;

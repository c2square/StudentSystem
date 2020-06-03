/*
 Navicat Premium Data Transfer

 Source Server         : xiaochen的数据库
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : 127.0.0.1:3306
 Source Schema         : student_system

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 06/05/2020 11:49:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_city
-- ----------------------------
DROP TABLE IF EXISTS `t_city`;
CREATE TABLE `t_city` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `numbers` int(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_city
-- ----------------------------
BEGIN;
INSERT INTO `t_city` VALUES (1, '北京', '2020-05-06 11:03:26', 2);
INSERT INTO `t_city` VALUES (2, '天津', '2020-05-06 11:03:00', 2);
INSERT INTO `t_city` VALUES (3, '上海', '2020-04-29 05:15:22', 0);
INSERT INTO `t_city` VALUES (4, '深圳', '2020-04-29 05:18:26', 0);
INSERT INTO `t_city` VALUES (5, '天津', '2020-05-05 22:48:48', 0);
COMMIT;

-- ----------------------------
-- Table structure for t_clazz
-- ----------------------------
DROP TABLE IF EXISTS `t_clazz`;
CREATE TABLE `t_clazz` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  `tagid` int(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_clazz
-- ----------------------------
BEGIN;
INSERT INTO `t_clazz` VALUES (1, '1班', 3);
INSERT INTO `t_clazz` VALUES (2, '2班', 3);
INSERT INTO `t_clazz` VALUES (3, '3班', 3);
INSERT INTO `t_clazz` VALUES (4, '4班', 4);
INSERT INTO `t_clazz` VALUES (5, '5班', 3);
INSERT INTO `t_clazz` VALUES (6, '2班', 3);
COMMIT;

-- ----------------------------
-- Table structure for t_group
-- ----------------------------
DROP TABLE IF EXISTS `t_group`;
CREATE TABLE `t_group` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  `content` varchar(200) DEFAULT NULL,
  `clazzid` int(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_group
-- ----------------------------
BEGIN;
INSERT INTO `t_group` VALUES (1, '一组', '千行代码过,BUG不沾身!', 1);
INSERT INTO `t_group` VALUES (2, '二组', '我们都是大神', 1);
INSERT INTO `t_group` VALUES (3, '三组', 'NOBUG', 1);
INSERT INTO `t_group` VALUES (4, '一组', '学JAVA,我的未来不是梦!', 2);
INSERT INTO `t_group` VALUES (5, '二组', '我们二组都是人才', 2);
INSERT INTO `t_group` VALUES (6, '2组', '我们都是大神', 1);
COMMIT;

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `bir` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `phone` varchar(11) DEFAULT NULL,
  `qq` varchar(16) DEFAULT NULL,
  `attr` varchar(6) DEFAULT NULL,
  `starts` varchar(14) DEFAULT NULL,
  `mark` varchar(200) DEFAULT NULL,
  `cityid` int(6) DEFAULT NULL,
  `clazzid` int(6) DEFAULT NULL,
  `groupid` int(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
BEGIN;
INSERT INTO `t_student` VALUES (4, 'yannan chen', 28, '1992-12-22 10:00:00', '01010533789', '344355', '猴', '摩羯座', '这是好学生', 2, 2, 5);
INSERT INTO `t_student` VALUES (5, '小黑', 27, '1993-10-22 11:00:00', '01010533789', '344355', '鸡', '天秤座', '这是好学生', 1, 1, 1);
INSERT INTO `t_student` VALUES (6, 'yannan chen', 8, '2012-12-11 10:00:00', '01010533789', '344355', '龙', '射手座', '这是好学生', 2, 2, 5);
INSERT INTO `t_student` VALUES (7, 'yannan chen', 8, '2012-12-11 10:00:00', '01010533789', '344355', '龙', '射手座', '这是好学生', 1, 2, 5);
COMMIT;

-- ----------------------------
-- Table structure for t_student_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_student_tag`;
CREATE TABLE `t_student_tag` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `studentid` int(6) DEFAULT NULL,
  `tagid` int(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student_tag
-- ----------------------------
BEGIN;
INSERT INTO `t_student_tag` VALUES (7, 4, 2);
INSERT INTO `t_student_tag` VALUES (8, 4, 5);
INSERT INTO `t_student_tag` VALUES (9, 5, 1);
INSERT INTO `t_student_tag` VALUES (10, 6, 2);
INSERT INTO `t_student_tag` VALUES (11, 7, 5);
COMMIT;

-- ----------------------------
-- Table structure for t_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_tag`;
CREATE TABLE `t_tag` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_tag
-- ----------------------------
BEGIN;
INSERT INTO `t_tag` VALUES (1, '帅哥', '学生', '2020-04-30 21:19:06');
INSERT INTO `t_tag` VALUES (2, '美女', '学生', '2020-04-30 08:16:21');
INSERT INTO `t_tag` VALUES (3, '牛逼班', '班级', '2020-04-30 08:18:36');
INSERT INTO `t_tag` VALUES (4, '好玩班', '班级', '2020-04-30 23:09:56');
INSERT INTO `t_tag` VALUES (5, '学渣', '学生', '2020-05-04 02:09:09');
COMMIT;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `regtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `role` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES (1, 'admin', 'admin', '激活', '2020-04-27 01:58:46', 'admin');
INSERT INTO `t_user` VALUES (2, 'xiaochen', '123', '激活', '2020-04-27 02:01:20', 'admin');
INSERT INTO `t_user` VALUES (4, 'xiaochen123', '123', '激活', '2020-04-27 02:06:37', 'admin');
INSERT INTO `t_user` VALUES (5, 'zhangsan', '123', '激活', '2020-04-27 03:42:27', 'student');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

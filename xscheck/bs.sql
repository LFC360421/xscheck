/*
Navicat MySQL Data Transfer

Source Server         : db2
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : bs

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2020-06-05 14:04:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adminno` int(20) NOT NULL,
  `password` int(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '111111', '123456');
INSERT INTO `admin` VALUES ('2', '1', '1');
INSERT INTO `admin` VALUES ('3', '2', '2');

-- ----------------------------
-- Table structure for `apply`
-- ----------------------------
DROP TABLE IF EXISTS `apply`;
CREATE TABLE `apply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sno` int(20) NOT NULL,
  `sname` varchar(20) DEFAULT NULL,
  `majorclass` varchar(20) DEFAULT NULL,
  `reason` varchar(100) DEFAULT NULL,
  `starttime` date DEFAULT NULL,
  `endtime` date DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  `isagree` varchar(4) CHARACTER SET utf8 DEFAULT '',
  `note` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of apply
-- ----------------------------
INSERT INTO `apply` VALUES ('2', '10000002', '李四', '网路B161', '去北京办事', '2019-03-04', '2019-03-05', '2019-03-01', '批准', '222');
INSERT INTO `apply` VALUES ('4', '10000001', '张三', '信管B161', '感冒', '2020-03-30', '2020-05-10', '2020-03-30', '批准', '休息休息11111111111111111111111111111111111111111111111111111111111');

-- ----------------------------
-- Table structure for `check1`
-- ----------------------------
DROP TABLE IF EXISTS `check1`;
CREATE TABLE `check1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sno` int(20) DEFAULT NULL,
  `sname` varchar(20) DEFAULT NULL,
  `majorclass` varchar(20) DEFAULT NULL,
  `checktime` date DEFAULT NULL,
  `coursename` varchar(20) DEFAULT NULL,
  `tname` varchar(20) DEFAULT NULL,
  `istruancy` varchar(4) CHARACTER SET utf8 DEFAULT NULL,
  `acadyearterm` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of check1
-- ----------------------------
INSERT INTO `check1` VALUES ('1', '1', '1', '1', '2020-04-05', '1', '1', '', '2019-2020学年第一学期');
INSERT INTO `check1` VALUES ('2', '2', '2', '2', '2020-02-20', '2', '2', null, '2019-2020学年第一学期');
INSERT INTO `check1` VALUES ('17', '10000001', '张三', '信管B161', '2020-04-09', '大学英语', '张1', '旷课', '2019-2020学年第一学期');
INSERT INTO `check1` VALUES ('18', '10000008', '张五', '信管B161', '2020-04-09', '大学英语', '张1', '已到', '2019-2020学年第一学期');
INSERT INTO `check1` VALUES ('19', '10000001', '张三', '信管B161', '2020-04-09', '大学英语', '张1', '请假', '2019-2020学年第二学期');
INSERT INTO `check1` VALUES ('20', '10000008', '张五', '信管B161', '2020-04-09', '大学英语', '张1', '旷课', '2019-2020学年第二学期');
INSERT INTO `check1` VALUES ('21', '10000001', '张三', '信管B161', '2020-04-12', '高等数学', '张2', '已到', '2019-2020学年第一学期');
INSERT INTO `check1` VALUES ('22', '10000001', '张三', '信管B161', '2020-04-13', '大学英语', '张1', '请假', '2019-2020学年第一学期');
INSERT INTO `check1` VALUES ('23', '10000001', '张三', '信管B161', '2020-04-13', '高等数学', '张2', '请假', '2019-2020学年第一学期');
INSERT INTO `check1` VALUES ('32', '10000001', '张三', '信管B161', '2020-05-08', '大学英语', '张1', '请假', '2019-2020学年第一学期');
INSERT INTO `check1` VALUES ('33', '10000008', '张五', '信管B161', '2020-05-08', '大学英语', '张1', '未考勤', '2019-2020学年第一学期');

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `coursename` varchar(20) DEFAULT NULL,
  `majorclass` varchar(20) DEFAULT NULL,
  `tno` int(20) DEFAULT NULL,
  `tname` varchar(20) DEFAULT NULL,
  `schedule` varchar(100) DEFAULT NULL,
  `credit` varchar(20) DEFAULT NULL,
  `period` varchar(20) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `acadyearterm` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '大学英语', '信管B161', '10000001', '张老师', '1-4周，10305；5-8周；20304', '4学分', '36课时', '必修', '2019-2020学年第一学期');
INSERT INTO `course` VALUES ('2', '大学英语', '信管B162', '10000001', '张老师', '1-4周，10305；5-8周；20304', '4学分', '36课时', '必修', '2019-2020学年第一学期');
INSERT INTO `course` VALUES ('5', '大学语文', 'xinguan', null, null, '1-4周，10607；5-8周，30607', '2.5学分', '18课时', '必修', 'aa');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sno` int(20) NOT NULL,
  `sname` varchar(20) DEFAULT NULL,
  `sex` char(2) DEFAULT NULL,
  `password` varchar(20) NOT NULL,
  `phone` int(11) DEFAULT NULL,
  `majorclass` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '10000001', '张三', '男', '123', '10000001', '信管B161');
INSERT INTO `student` VALUES ('2', '10000002', '李四', '男', '123456', '10000002', '网络B161');
INSERT INTO `student` VALUES ('3', '10000003', '王五', '男', '654321', '10000003', '计科B161');
INSERT INTO `student` VALUES ('4', '10000004', '张四', '女', '123456', '10000004', '信管B162');
INSERT INTO `student` VALUES ('5', '10000005', '李三', '男', '123456', '10000005', '网络B162');
INSERT INTO `student` VALUES ('6', '10000006', '王三', '女', '654321', '10000006', '计科B162');
INSERT INTO `student` VALUES ('7', '10000007', '王四', '男', '654321', '10000007', '计科B161');
INSERT INTO `student` VALUES ('8', '10000008', '张五', '男', '123456', '10000008', '信管B161');
INSERT INTO `student` VALUES ('9', '10000009', '李五', '女', '123456', '10000009', '网络B161');
INSERT INTO `student` VALUES ('27', '10000010', '李五', '男', '10000010', '10000010', '信管B162');
INSERT INTO `student` VALUES ('36', '11111', '张11', '男', '11111', '1111111111', '信管B161');
INSERT INTO `student` VALUES ('37', '2222', '刘11', '男', '2222', '22222222', '信管B161');
INSERT INTO `student` VALUES ('38', '3333', '王12', '女', '3333', '12345678', '网络B162');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tno` int(20) NOT NULL,
  `tname` varchar(20) DEFAULT NULL,
  `sex` char(2) DEFAULT NULL,
  `password` varchar(11) NOT NULL,
  `phone` int(20) DEFAULT NULL,
  `education` varchar(20) DEFAULT NULL,
  `department` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '10000001', '张1', '男', '123', '10000001', '硕士', '计算机学院');
INSERT INTO `teacher` VALUES ('2', '10000002', '张2', '女', '123456', '10000002', '博士', '管理学院');
INSERT INTO `teacher` VALUES ('3', '10000003', '张3', '男', '123456', '10000003', '硕士', '计算机学院');
INSERT INTO `teacher` VALUES ('4', '10000004', '李1', '女', '123456', '10000004', '博士', '计算机学院');
INSERT INTO `teacher` VALUES ('5', '10000005', '李2', '男', '123456', '10000005', '硕士', '计算机学院');
INSERT INTO `teacher` VALUES ('6', '10000006', '李3', '女', '123456', '10000006', '硕士', '外国语学院');

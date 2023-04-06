/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : desktop_platfrom

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 06/04/2023 20:16:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bug_type
-- ----------------------------
DROP TABLE IF EXISTS `bug_type`;
CREATE TABLE `bug_type`  (
  `type_id` int NOT NULL AUTO_INCREMENT COMMENT '类型id',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '类型',
  PRIMARY KEY (`type_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bug_type
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `account_number` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `student_number` bigint NOT NULL COMMENT '学号',
  `gender` int NOT NULL COMMENT '性别',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话号码',
  `post` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱',
  `register_time` timestamp NOT NULL COMMENT '注册时间',
  `login_status` int NOT NULL COMMENT '登录状态',
  `role_id` int NOT NULL COMMENT '角色id',
  PRIMARY KEY (`user_id`, `student_number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for user_book
-- ----------------------------
DROP TABLE IF EXISTS `user_book`;
CREATE TABLE `user_book`  (
  `book_id` int NOT NULL AUTO_INCREMENT COMMENT '图书编号',
  `book_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书名称',
  `user_student_number` bigint NOT NULL COMMENT '用户id',
  `book_status` int NOT NULL COMMENT '借阅状态',
  `book_price` double NOT NULL COMMENT '图书价格',
  PRIMARY KEY (`book_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_book
-- ----------------------------

-- ----------------------------
-- Table structure for user_book_borrow
-- ----------------------------
DROP TABLE IF EXISTS `user_book_borrow`;
CREATE TABLE `user_book_borrow`  (
  `user_student_number` bigint NOT NULL COMMENT '拥有者id',
  `book_id` int NOT NULL COMMENT '图书id',
  `borrow_user_student_number` bigint NOT NULL COMMENT '借阅用户id',
  `borrow_book_time` timestamp NOT NULL COMMENT '借阅时间',
  `return_book_time` datetime NOT NULL COMMENT '还书时间'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_book_borrow
-- ----------------------------

-- ----------------------------
-- Table structure for user_bug_message
-- ----------------------------
DROP TABLE IF EXISTS `user_bug_message`;
CREATE TABLE `user_bug_message`  (
  `bug_id` bigint NOT NULL AUTO_INCREMENT COMMENT '报错id',
  `bug_titile` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '报错主题',
  `bug_solve` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '报错解决',
  `release_time` datetime NOT NULL COMMENT '发布时间',
  `user_student_number` bigint NOT NULL COMMENT '用户id',
  PRIMARY KEY (`bug_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_bug_message
-- ----------------------------

-- ----------------------------
-- Table structure for user_bug_type
-- ----------------------------
DROP TABLE IF EXISTS `user_bug_type`;
CREATE TABLE `user_bug_type`  (
  `bug_type_id` int NOT NULL COMMENT '报错类型id',
  `bug_id` bigint NOT NULL COMMENT '报错id'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_bug_type
-- ----------------------------

-- ----------------------------
-- Table structure for user_file_up
-- ----------------------------
DROP TABLE IF EXISTS `user_file_up`;
CREATE TABLE `user_file_up`  (
  `up_id` bigint NOT NULL AUTO_INCREMENT COMMENT '上传id',
  `user_student_number` bigint NOT NULL COMMENT '用户id',
  `up_file_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '上传文件路径',
  `up_time` datetime NOT NULL COMMENT '上传时间',
  `up_ip` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '上传者ip',
  PRIMARY KEY (`up_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_file_up
-- ----------------------------

-- ----------------------------
-- Table structure for user_login_log
-- ----------------------------
DROP TABLE IF EXISTS `user_login_log`;
CREATE TABLE `user_login_log`  (
  `log_id` bigint NOT NULL AUTO_INCREMENT COMMENT '登录日志id',
  `user_student_number` bigint NOT NULL COMMENT '用户id',
  `login_time` datetime NOT NULL COMMENT '登录时间',
  `login_ip` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '登录ip',
  PRIMARY KEY (`log_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_login_log
-- ----------------------------

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `role_id` int NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `duty` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色说明',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------

-- ----------------------------
-- Table structure for user_tasks_list
-- ----------------------------
DROP TABLE IF EXISTS `user_tasks_list`;
CREATE TABLE `user_tasks_list`  (
  `task_id` bigint NOT NULL AUTO_INCREMENT COMMENT '任务id',
  `user_student_number` bigint NOT NULL COMMENT '用户id',
  `task_content` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '任务内容',
  `task_start_time` datetime NOT NULL COMMENT '任务开始时间',
  `task_end_time` datetime NOT NULL COMMENT '任务截止时间',
  PRIMARY KEY (`task_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_tasks_list
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;

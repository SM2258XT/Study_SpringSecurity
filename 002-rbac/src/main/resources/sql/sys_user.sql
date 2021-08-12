/*
 Navicat Premium Data Transfer

 Source Server         : mysql111
 Source Server Type    : MySQL
 Source Server Version : 50528
 Source Host           : localhost:3306
 Source Schema         : sys

 Target Server Type    : MySQL
 Target Server Version : 50528
 File Encoding         : 65001

 Date: 09/08/2021 17:04:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `realname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_enabled` tinyint(1) NULL DEFAULT 1 COMMENT '可用的',
  `is_credentials` tinyint(1) NULL DEFAULT 1 COMMENT '有凭证的',
  `is_non_locked` tinyint(1) NULL DEFAULT 1 COMMENT '没有锁定',
  `is_non_expired` tinyint(1) NULL DEFAULT 1 COMMENT '没有过期',
  `gmt_created` datetime NULL DEFAULT NULL,
  `gmt_modified` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `index_username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (4, 'jack', '666', '杰克', 1, 1, 1, 1, '2021-08-09 10:44:31', '2021-08-09 10:44:31');
INSERT INTO `sys_user` VALUES (5, 'tom', '666', '汤姆', 1, 1, 1, 1, '2021-08-09 10:44:32', '2021-08-09 10:44:32');
INSERT INTO `sys_user` VALUES (6, 'root', 'zhang', '张三', 1, 1, 1, 1, '2021-08-09 10:45:47', '2021-08-09 10:45:47');

SET FOREIGN_KEY_CHECKS = 1;

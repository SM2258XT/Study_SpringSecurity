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

 Date: 09/08/2021 17:04:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `roleinfo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_created` datetime NULL DEFAULT NULL,
  `gmt_modified` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `index_rolename`(`rolename`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'visitor', '访客', '2021-08-09 10:37:38', '2021-08-09 10:37:38');
INSERT INTO `sys_role` VALUES (2, 'customer', '顾客', '2021-08-09 10:37:39', '2021-08-09 10:37:39');
INSERT INTO `sys_role` VALUES (3, 'staff', '职员', '2021-08-09 10:37:39', '2021-08-09 10:37:39');
INSERT INTO `sys_role` VALUES (4, 'admin', '系统管理员', '2021-08-09 10:37:39', '2021-08-09 10:37:39');

SET FOREIGN_KEY_CHECKS = 1;

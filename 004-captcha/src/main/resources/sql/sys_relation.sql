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

 Date: 09/08/2021 17:04:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_relation
-- ----------------------------
DROP TABLE IF EXISTS `sys_relation`;
CREATE TABLE `sys_relation`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `roleid` int(11) NOT NULL,
  `gmt_created` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_relation
-- ----------------------------
INSERT INTO `sys_relation` VALUES (1, 6, 1, '2021-08-09 11:12:40', '2021-08-09 11:12:40');
INSERT INTO `sys_relation` VALUES (2, 6, 2, '2021-08-09 11:12:40', '2021-08-09 11:12:40');
INSERT INTO `sys_relation` VALUES (3, 6, 3, '2021-08-09 11:12:40', '2021-08-09 11:12:40');
INSERT INTO `sys_relation` VALUES (4, 6, 4, '2021-08-09 11:12:40', '2021-08-09 11:12:40');
INSERT INTO `sys_relation` VALUES (5, 4, 1, '2021-08-09 11:12:40', '2021-08-09 11:12:40');
INSERT INTO `sys_relation` VALUES (6, 4, 2, '2021-08-09 11:12:40', '2021-08-09 11:12:40');
INSERT INTO `sys_relation` VALUES (7, 4, 3, '2021-08-09 11:12:40', '2021-08-09 11:12:40');
INSERT INTO `sys_relation` VALUES (8, 5, 1, '2021-08-09 11:12:40', '2021-08-09 11:12:40');

SET FOREIGN_KEY_CHECKS = 1;

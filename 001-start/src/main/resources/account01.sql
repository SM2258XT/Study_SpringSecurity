/*
 Navicat Premium Data Transfer

 Source Server         : mysql111
 Source Server Type    : MySQL
 Source Server Version : 50528
 Source Host           : localhost:3306
 Source Schema         : spring

 Target Server Type    : MySQL
 Target Server Version : 50528
 File Encoding         : 65001

 Date: 08/08/2021 18:45:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`
(
    `id`           int(11)                                                 NOT NULL AUTO_INCREMENT,
    `username`     varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `password`     varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `role`         varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL,
    `gmt_created`  datetime                                                NOT NULL,
    `gmt_modified` datetime                                                NOT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Compact;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account`
VALUES (1, 'root', 'zhang', 'admin', '2021-08-07 11:25:33', '2021-08-07 11:25:33');
INSERT INTO `account`
VALUES (2, 'lucy', '666', 'visitor', '2021-08-07 11:26:56', '2021-08-07 11:26:56');
INSERT INTO `account`
VALUES (3, 'jack', '666', 'visitor', '2021-08-07 11:26:56', '2021-08-07 11:26:56');

SET FOREIGN_KEY_CHECKS = 1;

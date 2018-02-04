/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50639
 Source Host           : localhost:3306
 Source Schema         : lawyer_wechar

 Target Server Type    : MySQL
 Target Server Version : 50639
 File Encoding         : 65001

 Date: 04/02/2018 22:11:04
*/

DROP DATABASE IF EXISTS `lawyer_wechat`;
CREATE DATABASE `lawyer_wechat`;
USE `lawyer_wechat`;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
-- ----------------------------
-- Table structure for t_article
-- ----------------------------
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `brief` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `details` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `createAt` datetime(0) NOT NULL,
  `releasePlace` enum('banner','list') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `briefInfo` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `articleGroup` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `articleIndex` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_lawyer
-- ----------------------------
DROP TABLE IF EXISTS `t_lawyer`;
CREATE TABLE `t_lawyer`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `lawOffice` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` bigint(20) UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_ptbbsmessagerecord
-- ----------------------------
DROP TABLE IF EXISTS `t_ptbbsmessagerecord`;
CREATE TABLE `t_ptbbsmessagerecord`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) UNSIGNED NOT NULL,
  `message` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `speakAt` datetime(0) NOT NULL,
  `sensitive` tinyint(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_publicbbsmessagerecord
-- ----------------------------
DROP TABLE IF EXISTS `t_publicbbsmessagerecord`;
CREATE TABLE `t_publicbbsmessagerecord`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) UNSIGNED NOT NULL,
  `message` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `speakAt` datetime(0) NOT NULL,
  `sensitive` tinyint(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_question
-- ----------------------------
DROP TABLE IF EXISTS `t_question`;
CREATE TABLE `t_question`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `questionerId` bigint(20) UNSIGNED NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createAt` datetime(0) NOT NULL,
  `questionerContactInfo` bigint(20) UNSIGNED NULL DEFAULT NULL,
  `pay` tinyint(1) NOT NULL DEFAULT 0,
  `answerWay` enum('文字','电话','其他') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` enum('已提交处理','正在处理','处理完毕') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `answerAt` datetime(0) NULL DEFAULT NULL,
  `answerId` bigint(20) UNSIGNED NULL DEFAULT NULL,
  `releasePlace` enum('banner','list') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_sign
-- ----------------------------
DROP TABLE IF EXISTS `t_sign`;
CREATE TABLE `t_sign`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) UNSIGNED NOT NULL,
  `signAt` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_systemnotice
-- ----------------------------
DROP TABLE IF EXISTS `t_systemnotice`;
CREATE TABLE `t_systemnotice`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `content` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createAt` datetime(0) NOT NULL,
  `releaseAt` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_teacher
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `school` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` bigint(20) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `wechatAccount` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `photoGroup` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `photoIndex` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nickname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `mobilephone` bigint(20) NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `province` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `city` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `county` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `addr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `permission` bigint(20) NULL DEFAULT NULL,
  `status` tinyint(1) NULL DEFAULT NULL,
  `integral` bigint(20) UNSIGNED NULL DEFAULT 0,
  `lastLogin` datetime(0) NULL DEFAULT NULL,
  `gag` tinyint(1) NULL DEFAULT NULL,
  `banner` tinyint(1) NULL DEFAULT NULL,
  `openId` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;

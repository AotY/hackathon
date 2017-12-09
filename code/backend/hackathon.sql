/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : 192.168.137.214
 Source Database       : hackathon

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : utf-8

 Date: 12/09/2017 17:47:37 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `evaluation`
-- ----------------------------
-- DROP TABLE IF EXISTS `evaluation`;
-- CREATE TABLE `evaluation` (
--   `from_user_id` int(11) NOT NULL COMMENT '发表评价的用户id',
--   `to_user_id` int(11) DEFAULT NULL COMMENT '被评价的用户id',
--   `evaluation_label` varchar(300) DEFAULT NULL COMMENT '用户评价 label',
--   `evaluation_text` varchar(500) DEFAULT NULL COMMENT '用户评价 text',
--   `rating` float DEFAULT NULL COMMENT '当前该评论分数',
--   `main_image` varchar(500) DEFAULT NULL COMMENT '评价图片',
--   `sub_images` text COMMENT '图片地址,json格式 扩展用',
--   `create_time` datetime DEFAULT NULL COMMENT '记录创建时间',
--   `update_time` datetime DEFAULT NULL COMMENT '记录更新时间'
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `evaluation`
-- ----------------------------
-- BEGIN;
-- INSERT INTO `evaluation` VALUES ('26', '27', '态度很好,聊得很开心', null, '4.8', null, null, '2017-12-09 17:02:44', '2017-12-09 17:02:46'), ('26', '28', '知识面很广,很贴心', null, '5', null, null, '2017-12-09 17:03:52', '2017-12-09 17:03:54'), ('27', '26', '准时,很贴心', null, '4.9', null, null, '2017-12-09 17:04:36', '2017-12-09 17:04:38'), ('29', '30', '不准时,知识面窄', null, '4.6', null, null, '2017-12-09 17:06:33', '2017-12-09 17:06:35');
-- COMMIT;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
-- DROP TABLE IF EXISTS `user`;
-- CREATE TABLE `user` (
--   `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户表id',
--   `username` varchar(50) NOT NULL COMMENT '用户名',
--   `main_image` varchar(500) DEFAULT NULL COMMENT '用户头像, url相对地址',
--   `sub_images` text COMMENT '图片地址, json格式 扩展用',
--   `sex` varchar(10) NOT NULL COMMENT '性别',
--   `age` int(10) NOT NULL COMMENT '年龄',
--   `hometown` varchar(20) NOT NULL COMMENT '家乡',
--   `industry` varchar(50) NOT NULL COMMENT '职业',
--   `online` int(4) NOT NULL COMMENT '用户是否在线',
--   `guide` int(4) NOT NULL COMMENT '用户当前是否是导游状态',
--   `longitude` float NOT NULL COMMENT '用户位置经度',
--   `latitude` float NOT NULL COMMENT '用户位置维度',
--   `guide_count` int(4) DEFAULT '0' COMMENT '用户当导游次数',
--   `rating` float DEFAULT '0' COMMENT '如果是导游状态则显示用户评分',
--   `personality` varchar(200) DEFAULT NULL COMMENT '用户性格',
--   `language` varchar(200) DEFAULT NULL COMMENT '擅长语言',
--   `travel` varchar(200) DEFAULT NULL COMMENT '用户去过的旅游点',
--   `book` varchar(200) DEFAULT NULL COMMENT '喜欢的书籍',
--   `movie` varchar(200) DEFAULT NULL COMMENT '喜欢的电影',
--   `music` varchar(200) DEFAULT NULL COMMENT '喜欢的音乐',
--   `food` varchar(200) DEFAULT NULL COMMENT '喜欢的食物',
--   `sport` varchar(200) DEFAULT NULL COMMENT '喜欢的运动',
--   `password` varchar(50) NOT NULL COMMENT '用户密码，MD5加密',
--   `phone` varchar(20) NOT NULL COMMENT '用户手机号码',
--   `device` varchar(20) NOT NULL COMMENT '用户客户端标识',
--   `create_time` datetime NOT NULL COMMENT '记录创建时间',
--   `update_time` datetime NOT NULL COMMENT '记录更新时间',
--   PRIMARY KEY (`id`),
--   UNIQUE KEY `user_name_unique` (`username`) USING BTREE
-- ) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user`
-- ----------------------------
-- BEGIN;
-- INSERT INTO `user` VALUES ('26', '西安1', 'user_image_3.png', null, '男', '25', '西安', '教育', '0', '0', '108.984', '34.2461', '10', '4.8', '靠谱,理想主义', '普通话,陕西话', '成都,北京,上海,杭州', '刘震云,余华,贾平凹', '海上钢琴师,辛德勒的名单', '民谣,摇滚', '寿司,拌饭', '篮球,跑步', '81DC9BDB52D04DC20036DBD8313ED055', '18786116312', 'iphone 6s', '2017-12-09 16:29:25', '2017-12-09 16:29:28'), ('27', '西安2', 'user_image_1.png', null, '女', '20', '西安', '学生', '0', '0', '109.134', '34.3912', '15', '4.7', '文艺,活泼,女汉子,强迫症', '普通话,英语', '兰州,武汉,香港,广东', '村上春树,东野圭吾,三毛', '一一,死亡诗社,海上钢琴师', '流行,民谣,爵士', '火锅,麻小,牛排', '健身,爬山,游泳', '81DC9BDB52D04DC20036DBD8313ED055', '18786116313', 'iphone 8', '2017-12-09 16:36:31', '2017-12-09 16:36:33'), ('28', '西安3', 'user_image_6.png', null, '女', '30', '西安', '银行', '0', '0', '109.214', '34.3321', '3', '4.9', '强迫症,喜欢简单,随性', '普通话', '南昌,无锡,上海,北京', '三毛,路遥,余华', '飞越疯人院,海上钢琴师', '流行,民谣', '火锅,寿司,拌饭', '跑步,爬山', '81DC9BDB52D04DC20036DBD8313ED055', '18786116314', 'iphone x', '2017-12-09 16:36:31', '2017-12-09 16:36:33'), ('29', '西安4', 'user_image_5.png', null, '男', '20', '西安', '学生', '0', '0', '109.234', '34.3044', '20', '4.8', '理想主义,强迫症', '普通话,英语', '哈尔滨,大连,郑州,上海,北京', '鲁迅,王朔,贾平凹', '海上钢琴师,肖申克的救赎,这个杀手不太冷', '民谣,摇滚,电子,嘻哈', '寿司,拌饭,牛排', '篮球,台球,健身房', '81DC9BDB52D04DC20036DBD8313ED055', '18786116315', 'iphone se', '2017-12-09 16:36:31', '2017-12-09 16:36:33'), ('30', '西安5', 'user_image_2.png', null, '女', '18', '西安', '学生', '0', '0', '109.131', '34.212', '30', '4.6', '安静,喜欢简单,理想主义', '普通话', '成都,重庆,贵阳,北京,上海', '张爱玲,胡适,李敖,三毛', '放牛班的春天,一一,教父,这个杀手不太冷', '流行,摇滚', '火锅,麻小,寿司', '游泳,拉面,牛排', '81DC9BDB52D04DC20036DBD8313ED055', '18786116316', 'iphone 7', '2017-12-09 16:36:31', '2017-12-09 16:36:33');
-- COMMIT;


-- ----------------------------
--  Table structure for `carousel` 商品推荐
-- ----------------------------
DROP TABLE IF EXISTS `carousel`;
CREATE TABLE `carousel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `keyword` varchar(100) NOT NULL COMMENT '图片对应的关键词',
  `image` varchar(500) DEFAULT NULL COMMENT '商品主图, url相对地址',
  `create_time` datetime DEFAULT NULL COMMENT '记录创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '记录更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;


-- ----------------------------
--  Table structure for `carousel` 查询词
-- ----------------------------
DROP TABLE IF EXISTS `keyword`;
CREATE TABLE `keyword` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `keyword` varchar(100) NOT NULL COMMENT '检索keyword',
  `count` int(11) DEFAULT '0' COMMENT '检索次数',
  `create_time` datetime DEFAULT NULL COMMENT '记录创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '记录更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;

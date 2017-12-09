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
DROP TABLE IF EXISTS `evaluation`;
CREATE TABLE `evaluation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fromUserId` int(11) NOT NULL COMMENT '发表评价的用户id',
  `toUserId` int(11) DEFAULT NULL COMMENT '被评价的用户id',
  `evaluationLabel` varchar(300) DEFAULT NULL COMMENT '用户评价 label',
  `evaluationText` varchar(500) DEFAULT NULL COMMENT '用户评价 text',
  `rating` float DEFAULT NULL COMMENT '当前该评论分数',
  `mainImage` varchar(500) DEFAULT NULL COMMENT '评价图片',
  `subImages` text COMMENT '图片地址,json格式 扩展用',
  `createTime` datetime DEFAULT NULL COMMENT '记录创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '记录更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `evaluation`
-- ----------------------------
BEGIN;
INSERT INTO `evaluation` VALUES
('19', '26', '27', '态度很好,聊得很开心', null, '4.8', null, null, '2017-12-09 17:02:44', '2017-12-09 17:02:46'),
('20','26', '28', '知识面很广,很贴心', null, '5', null, null, '2017-12-09 17:03:52', '2017-12-09 17:03:54'),
('21','27', '26', '准时,很贴心', null, '4.9', null, null, '2017-12-09 17:04:36', '2017-12-09 17:04:38'),
('22','29', '30', '不准时,知识面窄', null, '4.6', null, null, '2017-12-09 17:06:33', '2017-12-09 17:06:35');
COMMIT;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户表id',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `mainImage` varchar(500) DEFAULT NULL COMMENT '用户头像, url相对地址',
  `subImages` text COMMENT '图片地址, json格式 扩展用',
  `sex` varchar(10) NOT NULL COMMENT '性别',
  `age` int(10) NOT NULL COMMENT '年龄',
  `hometown` varchar(20) DEFAULT NULL COMMENT '家乡',
  `industry` varchar(50) DEFAULT NULL COMMENT '职业',
  `online` int(4) DEFAULT '0' COMMENT '用户是否在线',
  `guide` int(4) DEFAULT '0' COMMENT '用户当前是否是导游状态',
  `longitude` float DEFAULT NULL COMMENT '用户位置经度',
  `latitude` float DEFAULT NULL COMMENT '用户位置维度',
  `guideCount` int(4) DEFAULT '0' COMMENT '用户当导游次数',
  `rating` float DEFAULT '0' COMMENT '如果是导游状态则显示用户评分',
  `personality` varchar(200) DEFAULT NULL COMMENT '用户性格',
  `language` varchar(200) DEFAULT NULL COMMENT '擅长语言',
  `place` varchar(200) DEFAULT NULL COMMENT '用户熟悉的地点',
  `travel` varchar(200) DEFAULT NULL COMMENT '用户去过的旅游点',
  `book` varchar(200) DEFAULT NULL COMMENT '喜欢的书籍',
  `movie` varchar(200) DEFAULT NULL COMMENT '喜欢的电影',
  `music` varchar(200) DEFAULT NULL COMMENT '喜欢的音乐',
  `food` varchar(200) DEFAULT NULL COMMENT '喜欢的食物',
  `sport` varchar(200) DEFAULT NULL COMMENT '喜欢的运动',
  `password` varchar(50) NOT NULL COMMENT '用户密码，MD5加密',
  `phone` varchar(20) NOT NULL COMMENT '用户手机号码',
  `device` varchar(20) NOT NULL COMMENT '用户客户端标识',
  `createTime` datetime NOT NULL COMMENT '记录创建时间',
  `updateTime` datetime NOT NULL COMMENT '记录更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name_unique` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('26', '西安1', 'user_image_3.png', null, '男', '25', '西安', '教育', '0', '0', '108.984', '34.2461', '10', '4.8', '靠谱,理想主义', '普通话,陕西话', '兵马俑,城墙,钟楼,回民街','成都,北京,上海,杭州', '刘震云,余华,贾平凹', '海上钢琴师,辛德勒的名单', '民谣,摇滚', '寿司,拌饭', '篮球,跑步', '81DC9BDB52D04DC20036DBD8313ED055', '18786116312', 'iphone 6s', '2017-12-09 16:29:25', '2017-12-09 16:29:28'), ('27', '西安2', 'user_image_1.png', null, '女', '20', '西安', '学生', '0', '0', '109.134', '34.3912', '15', '4.7', '文艺,活泼,女汉子,强迫症', '普通话,英语', '兵马俑,城墙,钟楼,回民街','兰州,武汉,香港,广东', '村上春树,东野圭吾,三毛', '一一,死亡诗社,海上钢琴师', '流行,民谣,爵士', '火锅,麻小,牛排', '健身,爬山,游泳', '81DC9BDB52D04DC20036DBD8313ED055', '18786116313', 'iphone 8', '2017-12-09 16:36:31', '2017-12-09 16:36:33'), ('28', '西安3', 'user_image_6.png', null, '女', '30', '西安', '银行', '0', '0', '109.214', '34.3321', '3', '4.9', '强迫症,喜欢简单,随性', '普通话', '兵马俑,城墙,钟楼,回民街','南昌,无锡,上海,北京', '三毛,路遥,余华', '飞越疯人院,海上钢琴师', '流行,民谣', '火锅,寿司,拌饭', '跑步,爬山', '81DC9BDB52D04DC20036DBD8313ED055', '18786116314', 'iphone x', '2017-12-09 16:36:31', '2017-12-09 16:36:33'), ('29', '西安4', 'user_image_5.png', null, '男', '20', '西安', '学生', '0', '0', '109.234', '34.3044', '20', '4.8', '理想主义,强迫症', '普通话,英语', '兵马俑,城墙,钟楼,回民街','哈尔滨,大连,郑州,上海,北京', '鲁迅,王朔,贾平凹', '海上钢琴师,肖申克的救赎,这个杀手不太冷', '民谣,摇滚,电子,嘻哈', '寿司,拌饭,牛排', '篮球,台球,健身房', '81DC9BDB52D04DC20036DBD8313ED055', '18786116315', 'iphone se', '2017-12-09 16:36:31', '2017-12-09 16:36:33'), ('30', '西安5', 'user_image_2.png', null, '女', '18', '西安', '学生', '0', '0', '109.131', '34.212', '30', '4.6', '安静,喜欢简单,理想主义', '普通话', '兵马俑,城墙,钟楼,回民街','成都,重庆,贵阳,北京,上海', '张爱玲,胡适,李敖,三毛', '放牛班的春天,一一,教父,这个杀手不太冷', '流行,摇滚', '火锅,麻小,寿司', '游泳,拉面,牛排', '81DC9BDB52D04DC20036DBD8313ED055', '18786116316', 'iphone 7', '2017-12-09 16:36:31', '2017-12-09 16:36:33');
COMMIT;


-- ----------------------------
--  Table structure for `carousel` 商品推荐
-- ----------------------------
DROP TABLE IF EXISTS `carousel`;
CREATE TABLE `carousel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `keyword` varchar(100) NOT NULL COMMENT '图片对应的关键词',
  `image` varchar(500) DEFAULT NULL COMMENT '商品主图, url相对地址',
  `createTime` datetime DEFAULT NULL COMMENT '记录创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '记录更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

BEGIN;
INSERT INTO `carousel` VALUES ('32', '城墙', 'xian_1.jpg', '2017-12-09 19:01:33', '2017-12-09 19:01:35'), ('33', '钟楼', 'xian_2.jpg', '2017-12-09 19:02:05', '2017-12-09 19:02:07'), ('34', '兵马俑', 'xian_4.jpg', '2017-12-09 19:05:03', '2017-12-09 19:05:04');
COMMIT;

-- ----------------------------
--  Table structure for `carousel` 查询词
-- ----------------------------
DROP TABLE IF EXISTS `keyword`;
CREATE TABLE `keyword` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `keyword` varchar(100) NOT NULL COMMENT '检索keyword',
  `count` int(11) DEFAULT '0' COMMENT '检索次数',
  `createTime` datetime DEFAULT NULL COMMENT '记录创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '记录更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;


BEGIN;
INSERT INTO `keyword` VALUES ('11', '城墙', '30', '2017-12-09 19:02:31', '2017-12-09 19:02:33'), ('12', '钟楼', '53', '2017-12-09 19:02:47', '2017-12-09 19:02:49'), ('13', '兵马俑', '100', '2017-12-09 19:02:57', '2017-12-09 19:02:59');
COMMIT;

-- ----------------------------
--  Table structure for `history` 用户向导历史表
-- ----------------------------
DROP TABLE IF EXISTS `history`;
CREATE TABLE `history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fromUserId` int(11) NOT NULL COMMENT '请求向导的用户id',
  `toUserId` int(11) DEFAULT NULL COMMENT '接受向导的用户id',
  `destination` varchar(200) NOT NULL COMMENT '目的地',
  `createTime` datetime DEFAULT NULL COMMENT '记录创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '记录更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

BEGIN;
INSERT INTO `history` VALUES ('14', '26', '27', '兵马俑', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('15', '26', '28', '城墙', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('16', '26', '29', '钟楼', '2017-12-09 19:02:33' , '2017-12-09 19:02:47');
COMMIT;


-- 用户特点 character 表
DROP TABLE IF EXISTS `character`;
CREATE TABLE `character` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(20) NOT NULL COMMENT '目的地',
  `type` varchar(20) NOT NULL COMMENT '目的地',
  `createTime` datetime DEFAULT NULL COMMENT '记录创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '记录更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

BEGIN;
INSERT INTO `character` VALUES
('15', '靠谱', 'personality', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('16', '理想主义', 'personality', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('17', '文艺', 'personality', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('18', '活泼', 'personality', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('19', '女汉子', 'personality', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('20', '强迫症', 'personality', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('21', '喜欢简单', 'personality', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('22', '随性', 'personality', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('23', '安静', 'personality', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),

('24', '普通话', 'language', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('25', '陕西话', 'language', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('26', '英语', 'language', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),

('27', '兵马俑', 'place', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('28', '城墙', 'place', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('29', '钟楼', 'place', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('30', '回民街', 'place', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),

('31', '成都', 'travel', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('32', '北京', 'travel', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('33', '杭州', 'travel', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('34', '上海', 'travel', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('35', '兰州', 'travel', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('36', '广东', 'travel', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('37', '香港', 'travel', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('38', '武汉', 'travel', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('39', '南昌', 'travel', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('40', '无锡', 'travel', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('41', '哈尔滨', 'travel', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('42', '郑州', 'travel', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('43', '重庆', 'travel', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('44', '贵阳', 'travel', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),

('45', '刘震云', 'book', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('46', '余华', 'book', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('47', '贾平凹', 'book', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('48', '村上春树', 'book', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('49', '东野圭吾', 'book', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('50', '三毛', 'book', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('51', '路遥', 'book', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('52', '鲁迅', 'book', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('53', '王朔', 'book', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('54', '张爱玲', 'book', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('55', '胡适', 'book', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('56', '李敖', 'book', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),

('57', '海上钢琴师', 'movie', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('58', '辛德勒的名单', 'movie', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('59', '一一', 'movie', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('60', '死亡诗社', 'movie', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('61', '飞越疯人院', 'movie', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('62', '肖申克的救赎', 'movie', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('63', '这个杀手不太冷', 'movie', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('64', '放牛班的春天', 'movie', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),

('65', '民谣', 'music', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('66', '摇滚', 'music', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('67', '流行', 'music', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('68', '爵士', 'music', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('69', '电子', 'music', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('70', '嘻哈', 'music', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),

('71', '寿司', 'food', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('72', '拌饭', 'food', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('73', '火锅', 'food', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('74', '麻小', 'food', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('75', '牛排', 'food', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),

('76', '篮球', 'sport', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('77', '跑步', 'sport', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('78', '健身', 'sport', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('79', '爬山', 'sport', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('80', '游泳', 'sport', '2017-12-09 19:02:33' , '2017-12-09 19:02:47'),
('81', '台球', 'sport', '2017-12-09 19:02:33' , '2017-12-09 19:02:47');
COMMIT;



SET FOREIGN_KEY_CHECKS = 1;

/*
Navicat MySQL Data Transfer

Source Server         : la
Source Server Version : 50559
Source Host           : localhost:3306
Source Database       : mmsdb

Target Server Type    : MYSQL
Target Server Version : 50559
File Encoding         : 65001

Date: 2018-03-31 12:34:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for area
-- ----------------------------
DROP TABLE IF EXISTS `area`;
CREATE TABLE `area` (
  `AREAID` int(11) NOT NULL,
  `AREANAME` varchar(50) NOT NULL,
  `RELATIVE` int(11) DEFAULT NULL,
  PRIMARY KEY (`AREAID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=5461;

-- ----------------------------
-- Records of area
-- ----------------------------
INSERT INTO `area` VALUES ('1', '华北地区', '0');
INSERT INTO `area` VALUES ('2', '华南地区', null);
INSERT INTO `area` VALUES ('5', '华西0', '0');

-- ----------------------------
-- Table structure for balance
-- ----------------------------
DROP TABLE IF EXISTS `balance`;
CREATE TABLE `balance` (
  `BID` int(11) NOT NULL AUTO_INCREMENT,
  `BNAME` varchar(50) NOT NULL,
  `BCOUNT` double NOT NULL,
  `PRICE` decimal(7,2) NOT NULL,
  `BDATE` datetime NOT NULL,
  `CID` int(11) NOT NULL,
  `DEPARTID` int(11) NOT NULL,
  PRIMARY KEY (`BID`) USING BTREE,
  KEY `CID` (`CID`) USING BTREE,
  KEY `DEPARTID` (`DEPARTID`) USING BTREE,
  CONSTRAINT `balance_ibfk_1` FOREIGN KEY (`CID`) REFERENCES `category` (`CID`),
  CONSTRAINT `balance_ibfk_2` FOREIGN KEY (`DEPARTID`) REFERENCES `department` (`DEPARTID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=8192;

-- ----------------------------
-- Records of balance
-- ----------------------------
INSERT INTO `balance` VALUES ('1', '电脑', '200', '10000.00', '2017-01-01 00:00:00', '1', '1');
INSERT INTO `balance` VALUES ('2', '办公桌', '100', '2000.00', '2017-01-13 00:00:00', '1', '1');

-- ----------------------------
-- Table structure for buy
-- ----------------------------
DROP TABLE IF EXISTS `buy`;
CREATE TABLE `buy` (
  `BUYID` int(11) NOT NULL AUTO_INCREMENT,
  `BUYCOUNT` double NOT NULL,
  `BUYTIME` datetime NOT NULL,
  `PROVID` int(11) NOT NULL,
  `DEPARTID` int(11) NOT NULL,
  PRIMARY KEY (`BUYID`) USING BTREE,
  KEY `DEPARTID` (`DEPARTID`) USING BTREE,
  KEY `PROVID` (`PROVID`) USING BTREE,
  CONSTRAINT `buy_ibfk_1` FOREIGN KEY (`DEPARTID`) REFERENCES `department` (`DEPARTID`),
  CONSTRAINT `buy_ibfk_2` FOREIGN KEY (`PROVID`) REFERENCES `provider` (`PROVID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=8192;

-- ----------------------------
-- Records of buy
-- ----------------------------
INSERT INTO `buy` VALUES ('1', '106', '2019-01-22 12:00:00', '2', '5');
INSERT INTO `buy` VALUES ('7', '163', '2017-10-27 16:00:00', '1', '1');
INSERT INTO `buy` VALUES ('8', '15', '2018-03-07 10:22:32', '1', '3');
INSERT INTO `buy` VALUES ('9', '150', '2018-03-05 10:39:27', '2', '2');
INSERT INTO `buy` VALUES ('14', '4', '2019-02-16 00:00:00', '1', '1');

-- ----------------------------
-- Table structure for basicDataAdmin
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `CID` int(9) NOT NULL AUTO_INCREMENT,
  `CNAME` varchar(50) NOT NULL,
  PRIMARY KEY (`CID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=5461;

-- ----------------------------
-- Records of basicDataAdmin
-- ----------------------------
INSERT INTO `category` VALUES ('1', '办公用品02');
INSERT INTO `category` VALUES ('2', '设备01');
INSERT INTO `category` VALUES ('3', '房产');
INSERT INTO `category` VALUES ('7', 'abc');

-- ----------------------------
-- Table structure for checkbalance
-- ----------------------------
DROP TABLE IF EXISTS `checkbalance`;
CREATE TABLE `checkbalance` (
  `CHID` int(11) NOT NULL,
  `BUYID` int(11) NOT NULL,
  `BID` int(11) NOT NULL,
  `REPAIRID` int(11) NOT NULL,
  `SID` int(11) NOT NULL,
  `TID` int(11) NOT NULL,
  PRIMARY KEY (`CHID`) USING BTREE,
  KEY `BID` (`BID`) USING BTREE,
  KEY `BUYID` (`BUYID`) USING BTREE,
  KEY `REPAIRID` (`REPAIRID`) USING BTREE,
  KEY `SID` (`SID`) USING BTREE,
  KEY `TID` (`TID`) USING BTREE,
  CONSTRAINT `checkbalance_ibfk_1` FOREIGN KEY (`BID`) REFERENCES `balance` (`BID`) ON DELETE CASCADE,
  CONSTRAINT `checkbalance_ibfk_2` FOREIGN KEY (`BUYID`) REFERENCES `buy` (`BUYID`),
  CONSTRAINT `checkbalance_ibfk_3` FOREIGN KEY (`REPAIRID`) REFERENCES `repair` (`REPAIRID`),
  CONSTRAINT `checkbalance_ibfk_4` FOREIGN KEY (`SID`) REFERENCES `scrap` (`SID`),
  CONSTRAINT `checkbalance_ibfk_5` FOREIGN KEY (`TID`) REFERENCES `translate` (`TID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=8192;

-- ----------------------------
-- Records of checkbalance
-- ----------------------------
INSERT INTO `checkbalance` VALUES ('1', '1', '1', '1', '1', '1');
INSERT INTO `checkbalance` VALUES ('2', '2', '2', '2', '2', '2');

-- ----------------------------
-- Table structure for demo
-- ----------------------------
DROP TABLE IF EXISTS `demo`;
CREATE TABLE `demo` (
  `ID` int(11) DEFAULT NULL,
  `NAME` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=16384;

-- ----------------------------
-- Records of demo
-- ----------------------------
INSERT INTO `demo` VALUES ('1', 'test');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `DEPARTID` int(11) NOT NULL AUTO_INCREMENT,
  `DEPARTNAME` varchar(20) NOT NULL,
  `AREAID` int(11) DEFAULT NULL,
  `AREANAME` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`DEPARTID`) USING BTREE,
  KEY `AREAID` (`AREAID`) USING BTREE,
  CONSTRAINT `department_ibfk_1` FOREIGN KEY (`AREAID`) REFERENCES `area` (`AREAID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=5461;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '开发部01', '1', '华南区');
INSERT INTO `department` VALUES ('2', '市场部', '1', '华南区');
INSERT INTO `department` VALUES ('3', '销售部', '2', '华南区');
INSERT INTO `department` VALUES ('5', '啦啦', null, '华南区');

-- ----------------------------
-- Table structure for privilegelist
-- ----------------------------
DROP TABLE IF EXISTS `privilegelist`;
CREATE TABLE `privilegelist` (
  `PID` int(11) NOT NULL,
  `PNAME` varchar(50) NOT NULL,
  `PURL` varchar(255) DEFAULT NULL,
  `PARENTID` int(11) NOT NULL COMMENT '自关联pid列，0表示顶级权限',
  PRIMARY KEY (`PID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=204;

-- ----------------------------
-- Records of privilegelist
-- ----------------------------
INSERT INTO `privilegelist` VALUES ('1', '基础数据管理', null, '0');
INSERT INTO `privilegelist` VALUES ('2', '资产管理', null, '0');
INSERT INTO `privilegelist` VALUES ('3', '使用统计管理', null, '0');
INSERT INTO `privilegelist` VALUES ('4', '供应商管理', null, '0');
INSERT INTO `privilegelist` VALUES ('5', '系统管理', null, '0');
INSERT INTO `privilegelist` VALUES ('101', '资产分类设置', null, '1');
INSERT INTO `privilegelist` VALUES ('102', '部门设置', null, '1');
INSERT INTO `privilegelist` VALUES ('103', '资产录入', null, '1');
INSERT INTO `privilegelist` VALUES ('104', '区域管理', null, '1');
INSERT INTO `privilegelist` VALUES ('201', '采购管理', null, '2');
INSERT INTO `privilegelist` VALUES ('202', '盘点管理', null, '2');
INSERT INTO `privilegelist` VALUES ('203', '跨部门调配管理', null, '2');
INSERT INTO `privilegelist` VALUES ('204', '报修管理', null, '2');
INSERT INTO `privilegelist` VALUES ('205', '报废管理', null, '2');
INSERT INTO `privilegelist` VALUES ('301', '资产总数', null, '3');
INSERT INTO `privilegelist` VALUES ('302', '采购记录', null, '3');
INSERT INTO `privilegelist` VALUES ('303', '跨部门调配记录', null, '3');
INSERT INTO `privilegelist` VALUES ('304', '报修记录', null, '3');
INSERT INTO `privilegelist` VALUES ('305', '报废记录', null, '3');
INSERT INTO `privilegelist` VALUES ('306', '盘点记录', null, '3');
INSERT INTO `privilegelist` VALUES ('401', '供应商信息查看', null, '4');
INSERT INTO `privilegelist` VALUES ('402', '产品信息查看', null, '4');
INSERT INTO `privilegelist` VALUES ('501', '用户管理', null, '5');
INSERT INTO `privilegelist` VALUES ('502', '角色管理', null, '5');
INSERT INTO `privilegelist` VALUES ('503', '权限管理', null, '5');
INSERT INTO `privilegelist` VALUES ('10101', '新增分类', null, '101');
INSERT INTO `privilegelist` VALUES ('10102', '修改分类', null, '101');
INSERT INTO `privilegelist` VALUES ('10103', '删除分类', null, '101');
INSERT INTO `privilegelist` VALUES ('10104', '查询分类', null, '101');
INSERT INTO `privilegelist` VALUES ('10201', '新增部门', null, '102');
INSERT INTO `privilegelist` VALUES ('10202', '修改部门', null, '102');
INSERT INTO `privilegelist` VALUES ('10203', '删除部门', null, '102');
INSERT INTO `privilegelist` VALUES ('10204', '查询部门', null, '102');
INSERT INTO `privilegelist` VALUES ('10301', '新增资产', null, '103');
INSERT INTO `privilegelist` VALUES ('10401', '新增区域', null, '104');
INSERT INTO `privilegelist` VALUES ('10402', '修改区域', null, '104');
INSERT INTO `privilegelist` VALUES ('10403', '删除区域', null, '104');
INSERT INTO `privilegelist` VALUES ('10404', '查询区域', null, '104');
INSERT INTO `privilegelist` VALUES ('20101', '新增采购单', null, '201');
INSERT INTO `privilegelist` VALUES ('20102', '修改采购单', null, '201');
INSERT INTO `privilegelist` VALUES ('20103', '删除采购单', null, '201');
INSERT INTO `privilegelist` VALUES ('20104', '查询采购单', null, '201');
INSERT INTO `privilegelist` VALUES ('20201', '新增盘点', null, '202');
INSERT INTO `privilegelist` VALUES ('20202', '修改盘点', null, '202');
INSERT INTO `privilegelist` VALUES ('20203', '删除盘点', null, '202');
INSERT INTO `privilegelist` VALUES ('20204', '查询盘点', null, '202');
INSERT INTO `privilegelist` VALUES ('20301', '新增调配', null, '203');
INSERT INTO `privilegelist` VALUES ('20302', '修改调配', null, '203');
INSERT INTO `privilegelist` VALUES ('20303', '删除调配', null, '203');
INSERT INTO `privilegelist` VALUES ('20304', '查询调配', null, '203');
INSERT INTO `privilegelist` VALUES ('20401', '新增报修', null, '204');
INSERT INTO `privilegelist` VALUES ('20402', '修改报修', null, '204');
INSERT INTO `privilegelist` VALUES ('20403', '删除报修', null, '204');
INSERT INTO `privilegelist` VALUES ('20404', '查询报修', null, '204');
INSERT INTO `privilegelist` VALUES ('20501', '新增报废', null, '205');
INSERT INTO `privilegelist` VALUES ('20502', '修改报废', null, '205');
INSERT INTO `privilegelist` VALUES ('20503', '删除报废', null, '205');
INSERT INTO `privilegelist` VALUES ('20504', '查询报废', null, '205');
INSERT INTO `privilegelist` VALUES ('30101', '统计1', null, '301');
INSERT INTO `privilegelist` VALUES ('30201', '统计2', null, '302');
INSERT INTO `privilegelist` VALUES ('30301', '统计3', null, '303');
INSERT INTO `privilegelist` VALUES ('30401', '统计4', null, '304');
INSERT INTO `privilegelist` VALUES ('30501', '统计5', null, '305');
INSERT INTO `privilegelist` VALUES ('30601', '统计6', null, '306');
INSERT INTO `privilegelist` VALUES ('40101', '新增供应商', null, '401');
INSERT INTO `privilegelist` VALUES ('40102', '修改供应商', null, '401');
INSERT INTO `privilegelist` VALUES ('40103', '删除供应商', null, '401');
INSERT INTO `privilegelist` VALUES ('40104', '查询供应商', null, '401');
INSERT INTO `privilegelist` VALUES ('40201', '新增产品', null, '402');
INSERT INTO `privilegelist` VALUES ('40202', '修改产品', null, '402');
INSERT INTO `privilegelist` VALUES ('40203', '删除产品', null, '402');
INSERT INTO `privilegelist` VALUES ('40204', '查询产品', null, '402');
INSERT INTO `privilegelist` VALUES ('50101', '新增用户', null, '501');
INSERT INTO `privilegelist` VALUES ('50102', '修改用户', null, '501');
INSERT INTO `privilegelist` VALUES ('50103', '删除用户', null, '501');
INSERT INTO `privilegelist` VALUES ('50104', '查询用户', null, '501');
INSERT INTO `privilegelist` VALUES ('50201', '新增角色', null, '502');
INSERT INTO `privilegelist` VALUES ('50202', '修改角色', null, '502');
INSERT INTO `privilegelist` VALUES ('50203', '删除角色', null, '502');
INSERT INTO `privilegelist` VALUES ('50204', '查询角色', null, '502');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `PRODID` int(11) NOT NULL,
  `PRODNAME` varchar(50) NOT NULL,
  `PRODCOUNT` double NOT NULL,
  `PROVID` int(11) NOT NULL,
  PRIMARY KEY (`PRODID`) USING BTREE,
  KEY `PROVID` (`PROVID`) USING BTREE,
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`PROVID`) REFERENCES `provider` (`PROVID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=8192;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '电脑', '10000', '1');
INSERT INTO `product` VALUES ('2', '显示器', '2000', '2');
INSERT INTO `product` VALUES ('3', '变速器', '156', '3');

-- ----------------------------
-- Table structure for provider
-- ----------------------------
DROP TABLE IF EXISTS `provider`;
CREATE TABLE `provider` (
  `PROVID` int(11) NOT NULL AUTO_INCREMENT,
  `PROVNAME` varchar(50) NOT NULL,
  `ADDRESS` varchar(50) NOT NULL,
  `PHONE` varchar(20) NOT NULL,
  PRIMARY KEY (`PROVID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=8192;

-- ----------------------------
-- Records of provider
-- ----------------------------
INSERT INTO `provider` VALUES ('1', '深圳电脑批发厂', '深圳市66', '15077788910');
INSERT INTO `provider` VALUES ('2', '广州电脑生产商', '广州市', '13677778888');
INSERT INTO `provider` VALUES ('3', '拉拉阿拉蕾', '来来来', '1578');
INSERT INTO `provider` VALUES ('4', '丽丽', '按时', '159');

-- ----------------------------
-- Table structure for repair
-- ----------------------------
DROP TABLE IF EXISTS `repair`;
CREATE TABLE `repair` (
  `REPAIRID` int(11) NOT NULL,
  `RCOUNT` double NOT NULL,
  `RTIME` datetime NOT NULL,
  `DEPARTID` int(11) NOT NULL,
  `BID` int(11) NOT NULL,
  PRIMARY KEY (`REPAIRID`) USING BTREE,
  KEY `BID` (`BID`) USING BTREE,
  KEY `DEPARTID` (`DEPARTID`) USING BTREE,
  CONSTRAINT `repair_ibfk_1` FOREIGN KEY (`BID`) REFERENCES `balance` (`BID`),
  CONSTRAINT `repair_ibfk_2` FOREIGN KEY (`DEPARTID`) REFERENCES `department` (`DEPARTID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=8192;

-- ----------------------------
-- Records of repair
-- ----------------------------
INSERT INTO `repair` VALUES ('1', '10', '2016-12-02 00:00:00', '2', '1');
INSERT INTO `repair` VALUES ('2', '5', '2016-11-30 00:00:00', '1', '2');

-- ----------------------------
-- Table structure for rolelist
-- ----------------------------
DROP TABLE IF EXISTS `rolelist`;
CREATE TABLE `rolelist` (
  `RID` int(11) NOT NULL,
  `RNAME` varchar(50) NOT NULL,
  PRIMARY KEY (`RID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=5461;

-- ----------------------------
-- Records of rolelist
-- ----------------------------
INSERT INTO `rolelist` VALUES ('1', '系统管理员');
INSERT INTO `rolelist` VALUES ('2', '资产管理员');
INSERT INTO `rolelist` VALUES ('3', '普通员工');

-- ----------------------------
-- Table structure for roleprivilege
-- ----------------------------
DROP TABLE IF EXISTS `roleprivilege`;
CREATE TABLE `roleprivilege` (
  `RPID` int(11) NOT NULL,
  `RID` int(11) NOT NULL,
  `PID` int(11) NOT NULL,
  PRIMARY KEY (`RPID`) USING BTREE,
  KEY `PID` (`PID`) USING BTREE,
  KEY `RID` (`RID`) USING BTREE,
  CONSTRAINT `roleprivilege_ibfk_1` FOREIGN KEY (`PID`) REFERENCES `privilegelist` (`PID`),
  CONSTRAINT `roleprivilege_ibfk_2` FOREIGN KEY (`RID`) REFERENCES `rolelist` (`RID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=120;

-- ----------------------------
-- Records of roleprivilege
-- ----------------------------
INSERT INTO `roleprivilege` VALUES ('241', '1', '1');
INSERT INTO `roleprivilege` VALUES ('242', '1', '2');
INSERT INTO `roleprivilege` VALUES ('243', '1', '3');
INSERT INTO `roleprivilege` VALUES ('244', '1', '4');
INSERT INTO `roleprivilege` VALUES ('245', '1', '5');
INSERT INTO `roleprivilege` VALUES ('246', '1', '101');
INSERT INTO `roleprivilege` VALUES ('247', '1', '102');
INSERT INTO `roleprivilege` VALUES ('248', '1', '103');
INSERT INTO `roleprivilege` VALUES ('249', '1', '104');
INSERT INTO `roleprivilege` VALUES ('250', '1', '201');
INSERT INTO `roleprivilege` VALUES ('251', '1', '202');
INSERT INTO `roleprivilege` VALUES ('252', '1', '203');
INSERT INTO `roleprivilege` VALUES ('253', '1', '204');
INSERT INTO `roleprivilege` VALUES ('254', '1', '205');
INSERT INTO `roleprivilege` VALUES ('255', '1', '301');
INSERT INTO `roleprivilege` VALUES ('256', '1', '302');
INSERT INTO `roleprivilege` VALUES ('257', '1', '303');
INSERT INTO `roleprivilege` VALUES ('258', '1', '304');
INSERT INTO `roleprivilege` VALUES ('259', '1', '305');
INSERT INTO `roleprivilege` VALUES ('260', '1', '306');
INSERT INTO `roleprivilege` VALUES ('261', '1', '401');
INSERT INTO `roleprivilege` VALUES ('262', '1', '402');
INSERT INTO `roleprivilege` VALUES ('263', '1', '501');
INSERT INTO `roleprivilege` VALUES ('264', '1', '502');
INSERT INTO `roleprivilege` VALUES ('265', '1', '503');
INSERT INTO `roleprivilege` VALUES ('266', '1', '10101');
INSERT INTO `roleprivilege` VALUES ('267', '1', '10102');
INSERT INTO `roleprivilege` VALUES ('268', '1', '10103');
INSERT INTO `roleprivilege` VALUES ('269', '1', '10104');
INSERT INTO `roleprivilege` VALUES ('270', '1', '10201');
INSERT INTO `roleprivilege` VALUES ('271', '1', '10202');
INSERT INTO `roleprivilege` VALUES ('272', '1', '10203');
INSERT INTO `roleprivilege` VALUES ('273', '1', '10204');
INSERT INTO `roleprivilege` VALUES ('274', '1', '10301');
INSERT INTO `roleprivilege` VALUES ('275', '1', '10401');
INSERT INTO `roleprivilege` VALUES ('276', '1', '10402');
INSERT INTO `roleprivilege` VALUES ('277', '1', '10403');
INSERT INTO `roleprivilege` VALUES ('278', '1', '10404');
INSERT INTO `roleprivilege` VALUES ('279', '1', '20101');
INSERT INTO `roleprivilege` VALUES ('280', '1', '20102');
INSERT INTO `roleprivilege` VALUES ('281', '1', '20103');
INSERT INTO `roleprivilege` VALUES ('282', '1', '20104');
INSERT INTO `roleprivilege` VALUES ('283', '1', '20201');
INSERT INTO `roleprivilege` VALUES ('284', '1', '20202');
INSERT INTO `roleprivilege` VALUES ('285', '1', '20203');
INSERT INTO `roleprivilege` VALUES ('286', '1', '20204');
INSERT INTO `roleprivilege` VALUES ('287', '1', '20301');
INSERT INTO `roleprivilege` VALUES ('288', '1', '20302');
INSERT INTO `roleprivilege` VALUES ('289', '1', '20303');
INSERT INTO `roleprivilege` VALUES ('290', '1', '20304');
INSERT INTO `roleprivilege` VALUES ('291', '1', '20401');
INSERT INTO `roleprivilege` VALUES ('292', '1', '20402');
INSERT INTO `roleprivilege` VALUES ('293', '1', '20403');
INSERT INTO `roleprivilege` VALUES ('294', '1', '20404');
INSERT INTO `roleprivilege` VALUES ('295', '1', '20501');
INSERT INTO `roleprivilege` VALUES ('296', '1', '20502');
INSERT INTO `roleprivilege` VALUES ('297', '1', '20503');
INSERT INTO `roleprivilege` VALUES ('298', '1', '20504');
INSERT INTO `roleprivilege` VALUES ('299', '1', '30101');
INSERT INTO `roleprivilege` VALUES ('300', '1', '30201');
INSERT INTO `roleprivilege` VALUES ('301', '1', '30301');
INSERT INTO `roleprivilege` VALUES ('302', '1', '30401');
INSERT INTO `roleprivilege` VALUES ('303', '1', '30501');
INSERT INTO `roleprivilege` VALUES ('304', '1', '30601');
INSERT INTO `roleprivilege` VALUES ('305', '1', '40101');
INSERT INTO `roleprivilege` VALUES ('306', '1', '40102');
INSERT INTO `roleprivilege` VALUES ('307', '1', '40103');
INSERT INTO `roleprivilege` VALUES ('308', '1', '40104');
INSERT INTO `roleprivilege` VALUES ('309', '1', '40201');
INSERT INTO `roleprivilege` VALUES ('310', '1', '40202');
INSERT INTO `roleprivilege` VALUES ('311', '1', '40203');
INSERT INTO `roleprivilege` VALUES ('312', '1', '40204');
INSERT INTO `roleprivilege` VALUES ('313', '1', '50101');
INSERT INTO `roleprivilege` VALUES ('314', '1', '50102');
INSERT INTO `roleprivilege` VALUES ('315', '1', '50103');
INSERT INTO `roleprivilege` VALUES ('316', '1', '50104');
INSERT INTO `roleprivilege` VALUES ('317', '1', '50201');
INSERT INTO `roleprivilege` VALUES ('318', '1', '50202');
INSERT INTO `roleprivilege` VALUES ('319', '1', '50203');
INSERT INTO `roleprivilege` VALUES ('320', '1', '50204');
INSERT INTO `roleprivilege` VALUES ('321', '2', '20101');
INSERT INTO `roleprivilege` VALUES ('322', '2', '20102');
INSERT INTO `roleprivilege` VALUES ('323', '2', '20103');
INSERT INTO `roleprivilege` VALUES ('324', '2', '20104');
INSERT INTO `roleprivilege` VALUES ('325', '2', '20201');
INSERT INTO `roleprivilege` VALUES ('326', '2', '20202');
INSERT INTO `roleprivilege` VALUES ('327', '2', '20203');
INSERT INTO `roleprivilege` VALUES ('328', '2', '20204');
INSERT INTO `roleprivilege` VALUES ('329', '2', '20301');
INSERT INTO `roleprivilege` VALUES ('330', '2', '20302');
INSERT INTO `roleprivilege` VALUES ('331', '2', '20303');
INSERT INTO `roleprivilege` VALUES ('332', '2', '20304');
INSERT INTO `roleprivilege` VALUES ('333', '2', '20401');
INSERT INTO `roleprivilege` VALUES ('334', '2', '20402');
INSERT INTO `roleprivilege` VALUES ('335', '2', '20403');
INSERT INTO `roleprivilege` VALUES ('336', '2', '20404');
INSERT INTO `roleprivilege` VALUES ('337', '2', '20501');
INSERT INTO `roleprivilege` VALUES ('338', '2', '20502');
INSERT INTO `roleprivilege` VALUES ('339', '2', '20503');
INSERT INTO `roleprivilege` VALUES ('340', '2', '20504');
INSERT INTO `roleprivilege` VALUES ('341', '2', '30101');
INSERT INTO `roleprivilege` VALUES ('342', '2', '30201');
INSERT INTO `roleprivilege` VALUES ('343', '2', '30301');
INSERT INTO `roleprivilege` VALUES ('344', '2', '30401');
INSERT INTO `roleprivilege` VALUES ('345', '2', '30501');
INSERT INTO `roleprivilege` VALUES ('346', '2', '30601');
INSERT INTO `roleprivilege` VALUES ('347', '2', '40101');
INSERT INTO `roleprivilege` VALUES ('348', '2', '40102');
INSERT INTO `roleprivilege` VALUES ('349', '2', '40103');
INSERT INTO `roleprivilege` VALUES ('350', '2', '40104');
INSERT INTO `roleprivilege` VALUES ('351', '2', '40201');
INSERT INTO `roleprivilege` VALUES ('352', '2', '40202');
INSERT INTO `roleprivilege` VALUES ('353', '2', '40203');
INSERT INTO `roleprivilege` VALUES ('354', '2', '40204');
INSERT INTO `roleprivilege` VALUES ('355', '2', '1');
INSERT INTO `roleprivilege` VALUES ('356', '2', '201');
INSERT INTO `roleprivilege` VALUES ('357', '2', '202');
INSERT INTO `roleprivilege` VALUES ('358', '2', '203');
INSERT INTO `roleprivilege` VALUES ('359', '2', '204');
INSERT INTO `roleprivilege` VALUES ('360', '2', '205');
INSERT INTO `roleprivilege` VALUES ('361', '2', '301');
INSERT INTO `roleprivilege` VALUES ('362', '2', '302');
INSERT INTO `roleprivilege` VALUES ('363', '2', '303');
INSERT INTO `roleprivilege` VALUES ('364', '2', '304');
INSERT INTO `roleprivilege` VALUES ('365', '2', '305');
INSERT INTO `roleprivilege` VALUES ('366', '2', '306');
INSERT INTO `roleprivilege` VALUES ('367', '2', '401');
INSERT INTO `roleprivilege` VALUES ('368', '2', '402');
INSERT INTO `roleprivilege` VALUES ('369', '3', '2');
INSERT INTO `roleprivilege` VALUES ('370', '3', '20104');
INSERT INTO `roleprivilege` VALUES ('371', '3', '20204');
INSERT INTO `roleprivilege` VALUES ('372', '3', '20304');
INSERT INTO `roleprivilege` VALUES ('373', '3', '20404');
INSERT INTO `roleprivilege` VALUES ('374', '3', '20504');
INSERT INTO `roleprivilege` VALUES ('375', '3', '40104');
INSERT INTO `roleprivilege` VALUES ('376', '3', '40204');

-- ----------------------------
-- Table structure for scrap
-- ----------------------------
DROP TABLE IF EXISTS `scrap`;
CREATE TABLE `scrap` (
  `SID` int(11) NOT NULL,
  `SCOUNT` double NOT NULL,
  `STIME` datetime NOT NULL,
  `BID` int(11) NOT NULL,
  `DEPARTID` int(11) NOT NULL,
  PRIMARY KEY (`SID`) USING BTREE,
  KEY `BID` (`BID`) USING BTREE,
  KEY `DEPARTID` (`DEPARTID`) USING BTREE,
  CONSTRAINT `scrap_ibfk_1` FOREIGN KEY (`BID`) REFERENCES `balance` (`BID`),
  CONSTRAINT `scrap_ibfk_2` FOREIGN KEY (`DEPARTID`) REFERENCES `department` (`DEPARTID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=8192;

-- ----------------------------
-- Records of scrap
-- ----------------------------
INSERT INTO `scrap` VALUES ('1', '10', '2017-01-03 00:00:00', '1', '1');
INSERT INTO `scrap` VALUES ('2', '10', '2017-01-02 00:00:00', '2', '1');

-- ----------------------------
-- Table structure for translate
-- ----------------------------
DROP TABLE IF EXISTS `translate`;
CREATE TABLE `translate` (
  `TID` int(11) NOT NULL,
  `TCOUNT` double NOT NULL,
  `TRTIME` datetime NOT NULL,
  `BID` int(11) NOT NULL,
  `DEPARTID` int(11) NOT NULL,
  PRIMARY KEY (`TID`) USING BTREE,
  KEY `BID` (`BID`) USING BTREE,
  KEY `DEPARTID` (`DEPARTID`) USING BTREE,
  CONSTRAINT `translate_ibfk_1` FOREIGN KEY (`BID`) REFERENCES `balance` (`BID`),
  CONSTRAINT `translate_ibfk_2` FOREIGN KEY (`DEPARTID`) REFERENCES `department` (`DEPARTID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=8192;

-- ----------------------------
-- Records of translate
-- ----------------------------
INSERT INTO `translate` VALUES ('1', '20', '2017-01-02 00:00:00', '1', '3');
INSERT INTO `translate` VALUES ('2', '10', '2016-11-23 00:00:00', '1', '2');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(20) DEFAULT NULL,
  `USER_AGE` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=16384;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('2', '李四', '22');

-- ----------------------------
-- Table structure for useraccount
-- ----------------------------
DROP TABLE IF EXISTS `useraccount`;
CREATE TABLE `useraccount` (
  `USERID` int(11) NOT NULL,
  `USERNAME` varchar(20) NOT NULL,
  `ACCOUNTS` varchar(20) NOT NULL,
  `PASSWORD` varchar(32) NOT NULL,
  `SEX` varchar(20) NOT NULL,
  `AGE` datetime NOT NULL,
  `PHONE` varchar(20) NOT NULL,
  `RAGEDATE` datetime NOT NULL,
  `RID` int(11) NOT NULL,
  `DEPARTID` int(11) NOT NULL,
  PRIMARY KEY (`USERID`) USING BTREE,
  KEY `DEPARTID` (`DEPARTID`) USING BTREE,
  KEY `RID` (`RID`) USING BTREE,
  CONSTRAINT `useraccount_ibfk_1` FOREIGN KEY (`DEPARTID`) REFERENCES `department` (`DEPARTID`),
  CONSTRAINT `useraccount_ibfk_2` FOREIGN KEY (`RID`) REFERENCES `rolelist` (`RID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=5461;

-- ----------------------------
-- Records of useraccount
-- ----------------------------
INSERT INTO `useraccount` VALUES ('1', '张明', 'zhangming01', '123', '男', '1985-01-01 00:00:00', '13878009999', '2013-06-01 00:00:00', '3', '1');
INSERT INTO `useraccount` VALUES ('2', 'admin', '李华', '456', '男', '1985-07-10 00:00:00', '15077730988', '2013-05-01 00:00:00', '2', '1');
INSERT INTO `useraccount` VALUES ('3', '超级管理员', 'admin', 'admin', '男', '1975-07-09 00:00:00', '13878008888', '2010-01-20 00:00:00', '1', '1');

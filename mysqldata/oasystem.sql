/*
Navicat MySQL Data Transfer

Source Server         : OASystem
Source Server Version : 50710
Source Host           : 192.168.0.180:3306
Source Database       : oasystem

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2019-04-15 09:55:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '书籍编id',
  `name` varchar(30) DEFAULT NULL COMMENT '书籍名称',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES ('1', '玉女心经', '林朝英著');
INSERT INTO `books` VALUES ('2', '西游记', '你');
INSERT INTO `books` VALUES ('3', '红楼梦', '我写的');
INSERT INTO `books` VALUES ('5', 'asd', null);
INSERT INTO `books` VALUES ('6', 'a', '哦');
INSERT INTO `books` VALUES ('8', '三国演义', '我写的');

-- ----------------------------
-- Table structure for booksapply
-- ----------------------------
DROP TABLE IF EXISTS `booksapply`;
CREATE TABLE `booksapply` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '图书借阅申请id',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `borrowDate` date DEFAULT NULL COMMENT '借阅时间',
  `booksName` varchar(50) DEFAULT NULL COMMENT '书籍名称',
  `approver` varchar(50) DEFAULT NULL COMMENT '审核人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of booksapply
-- ----------------------------
INSERT INTO `booksapply` VALUES ('1', '李莫愁', '2019-04-13', '玉女心经', '小龙女');
INSERT INTO `booksapply` VALUES ('2', 'a', '2019-01-16', 'a', 'admin');

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '车辆id',
  `plateNumber` varchar(10) DEFAULT NULL COMMENT '车牌号',
  `type` int(10) NOT NULL COMMENT '0 货车 1 大巴 2 商务车',
  `remark` varchar(10) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES ('1', '京A00001', '1', 'sdasd');
INSERT INTO `car` VALUES ('2', '京A00002', '3', '狂野');
INSERT INTO `car` VALUES ('4', '黑A1231231', '3', '彪悍');

-- ----------------------------
-- Table structure for carapply
-- ----------------------------
DROP TABLE IF EXISTS `carapply`;
CREATE TABLE `carapply` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '车辆申请id',
  `driver` varchar(50) DEFAULT NULL COMMENT '司机',
  `userName` varchar(50) DEFAULT NULL COMMENT '用车人',
  `companyer` varchar(50) DEFAULT NULL COMMENT '随行人员',
  `dept` varchar(50) DEFAULT NULL COMMENT '用车部门',
  `startDay` date DEFAULT NULL COMMENT '开始日期',
  `endDay` date DEFAULT NULL COMMENT '归还时间',
  `destination` varchar(50) DEFAULT NULL COMMENT '目的地',
  `mileage` double(20,0) DEFAULT NULL COMMENT '申请里程',
  `reason` varchar(50) DEFAULT NULL COMMENT '用车事由',
  `status` int(20) DEFAULT '0' COMMENT '0未审核1已审核3驳回',
  `approver` varchar(50) DEFAULT NULL COMMENT '审核人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of carapply
-- ----------------------------
INSERT INTO `carapply` VALUES ('1', 'sd', 'sadad', 'ds', 'wwer', '2019-04-13', '2019-04-16', 'adds', '232', 'sdfdsa', '0', 'asdf');
INSERT INTO `carapply` VALUES ('2', 'a', 'a', 'a', '10', '2019-04-25', '2019-04-19', 'a', '1', 'asd', '1', 'ad');
INSERT INTO `carapply` VALUES ('3', 's', 's', 's', 's', '2019-04-09', '2019-04-30', 'sas', '11', 'sas', '2', 's');
INSERT INTO `carapply` VALUES ('4', 'A', 'A', 'a', '21', '2019-04-25', '2019-04-17', 'afa', '21231', 'afafa', '2', 'admin');
INSERT INTO `carapply` VALUES ('5', '1', '1', '1', '1', '2019-05-07', '2019-05-09', '1', '1', '', '0', 'admin');

-- ----------------------------
-- Table structure for card
-- ----------------------------
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '名片id',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `job` varchar(50) DEFAULT NULL COMMENT '职位',
  `mb` varchar(50) DEFAULT NULL COMMENT '手机号码',
  `tel` varchar(50) DEFAULT NULL COMMENT '电话号码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of card
-- ----------------------------
INSERT INTO `card` VALUES ('1', '老王', '攻程狮', '123', '321');
INSERT INTO `card` VALUES ('3', '阿斯顿', '我去额', '12321421', '435346456');
INSERT INTO `card` VALUES ('4', '我', '我', '123', '12314');
INSERT INTO `card` VALUES ('6', '你', '他', '123', '12314');

-- ----------------------------
-- Table structure for cardapply
-- ----------------------------
DROP TABLE IF EXISTS `cardapply`;
CREATE TABLE `cardapply` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '申请名片的id',
  `applyDate` date DEFAULT NULL COMMENT '申请时间',
  `name` varchar(50) DEFAULT NULL COMMENT '申请人姓名',
  `dept` varchar(50) DEFAULT NULL COMMENT '部门',
  `job` varchar(50) DEFAULT NULL COMMENT '职位',
  `mb` varchar(50) DEFAULT NULL COMMENT '手机号码',
  `tel` varchar(50) DEFAULT NULL COMMENT '电话号码',
  `cardNumber` int(20) DEFAULT NULL COMMENT '名片数量(盒)',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  `status` int(10) NOT NULL COMMENT '0未审核1已审核3驳回',
  `approver` varchar(50) DEFAULT NULL COMMENT '审核人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cardapply
-- ----------------------------
INSERT INTO `cardapply` VALUES ('1', '2019-04-08', '老李', '测试', '所长', '1234123', '2434231', '12', '不要马虎', '0', '老王');
INSERT INTO `cardapply` VALUES ('2', '2019-01-10', 'asd', 'sd', 'das', '212', '33', '12', 'df', '1', 'df');
INSERT INTO `cardapply` VALUES ('3', '2019-01-11', '集合', 'sad', '玩儿', '123', '312', '12', '阿诗丹顿所', '2', '水电费费');
INSERT INTO `cardapply` VALUES ('4', '2019-01-20', '打', '萨德', '萨德', '123', '123', '123', '地方 ', '2', '玩儿v');
INSERT INTO `cardapply` VALUES ('6', '2019-01-02', '威尔而', '尔特', '瑞特人', '1241', '34556', '12', '21323', '0', 'admin');
INSERT INTO `cardapply` VALUES ('7', '2019-01-03', '水电费s', '双方都', '士大夫', '213', '234', '23', '阿斯顿', '1', 'admin');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `name` varchar(20) DEFAULT NULL COMMENT '部门名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '人事');
INSERT INTO `department` VALUES ('2', '销售');
INSERT INTO `department` VALUES ('3', '研发');

-- ----------------------------
-- Table structure for function
-- ----------------------------
DROP TABLE IF EXISTS `function`;
CREATE TABLE `function` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `name` varchar(255) DEFAULT NULL COMMENT '权限名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of function
-- ----------------------------
INSERT INTO `function` VALUES ('1', '我的桌面,行政管理,人事管理');
INSERT INTO `function` VALUES ('2', '我的桌面,通告管理,行政管理,人事管理');
INSERT INTO `function` VALUES ('3', '我的桌面,文档管理,行政管理,人事管理,系统管理');
INSERT INTO `function` VALUES ('4', '我的桌面,通告管理,文档管理,行政管理,人事管理,系统管理');

-- ----------------------------
-- Table structure for income
-- ----------------------------
DROP TABLE IF EXISTS `income`;
CREATE TABLE `income` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '收入证明Id',
  `name` varchar(20) DEFAULT NULL COMMENT '收入人员姓名',
  `applyDay` date DEFAULT NULL COMMENT '申请日期',
  `dept` varchar(100) DEFAULT NULL COMMENT '部门',
  `job` varchar(101) DEFAULT NULL COMMENT '岗位',
  `status` int(10) NOT NULL COMMENT '0未审批1已审批2驳回',
  `applicationReason` varchar(201) DEFAULT NULL COMMENT '申请原因',
  `approver` varchar(151) DEFAULT NULL COMMENT '审批人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of income
-- ----------------------------
INSERT INTO `income` VALUES ('1', '张三', '2019-04-02', '1', '1', '1', '1', '1');
INSERT INTO `income` VALUES ('5', '周杰伦', '2019-04-03', '音乐部', null, '0', '233', 'admin');
INSERT INTO `income` VALUES ('6', '刘德华', '2019-04-02', '演员', '演员', '0', '222', 'admin');

-- ----------------------------
-- Table structure for inform
-- ----------------------------
DROP TABLE IF EXISTS `inform`;
CREATE TABLE `inform` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '通告id',
  `title` varchar(10) DEFAULT NULL COMMENT '标题',
  `content` varchar(30) DEFAULT NULL COMMENT '通告内容',
  `startDay` date DEFAULT NULL COMMENT '显示开始时间',
  `endDay` date DEFAULT NULL COMMENT '显示结束时间',
  `publishDay` date DEFAULT NULL COMMENT '发布时间',
  `type` int(10) DEFAULT NULL COMMENT '0 紧急 1 一般',
  `publisher` varchar(10) DEFAULT NULL COMMENT '发布人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of inform
-- ----------------------------
INSERT INTO `inform` VALUES ('1', '五一放假', '五一放假七天', '2019-05-01', '2019-05-07', '2019-04-14', '0', 'admin');
INSERT INTO `inform` VALUES ('2', '发奖金', '五一放假回来发奖金', '2019-04-09', '2019-04-09', '2019-04-14', '1', 'admin');
INSERT INTO `inform` VALUES ('3', '1', '2', '2019-04-18', '2019-04-30', '2019-04-24', '2', '2');

-- ----------------------------
-- Table structure for job
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '职称id',
  `name` varchar(20) DEFAULT NULL COMMENT '职称名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of job
-- ----------------------------

-- ----------------------------
-- Table structure for label
-- ----------------------------
DROP TABLE IF EXISTS `label`;
CREATE TABLE `label` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标签id',
  `name` varchar(100) DEFAULT NULL COMMENT '标签名字',
  `time` date DEFAULT NULL COMMENT '时间',
  `content` varchar(255) DEFAULT NULL COMMENT '标签内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of label
-- ----------------------------
INSERT INTO `label` VALUES ('1', '吃烧烤', '2019-04-14', '要去野外吃烧烤');
INSERT INTO `label` VALUES ('2', '吃海鲜', '2019-04-15', '学好了  吃海鲜大餐');
INSERT INTO `label` VALUES ('3', '太胖了,去运动', '2019-04-30', '最近吃的有点多 ,想去运动运动');
INSERT INTO `label` VALUES ('4', '继续运动', '2019-05-01', '继续运动 , 誓要和肥肉拼死相争');

-- ----------------------------
-- Table structure for leaves
-- ----------------------------
DROP TABLE IF EXISTS `leaves`;
CREATE TABLE `leaves` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '请假的编号',
  `name` varchar(15) DEFAULT NULL COMMENT '请假人的姓名',
  `dept` varchar(15) DEFAULT NULL COMMENT '所属部门',
  `startdate` date DEFAULT NULL COMMENT '开始时间',
  `enddate` date DEFAULT NULL COMMENT '结束时间',
  `leaveNumber` int(10) DEFAULT NULL COMMENT '请假天数',
  `type` int(10) DEFAULT NULL COMMENT '1.病假、\r\n2.事假、\r\n3.婚假、\r\n4.丧假、\r\n5.产假、\r\n6.工伤假、\r\n7.父亲假、\r\n8.年假',
  `reason` varchar(15) DEFAULT NULL COMMENT '请假理由',
  `approver` varchar(15) DEFAULT NULL COMMENT '审核人',
  `status` int(10) DEFAULT NULL COMMENT '0等待,1是同意,2是驳回',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of leaves
-- ----------------------------
INSERT INTO `leaves` VALUES ('1', 'as', '10', '2019-04-12', '2019-04-17', '2', '1', '出差', 'admin', '1');
INSERT INTO `leaves` VALUES ('2', '阿斯顿', '阿斯顿', '2019-04-25', '2019-04-19', '2', '2', '2', '222', '0');
INSERT INTO `leaves` VALUES ('3', '周润发', '歌手', '2019-04-16', '2019-04-17', null, '1', '演出', 'admin', '1');
INSERT INTO `leaves` VALUES ('4', '大S', '歌手', '2019-04-16', '2019-04-17', null, '2', '演出', 'admin', '0');
INSERT INTO `leaves` VALUES ('5', 'w', 'w', '2019-04-10', '2019-04-23', null, '2', 'ss', 'admin', '0');

-- ----------------------------
-- Table structure for limits
-- ----------------------------
DROP TABLE IF EXISTS `limits`;
CREATE TABLE `limits` (
  `lid` int(10) NOT NULL COMMENT '和用户关联的主键',
  `realName` varchar(255) DEFAULT NULL COMMENT '用户的名字',
  `cruduser` int(10) DEFAULT NULL COMMENT '操作用户的权限(0是没有权限 ,1是有权限)',
  `updatelimit` int(10) DEFAULT NULL COMMENT '修改用户的使用权限',
  `crudrole` int(10) DEFAULT NULL COMMENT 'crud操作角色的权限',
  KEY `lid` (`lid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of limits
-- ----------------------------
INSERT INTO `limits` VALUES ('1', 'admin', '1', '1', '1');
INSERT INTO `limits` VALUES ('21', 'aaa', '0', '0', '0');
INSERT INTO `limits` VALUES ('25', 'bbb', '1', '0', '0');
INSERT INTO `limits` VALUES ('27', 'ccc', '0', '0', '0');
INSERT INTO `limits` VALUES ('35', 'ddd', '0', '0', '0');
INSERT INTO `limits` VALUES ('37', 'eee', '0', '0', '0');
INSERT INTO `limits` VALUES ('39', 'fff', '0', '0', '0');
INSERT INTO `limits` VALUES ('41', 'ggg', '0', '0', '0');
INSERT INTO `limits` VALUES ('43', 'zzz', '0', '0', '0');
INSERT INTO `limits` VALUES ('45', 'xxx', '0', '0', '0');
INSERT INTO `limits` VALUES ('47', 'vvv', '0', '0', '0');
INSERT INTO `limits` VALUES ('49', 'rrr', '0', '0', '0');

-- ----------------------------
-- Table structure for meetingroom
-- ----------------------------
DROP TABLE IF EXISTS `meetingroom`;
CREATE TABLE `meetingroom` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '会议室id',
  `name` varchar(10) DEFAULT NULL COMMENT '会议室名称',
  `description` varchar(20) DEFAULT NULL COMMENT '会议室描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of meetingroom
-- ----------------------------
INSERT INTO `meetingroom` VALUES ('1', 'A001', '董事长会议室');
INSERT INTO `meetingroom` VALUES ('2', 'A002', '总经理会议室');
INSERT INTO `meetingroom` VALUES ('3', 'A003', '普通员工会议室');
INSERT INTO `meetingroom` VALUES ('4', 'A004', '职工会议室');
INSERT INTO `meetingroom` VALUES ('5', 'A005', 'SHI');

-- ----------------------------
-- Table structure for messages
-- ----------------------------
DROP TABLE IF EXISTS `messages`;
CREATE TABLE `messages` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '留言id',
  `user` varchar(50) DEFAULT NULL COMMENT '留言用户',
  `message` varchar(255) DEFAULT NULL COMMENT '留言',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of messages
-- ----------------------------
INSERT INTO `messages` VALUES ('2', 'admin', '你好啊');
INSERT INTO `messages` VALUES ('3', 'admin', '你猜猜');
INSERT INTO `messages` VALUES ('4', 'admin', '修改显示Bug');
INSERT INTO `messages` VALUES ('5', 'admin', '登录显示bug');

-- ----------------------------
-- Table structure for mtroomapply
-- ----------------------------
DROP TABLE IF EXISTS `mtroomapply`;
CREATE TABLE `mtroomapply` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '会议室申请表Id',
  `startDay` date DEFAULT NULL COMMENT '预定开始时间',
  `endDay` date DEFAULT NULL COMMENT '预定结束时间',
  `userName` varchar(10) DEFAULT NULL COMMENT '会议室预订人',
  `type` int(10) DEFAULT NULL COMMENT '用途类型 0：周会议  1 面试 2 考试',
  `mtId` int(10) DEFAULT NULL COMMENT '会议室Id',
  `approver` varchar(10) NOT NULL COMMENT '审批人',
  `status` int(5) NOT NULL COMMENT '0未审核1已审核2驳回',
  PRIMARY KEY (`id`),
  KEY `mtId` (`mtId`),
  CONSTRAINT `mtId` FOREIGN KEY (`mtId`) REFERENCES `meetingroom` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mtroomapply
-- ----------------------------
INSERT INTO `mtroomapply` VALUES ('1', '2019-04-17', '2019-04-16', '周润发', '1', '1', 'admin', '1');
INSERT INTO `mtroomapply` VALUES ('2', '2019-04-02', '2019-04-05', '周杰伦', '1', '2', 'admin', '1');
INSERT INTO `mtroomapply` VALUES ('3', '2019-04-16', '2019-04-17', 'ccc', '1', '1', 'admin', '2');
INSERT INTO `mtroomapply` VALUES ('4', '2019-04-16', '2019-04-16', 'w', '2', '1', 'admin', '0');
INSERT INTO `mtroomapply` VALUES ('5', '2019-04-03', '2019-04-16', 'admin', '2', '2', 'admin', '0');
INSERT INTO `mtroomapply` VALUES ('6', '2019-04-16', '2019-04-17', 'admin', '1', '2', 'admin', '0');
INSERT INTO `mtroomapply` VALUES ('7', '2019-04-10', '2019-04-11', 'admin', '1', '2', 'admin', '0');

-- ----------------------------
-- Table structure for operationlog
-- ----------------------------
DROP TABLE IF EXISTS `operationlog`;
CREATE TABLE `operationlog` (
  `id` int(100) NOT NULL AUTO_INCREMENT COMMENT '日志id',
  `operator` varchar(25) DEFAULT NULL COMMENT '操作者',
  `operation` varchar(50) DEFAULT NULL COMMENT '操作事件名称',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  `time` date DEFAULT NULL COMMENT '操作事件的时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of operationlog
-- ----------------------------
INSERT INTO `operationlog` VALUES ('1', '1', '1', '1', '2019-04-12');
INSERT INTO `operationlog` VALUES ('2', 'admin', '添加了fff这个用户', '', '2019-04-12');
INSERT INTO `operationlog` VALUES ('3', 'admin', '添加了fff这个用户', '', '2019-04-12');
INSERT INTO `operationlog` VALUES ('5', 'admin', '删除了一个用户', '', '2019-04-12');
INSERT INTO `operationlog` VALUES ('6', null, '修改了一个用户', '', '2019-04-12');
INSERT INTO `operationlog` VALUES ('7', 'admin', '修改了一个用户', '', '2019-04-12');
INSERT INTO `operationlog` VALUES ('8', null, '添加了一辆车的信息', '', '2019-04-12');
INSERT INTO `operationlog` VALUES ('9', 'admin', '添加了null这个用户', '', '2019-04-13');
INSERT INTO `operationlog` VALUES ('10', 'admin', '添加了null这个用户', '', '2019-04-13');
INSERT INTO `operationlog` VALUES ('11', 'admin', '添加了null这个用户', '', '2019-04-13');
INSERT INTO `operationlog` VALUES ('12', 'admin', '添加了null这个用户', '', '2019-04-13');
INSERT INTO `operationlog` VALUES ('13', 'admin', '添加了null这个用户', '', '2019-04-13');
INSERT INTO `operationlog` VALUES ('14', 'admin', '添加了null这个用户', '', '2019-04-13');
INSERT INTO `operationlog` VALUES ('15', 'admin', '添加了null这个用户', '', '2019-04-13');
INSERT INTO `operationlog` VALUES ('16', 'admin', '添加了null这个用户', '', '2019-04-13');
INSERT INTO `operationlog` VALUES ('17', 'admin', '添加了null这个用户', '', '2019-04-13');
INSERT INTO `operationlog` VALUES ('18', 'admin', '添加了一本你好', '', '2019-04-13');
INSERT INTO `operationlog` VALUES ('19', 'admin', '修改了一本id为2的书', '', '2019-04-13');
INSERT INTO `operationlog` VALUES ('20', 'admin', '添加了null这个用户', '', '2019-04-13');
INSERT INTO `operationlog` VALUES ('21', 'admin', '添加了null这个用户', '', '2019-04-13');
INSERT INTO `operationlog` VALUES ('22', 'admin', '添加了一本集合', '', '2019-04-13');
INSERT INTO `operationlog` VALUES ('23', 'admin', '修改了一本id为2的书', '', '2019-04-13');
INSERT INTO `operationlog` VALUES ('24', 'admin', '添加了一个会议室', '', '2019-04-13');
INSERT INTO `operationlog` VALUES ('25', 'admin', '添加了一个会议室的申请', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('26', 'admin', '添加了一本asd', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('27', 'admin', '添加了一个会议室的申请', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('28', 'admin', '添加了一本as', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('29', 'admin', '修改了一条请假申请', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('30', 'admin', '修改了一条请假申请', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('31', 'admin', '添加了一本as', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('32', 'admin', '添加了一本asd', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('33', 'admin', '添加了一本asd', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('34', 'admin', '添加了一本a', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('35', 'admin', '添加了一本你', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('36', 'admin', '修改了一条请假申请', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('37', 'admin', '添加了一本as', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('38', 'admin', '添加了一本阿斯顿', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('39', 'admin', '删除了一本id为7的书', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('40', 'admin', '添加了一本阿斯顿', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('41', 'admin', '添加了一本威尔而', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('42', 'admin', '添加了一条请假申请', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('43', 'admin', '添加了一条请假申请', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('44', 'admin', '添加了一条请假申请', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('45', 'admin', '添加了一条请假申请', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('46', 'admin', '添加了一条请假申请', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('47', 'admin', '添加了一条请假申请', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('48', 'admin', '添加了一条请假申请', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('49', 'admin', '添加了一本三国演义', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('50', 'admin', '添加了一条请假申请', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('51', 'admin', '添加了一条请假申请', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('52', 'admin', '添加了null这个用户', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('53', 'admin', '添加了null这个用户', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('54', 'admin', '添加了一条请假申请', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('55', 'admin', '添加了一条请假申请', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('56', 'admin', '添加了一条出差记录', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('57', 'admin', '添加了一条出差记录', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('58', 'admin', '添加了一条出差记录', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('59', 'admin', '添加了一本水电费s', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('60', 'admin', '添加了一条出差记录', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('61', 'admin', '修改了一条收入记录', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('62', 'admin', '编辑了一条通告信息', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('63', 'admin', '编辑了一条通告信息', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('64', 'admin', '编辑了一条通告信息', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('65', 'admin', '添加了一个收入记录', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('66', 'admin', '添加了一个收入记录', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('67', 'admin', '删除了一条收入记录', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('68', 'admin', '删除了一条出差记录', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('69', 'admin', '添加了一条出差记录', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('70', 'admin', '添加了一辆车的信息', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('71', 'admin', '删除了一辆车的信息', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('72', 'admin', '删除了一条请假申请', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('73', 'admin', '修改了一本id为2的书', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('74', 'admin', '删除了一本id为3的书', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('75', 'admin', '添加了一本私章', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('76', 'admin', '删除了一本id为4的书', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('77', 'admin', '添加了一本三国演义的书', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('78', 'admin', '修改了一本id为6的书', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('79', 'admin', '删除了一本id为4的书', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('80', 'admin', '删除了一本id为3的书', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('81', 'admin', '删除了一张名片', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('82', 'admin', '修改了一张名片', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('83', 'admin', '添加了一条请假申请', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('84', 'admin', '删除了一条请假申请', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('85', 'admin', '添加了一条请假申请', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('86', 'admin', '删除了一条请假申请', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('87', 'admin', '修改了一条请假申请', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('88', 'admin', '修改了一条请假申请', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('89', 'admin', '修改了一条请假申请', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('90', 'admin', '修改了一条请假申请', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('91', 'admin', '修改了一条出差记录', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('92', 'admin', '修改了一条收入记录', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('93', 'admin', '添加了一个收入记录', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('94', 'admin', '删除了一条收入记录', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('95', 'admin', '添加了null这个用户', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('96', 'admin', '添加了一个收入记录', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('97', 'admin', '添加了一个收入记录', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('98', 'admin', '删除了一条收入记录', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('99', 'admin', '添加了一个收入记录', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('100', 'admin', '修改了密码', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('101', 'admin', '修改了密码', '', '2019-04-14');
INSERT INTO `operationlog` VALUES ('102', 'admin', '添加了null这个用户', '', '2019-04-15');
INSERT INTO `operationlog` VALUES ('103', 'admin', '添加了一个会议室的申请', '', '2019-04-15');
INSERT INTO `operationlog` VALUES ('104', 'admin', '添加了一条请假申请', '', '2019-04-15');
INSERT INTO `operationlog` VALUES ('105', 'admin', '添加了一条请假申请', '', '2019-04-15');
INSERT INTO `operationlog` VALUES ('106', 'admin', '修改了一条请假申请', '', '2019-04-15');
INSERT INTO `operationlog` VALUES ('107', 'admin', '添加了null这个用户', '', '2019-04-15');
INSERT INTO `operationlog` VALUES ('108', 'admin', '添加了一条请假申请', '', '2019-04-15');
INSERT INTO `operationlog` VALUES ('109', 'admin', '添加了一个会议室的申请', '', '2019-04-15');
INSERT INTO `operationlog` VALUES ('110', 'admin', '修改了密码', '', '2019-04-15');
INSERT INTO `operationlog` VALUES ('111', 'admin', '修改了一个会议室的申请', '', '2019-04-15');
INSERT INTO `operationlog` VALUES ('112', 'admin', '添加了一个会议室', '', '2019-04-15');
INSERT INTO `operationlog` VALUES ('113', 'admin', '修改了一个会议室', '', '2019-04-15');
INSERT INTO `operationlog` VALUES ('114', 'admin', '删除了一个会议室', '', '2019-04-15');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(20) DEFAULT NULL COMMENT '角色名称',
  `functionId` int(10) DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`),
  KEY `fid` (`functionId`),
  CONSTRAINT `fid` FOREIGN KEY (`functionId`) REFERENCES `function` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '普通用户', '1');
INSERT INTO `role` VALUES ('2', '人事专员', '2');
INSERT INTO `role` VALUES ('3', '领导', '4');
INSERT INTO `role` VALUES ('4', '系统管理员', '3');

-- ----------------------------
-- Table structure for schedule
-- ----------------------------
DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '日程id',
  `user` varchar(20) DEFAULT NULL COMMENT '操作人',
  `time` date DEFAULT NULL COMMENT '记录时间',
  `remark` varchar(20) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of schedule
-- ----------------------------
INSERT INTO `schedule` VALUES ('1', 'admin', '2019-04-16', '烧烤');
INSERT INTO `schedule` VALUES ('2', 'admin', '2019-04-06', '吃西餐');
INSERT INTO `schedule` VALUES ('3', 'admin', '2019-04-04', '吃烤鱼');
INSERT INTO `schedule` VALUES ('4', 'leader', '2019-04-13', '吃大餐');
INSERT INTO `schedule` VALUES ('5', 'leader', '2019-04-17', '吃烧烤');
INSERT INTO `schedule` VALUES ('6', 'admin', '2019-04-23', 'hhhh');
INSERT INTO `schedule` VALUES ('7', 'admin', '2019-04-23', 'aaaa');
INSERT INTO `schedule` VALUES ('8', 'admin', '2019-04-01', 'AAA');
INSERT INTO `schedule` VALUES ('9', 'admin', '2019-04-05', 'wwww');
INSERT INTO `schedule` VALUES ('10', 'admin', '2019-04-15', '我');
INSERT INTO `schedule` VALUES ('11', 'admin', '2019-04-17', '面试');
INSERT INTO `schedule` VALUES ('12', 'admin', '2019-04-03', '考试');
INSERT INTO `schedule` VALUES ('13', 'admin', '2019-04-15', '今天演讲项目');
INSERT INTO `schedule` VALUES ('14', 'admin', '2019-04-18', '演讲项目');

-- ----------------------------
-- Table structure for seal
-- ----------------------------
DROP TABLE IF EXISTS `seal`;
CREATE TABLE `seal` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '印章Id',
  `name` varchar(15) DEFAULT NULL COMMENT '印章名称',
  `remark` varchar(20) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of seal
-- ----------------------------
INSERT INTO `seal` VALUES ('1', '公司章', 'sd');
INSERT INTO `seal` VALUES ('2', '人事章', '专业');
INSERT INTO `seal` VALUES ('4', '财务章', '私用');

-- ----------------------------
-- Table structure for sealapply
-- ----------------------------
DROP TABLE IF EXISTS `sealapply`;
CREATE TABLE `sealapply` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '印章申请表id',
  `applyer` varchar(10) DEFAULT NULL COMMENT '申请人姓名',
  `applyDay` date DEFAULT NULL COMMENT '申请时间',
  `dept` varchar(15) DEFAULT NULL COMMENT '申请部门',
  `reason` varchar(30) DEFAULT NULL COMMENT '申请事由',
  `approver` varchar(10) DEFAULT NULL COMMENT '审批人',
  `status` int(5) DEFAULT '0' COMMENT '0未审批1已审批2驳回',
  `sealId` int(10) DEFAULT NULL COMMENT '用章类型 \r\n1.公章\r\n2.财务章\r\n3.法人章\r\n4.合同专用章\r\n5.发票专用章',
  PRIMARY KEY (`id`),
  KEY `sealId` (`sealId`),
  CONSTRAINT `sealId` FOREIGN KEY (`sealId`) REFERENCES `seal` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sealapply
-- ----------------------------
INSERT INTO `sealapply` VALUES ('1', 'sd', '2019-05-01', 'sd', 'sd', 'asd', '1', '1');
INSERT INTO `sealapply` VALUES ('2', 'sd', '2018-12-30', '人事', '速度', '速度', '1', '2');
INSERT INTO `sealapply` VALUES ('3', '阿斯顿', '2018-12-30', '人事', '你猜', 'admin', '2', '2');
INSERT INTO `sealapply` VALUES ('4', 'as', '2018-12-30', '对方水电费', '是', '是', '2', '1');

-- ----------------------------
-- Table structure for trip
-- ----------------------------
DROP TABLE IF EXISTS `trip`;
CREATE TABLE `trip` (
  `id` int(100) NOT NULL AUTO_INCREMENT COMMENT '出差管理id',
  `name` varchar(100) DEFAULT NULL COMMENT '出差人姓名',
  `dept` varchar(100) DEFAULT NULL COMMENT '所属部门',
  `stardate` date DEFAULT NULL COMMENT '开始出差的日期',
  `enddate` date DEFAULT NULL COMMENT '结束出差的日期',
  `place` varchar(100) DEFAULT NULL COMMENT '出差地址',
  `loanAmount` double(100,2) unsigned DEFAULT NULL COMMENT '借款金额',
  `tripReason` varchar(100) DEFAULT NULL COMMENT '出差理由',
  `task` varchar(100) DEFAULT NULL COMMENT '工作任务',
  `approver` varchar(100) DEFAULT NULL COMMENT '审核人',
  `status` int(10) NOT NULL COMMENT '0未审批1已审批2驳回',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of trip
-- ----------------------------
INSERT INTO `trip` VALUES ('1', 'asd', 'asd', '2019-02-20', '2019-05-20', 'ad', '1231.20', 'fa1', 'ad', 'admin', '0');
INSERT INTO `trip` VALUES ('3', '你', '我', '2019-04-03', '2019-04-09', '1', '1.00', '1', '1', '1', '1');
INSERT INTO `trip` VALUES ('4', '1', '1', '2019-04-03', '2019-04-24', '1', '12.00', '阿斯顿', '是', 'admin', '2');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `loginName` varchar(10) DEFAULT NULL COMMENT '登录名称',
  `password` varchar(20) DEFAULT NULL COMMENT '登录密码',
  `realName` varchar(10) DEFAULT NULL COMMENT '真实姓名',
  `sex` int(10) DEFAULT NULL COMMENT '0 代表男  1代表女',
  `roleId` int(10) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', 'admin', '1', '4');
INSERT INTO `user` VALUES ('21', 'resourcer', 'resourcer', 'resourcer', '0', '2');
INSERT INTO `user` VALUES ('25', 'leader', 'leader', 'leader', '1', '3');
INSERT INTO `user` VALUES ('27', 'user', 'user', 'user', '0', '1');
INSERT INTO `user` VALUES ('35', 'ddd', 'ddd', 'ddd', '1', '1');
INSERT INTO `user` VALUES ('37', 'eee', 'eee', 'eee', '0', '1');
INSERT INTO `user` VALUES ('39', 'fff', 'fff', 'fff', '1', '1');
INSERT INTO `user` VALUES ('41', 'ggg', 'ggg', 'ggg', '0', '1');
INSERT INTO `user` VALUES ('43', 'zzz', 'zzz', 'zzz', '0', '1');
INSERT INTO `user` VALUES ('45', 'xxx', 'xxx', 'xxx', '1', '1');
INSERT INTO `user` VALUES ('47', 'vvv', 'vvv', 'vvv', '0', '1');
INSERT INTO `user` VALUES ('49', 'fffqq', 'rrr', 'fffqq', '0', '1');

-- ----------------------------
-- Table structure for webaddress
-- ----------------------------
DROP TABLE IF EXISTS `webaddress`;
CREATE TABLE `webaddress` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '网址id',
  `name` varchar(25) DEFAULT NULL COMMENT '网址名称',
  `webaddress` varchar(25) DEFAULT NULL COMMENT '网址地址',
  `user` varchar(50) DEFAULT NULL COMMENT '用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of webaddress
-- ----------------------------
INSERT INTO `webaddress` VALUES ('1', '百度', 'https://www.baidu.com', 'admin');
INSERT INTO `webaddress` VALUES ('2', '淘宝', 'https://taobao.com', 'admin');
INSERT INTO `webaddress` VALUES ('5', '京东', 'https://www.jd.com', 'admin');
INSERT INTO `webaddress` VALUES ('6', '天猫', 'https://www.tmall.com', 'admin');

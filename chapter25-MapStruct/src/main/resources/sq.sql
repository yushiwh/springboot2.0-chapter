--商品类型信息表
CREATE TABLE `good_types` (
  `tgt_id` int(11) NOT NULL AUTO_INCREMENT,
  `tgt_name` varchar(30) DEFAULT NULL,
  `tgt_is_show` int(1) DEFAULT NULL,
  `tgt_order` int(255) DEFAULT NULL,
  PRIMARY KEY (`tgt_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--商品基本信息表
CREATE TABLE `good_infos` (
  `tg_id` int(11) NOT NULL AUTO_INCREMENT,
  `tg_type_id` int(11) DEFAULT NULL,
  `tg_title` varchar(30) DEFAULT NULL,
  `tg_price` decimal(8,2) DEFAULT NULL,
  `tg_order` int(2) DEFAULT NULL,
  PRIMARY KEY (`tg_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO `good_types` VALUES ('1', '青菜', '1', '1');
INSERT INTO `good_infos` VALUES ('1', '1', '芹菜', '12.40', '1');

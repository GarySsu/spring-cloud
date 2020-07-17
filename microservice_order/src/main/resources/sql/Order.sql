CREATE TABLE `order_master` (
  `order_id` int(10) NOT NULL AUTO_INCREMENT,
  `order_num` varchar(50) ,
  `game` varchar(10) ,
  `device` varchar(200) DEFAULT NULL,
  `user_id` int(10) NOT NULL
  PRIMARY KEY (`order_id`),
  FOREIGN KEY (user_id) REFERENCES `sys_user`(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `order_detail` (
  `order_detail_id` int(10) NOT NULL AUTO_INCREMENT,
  `order_id` int(10) NOT NULL ,
  `weapon` varchar(50) ,
  `amount` int(10) ,
  `status` int(1),
  PRIMARY KEY (`order_detail_id`),
  FOREIGN KEY (order_detail_id) REFERENCES `order_master`(order_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sys_user` (
  `id` int(10) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  `lastLoginTime` date DEFAULT NULL,
  `enabled` int(5) DEFAULT NULL,
  `accountNonExpired` int(5) DEFAULT NULL,
  `accountNonLocked` int(5) DEFAULT NULL,
  `credentialsNonExpired` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

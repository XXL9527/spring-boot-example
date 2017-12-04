DROP TABLE IF EXISTS `m_user`;

CREATE TABLE `m_user` (

  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ユーザID',

  `user_name` varchar(32) DEFAULT NULL COMMENT 'ユーザ名',

  `passwd` varchar(32) DEFAULT NULL COMMENT 'パスワード',

  `role` varchar(6) DEFAULT NULL COMMENT '権限',

  PRIMARY KEY (`user_id`),
  
  UNIQUE INDEX `UNIQUE_user_name` (`user_name` ASC)

) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;

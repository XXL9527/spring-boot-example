DROP TABLE IF EXISTS `m_user`;

CREATE TABLE `m_user` (

  `user_id` varchar(32) NOT NULL COMMENT 'ユーザID',
  
  `user_name` varchar(32) DEFAULT NULL COMMENT 'ユーザ名',

  `passwd` varchar(32) DEFAULT NULL COMMENT 'パスワード',

  `role` varchar(6) DEFAULT NULL COMMENT '権限',

  PRIMARY KEY (`user_id`),
  
  UNIQUE INDEX `UNIQUE_user_id` (`user_id` ASC)

) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;

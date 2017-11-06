DROP TABLE IF EXISTS `m_user`;

CREATE TABLE `m_user` (

  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ユーザID',

  `user_name` varchar(32) DEFAULT NULL COMMENT 'ユーザ名',

  `passwd` varchar(32) DEFAULT NULL COMMENT 'パスワード',

  `user_sex` varchar(6) DEFAULT NULL COMMENT '性別',

  `nick_name` varchar(32) DEFAULT NULL COMMENT 'ニックネーム',

  PRIMARY KEY (`user_id`)

) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;

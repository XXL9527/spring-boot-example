DROP TABLE IF EXISTS `m_user`;

CREATE TABLE `m_user` (

  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ユーザID',

  `user_name` varchar(32) DEFAULT NULL COMMENT 'ユーザ名',

  `passwd` varchar(32) DEFAULT NULL COMMENT 'パスワード',

  `user_sex` varchar(6) DEFAULT NULL COMMENT '性別',

  `nick_name` varchar(32) DEFAULT NULL COMMENT 'ニックネーム',

  PRIMARY KEY (`user_id`)

) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;

INSERT INTO `m_user`(`user_id`, `user_name`, `passwd`, `user_sex`, `nick_name`)VALUES('101', 'テスト０１', 'pass01', 'MAN', 'テ０１');
INSERT INTO `m_user`(`user_id`, `user_name`, `passwd`, `user_sex`, `nick_name`)VALUES('102', 'テスト０２', 'pass02', 'WOMAN', 'テ０２');
INSERT INTO `m_user`(`user_id`, `user_name`, `passwd`, `user_sex`, `nick_name`)VALUES('103', 'テスト０３', 'pass03', 'OTHERS', 'テ０３');
INSERT INTO `m_user`(`user_id`, `user_name`, `passwd`, `user_sex`, `nick_name`)VALUES('104', 'テスト０４', 'pass04', 'MAN', 'テ０４');
INSERT INTO `m_user`(`user_id`, `user_name`, `passwd`, `user_sex`, `nick_name`)VALUES('105', 'テスト０５', 'pass05', 'WOMAN', 'テ０５');


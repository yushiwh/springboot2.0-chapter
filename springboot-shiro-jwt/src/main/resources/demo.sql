CREATE TABLE `jwtuser` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`username` VARCHAR(50) NULL DEFAULT NULL COMMENT '用户名',
	`password` VARCHAR(50) NULL DEFAULT NULL COMMENT '密码',
	`role` VARCHAR(50) NULL DEFAULT NULL COMMENT '角色',
	`permission` VARCHAR(50) NULL DEFAULT NULL COMMENT '权限',
	`ban` INT(11) NULL DEFAULT NULL COMMENT '状态',
	PRIMARY KEY (`id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=4
;


CREATE TABLE `jwtrole` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`role` VARCHAR(50) NULL DEFAULT NULL COMMENT '角色',
	`permission` VARCHAR(50) NULL DEFAULT NULL COMMENT '权限',
	PRIMARY KEY (`id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=3
;


INSERT INTO `jwtuser` (`username`, `password`, `role`, `permission`, `ban`) VALUES ('howie', '1234567', 'admin', 'normal', 0);
INSERT INTO `jwtuser` (`username`, `password`, `role`, `permission`, `ban`) VALUES ('ys', '123456789', 'user', 'normal', 0);
INSERT INTO `jwtuser` (`username`, `password`, `role`, `permission`, `ban`) VALUES ('kobe', '112233', 'user', 'vip', 0);



INSERT INTO `jwtrole` (`role`, `permission`) VALUES ('user', 'normal');
INSERT INTO `jwtrole` (`role`, `permission`) VALUES ('admin', 'vip');



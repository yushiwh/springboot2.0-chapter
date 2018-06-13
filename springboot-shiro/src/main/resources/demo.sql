CREATE TABLE `roleshiro` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`role` VARCHAR(50) NULL DEFAULT NULL,
	PRIMARY KEY (`id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=3
;



CREATE TABLE `usershiro` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`username` VARCHAR(50) NULL DEFAULT NULL,
	`password` VARCHAR(50) NULL DEFAULT NULL,
	`role` VARCHAR(50) NULL DEFAULT NULL,
	PRIMARY KEY (`id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=3
;



INSERT INTO `roleshiro` (`role`) VALUES ('user');
INSERT INTO `roleshiro` (`role`) VALUES ('admin');



INSERT INTO `usershiro` (`username`, `password`, `role`) VALUES ('howie', '123456', 'user');
INSERT INTO `usershiro` (`username`, `password`, `role`) VALUES ('swit', '123456789', 'admin');


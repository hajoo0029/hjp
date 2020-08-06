--<ScriptOptions statementTerminator=";"/>

ALTER TABLE `ACUB`.`info_user` DROP PRIMARY KEY;

ALTER TABLE `ACUB`.`info_beacon` DROP PRIMARY KEY;

ALTER TABLE `ACUB`.`user` DROP PRIMARY KEY;

ALTER TABLE `ACUB`.`info_beacon` DROP INDEX `ACUB`.`macAddr`;

DROP TABLE `ACUB`.`user`;

DROP TABLE `ACUB`.`testset_ble`;

DROP TABLE `ACUB`.`record_ble`;

DROP TABLE `ACUB`.`info_beacon`;

DROP TABLE `ACUB`.`location`;

DROP TABLE `ACUB`.`info_user`;

DROP TABLE `ACUB`.`testset_beacon`;

DROP TABLE `ACUB`.`record_beacon`;

CREATE TABLE `ACUB`.`user` (
	`user_id` VARCHAR(20) NOT NULL,
	`user_pswd` VARCHAR(20) NOT NULL,
	`user_email` VARCHAR(20) NOT NULL,
	PRIMARY KEY (`user_id`)
) ENGINE=InnoDB;

CREATE TABLE `ACUB`.`testset_ble` (
	`my_id` VARCHAR(20) NOT NULL,
	`other_id` VARCHAR(20) NOT NULL,
	`rssi` INT NOT NULL,
	`mTime` TIME NOT NULL
) ENGINE=InnoDB;

CREATE TABLE `ACUB`.`record_ble` (
	`my_id` VARCHAR(20) NOT NULL,
	`other_id` VARCHAR(20) NOT NULL,
	`rssi` INT NOT NULL,
	`mDate` DATE NOT NULL,
	`mTime` TIME NOT NULL
) ENGINE=InnoDB;

CREATE TABLE `ACUB`.`info_beacon` (
	`id` VARCHAR(20) NOT NULL,
	`macAddr` VARCHAR(20) NOT NULL,
	`UUID` VARCHAR(20) NOT NULL,
	`major` VARCHAR(20) NOT NULL,
	`miner` VARCHAR(20) NOT NULL,
	`x` VARCHAR(10) NOT NULL,
	`y` VARCHAR(10) NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB;

CREATE TABLE `ACUB`.`location` (
	`id` VARCHAR(20) NOT NULL,
	`x` INT NOT NULL,
	`y` INT NOT NULL
) ENGINE=InnoDB;

CREATE TABLE `ACUB`.`info_user` (
	`id` VARCHAR(20) NOT NULL,
	`pswd` VARCHAR(20) NOT NULL,
	`userName` VARCHAR(20) NOT NULL,
	`email` VARCHAR(20) NOT NULL,
	`Major` VARCHAR(20) NOT NULL,
	`MACADDR` VARCHAR(20) NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB;

CREATE TABLE `ACUB`.`testset_beacon` (
	`id` VARCHAR(20) NOT NULL,
	`rssi` INT NOT NULL,
	`macAddr` VARCHAR(20) NOT NULL,
	`mTime` TIME NOT NULL
) ENGINE=InnoDB;

CREATE TABLE `ACUB`.`record_beacon` (
	`id` VARCHAR(20) NOT NULL,
	`rssi` INT NOT NULL,
	`macAddr` VARCHAR(20) NOT NULL,
	`mDate` DATE NOT NULL,
	`mTime` TIME NOT NULL
) ENGINE=InnoDB;

CREATE UNIQUE INDEX `macAddr` ON `ACUB`.`info_beacon` (`macAddr` ASC);


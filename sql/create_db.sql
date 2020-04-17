DROP DATABASE IF EXISTS `gamers_data`;
CREATE DATABASE `gamers_data` DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_unicode_ci;
USE gamers_data;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `countries`;
DROP TABLE IF EXISTS `gamers`;
DROP TABLE IF EXISTS `activity`;

CREATE TABLE `countries` (
  `id` int(3) NOT NULL AUTO_INCREMENT COMMENT 'ID страны',
  `code` VARCHAR(3) COLLATE utf8_unicode_ci NOT NULL COMMENT 'Трёхбуквенный код страны',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `gamers` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'ID пользователя в СУБД',
  `uuid` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT 'UUID пользователя, уникально во всём приложении',
  `country_id` INT(3) NOT NULL COMMENT 'ID страны пользователя',
  `money` INT(11) DEFAULT NULL COMMENT 'Количество денег',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uuid` (`uuid`),
  KEY `country_id` (`country_id`),
  CONSTRAINT `gamers_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `countries` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `activity` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'ID одного показателя activity',
  `gamer_id` BIGINT(20) DEFAULT NULL COMMENT 'ID пользователя, которому принадлежит показатель',
  `date` DATETIME DEFAULT NULL COMMENT 'Дата и время записи показателя',
  `value` INT(11) DEFAULT NULL COMMENT 'Значение показателя',
  PRIMARY KEY (`id`),
  KEY `gamer_id` (`gamer_id`),
  CONSTRAINT `activity_ibfk_1` FOREIGN KEY (`gamer_id`) REFERENCES `gamers` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

SET FOREIGN_KEY_CHECKS = 1;
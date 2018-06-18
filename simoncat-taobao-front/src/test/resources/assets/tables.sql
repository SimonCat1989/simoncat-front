CREATE DATABASE `simoncat_test` CHARACTER SET utf8 COLLATE utf8_general_ci;
alter database `simoncat_test` CHARACTER SET utf8 COLLATE utf8_general_ci;
 
use simoncat_test;

create table `book_type` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`type` varchar(20) NOT NULL,
	PRIMARY KEY (`id`)
)CHARACTER SET utf8 COLLATE utf8_general_ci;

create table `book` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(60) NOT NULL,
	`author` varchar(60) NOT NULL,
	`type_id` int(11) NOT NULL,
	`cover` varchar(100) NOT NULL,
	`description` text NOT NULL,
	PRIMARY KEY (`id`),
	KEY `fk_book_type` (`type_id`),
	CONSTRAINT `fk_book_type` FOREIGN KEY (`type_id`) REFERENCES `book_type` (`id`)
)CHARACTER SET utf8 COLLATE utf8_general_ci;

create table `essay` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`title` varchar(60) NOT NULL,
	`author` varchar(60) NOT NULL,
	`authorAvatar` varchar(100) NOT NULL,
	`createMonth` varchar(5) NOT NULL,
	`createMonthSuffix` varchar(1) NOT NULL,
	`createDay` varchar(2) NOT NULL,
	`createYear` varchar(5) NOT NULL,
	`comment` int NOT NULL,
	`heart` int NOT NULL,
	`twitter` int NOT NULL,
	`facebook` int NOT NULL,
	`keyword` varchar(100) NOT NULL,
	`description` text NOT NULL,
	PRIMARY KEY (`id`)
)CHARACTER SET utf8 COLLATE utf8_general_ci;

create table `essay_comment` (
	`essay_id` int(11) NOT NULL,
	`book_id` int(11) NOT NULL,
	`comment` text NOT NULL,
	PRIMARY KEY (`essay_id`, `book_id`),
	KEY `fk_essay` (`essay_id`),
	KEY `fk_book` (`book_id`),
	CONSTRAINT `fk_essay` FOREIGN KEY (`essay_id`) REFERENCES `essay` (`id`),
	CONSTRAINT `fk_book` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`)
)CHARACTER SET utf8 COLLATE utf8_general_ci;

drop table `essay_comment`;
drop table `essay`;
drop table `book`;
drop table `book_type`;
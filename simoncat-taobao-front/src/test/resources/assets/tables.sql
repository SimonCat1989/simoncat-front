CREATE DATABASE `simoncat_test`;
 
use simoncat_test;

create table `book_type` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`type` varchar(20) NOT NULL,
	PRIMARY KEY (`id`)
);

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
);

create table `essay` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	TITLE varchar(60) NOT NULL,
	AUTHOR varchar(60) NOT NULL,
	AUTHOR_AVATAR varchar(100) NOT NULL,
	CREATE_MONTH varchar(5) NOT NULL,
	CREATE_MONTH_SUFFIX varchar(1) NOT NULL,
	CREATE_DAY varchar(2) NOT NULL,
	CREATE_YEAR varchar(5) NOT NULL,
	COMMENT int NOT NULL,
	HEART int NOT NULL,
	TWITTER int NOT NULL,
	FACEBOOK int NOT NULL,
	KEYWORD varchar(100) NOT NULL,
	DESCRIPTION varchar(2000) NOT NULL,
	PRIMARY KEY (ID)
);

create table LINK_RECOMMENTATION_BOOK (
	RECOMMENTATION_ID int,
	BOOK_ID int,
	CONTENT varchar(2000) NOT NULL,
	PRIMARY KEY (RECOMMENTATION_ID, BOOK_ID),
	KEY FK_RECOMMENTATION (RECOMMENTATION_ID),
	KEY FK_BOOK (BOOK_ID),
	CONSTRAINT FK_RECOMMENTATION FOREIGN KEY (RECOMMENTATION_ID) REFERENCES RECOMMENDATION (ID),
	CONSTRAINT FK_BOOK FOREIGN KEY (BOOK_ID) REFERENCES BOOK (ID)
);

insert into BOOK values (1, `123`, `12`, `12`, `12`);
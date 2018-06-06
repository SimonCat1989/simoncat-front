create table BOOK (
	ID int,
	NAME varchar(60) NOT NULL,
	AUTHOR varchar(60) NOT NULL,
	COVER varchar(100) NOT NULL,
	DESCRIPTION varchar(2000) NOT NULL,
	PRIMARY KEY (ID)
);

create table RECOMMENDATION (
	ID int,
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

insert into BOOK values (1, '123', '12', '12', '12');
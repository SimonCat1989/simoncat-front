create table BOOK (
	ID int,
	NAME varchar(60) NOT NULL,
	AUTHOR varchar(60) NOT NULL,
	COVER varchar(100) NOT NULL,
	DESCRIPTION varchar(1000) NOT NULL,
	PRIMARY KEY (ID)
);

insert into BOOK values (1, '123', '12', '12', '12');
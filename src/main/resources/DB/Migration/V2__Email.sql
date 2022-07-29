create table TB_EMAIL
(

ID_EMAIL	        int(20) NOT NULL AUTO_INCREMENT,
OWNER_REF	varchar(50) not null,
EMAIL_FROM		varchar(100) not null,
EMAIL_TO		varchar(100) not null,
SUBJECT			varchar(50) not null,
TEXT		    	varchar(300) not null,
STATUS			varchar(15) not null,
DATE_SEND		timestamp not null,

PRIMARY KEY (`ID_EMAIL`));
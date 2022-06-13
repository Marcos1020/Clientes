create table USER_TB
(

ID_USUARIO	numeric(50) NOT NULL,
NOME_CLIENTE	varchar(255) not null,
NOME_USUARIO	varchar(255) not null,
EMAIL		varchar(20) not null,
SENHA		varchar(255) not null,
STATUS_USER	varchar(15) not null,

PRIMARY KEY (`ID_USUARIO`));

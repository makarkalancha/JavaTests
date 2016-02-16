--create sequence group_seq;
--create table test3(id bigint default group_seq.nextval primary key);
--And if not:
--create table test1(id identity);
--or
--create table test2(id bigint auto_increment primary key);


CREATE TABLE TAX(
ID identity,
NAME VARCHAR(100),
DESCRIPTION VARCHAR(512),
FORMULA VARCHAR(512)
);

CREATE TABLE TAX_RATE(
ID identity,
TAX_ID BIGINT,
RATE DECIMAL(20,2),
DESCRIPTION VARCHAR(512),
STARTDATE TIMESTAMP DEFAULT '1970-01-01 00:00:00',
ENDDATE TIMESTAMP DEFAULT '2037-01-01 00:00:00',
FOREIGN KEY (TAX_ID) REFERENCES TAX(ID),
);

INSERT INTO TAX (NAME,DESCRIPTION1) VALUES('GST/TPS','The goods and services tax / La taxe sur les produits et services'); 
select @a := scope_identity();
INSERT INTO TAX_RATE (TAX_ID,RATE,DESCRIPTION,STARTDATE,ENDDATE) VALUES(@a,5,null,default,default);

INSERT INTO TAX (NAME,DESCRIPTION1) VALUES('QST/TVQ','The Québec sales tax / La taxe de vente du Québec');
select @a := scope_identity();
INSERT INTO TAX_RATE (TAX_ID,RATE,DESCRIPTION,STARTDATE,ENDDATE) VALUES(@a,9.5,null,'2015-06-01 00:00:00',default);



CREATE TABLE TRANSACTION(
ID identity,
--ACCOUNT_ID BIGINT,
--ORGANIZATION_ID BIGINT,
DATE DATE NOT NULL,
COMMENT VARCHAR(512),
CUSTOM1 DECIMAL(20,6),
CUSTOM2 DECIMAL(20,6),
BALANCE DECIMAL(20,6)
);

CREATE TABLE ITEM(
ID identity,
DESCRIPTION1 VARCHAR(512),
DESCRIPTION2 VARCHAR(512),
TRANSACTION_ID BIGINT,
AMOUNT DECIMAL(20,6),
TAX_ID BIGINT,
COMMENT VARCHAR(512),
FOREIGN KEY (TRANSACTION_ID) REFERENCES TRANSACTION(ID),
FOREIGN KEY (TAX_ID) REFERENCES TAX(ID)
);

--EXAMPLE
--http://stackoverflow.com/questions/29993308/h2-how-to-create-a-database-trigger-that-log-a-row-change-to-another-table
--CREATE TRIGGER TRANSACTION_SUM_T
--AFTER INSERT
--ON ITEM
--FOR EACH ROW
--CALL "com.example.MyTrigger"


INSERT INTO FINANCE1.FAMILY_MEMBER (NAME,DESCRIPTION) VALUES('Fred','husband');
select @husband := scope_identity();
INSERT INTO FINANCE1.FAMILY_MEMBER (NAME,DESCRIPTION) VALUES('Wilma','wife');
select @wife := scope_identity();
INSERT INTO FINANCE1.FAMILY_MEMBER (NAME,DESCRIPTION) VALUES('the Flintstones','family');
select @family := scope_identity();

INSERT INTO FINANCE1.CURRENCY (CODE, NAME, DESCRIPTION) VALUES('CAD','canadian dollar','canadian dollar desc');
select @cad := scope_identity();
INSERT INTO FINANCE1.CURRENCY (CODE, NAME, DESCRIPTION) VALUES('USD','american dollar','american dollar desc');
select @usd := scope_identity();
INSERT INTO FINANCE1.CURRENCY (CODE, NAME, DESCRIPTION) VALUES('MDL','moldavian lei','moldavian lei desc');
select @mdl := scope_identity();

INSERT INTO FINANCE1.ACCOUNT_GROUP (TYPE, NAME, DESCRIPTION) VALUES('D', 'cash', 'money in wallet');
select @cash := scope_identity();
INSERT INTO FINANCE1.ACCOUNT_GROUP (TYPE, NAME, DESCRIPTION) VALUES('C', 'credit card', 'credit cards');
select @credit_card := scope_identity();

INSERT INTO FINANCE1.ACCOUNT (ACCOUNT_GROUP_ID, ACCOUNT_GROUP_TYPE, CURRENCY_ID, NAME, DESCRIPTION, INITIAL_BALANCE) VALUES(@cash,'D',@cad,'cash CAD','money in wallet cad', 100);
select @cash_cad := scope_identity();
INSERT INTO FINANCE1.ACCOUNT (ACCOUNT_GROUP_ID, ACCOUNT_GROUP_TYPE, CURRENCY_ID, NAME, DESCRIPTION, INITIAL_BALANCE) VALUES(@cash,'D',@usd,'cash USD','money in wallet usd', 100);
select @cash_usd := scope_identity();
INSERT INTO FINANCE1.ACCOUNT (ACCOUNT_GROUP_ID, ACCOUNT_GROUP_TYPE, CURRENCY_ID, NAME, DESCRIPTION, INITIAL_BALANCE,ACC_LIMIT) VALUES(@credit_card,'C',@cad,'visa 1234 CAD','credit card ???initial balance is a limit??', 0, 500);
select @visa_1234_cad := scope_identity();

INSERT INTO FINANCE1.BILL_COIN_AMT(ACCOUNT_ID,DATE,AMT_CENT1,AMT_CENT5,AMT_CENT10,AMT_CENT25,AMT_DOLLAR1,AMT_DOLLAR2,AMT_DOLLAR5,AMT_DOLLAR10,AMT_DOLLAR20,AMT_DOLLAR50,AMT_DOLLAR100)
VALUES(@cash_cad,'2016-02-03',0,0,0,0,0,0,0,0,0,0,1);

INSERT INTO FINANCE1.ACCOUNT_BALANCE(ACCOUNT_ID, DATE, BALANCE) VALUES(@cash_cad,'2016-02-03',100);

INSERT INTO FINANCE1.CATEGORY_GROUP (TYPE, NAME, DESCRIPTION) VALUES('D', 'доходы', 'income');
select @income := scope_identity();
INSERT INTO FINANCE1.CATEGORY_GROUP (TYPE, NAME, DESCRIPTION) VALUES('C', 'личные расходы', 'what person needs');
select @pers_exp := scope_identity();

INSERT INTO FINANCE1.CATEGORY(CATEGORY_GROUP_ID, CATEGORY_GROUP_TYPE, NAME, DESCRIPTION) VALUES(@income,'D', 'зп','salary from job');
select @salary := scope_identity();
INSERT INTO FINANCE1.CATEGORY(CATEGORY_GROUP_ID, CATEGORY_GROUP_TYPE, NAME, DESCRIPTION) VALUES(@pers_exp,'C', 'еда','food');
select @food := scope_identity();
INSERT INTO FINANCE1.CATEGORY(CATEGORY_GROUP_ID, CATEGORY_GROUP_TYPE, NAME, DESCRIPTION) VALUES(@pers_exp,'C', 'одежда','clothes');
select @clothes := scope_identity();

INSERT INTO FINANCE1.ORGANIZATION (NAME,DESCRIPTION) VALUES('job','my job');
select @job := scope_identity();
INSERT INTO FINANCE1.ORGANIZATION (NAME,DESCRIPTION) VALUES('walmart','shop');
select @walmart := scope_identity();
INSERT INTO FINANCE1.ORGANIZATION (NAME,DESCRIPTION) VALUES('rbc','bank');
select @rbc := scope_identity();
INSERT INTO FINANCE1.ORGANIZATION (NAME,DESCRIPTION) VALUES('sami fruits','shop');
select @sami_fruits := scope_identity();

INSERT INTO FINANCE1.TAX (NAME,DESCRIPTION) VALUES('GST/TPS','The goods and services tax / La taxe sur les produits et services');
select @gst_tps := scope_identity();
INSERT INTO FINANCE1.TAX_RATE (TAX_ID,RATE,DESCRIPTION,STARTDATE,ENDDATE) VALUES(@gst_tps,5,null,default,default);
select @qst_tvq5 := scope_identity();

INSERT INTO FINANCE1.TAX (NAME,DESCRIPTION) VALUES('QST/TVQ','The Québec sales tax / La taxe de vente du Québec');
select @qst_tvq := scope_identity();
INSERT INTO FINANCE1.TAX_RATE (TAX_ID,RATE,DESCRIPTION,STARTDATE,ENDDATE) VALUES(@qst_tvq,9.5,null,'2015-06-01 00:00:00',default);
select @qst_tvq95 := scope_identity();

INSERT INTO FINANCE1.TAX (NAME,DESCRIPTION) VALUES('no tax','no tax');
select @no_tax := scope_identity();
INSERT INTO FINANCE1.TAX_RATE (TAX_ID,RATE,DESCRIPTION,STARTDATE,ENDDATE) VALUES(@no_tax,default, null,default,default);
select @no_tax0 := scope_identity();





INSERT INTO FINANCE1.INVOICE (ORGANIZATION_ID, COMMENT) VALUES(@job,'SALARY comment');
INSERT INTO FINANCE1.ITEM (DESCRIPTION1,DESCRIPTION2,INVOICE_ID,AMOUNT,TAX_ID) VALUES('ЗП','SALARY',1,1000,3);

INSERT INTO FINANCE1.INVOICE (ACCOUNT_ID,ORGANIZATION_ID,CURRENCY_ID,DATE,COMMENT) VALUES(3,2,1,'2016-02-12','GROCERY');--19.27
INSERT INTO FINANCE1.ITEM (DESCRIPTION1,DESCRIPTION2,INVOICE_ID,AMOUNT,TAX_ID) VALUES('хлеб','bread',2,4,3);
INSERT INTO FINANCE1.ITEM (DESCRIPTION1,DESCRIPTION2,INVOICE_ID,AMOUNT,TAX_ID) VALUES('масло','butter',2,3.69,3);
INSERT INTO FINANCE1.ITEM (DESCRIPTION1,DESCRIPTION2,INVOICE_ID,AMOUNT,TAX_ID) VALUES('колбаса','kolbasa',2,11.58,3);

UPDATE FINANCE1.ITEM SET AMOUNT = 12 WHERE DESCRIPTION1 = 'колбаса' AND INVOICE_ID=2;--19.69
DELETE FROM FINANCE1.ITEM WHERE DESCRIPTION1 = 'масло' AND INVOICE_ID=2;--16.00

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
INSERT INTO FINANCE1.ACCOUNT_GROUP (TYPE, NAME, DESCRIPTION) VALUES('D', 'bank account', 'money on the bank account');
select @bank_acc := scope_identity();
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
INSERT INTO FINANCE1.CATEGORY_GROUP (TYPE, NAME, DESCRIPTION) VALUES('C', 'кредиторская задолж', 'credit cards');
select @credit_exp := scope_identity();

INSERT INTO FINANCE1.CATEGORY(CATEGORY_GROUP_ID, CATEGORY_GROUP_TYPE, NAME, DESCRIPTION) VALUES(@income,'D', 'зп','salary from job');
select @salary := scope_identity();
INSERT INTO FINANCE1.CATEGORY(CATEGORY_GROUP_ID, CATEGORY_GROUP_TYPE, NAME, DESCRIPTION) VALUES(@pers_exp,'C', 'еда','food');
select @food := scope_identity();
INSERT INTO FINANCE1.CATEGORY(CATEGORY_GROUP_ID, CATEGORY_GROUP_TYPE, NAME, DESCRIPTION) VALUES(@pers_exp,'C', 'одежда','clothes');
select @clothes := scope_identity();
INSERT INTO FINANCE1.CATEGORY(CATEGORY_GROUP_ID, CATEGORY_GROUP_TYPE, NAME, DESCRIPTION) VALUES(@credit_exp,'C', 'вернул кредит','credit return');
select @credit_return := scope_identity();

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
select @inv1 := scope_identity();
INSERT INTO FINANCE1.ITEM (INVOICE_ID, CATEGORY_ID, TAX_ID, FAMILY_MEMBER_ID, DESCRIPTION1, DESCRIPTION2, AMOUNT, COMMENT) VALUES(@inv1, @salary, @no_tax, @husband,'ЗП','SALARY',1000,'salary comm');
SELECT @inv1_balance := (SELECT SUM(AMOUNT) FROM FINANCE1.ITEM WHERE INVOICE_ID = @inv1);
UPDATE FINANCE1.INVOICE SET BALANCE = @inv1_balance WHERE ID = @inv1;
INSERT INTO FINANCE1.TRANSACTION (ACCOUNT_ID, ACCOUNT_GROUP_TYPE, INVOICE_ID, DATE, DEBIT_AMOUNT, CREDIT_AMOUNT, COMMENT) VALUES(@cash_cad,'D',@inv1,'2016-02-03',@inv1_balance,DEFAULT,'trans comm');

INSERT INTO FINANCE1.INVOICE (ORGANIZATION_ID,COMMENT) VALUES(@walmart,'GROCERY comme');
select @inv2 := scope_identity();
INSERT INTO FINANCE1.ITEM (INVOICE_ID, CATEGORY_ID, TAX_ID, FAMILY_MEMBER_ID, DESCRIPTION1, DESCRIPTION2, AMOUNT, COMMENT) VALUES(@inv2, @food, @no_tax, @family,'хлеб','bread',4,'bread comm');
INSERT INTO FINANCE1.ITEM (INVOICE_ID, CATEGORY_ID, TAX_ID, FAMILY_MEMBER_ID, DESCRIPTION1, DESCRIPTION2, AMOUNT, COMMENT) VALUES(@inv2, @food, @no_tax, @family,'масло','butter',3.69,'butter comm');
INSERT INTO FINANCE1.ITEM (INVOICE_ID, CATEGORY_ID, TAX_ID, FAMILY_MEMBER_ID, DESCRIPTION1, DESCRIPTION2, AMOUNT, COMMENT) VALUES(@inv2, @food, @no_tax, @family,'колбаса','kolbasa',11.58,'kolbasa comm');
SELECT @inv2_balance := (SELECT SUM(AMOUNT) FROM FINANCE1.ITEM WHERE INVOICE_ID = @inv2);
UPDATE FINANCE1.INVOICE SET BALANCE = @inv2_balance WHERE ID = @inv2;
INSERT INTO FINANCE1.TRANSACTION (ACCOUNT_ID, ACCOUNT_GROUP_TYPE, INVOICE_ID, DATE, DEBIT_AMOUNT, CREDIT_AMOUNT, COMMENT) VALUES(@visa_1234_cad,'C',@inv2,'2016-02-02',@inv2_balance,DEFAULT,'trans comm');


INSERT INTO FINANCE1.INVOICE (ORGANIZATION_ID,COMMENT) VALUES(@rbc,'bank comm');
select @inv3 := scope_identity();
INSERT INTO FINANCE1.ITEM (INVOICE_ID, CATEGORY_ID, TAX_ID, FAMILY_MEMBER_ID, DESCRIPTION1, DESCRIPTION2, AMOUNT, COMMENT) VALUES(@inv3, @credit_return, @no_tax, @family,'rbc credit period [2016-01-05 to 2016-02-05]',default,@inv2_balance,'return inv from walmart');
SELECT @inv3_balance := (SELECT SUM(AMOUNT) FROM FINANCE1.ITEM WHERE INVOICE_ID = @inv3);
UPDATE FINANCE1.INVOICE SET BALANCE = @inv3_balance WHERE ID = @inv3;
INSERT INTO FINANCE1.TRANSACTION (ACCOUNT_ID, ACCOUNT_GROUP_TYPE, INVOICE_ID, DATE, DEBIT_AMOUNT, CREDIT_AMOUNT, COMMENT) VALUES(@cash_cad,'D',@inv3,'2016-02-02',DEFAULT,@inv3_balance,'transfer from cash to visa');
INSERT INTO FINANCE1.TRANSACTION (ACCOUNT_ID, ACCOUNT_GROUP_TYPE, INVOICE_ID, DATE, DEBIT_AMOUNT, CREDIT_AMOUNT, COMMENT) VALUES(@visa_1234_cad,'C',@inv3,'2016-02-02',DEFAULT,@inv3_balance,'transfer from cash to visa');
--till now credit card balance is 0

INSERT INTO FINANCE1.INVOICE (ORGANIZATION_ID,COMMENT) VALUES(@walmart,'GROCERY2 comme');
select @inv4 := scope_identity();
INSERT INTO FINANCE1.ITEM (INVOICE_ID, CATEGORY_ID, TAX_ID, FAMILY_MEMBER_ID, DESCRIPTION1, DESCRIPTION2, AMOUNT, COMMENT) VALUES(@inv4, @food, @no_tax, @family,'печенье','cookies',2.5,'cookies comm');
INSERT INTO FINANCE1.ITEM (INVOICE_ID, CATEGORY_ID, TAX_ID, FAMILY_MEMBER_ID, DESCRIPTION1, DESCRIPTION2, AMOUNT, COMMENT) VALUES(@inv4, @food, @no_tax, @family,'молоко','milk',6.58,'milk comm');
INSERT INTO FINANCE1.ITEM (INVOICE_ID, CATEGORY_ID, TAX_ID, FAMILY_MEMBER_ID, DESCRIPTION1, DESCRIPTION2, AMOUNT, COMMENT) VALUES(@inv4, @food, @no_tax, @family,'дрожжи','yeast',4.69,'yeast comm');
INSERT INTO FINANCE1.ITEM (INVOICE_ID, CATEGORY_ID, TAX_ID, FAMILY_MEMBER_ID, DESCRIPTION1, DESCRIPTION2, AMOUNT, COMMENT) VALUES(@inv4, @food, @no_tax, @family,'помидоры','tomato',5.69,'tomato comm');
SELECT @inv4_balance := (SELECT SUM(AMOUNT) FROM FINANCE1.ITEM WHERE INVOICE_ID = @inv4);
UPDATE FINANCE1.INVOICE SET BALANCE = @inv4_balance WHERE ID = @inv4;
INSERT INTO FINANCE1.TRANSACTION (ACCOUNT_ID, ACCOUNT_GROUP_TYPE, INVOICE_ID, DATE, DEBIT_AMOUNT, CREDIT_AMOUNT, COMMENT) VALUES(@visa_1234_cad,'C',@inv4,'2016-02-05',@inv4_balance,DEFAULT,'trans comm');



COMMIT;



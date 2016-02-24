SET SCHEMA FINANCE;
CREATE ALIAS INSERT_SELECT_DATE FOR "com.everything.JDBC.h2.Functions.insertSelectDate";

--set @date = call PARSEDATETIME("2016-02-12","yyyy-MM-dd");
--set @date = "2016-02-12";
--CALL INSERT_SELECT_DATE(@date);

CALL INSERT_SELECT_DATE(call PARSEDATETIME("2016-02-12","yyyy-MM-dd"))
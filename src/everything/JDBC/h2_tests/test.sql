SET SCHEMA FINANCE;
CREATE ALIAS CREATE_DATE_UNIT_TABLE FOR "com.everything.JDBC.h2.Functions.createDateUnitTable";
CREATE ALIAS INSERT_SELECT_DATE FOR "com.everything.JDBC.h2.Functions.insertSelectDate";

--set @date = call PARSEDATETIME("2016-02-12","yyyy-MM-dd");
--set @date = "2016-02-12";
--CALL INSERT_SELECT_DATE(@date);
select @date1 := PARSEDATETIME('2016-02-12','yyyy-MM-dd');
CALL INSERT_SELECT_DATE(@date1)

CALL CREATE_DATE_UNIT_TABLE();
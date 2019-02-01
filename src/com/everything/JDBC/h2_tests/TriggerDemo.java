package com.everything.JDBC.h2_tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by mcalancea on 2016-02-16.
 */
//http://h2database.googlecode.com/svn-history/r5729/trunk/h2/src/test/org/h2/samples/TriggerSample.java
public class TriggerDemo {

    public static void main(String[] args) throws Exception {
//        invoiceTrigger();
        ////impossible to update same table with trigger in h2
        ////use hibernate @PreUpdate and @PrePersist
        ////https://docs.jboss.org/hibernate/entitymanager/3.5/reference/en/html/listeners.html
        organizationTrigger();
    }

    public static void organizationTrigger() throws Exception {
        String createTriggerName = "ORG_INS_T";
        String updateTriggerName = "ORG_UPD_T";
        String deleteTriggerName = "ORG_DEL_T";
        String triggerName = "CALL \"com.everything.JDBC.h2_tests.TriggerCreateUpdateTimestamp\" ";
        String createTrigger = "CREATE TRIGGER " + createTriggerName +
                " AFTER INSERT ON ORGANIZATION FOR EACH ROW " +
                triggerName;
        String updateTrigger = "CREATE TRIGGER " + updateTriggerName +
                " AFTER UPDATE ON ORGANIZATION FOR EACH ROW " +
                triggerName;
        String deleteTrigger = "CREATE TRIGGER " + deleteTriggerName +
                " AFTER DELETE ON ORGANIZATION FOR EACH ROW " +
                triggerName;
        String dropTrigger = "DROP TRIGGER IF EXISTS ";

        try (
                Connection conn = DriverManager.getConnection(H2DbConstants.DB_CONNECTION1_IFEXISTS, H2DbConstants.DB_USER, H2DbConstants.DB_PASSWORD);
                Statement stat = conn.createStatement();
        ) {
            stat.execute(dropTrigger + createTriggerName);
            stat.execute(dropTrigger + updateTriggerName);
            stat.execute(dropTrigger + deleteTriggerName);

//            stat.execute("DELETE FROM ITEM;");
//            stat.execute("DELETE FROM INVOICE;");

            stat.execute(createTrigger);
            stat.execute(updateTrigger);
            stat.execute(deleteTrigger);

            stat.execute("INSERT INTO ORGANIZATION(NAME, DESCRIPTION) VALUES('name','desc')");

            ResultSet id = stat.executeQuery("select @job := scope_identity()");
            id.next();
            long idLong = id.getLong(1);
            System.out.println("id " + idLong);

            ResultSet rs = stat.executeQuery("SELECT * FROM ORGANIZATION where id = "+idLong);
            rs.next();
            System.out.println("create " + rs.getTimestamp(4));
            System.out.println("update " + rs.getTimestamp(5));


            rs.close();
        }
    }

    public static void invoiceTrigger() throws Exception {
        String createTriggerName = "ITEM_INS_T";
        String updateTriggerName = "ITEM_UPD_T";
        String deleteTriggerName = "ITEM_DEL_T";
        String triggerName = "CALL \"com.everything.JDBC.h2_tests.TriggerInvoiceSum\" ";
        String createTrigger = "CREATE TRIGGER " + createTriggerName +
                " AFTER INSERT ON ITEM FOR EACH ROW " +
                triggerName;
        String updateTrigger = "CREATE TRIGGER " + updateTriggerName +
                " AFTER UPDATE ON ITEM FOR EACH ROW " +
                triggerName;
        String deleteTrigger = "CREATE TRIGGER " + deleteTriggerName +
                " AFTER DELETE ON ITEM FOR EACH ROW " +
                triggerName;
        String dropTrigger = "DROP TRIGGER IF EXISTS ";

        try (
                Connection conn = DriverManager.getConnection(H2DbConstants.DB_CONNECTION1_IFEXISTS, H2DbConstants.DB_USER, H2DbConstants.DB_PASSWORD);
                Statement stat = conn.createStatement();
        ) {
            stat.execute(dropTrigger + createTriggerName);
            stat.execute(dropTrigger + updateTriggerName);
            stat.execute(dropTrigger + deleteTriggerName);

//            stat.execute("DELETE FROM ITEM;");
//            stat.execute("DELETE FROM INVOICE;");

            stat.execute(createTrigger);
            stat.execute(updateTrigger);
            stat.execute(deleteTrigger);

//            stat.execute("INSERT INTO INVOICE VALUES(1, '2016-02-16', null, 0,0,0)");
//
//            ResultSet rs = null;
//            System.out.println("insert: 10 and 19.95 = 29.95");
//            stat.execute("INSERT INTO ITEM VALUES(1, 'a*', 'a**',1, 10.0,null,null)");
//            stat.execute("INSERT INTO ITEM VALUES(2, 'b*', 'b**',1, 19.95,null,null)");
//            rs = stat.executeQuery("SELECT BALANCE FROM TRANSACTION");
//            rs.next();
//            System.out.println("The sum is " + rs.getBigDecimal(1));
//
//            System.out.println("update: 10 and 20 [was 19.95] = 30.00");
//            stat.execute("UPDATE ITEM SET AMOUNT=20.0 WHERE ID=2");
//            rs = stat.executeQuery("SELECT BALANCE FROM TRANSACTION");
//            rs.next();
//            System.out.println("The sum is " + rs.getBigDecimal(1));
//
//            System.out.println("delete: [10 removed] 20 = 20.00");
//            stat.execute("DELETE FROM ITEM WHERE ID=1");
//            rs = stat.executeQuery("SELECT BALANCE FROM TRANSACTION");
//            rs.next();
//            System.out.println("The sum is " + rs.getBigDecimal(1));
//
//            rs.close();
        }
    }

}

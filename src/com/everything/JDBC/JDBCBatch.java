package com.everything.JDBC;

import com.everything.utils.DateUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * User: Makar Kalancha
 * Date: 22/05/14
 * Time: 10:13 AM
 */
public class JDBCBatch {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        String sqlOld = "INSERT INTO exhibitor (name,foreignid,id,customref1,featured,statusclientandbilling,statusorder,statusaccount) values(?,?,?,'testBatch',false,'no_sales_test','no_sales_test','no_sales_test')";
//        String sqlNew = "INSERT INTO exhibitor (name,foreignid,id,customref1,featured,statusclientandbilling,statusorder,statusaccount) values(?,?,nextval('exhibitor_id_seq'),'testBatch',false,'no_sales_test','no_sales_test','no_sales_test')";
        String sqlNew = "SELECT id,foreignid FROM exhibitor WHERE id=?";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        try (
                Connection cnn = getConnection();
//                PreparedStatement preparedStatementOldSql = cnn.prepareStatement(sqlOld);
//                PreparedStatement preparedStatementNewSql = cnn.prepareStatement(sqlNew);
//                PreparedStatement preparedStatementNewSql = cnn.prepareStatement(sqlNew,PreparedStatement.RETURN_GENERATED_KEYS,PreparedStatement.EXECUTE_FAILED);//works
//                PreparedStatement preparedStatementNewSql = cnn.prepareStatement(sqlNew,PreparedStatement.RETURN_GENERATED_KEYS);
                PreparedStatement preparedStatementNewSql = cnn.prepareStatement(sqlNew,new String[]{"id","foreignid"});
//                PreparedStatement preparedStatementNewSql = cnn.prepareStatement(sqlNew,new String[]{"id","*"});

        ) {
//            cnn.setAutoCommit(true);
            Date start = new Date();
//            System.out.println(sdf.format(start));
//            for(int i = 0;i<10_000;i++) {
//                long id = nextId(cnn);
//                preparedStatementOldSql.setString(1, "Exhibitor " + i);
//                preparedStatementOldSql.setString(2, i + "_noBatch");
//                preparedStatementOldSql.setLong(3, id);
//                preparedStatementOldSql.executeUpdate();
//                Date currentTime = new Date();
////                System.out.println("{"+sdf.format(currentTime)+"} -- "+i+" execureQuery");
//            }
            Date end = new Date();
//            System.out.println(sdf.format(end));
//
//            System.out.println("Time elapsed: "+ DateTest.elapsedTimeToDateFormat(start,end));
//
//
//            System.out.println("\n-----------------------------------------------------------------------------------\n");

            cnn.setAutoCommit(false);
            start = new Date();
            System.out.println(sdf.format(start));
//            for(int i = 0;i<10_000;i++){
//                preparedStatementNewSql.setString(1, "Exhibitor " + i);
//                preparedStatementNewSql.setString(2, i + "_batch");
//                preparedStatementNewSql.addBatch();
//                Date currentTime = new Date();
////                System.out.println("{"+sdf.format(currentTime)+"} -- "+i+" addBatch");
//            }

            int[] arrayOfPk = {518991,518992,518993};
            for(int i : arrayOfPk){
                preparedStatementNewSql.setInt(1, i);
                preparedStatementNewSql.addBatch();
            }

            Date beforeExecute = new Date();
            System.out.println("{"+sdf.format(beforeExecute)+"} -- beforeExecure");
//            int[] count = preparedStatementNewSql.executeBatch();
//            System.out.println("count[0]:"+count[0]);
            preparedStatementNewSql.executeBatch();
            ResultSet generatedKeys = preparedStatementNewSql.getGeneratedKeys();
//            if (null != generatedKeys && generatedKeys.next()) {
            while(generatedKeys != null && generatedKeys.next()){
                Long primaryKey = generatedKeys.getLong(1);
                String foreignKey = generatedKeys.getString(2);
                System.out.println(primaryKey+":"+foreignKey);
            }
            Date afterExecute = new Date();
            System.out.println("{"+sdf.format(afterExecute)+"} -- afterExecute");

            end = new Date();
            System.out.println(sdf.format(end));
            System.out.println("Time elapsed: "+ DateUtils.elapsedTimeToDateFormat(start,end));


            cnn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            e.getNextException().printStackTrace();
        }
    }

    private static Connection getConnection() throws SQLException{
//        String dbDriver = "org.postgresql.Driver";
        String db = "postgresql";
        String host = "localhost";
        String port = "5432";
        String dbName = "jck2014";
        String username = "postgres";
        String password = "root";
        String url = "jdbc:"+db+"://"+host+":"+port+"/"+dbName;
//        Class.forName(dbDriver);
        return DriverManager.getConnection(url, username, password);
    }

    public static long nextId (Connection cnn)
            throws SQLException
    {
        Statement stmt = cnn.createStatement();
        try
        {
            String seq = "exhibitor_id_seq";
            ResultSet rs = stmt.executeQuery("SELECT nextval('" + seq + "')");
            try
            {
                return rs.next() ? rs.getLong(1) : -1;
            }
            finally
            {
                rs.close();
            }
        }
        finally
        {
            stmt.close();
        }
    }
}

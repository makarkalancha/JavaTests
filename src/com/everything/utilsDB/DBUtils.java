package com.everything.utilsDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

/**
 * User: Makar Kalancha
 * Date: 12/08/14
 * Time: 1:54 PM
 */
public class DBUtils {

    public static void searchInEveryDbInEveryTable(String environment, String word, String[] exceptDb) throws SQLException {
        List<String> dbs = DBUtils.getDbList(environment);
        Arrays.sort(exceptDb);
//        dbs.clear();
//        dbs.add("isce2012");

        for(String db : dbs) {
            if (Arrays.binarySearch(exceptDb, db) > -1) {
                continue;
            }
//            String db = "wfes2015";
            System.out.println("===================================");
            System.out.println(">>>>DB:" + db);
            List<String> tables = DBUtils.getPublicTablesList(environment, db);
//            tables.clear();
//            tables.add("registration");
            for (String table : tables) {
                int limit = 1000;
                int offset = 0;
                boolean hasData = true;
                Map<Integer, LinkedList<String>> successfulSearchSet = new TreeMap<Integer, LinkedList<String>>();
                int successRowNumber = 0;
                for (; hasData; offset += limit) {
                    hasData = false;
                    String query = "SELECT * FROM " + table + " limit " + limit + " offset " + offset;
                    try (Connection cnn = getConnection(environment, db);
                         Statement statement = cnn.createStatement(
                                 ResultSet.TYPE_SCROLL_INSENSITIVE,
                                 ResultSet.CONCUR_UPDATABLE);
                         ResultSet resultSet = statement.executeQuery(query);
                    ) {
                        //                    resultSet.last();
                        //                    int count = resultSet.getRow();
                        //                    resultSet.beforeFirst();
                        //
                        //                    if (count > 0) {
                        //                        System.out.println("=count:"+count);
                        //                        System.out.println(">>>>>>>>table:"+table);

                        Thread.sleep(10);
                        ResultSetMetaData metaData = resultSet.getMetaData();

                        //                        System.out.println();

                        while (resultSet.next()) {
                            LinkedList<String> row = new LinkedList<>();
                            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                                //                                System.out.print(resultSet.getObject(i) + "\t");
                                Object obj = resultSet.getObject(i);
                                if (obj != null) {
                                    row.add(obj.toString());
                                }

                            }
                            if (row.contains(word)) {
                                if (successfulSearchSet.size() == 0) {
                                    LinkedList<String> header = new LinkedList<>();
                                    for (int i = 1; i <= metaData.getColumnCount(); i++) {
                                        header.add(metaData.getColumnName(i));
                                    }
                                    successfulSearchSet.put(successRowNumber, header);
                                    successRowNumber++;
                                }
                                successfulSearchSet.put(successRowNumber, row);
                                successRowNumber++;
                            }
                            hasData = true;
                            //                            System.out.println();
                        }
                    } catch (SQLException e) {
                        System.out.println("ERROR:" + e.getMessage());
                    } catch (InterruptedException e) {
                        System.out.println("ERROR:" + e.getMessage());
                    }
                }
                if (successfulSearchSet.size() > 0) {
                    System.out.println(">>>>>>>>table:" + table);
                }
                for (Map.Entry<Integer, LinkedList<String>> entry : successfulSearchSet.entrySet()) {
                    System.out.print(entry.getKey() + "\t");
                    for (String text : entry.getValue()) {
                        System.out.print(text + "\t");
                    }
                    System.out.println();
                }


//                    }

            }
        }

    }

    public static List<String> getPublicTablesList(String environment, String dbName) throws SQLException {
        List<String> list = new ArrayList<>();
        String query = "SELECT table_name FROM information_schema.tables WHERE table_schema = 'public' order by table_name;";
        try(Connection cnn = getConnection(environment, dbName);
            Statement statement = cnn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
        ){
            while (resultSet.next()) {
                list.add(resultSet.getString(1));
            }
        }
        return list;
    }

    private static void checkQueryAndEnvironment(String environment, String query) {
        SQLStatements sqlStatements = new SQLStatements();
//        System.out.println(sqlStatements.isQuerySafe(query));
        if (/*!environment.equalsIgnoreCase("local") && */!sqlStatements.isQuerySafe(query)) {
            throw new RuntimeException("QUERY IS NOT SAFE! Impossible to run query: " + query);
        } else{
            System.out.println("query is safe");
        }
    }

    public static void runQueryForEveryDb(String environment, String query) throws SQLException {
        List<String> dbs = DBUtils.getDbList(environment);
        checkQueryAndEnvironment(environment, query);
//        for(String db : dbs) {
//            System.out.println("===================================");
//            System.out.println(">>>>"+db);
//            try(Connection cnn = getConnection(environment,db);
//                Statement statement = cnn.createStatement(
//                        ResultSet.TYPE_SCROLL_INSENSITIVE,
//                        ResultSet.CONCUR_UPDATABLE);
//                ResultSet resultSet = statement.executeQuery(query);
//            ){
//                resultSet.last();
//                int count = resultSet.getRow();
//                resultSet.beforeFirst();
//
//                if(count > 0){
////                    System.out.println("=count:"+count);
//
//                    ResultSetMetaData metaData = resultSet.getMetaData();
//                    for(int i = 1;i<=metaData.getColumnCount();i++) {
//                        System.out.print(metaData.getColumnName(i) + "\t");
//                    }
//                    System.out.println();
//                    while(resultSet.next()){
//
//                        for(int i = 1;i<=metaData.getColumnCount();i++) {
//                            System.out.print(resultSet.getObject(i) + "\t");
//                        }
//                        System.out.println();
//                    }
//                }
//            } catch (SQLException e){
//                System.out.println("ERROR:"+e.getMessage());
//            }
//
//        }

    }

    public static List<String> getDbList(String environment) throws SQLException {
        List<String> list = new ArrayList<>();
        String query = "SELECT datname FROM pg_database WHERE datistemplate = false order by datname;";
        try(Connection cnn = getConnection(environment, "postgres");
            Statement statement = cnn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
        ){
            while (resultSet.next()) {
                list.add(resultSet.getString(1));
            }
        }
        return list;
    }

    public static Connection getConnection(String environment, String dbName) throws SQLException {
        Conf conf = new Conf(environment);
        conf.load();
        Properties prop = conf.getProperties();

        String db = "postgresql";
        String host = prop.getProperty("db.host");
        String port = prop.getProperty("db.port");
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        String url = "jdbc:"+db+"://"+host+":"+port+"/"+dbName;

        return DriverManager.getConnection(url, username, password);
    }
}

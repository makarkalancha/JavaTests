package com.everything.utilsDB;

import java.sql.SQLException;

/**
 * User: Makar Kalancha
 * Date: 12/08/14
 * Time: 1:51 PM
 */
public class QueryTool {
    public static void main(String[] args) {
        String environment = "local";
        try {
//            List<String> dbs = DBUtils.getDbList(environment);
//            for(String db : dbs){
//                System.out.println(db);
//            }
//            String query = "SELECT * FROM exhibitor limit 1";
//            String query = "SELECT * FROM exhibitor where name is null";
//            String query = "select * from _schema_version order by id desc limit 1";
//            String query = "select * from  exhibitor where deleted = false";
            String query = "delete from  exhibitor where deleted = false";
            DBUtils.runQueryForEveryDb(environment, query);

//            String word = "agg_rankboard";
//            String[] exceptDb = {"g2e2012"};
//            DBUtils.searchInEveryDbInEveryTable(environment,word,exceptDb);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}

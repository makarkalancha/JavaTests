package com.everything;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * User: Makar Kalancha
 * Date: 09/01/14
 * Time: 12:15 PM
 */
public class testDB {
        public static void main(String[] args) throws Exception {

            Connection conn = null;
            Properties connProp = new Properties();
            connProp.put("user", "postgres");
            connProp.put("password", "root");

            try {

//                Class.forName("org.h2.Driver").newInstance();

                conn = DriverManager.getConnection( "jdbc:postgresql://localhost:5432/npew2014", connProp);

// create our java jdbc statement

                String search = "&";
                String sql = "select * FROM registration WHERE firstname = ? ORDER BY id";
//                String sql = "select * from table_b";
                PreparedStatement pStmt = conn.prepareStatement(sql);
                pStmt.setString(1,search);
//                pStmt.setString(2,search);

                ResultSet rs = pStmt.executeQuery();
                try
                {
                    while (rs.next())
                    {
                        System.out.println(rs.getLong(1));
//                        System.out.println(rs.getString(2));
                    }
                }
                finally
                {
                    rs.close();
                }

//// create table "StudentData”
//
//                String createQ = "CREATE TABLE IF NOT EXISTS studentData(matriculationNumber VARCHAR(14) PRIMARY KEY," + "lastname VARCHAR(30), "+ "firstname VARCHAR(30)," + "email VARCHAR(30), title CHAR(4), course_of_studies VARCHAR(30), " + "title_of_seminar VARCHAR(35), "+ "kind_of_seminar VARCHAR(15))";
//
//                stmt.executeUpdate(createQ);
//
//                // create table “SeminarData"
//
//                String createQ1 = "CREATE TABLE IF NOT EXISTS seminarData(title_of_seminar VARCHAR(35) PRIMARY KEY," + "seminar_id VARCHAR(10), "+ "kind_of_seminar VARCHAR(15)," + "date_of_examination VARCHAR(15), examiner(4))";
//
//                stmt.executeUpdate(createQ1);
//
//                // create table "SeminarAttendance”
//
//                String createQ2 = "CREATE TABLE IF NOT EXISTS seminarAttendance(title_of_seminar VARCHAR(35) PRIMARY KEY," + "matriculationNumber VARCHAR(14) PRIMARY KEY," + "seminar_id VARCHAR(10), "+ "kind_of_seminar VARCHAR(15),"+ "examination_office VARCHAR(10)," + "date_and_time_of_registration VARCHAR(30), " + "attempt VARCHAR(10),marks VARCHAR(5))";
//
//                stmt.executeUpdate(createQ2);
//
//                stmt.close();
//
//                // rs.close();
//
//                conn.close();

            }catch(SQLException e)

            {
                e.printStackTrace();

//                System.err.println("Keine Verbindung zur Datenbank möglich”);
//
//                        System.err.println("Fehlercode: " + e.getErrorCode());

            }
        }

}

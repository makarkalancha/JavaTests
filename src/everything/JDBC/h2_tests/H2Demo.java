package everything.JDBC.h2_tests;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.h2.jdbcx.JdbcConnectionPool;
import org.h2.tools.DeleteDbFiles;

/**
 * Created by mcalancea on 2016-02-15.
 */

//http://www.javatips.net/blog/2014/07/h2-database-example
//java -jar D:\SRC\Java_work_dir\JavaTests\lib\h2-1.4.191.jar
public class H2Demo {


    private static JdbcConnectionPool pool = null;

    public static void main(String[] args) {
        try{
            // delete the H2 database named 'test' in the user home directory
//            DeleteDbFiles.execute(DB_DIR, DB_NAME, true);
//            insertWithStatement();

            DeleteDbFiles.execute(H2DbConstants.DB_DIR, H2DbConstants.DB_NAME, true);
            insertWithPreparedStatement();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }



    private static Connection getDBConnection() throws SQLException {
//        return DriverManager.getConnection(H2DbConstants.DB_CONNECTION1, H2DbConstants.DB_USER, H2DbConstants.DB_PASSWORD);
//http://www.h2database.com/html/tutorial.html#creating_new_databases
//Using a Connection Pool
        JdbcConnectionPool pool = JdbcConnectionPool.create(H2DbConstants.DB_CONNECTION1, H2DbConstants.DB_USER, H2DbConstants.DB_PASSWORD);
        return pool.getConnection();
    }

    private static void insertWithPreparedStatement() throws SQLException {
        Connection connection = getDBConnection();
        PreparedStatement createPreparedStatement = null;
        PreparedStatement insertPreparedStatement = null;
        PreparedStatement selectPreparedStatement = null;
        ResultSet rs = null;

        String createQuery = "CREATE TABLE PERSON(id int primary key, name varchar(255))";
        String insertQuery = "INSERT INTO PERSON (id, name) VALUES (?,?)";
        String selectQuery = "SELECT * FROM PERSON";
        try {
            connection.setAutoCommit(false);

            createPreparedStatement = connection.prepareStatement(createQuery);
            createPreparedStatement.executeUpdate();
            createPreparedStatement.close(); //any way is closed in finally

            insertPreparedStatement = connection.prepareStatement(insertQuery);
            insertPreparedStatement.setInt(1, 1);
            insertPreparedStatement.setString(2, "jose");
            insertPreparedStatement.executeUpdate();
            insertPreparedStatement.close(); //any way is closed in finally

            selectPreparedStatement = connection.prepareStatement(selectQuery);
            rs = selectPreparedStatement.executeQuery();
            System.out.println("H2 database inserted through prepared statement");
            while(rs.next()) {
                System.out.println("id: " + rs.getInt("id") + "; name: " + rs.getString("name"));
            }
            selectPreparedStatement.close(); //any way is closed in finally

            connection.commit();
        } finally {
            if (connection != null) connection.close();
            if (createPreparedStatement != null) createPreparedStatement.close();
            if (insertPreparedStatement != null) insertPreparedStatement.close();
            if (selectPreparedStatement != null) selectPreparedStatement.close();
            if (rs != null) rs.close();
        }
    }

    //h2 sql statement example
    private static void insertWithStatement()throws SQLException{
        Connection connection = getDBConnection();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();
            stmt.execute("CREATE TABLE PERSON(id int primary key, name varchar(255))");
            stmt.execute("INSERT INTO PERSON (id, name) VALUES (1,'Anju')");
            stmt.execute("INSERT INTO PERSON (id, name) VALUES (2,'Sonia')");
            stmt.execute("INSERT INTO PERSON (id, name) VALUES (3,'Asha')");

            rs = stmt.executeQuery("SELECT * FROM PERSON");
            System.out.println("H2 database inserted through statement");
            while(rs.next()) {
                System.out.println("id: " + rs.getInt("id") + "; name: " + rs.getString("name"));
            }

            connection.commit();
        } finally {
            if (connection != null) connection.close();
            if (stmt != null) stmt.close();
            if (rs != null) rs.close();
        }
    }
}

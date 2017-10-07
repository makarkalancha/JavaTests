package com.everything;

import java.sql.SQLException;

/**
 * User: Makar Kalancha
 * Date: 28/04/14
 * Time: 12:15 PM
 */
public class ExceptionTest {
    public static void main(String[] args) {
        try{
            System.out.println("1");
            ExceptionTest et = new ExceptionTest();
            System.out.println("2");
            System.out.println(et.execute());
            System.out.println("3");
        }catch (Exception e){
            System.out.println("4");
            e.printStackTrace();
            System.out.println("5");
        }
    }

    public boolean throwException() throws Exception{
        boolean result = false;
        try {

            throw new SQLException();

        } catch (SQLException e) {
//            throw new IllegalStateException(e);
            System.out.println("before");
            throwSqlException();
            System.out.println("after");
            throw e;
//            throw new Exception(e);
//        } finally {
//            return randomNumber;
        }
//        return randomNumber;
    }

    private void throwSqlException() throws SQLException{
        throw new SQLException();
    }

//    public boolean execute() throws IllegalStateException {
    public boolean execute() throws Exception{
        return throwException();
    }

}

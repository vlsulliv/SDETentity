package com.techb.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    public static void main(String[] args) {

        // TODO Auto-generated method stub
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://awsmysql.cinshcjctrws.us-east-1.rds.amazonaws.com:3306/Users";
        final String USER = "admin";
        final String PASS = "admin123";

        Connection conn = null;

        try {
            // Connecting to the database
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");

            // getConnection method from mysql connector library
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // sysout to confirm db connection; if connection fails then sysout will not execute
            System.out.println("Creating table in given database...");
            Statement stmt = conn.createStatement();
            // TODO: create methods (CRUD methods) and pass object into methods
            //String sql = "INSERT INTO `testTable` (`AccountID`,`firstName`,`lastName`,`age`) VALUES ( 4,'Jay','C',21);";

            // Statement for execution (subject to change); creating a 'test table' note: the string manipulation
            // might not need to code this in java - DB admin most likely will have created it
            // instead may use the 'INSERT INTO' method above

            String sql = "CREATE TABLE TestTable " +
                    "(SSN INTEGER not NULL, " +
                    " firstName VARCHAR(255), " +
                    " lastName VARCHAR(255), " +
                    " age INTEGER(30));";
            System.out.println(sql);
            // stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

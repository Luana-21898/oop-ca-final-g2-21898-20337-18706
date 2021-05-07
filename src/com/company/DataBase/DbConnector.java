package com.company.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnector {

    private static String dataBaseName;
    final String DB_DATABASE = "vgc";
    final String DB_URL = "jdbc:mysql://localhost:3306/" + DB_DATABASE;
    final String DB_USER = "USER";
    final String DB_PASSWORD = "******";
    private Connection connection;

    public DbConnector() throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

    }

    public static String getDBName() {
        return dataBaseName;
    }

    public void setDBName(String DBName) {
        this.dataBaseName = DBName;
    }


    public static DbConnector getInstance() throws SQLException {
        return new DbConnector();
    }

    public Connection getConnection() {
        try {
            if (connection == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            } else {
                connection.close();
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;

    }
}

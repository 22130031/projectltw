package com.banthatlung.Dao.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect2 {
    static String url = "jdbc:mysql://"+DBProperties.host()+":"+DBProperties.port()+"/"+DBProperties.dbName()+"?"+DBProperties.option();
static Connection conn;
public static Statement get() {
    try {
        if (conn == null|| conn.isClosed()) makeConnect();
        return conn.createStatement();
    } catch (SQLException | ClassNotFoundException e) {
        return null;
    }
}

    private static void makeConnect() throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    conn = DriverManager.getConnection(url,DBProperties.username(),DBProperties.password());
    }

    public static void main(String[] args) {
        get();
    }
}

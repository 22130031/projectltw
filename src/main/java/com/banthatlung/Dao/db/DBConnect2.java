package com.banthatlung.Dao.db;

import java.sql.*;

public class DBConnect2 {
    static String url = "jdbc:mysql://"+DBProperties.host()+":"+DBProperties.port()+"/"+DBProperties.dbName()+"?"+DBProperties.option();
static Connection conn;
public static Statement get() {
    try {
        if (conn == null|| conn.isClosed()) makeConnect();
        return conn.createStatement();
    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
        return null;
    }
}

    private static void makeConnect() throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    conn = DriverManager.getConnection(url,DBProperties.username(),DBProperties.password());
    }

    public static void main(String[] args) throws SQLException {
        Statement stmt = get();
        ResultSet rs = stmt.executeQuery("select * from user where username= 'admin' ");
        while (rs.next()) {
            System.out.println(rs.getString(2) +
                    "," + rs.getString(3) + '\'' +
                    "," + rs.getString(4) +
                    "," + rs.getInt(5)
            );
        }
    }
}

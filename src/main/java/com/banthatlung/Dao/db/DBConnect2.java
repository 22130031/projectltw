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
        ResultSet rs = stmt.executeQuery("select * from san_pham");
        while (rs.next()) {
            System.out.println(rs.getInt(1) +
                    "," + rs.getString(2) + '\'' +
                    "," + rs.getDouble(4) +
                    "," + rs.getString(7)
            );
        }
    }
}

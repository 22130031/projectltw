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
    public static PreparedStatement getPreparedStatement(String sql) {
        try {
            if (conn == null || conn.isClosed()) makeConnect();
            return conn.prepareStatement(sql);
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
        String sql = "UPDATE users SET full_name = ?,email = ? WHERE userid = ?";
        PreparedStatement pstmt = getPreparedStatement(sql);
        pstmt.setString(1,"Administrator");
        pstmt.setString(2,"admin@gmail.com");
        pstmt.setInt(3, 1);
        pstmt.executeUpdate();
    }
}

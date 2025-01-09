package com.banthatlung.Dao.db;

import com.banthatlung.Dao.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
        List<Product>  products = new ArrayList<>();
        String sql = "Select * from products";
        PreparedStatement pstmt = getPreparedStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            products.add(new Product(1, rs.getString("name"), rs.getInt("price"), rs.getString("description"), rs.getInt("status"), rs.getInt("quantity"), rs.getString("created"), rs.getString("image")));
        }
        for (Product p : products) {
            System.out.println(p);
        }
    }
}

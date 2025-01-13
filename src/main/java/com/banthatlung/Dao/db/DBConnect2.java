package com.banthatlung.Dao.db;

import com.banthatlung.Dao.model.Category;
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
        String sql = "Select * from products where product_id=?";
        PreparedStatement pstmt = getPreparedStatement(sql);
        String in = "22";
        int id = Integer.parseInt(in);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            // Lấy thông tin từ ResultSet và khởi tạo đối tượng Product
            Category category = null; // Lấy đối tượng Category từ category_id

            Product product = new Product(
                    rs.getInt("product_id"),           // product_id
                    rs.getString("name"),              // name
                    category,                          // category (Category object)
                    rs.getDouble("gia"),               // gia (price)
                    rs.getInt("so_luong"),             // so_luong (quantity)
                    rs.getString("mo_ta"),             // mo_ta (description)
                    rs.getString("hinh_anh"),          // hinh_anh (image)
                    rs.getString("color"),             // color
                    rs.getString("ngay_tao")           // ngay_tao (createdDate)
            );

            products.add(product);
        }

        for (Product p : products) {
            System.out.println(p);
        }
    }
}

package com.banthatlung.Dao.db;

import com.banthatlung.Dao.model.Brand;
import com.banthatlung.Dao.model.Category;
import com.banthatlung.Dao.model.Material;
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
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products WHERE id = ?";
        PreparedStatement pstmt = getPreparedStatement(sql);
        String in = "22"; // Giả định rằng đây là đầu vào
        int id = Integer.parseInt(in);
        pstmt.setInt(1, id);

        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            // Lấy thông tin từ ResultSet và khởi tạo đối tượng Product
            Category category = new Category(); // Khởi tạo Category (nếu cần lấy thêm thông tin từ bảng liên quan)
            category.setId(rs.getInt("category_id")); // Lấy ID của danh mục từ cột `category_id`

            Brand brand = new Brand(); // Khởi tạo Brand (tương tự như Category)
            brand.setId(rs.getInt("brand_id"));

            Material material = new Material(); // Khởi tạo Material (nếu có dữ liệu liên quan)
            material.setId(rs.getInt("material_id"));

            Product product = new Product(
                    rs.getInt("id"),                  // id
                    rs.getString("name"),             // name
                    rs.getInt("price"),               // price
                    rs.getString("description"),      // description
                    rs.getInt("status"),              // status
                    rs.getInt("quantity"),            // quantity
                    rs.getString("created"),          // date (created)
                    rs.getString("image")             // image
            );

            product.setCategory(category);           // Gán đối tượng Category
            product.setBrand(brand);                 // Gán đối tượng Brand
            product.setMaterial(material);           // Gán đối tượng Material

            products.add(product);
        }

        // Hiển thị danh sách sản phẩm
        for (Product p : products) {
            System.out.println("Product: " + p.getName() + ", Price: " + p.getPrice() + ", Category ID: " + p.getCategory().getId());
        }
    }

}

package com.banthatlung.Dao;

import com.banthatlung.Dao.db.DBConnect;
import com.banthatlung.Dao.db.DBConnect2;
import com.banthatlung.Dao.model.Product;
import com.banthatlung.Dao.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con;

    // Lấy tất cả các sản phẩm
    public List<Product> getAll() {
        ArrayList<Product> result = new ArrayList<>();
        try {
            String sql = "SELECT * FROM products";
            ps = DBConnect2.getPreparedStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                Category category = null;// Lấy đối tượng Category

                Product product = new Product(
                        rs.getInt("product_id"),    // product_id
                        rs.getString("name"),       // name
                        category,                   // category
                        rs.getDouble("gia"),        // gia (price)
                        rs.getInt("so_luong"),      // so_luong (quantity)
                        rs.getString("mo_ta"),      // mo_ta (description)
                        rs.getString("hinh_anh"),   // hinh_anh (image)
                        rs.getString("color"),      // color
                        rs.getString("ngay_tao")    // ngay_tao (createdDate)
                );
                result.add(product);
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return result;
        }
    }

    public List<Product> getAll(int page, int pageSize) {
        ArrayList<Product> result = new ArrayList<>();
        try {
            // Tính toán vị trí bắt đầu (OFFSET) và số lượng sản phẩm trên mỗi trang (LIMIT)
            int offset = (page - 1) * pageSize;
            String sql = "SELECT * FROM products LIMIT ? OFFSET ?";
            ps = DBConnect2.getPreparedStatement(sql);
            ps.setInt(1, pageSize);
            ps.setInt(2, offset);

            rs = ps.executeQuery();
            while (rs.next()) {
                Category category = null; // Lấy đối tượng Category

                Product product = new Product(
                        rs.getInt("product_id"),    // product_id
                        rs.getString("name"),       // name
                        category,                   // category
                        rs.getDouble("gia"),        // gia (price)
                        rs.getInt("so_luong"),      // so_luong (quantity)
                        rs.getString("mo_ta"),      // mo_ta (description)
                        rs.getString("hinh_anh"),   // hinh_anh (image)
                        rs.getString("color"),      // color
                        rs.getString("ngay_tao")    // ngay_tao (createdDate)
                );
                result.add(product);
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return result;
        }
    }

    public int getTotalProductCount() {
        int count = 0;
        try {
            String sql = "SELECT COUNT(*) FROM products";
            ps = DBConnect2.getPreparedStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }


    // Lấy sản phẩm theo ID
    public Product getById(int id) {
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM products WHERE product_id = ?";
            ps = DBConnect2.getPreparedStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                Category category = null; // Lấy đối tượng Category

                Product product = new Product(
                        rs.getInt("product_id"),    // product_id
                        rs.getString("name"),       // name
                        category,                   // category
                        rs.getDouble("gia"),        // gia (price)
                        rs.getInt("so_luong"),      // so_luong (quantity)
                        rs.getString("mo_ta"),      // mo_ta (description)
                        rs.getString("hinh_anh"),   // hinh_anh (image)
                        rs.getString("color"),      // color
                        rs.getString("ngay_tao")    // ngay_tao (createdDate)
                );
                return product;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Tìm kiếm sản phẩm theo tên
    public List<Product> search(String name) {
        ArrayList<Product> result = new ArrayList<>();
        try {
            String sql = "SELECT * FROM products WHERE name LIKE ?";
            ps = DBConnect2.getPreparedStatement(sql);
            ps.setString(1, "%" + name + "%");
            rs = ps.executeQuery();
            while (rs.next()) {

                Category category = null;// Lấy đối tượng Category

                Product product = new Product(
                        rs.getInt("product_id"),
                        rs.getString("name"),
                        category,                   // category
                        rs.getDouble("gia"),        // gia (price)
                        rs.getInt("so_luong"),      // so_luong (quantity)
                        rs.getString("mo_ta"),      // mo_ta (description)
                        rs.getString("hinh_anh"),   // hinh_anh (image)
                        rs.getString("color"),      // color
                        rs.getString("ngay_tao")    // ngay_tao (createdDate)
                );
                result.add(product);
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return result;
        }
    }

    // Thêm mới sản phẩm
    public void add(Product product) throws SQLException {
        String sql = "INSERT INTO products (name, category_id, gia, mo_ta, so_luong, ngay_tao, hinh_anh, color) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = new DBConnect().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, product.getName());
            ps.setInt(2, product.getCategory().getId());  // category_id
            ps.setDouble(3, product.getPrice());          // gia
            ps.setString(4, product.getDescription());    // mo_ta
            ps.setInt(5, product.getQuantity());          // so_luong
            ps.setString(6, product.getCreatedDate());    // ngay_tao
            ps.setString(7, product.getImage());          // hinh_anh
            ps.setString(8, product.getColor());          // color
            ps.executeUpdate();
            System.out.println("Product added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error while adding product: " + e.getMessage());
        }
    }

    // Cập nhật sản phẩm
    public void update(Product product) throws SQLException {
        con = new DBConnect().getConnection();
        String sql = "UPDATE products SET name = ?, category_id = ?, gia = ?, mo_ta = ?, so_luong = ?, ngay_tao = ?, hinh_anh = ?, color = ? WHERE product_id = ?";
        ps = con.prepareStatement(sql);
        ps.setString(1, product.getName());
        ps.setInt(2, product.getCategory().getId());  // category_id
        ps.setDouble(3, product.getPrice());          // gia
        ps.setString(4, product.getDescription());    // mo_ta
        ps.setInt(5, product.getQuantity());          // so_luong
        ps.setString(6, product.getCreatedDate());    // ngay_tao
        ps.setString(7, product.getImage());          // hinh_anh
        ps.setString(8, product.getColor());          // color
        ps.setInt(9, product.getId());                // product_id
        ps.executeUpdate();
    }

    // Xóa sản phẩm
    public void delete(int id) throws SQLException {
        con = new DBConnect().getConnection();
        String sql = "DELETE FROM products WHERE product_id = ?";
        ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    public static void main(String[] args) {
        ProductDao dao = new ProductDao();
        List<Product> p = dao.getAll();
        for (Product p1 : p) {
            System.out.println(p1);
        }
    }
}

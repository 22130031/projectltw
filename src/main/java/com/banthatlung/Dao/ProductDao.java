package com.banthatlung.Dao;

import com.banthatlung.Dao.db.DBConnect;
import com.banthatlung.Dao.db.DBConnect2;
import com.banthatlung.Dao.model.Material;
import com.banthatlung.Dao.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.banthatlung.Dao.db.DBConnect2.getPreparedStatement;

public class ProductDao {
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con;

    public List<Product> getAll() {
        ArrayList<Product> re = new ArrayList<Product>();
        try {
            String sql = "SELECT * FROM products";
            ps = getPreparedStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                re.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("price"), rs.getString("description"), rs.getInt("status"), rs.getInt("quantity"), rs.getString("created"), rs.getString("image")));
            }
            return re;
        } catch (SQLException e) {
            return re;
        }
    }

    public Product getbyId(int id) {
        ResultSet rs = null;
        try {
            String sql = "Select * from products where id= ?";
            ps = getPreparedStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("price"), rs.getString("description"), rs.getInt("status"), rs.getInt("quantity"), rs.getString("created"), rs.getString("image"));
            }
            return null;
        } catch (SQLException e) {
            return null;
        }
    }

    public void add(Product product) throws SQLException {
        String sql = "INSERT INTO products (name) VALUES (?)";
        // Using try-with-resources to ensure resources are closed automatically
        try (Connection con = new DBConnect().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            // Set the name parameter
            ps.setString(1, product.getName());
            // Execute the update
            ps.executeUpdate();
            System.out.println("Material added successfully.");
        } catch (SQLException e) {
            // Handle SQL exceptions
            e.printStackTrace();
            System.err.println("Error while adding material: " + e.getMessage());
        }
    }

    public void update(Product product) throws SQLException {
        con = new DBConnect().getConnection();
        ps = con.prepareStatement("UPDATE materials SET name = ? WHERE id = ?");
        ps.setString(1, product.getName());
        ps.setInt(2, product.getId());
        ps.executeUpdate();
    }

    public void delete(int id) throws SQLException {
        con = new DBConnect().getConnection();
        ps = con.prepareStatement("DELETE FROM products WHERE id = ?");
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

package com.banthatlung.Dao;

import com.banthatlung.Dao.db.DBConnect2;
import com.banthatlung.Dao.model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.banthatlung.Dao.db.DBConnect2.getPreparedStatement;

public class ProductDao {
    PreparedStatement ps = null;
    ResultSet rs = null;
    public List<Product> getAll() {
        ArrayList<Product> re = new ArrayList<Product>();
        try {
            String sql = "SELECT * FROM products";
            ps = getPreparedStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                re.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("price"), rs.getString("description"), rs.getInt("status"), rs.getInt("quantity"), rs.getDate("created"), rs.getString("image")));
            }
            return re;
        } catch (SQLException e) {
            return re;
        }
    }

    public Product getbyId(int id) {
        Statement stmt = DBConnect2.get();
        ResultSet rs = null;
        try {
            String sql = "Select * from products where id= ?";
            ps = getPreparedStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("price"), rs.getString("description"), rs.getInt("status"), rs.getInt("quantity"), rs.getDate("created"),rs.getString("image"));
            }
            return null;
        } catch (SQLException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        ProductDao dao = new ProductDao();
        List<Product> p = dao.getAll();
        for (Product p1 : p) {
            System.out.println(p1);
        }
    }
}

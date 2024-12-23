package com.banthatlung.Dao;

import com.banthatlung.Dao.db.DBConnect2;
import com.banthatlung.Dao.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    public List<Product> getAll() {
        Statement stmt = DBConnect2.get();
        ResultSet rs = null;
        ArrayList<Product> re = new ArrayList<Product>();
               try {
                   rs = stmt.executeQuery("select * from san_pham");

        while (rs.next()) {
           re.add(new Product(rs.getInt(1), rs.getString(2),rs.getDouble(4),
                  rs.getString(7)));}
        return re;
        } catch (SQLException e) {
                return re;
               }
    }
    public Product getbyId(int id) {
        Statement stmt = DBConnect2.get();
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery("select * from san_pham");
            if (rs.next()) {
                return new Product(rs.getInt(1), rs.getString(2),rs.getDouble(4),rs.getString(7));
            }
            return null;
        } catch (SQLException e) {
            return null;
        }
    }
}

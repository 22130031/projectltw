package com.banthatlung.Dao;

import com.banthatlung.Model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    public ProductDao() {

    }
    public List<Person> getProducts() throws SQLException, ClassNotFoundException {
        List<Person> products = new ArrayList<Person>();
        con = new DBConnect().getConnection();
        ps = con.prepareStatement("select * from product");
        rs = ps.executeQuery();
        while (rs.next()) {
            products.add(new Person(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
        }
        return products;

    }

    public static void main(String[] args) {
        ProductDao dao = new ProductDao();
        try {
            dao.getProducts();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

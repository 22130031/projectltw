package com.banthatlung.Dao.db;

import com.banthatlung.Dao.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    public CategoryDao() {}
    public List<Category> getCategory() throws SQLException {
        List<Category> categories = new ArrayList<Category>();
        con = new DBConnect().getConnection();
        ps = con.prepareStatement("SELECT * from categories");
        rs = ps.executeQuery();
        while (rs.next()) {
            categories.add(new Category(rs.getInt("id"),rs.getString("name"), rs.getString("description")));
        }
        return categories;

    }



}

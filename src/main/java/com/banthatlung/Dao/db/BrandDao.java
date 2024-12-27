package com.banthatlung.Dao.db;

import com.banthatlung.Dao.model.Brand;
import com.banthatlung.Dao.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BrandDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public BrandDao() {
    }

    public List<Brand> getList() throws SQLException {
        List<Brand> brands = new ArrayList<Brand>();
        con = new DBConnect().getConnection();
        ps = con.prepareStatement("SELECT * from brands");
        rs = ps.executeQuery();
        while (rs.next()) {
            brands.add(new Brand(rs.getInt("id"),rs.getString("BrandName"), rs.getDate("Create_At")));
        }
        return brands;

    }
}

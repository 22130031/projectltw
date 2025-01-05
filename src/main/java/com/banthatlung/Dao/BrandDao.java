package com.banthatlung.Dao;

import com.banthatlung.Dao.db.DBConnect;
import com.banthatlung.Dao.model.Brand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.banthatlung.Dao.db.DBConnect2.getPreparedStatement;

public class BrandDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public BrandDao() {
    }

    public List<Brand> getList() throws SQLException {
        List<Brand> brands = new ArrayList<Brand>();
        String sql = "select * from brands";
        PreparedStatement ps = getPreparedStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            brands.add(new Brand(rs.getInt("id"), rs.getString("BrandName"), rs.getDate("Create_At")));
        }
        return brands;

    }

    public static void main(String[] args) throws SQLException {
        BrandDao bd = new BrandDao();
        for (Brand brand : bd.getList()) {
            System.out.println(brand);
        }
    }

}

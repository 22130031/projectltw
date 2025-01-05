package com.banthatlung.Dao;

import com.banthatlung.Dao.db.DBConnect;
import com.banthatlung.Dao.model.Material;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaterialDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public MaterialDao() {
    }

    public List<Material> getList() throws SQLException {
        List<Material> materialList = new ArrayList<Material>();
        con = new DBConnect().getConnection();
        ps = con.prepareStatement("SELECT * from materials");
        rs = ps.executeQuery();
        while (rs.next()) {
            materialList.add(new Material(rs.getInt("id"), rs.getString("MaterialName")));
        }
        return materialList;
    }
}

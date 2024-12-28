package com.banthatlung.Dao;

import com.banthatlung.Dao.db.DBConnect2;
import com.banthatlung.Dao.db.User;
import com.banthatlung.Dao.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {
    public User findUser(String username) {
        Statement stmt = DBConnect2.get();
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery("select * from user where username = " + "'" + username + "'" );
            if (rs.next()) {
                return new User(rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5) );
                }
            return null;
        } catch (SQLException e) {
            return null;
        }
    }
}

package com.banthatlung.Dao;

import com.banthatlung.Dao.db.DBConnect2;
import com.banthatlung.Dao.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {
    public User findUser(String username) {
        Statement stmt = DBConnect2.get();
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery("select * from users where username = " + "'" + username + "'" );
            if (rs.next()) {
                return new User(rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getDate(8),
                        rs.getString(9),
                        rs.getString(10)
                );
                }
            return null;
        } catch (SQLException e) {
            return null;
        }
    }
}

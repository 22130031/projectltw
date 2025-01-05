package com.banthatlung.Dao;

import com.banthatlung.Dao.db.DBConnect2;
import com.banthatlung.Dao.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

public class UserDao {
    public User findUser(String username) {
        Statement stmt = DBConnect2.get();
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery("select * from users where username = " + "'" + username + "'" );
            if (rs.next()) {
                return new User(rs.getInt(1),
                        rs.getString(2),
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
    public boolean updateProfile(User u) throws SQLException {
        String sql = "UPDATE users SET full_name = ?, email = ?, phone_number = ?, date_of_birth = ? WHERE username = ?";
        PreparedStatement stmt = DBConnect2.getPreparedStatement(sql) ;
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getPhone());
            stmt.setDate(4, u.getBirthday());
            stmt.setString(5, u.getUsername());
        System.out.println("Executing SQL: " + sql);
        System.out.println("With values: " +
                u.getName() + ", " +
                u.getEmail() + ", " +
                u.getPhone() + ", " +
                u.getBirthday() + ", " +
                u.getId());

        int rowsAffected = stmt.executeUpdate();
        System.out.println("Rows affected: " + rowsAffected);
        return rowsAffected > 0;
    }
}

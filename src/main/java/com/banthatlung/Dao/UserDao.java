package com.banthatlung.Dao;

import com.banthatlung.Dao.db.DBConnect;
import com.banthatlung.Dao.db.DBConnect2;
import com.banthatlung.Dao.model.User;

import java.sql.*;

public class UserDao {
    public User findUser(String username) {
        PreparedStatement stmt = null;
        String sql = "SELECT * FROM users WHERE username = ?";
        ResultSet rs = null;
        try {Connection con = DBConnect.getConnection();
            stmt=con.prepareStatement(sql);
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(rs.getString(1),
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
        String sql = "UPDATE users SET full_name = ?, email = ?, phone_number = ?, date_of_birth = ?,avatar_url =? WHERE user_id = ?";
        PreparedStatement stmt = DBConnect2.getPreparedStatement(sql) ;
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getPhone());
            stmt.setDate(4, u.getBirthday());
            stmt.setString(5, u.getImage());
            stmt.setString(6, u.getId());
        System.out.println("Executing SQL: " + sql);
        System.out.println("With values: " +
                u.getName() + ", " +
                u.getEmail() + ", " +
                u.getPhone() + ", " +
                u.getBirthday() + ", " +
                u.getImage() + ", " +
                u.getId());

        int rowsAffected = stmt.executeUpdate();
        System.out.println("Rows affected: " + rowsAffected);
        return rowsAffected > 0;
    }
    public boolean registerUser(User u) {
        String sql = "INSERT INTO users (username, password, full_name,user_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = DBConnect2.getPreparedStatement(sql)) {
            stmt.setString(1, u.getUsername());
            stmt.setString(2, u.getPass());
            stmt.setString(3, u.getName());
            stmt.setString(4, "u"+(generateID() +1));
            return stmt.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public int generateID() {
        String query = "SELECT COUNT(*) AS total FROM users";
        try (
                PreparedStatement stmt = DBConnect2.getPreparedStatement(query)) {
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}

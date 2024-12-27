package com.banthatlung.Dao.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestConnection {
    public static void main(String[] args) {
        try {
            Statement stmt = DBConnect2.get();
            if (stmt != null) {
                ResultSet rs = stmt.executeQuery("SELECT 1");
                if (rs.next()) {
                    System.out.println("Kết nối cơ sở dữ liệu thành công!");
                }
            } else {
                System.out.println("Không thể kết nối tới cơ sở dữ liệu.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

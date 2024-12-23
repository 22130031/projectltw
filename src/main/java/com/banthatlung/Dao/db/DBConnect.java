package com.banthatlung.Dao.db;

import java.sql.*;

public class DBConnect {
    public Connection getConnection() throws SQLException {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/webthatlung", "root", "");
    }
    public static void main(String arg[]) throws SQLException, ClassNotFoundException {
         DBConnect db = new DBConnect();
            Connection connection = db.getConnection();

            PreparedStatement statement = connection.prepareStatement("select * from categories");
            ResultSet resultSet = statement.executeQuery();

            int code;
            String title;
            while (resultSet.next()) {
                code = resultSet.getInt("Personid");
                title = resultSet.getString("LastName").trim();
                System.out.println("Code : " + code
                        + " Title : " + title);
            }
            resultSet.close();
            statement.close();
            connection.close();

    } // function ends
}

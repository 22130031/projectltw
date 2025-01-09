package com.banthatlung.Dao;

import com.banthatlung.Dao.db.DBConnect;
import com.banthatlung.Dao.model.Order;
import com.banthatlung.Dao.model.OrderDetail;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.banthatlung.Dao.db.DBConnect2.getPreparedStatement;

public class OrderDetailDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List<Order> getList() throws SQLException {
        List<Order> orders = new ArrayList<Order>();
        String sql = "select * from orders";
        PreparedStatement ps = getPreparedStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            // orders.add(new Order(rs.getInt("id"), rs.getInt("customer_id"), rs.getDate("oder_date").toString(), rs.getDate("created_at").toString(), rs.getString("status"), rs.getInt("total_amount")));
        }
        return orders;

    }

    public boolean addOrderDetail(OrderDetail orderDetail) {
        String sql = "INSERT INTO order_details (id, order_id, product_id, quantity, price, created_at, updated_at) " +
                "VALUES (?, ?, ?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)";
        boolean isAdded = false;

        try {
            con = new DBConnect().getConnection();
            ps = con.prepareStatement(sql);

            // Set parameters for the prepared statement
            ps.setInt(1, orderDetail.getId());
            ps.setInt(2, orderDetail.getOrder_id());
            ps.setInt(3, orderDetail.getProduct_id());
            ps.setInt(4, orderDetail.getQuantity());
            ps.setInt(5, orderDetail.getPrice());

            // Execute update and check if the record was inserted
            int rowsInserted = ps.executeUpdate();
            isAdded = rowsInserted > 0;

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return isAdded;
    }

    public void updateOrder(Order order) {
        try {
            String sql = "UPDATE orders SET user_id = ?, status = ?, total_amount = ?, update_date = CURRENT_TIMESTAMP WHERE id = ?";
            con = new DBConnect().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, order.getId());
            ps.setString(2, order.getStatus());
            ps.setInt(3, order.getTotal_amount());
            ps.setInt(4, order.getId());
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Order updated successfully!");
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) throws SQLException {
        con = new DBConnect().getConnection();
        ps = con.prepareStatement("DELETE FROM Orders WHERE id = ?");
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    public static void main(String[] args) throws SQLException {

        OrderDetailDao dao = new OrderDetailDao();
        OrderDetail o = new OrderDetail(1,22,1,21);
        dao.addOrderDetail(o);
    }
}

package com.banthatlung.Dao;

import com.banthatlung.Dao.db.DBConnect2;
import com.banthatlung.Dao.model.Order;
import com.banthatlung.Dao.model.OrderStatusHistory;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {

    private Connection conn;

    public OrderDao(Connection conn) {
        this.conn = conn;
    }

    // 1. Cập nhật trạng thái hóa đơn, đồng thời lưu lịch sử trạng thái
    public boolean updateOrderStatus(int orderId, int newStatus, String changedBy, String note) throws SQLException {
        conn.setAutoCommit(false); // Đảm bảo cả 2 thao tác thành công hoặc rollback

        try {
            // Lấy trạng thái cũ
            int oldStatus = -1;
            String getStatusSql = "SELECT status FROM orders WHERE id = ?";
            try (PreparedStatement ps = conn.prepareStatement(getStatusSql)) {
                ps.setInt(1, orderId);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        oldStatus = rs.getInt("status");
                    } else {
                        conn.rollback();
                        return false; // Không tìm thấy hóa đơn
                    }
                }
            }

            // Cập nhật trạng thái mới và ghi chú
            String updateSql = "UPDATE orders SET status = ?, note = ? WHERE id = ?";
            try (PreparedStatement ps = conn.prepareStatement(updateSql)) {
                ps.setInt(1, newStatus);
                ps.setString(2, note);
                ps.setInt(3, orderId);
                ps.executeUpdate();
            }

            // Lưu lịch sử trạng thái
            insertOrderStatusHistory(new OrderStatusHistory(
                    orderId, oldStatus, newStatus, LocalDateTime.now(), changedBy, note
            ));

            conn.commit();
            return true;
        } catch (SQLException ex) {
            conn.rollback();
            throw ex;
        } finally {
            conn.setAutoCommit(true);
        }
    }

    // 2. Lưu lịch sử trạng thái hóa đơn
    public void insertOrderStatusHistory(OrderStatusHistory history) throws SQLException {
        String sql = "INSERT INTO order_status_history (order_id, old_status, new_status, change_time, changed_by, note) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, history.getOrderId());
            ps.setInt(2, history.getOldStatus());
            ps.setInt(3, history.getNewStatus());
            ps.setTimestamp(4, Timestamp.valueOf(history.getChangeTime()));
            ps.setString(5, history.getChangedBy());
            ps.setString(6, history.getNote());
            ps.executeUpdate();
        }
    }

    // 3. (Tùy chọn) Lấy lịch sử trạng thái của 1 hóa đơn
    public List<OrderStatusHistory> getOrderStatusHistory(int orderId) throws SQLException {
        List<OrderStatusHistory> result = new ArrayList<>();
        String sql = "SELECT * FROM order_status_history WHERE order_id = ? ORDER BY change_time ASC";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, orderId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    OrderStatusHistory h = new OrderStatusHistory();
                    h.setId(rs.getInt("id"));
                    h.setOrderId(rs.getInt("order_id"));
                    h.setOldStatus(rs.getInt("old_status"));
                    h.setNewStatus(rs.getInt("new_status"));
                    h.setChangeTime(rs.getTimestamp("change_time").toLocalDateTime());
                    h.setChangedBy(rs.getString("changed_by"));
                    h.setNote(rs.getString("note"));
                    result.add(h);
                }
            }
        }
        return result;
    }

    public List<Order> getOrdersByUser(String userId) throws SQLException {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders WHERE user_id = ?";
        PreparedStatement ps = DBConnect2.getPreparedStatement(sql);
        ps.setString(1, userId);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            orders.add(new Order(
                    rs.getInt("id"),
                    rs.getString("user_id"),
                    rs.getInt("order_code"),
                    rs.getInt("total_price"),
                    rs.getDate("order_date").toString(),
                    rs.getBoolean("signed"),
                    rs.getInt("status")
            ));
        }
        return orders;
    }

    public Order getOrderById(int id) throws SQLException {
        Order order = null;
        String sql = "SELECT * FROM orders WHERE id = ?";
        PreparedStatement ps = DBConnect2.getPreparedStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            order = new Order(
                    rs.getInt("id"),
                    rs.getString("user_id"),
                    rs.getInt("order_code"),
                    rs.getInt("total_price"),
                    rs.getDate("order_date").toString(),
                    rs.getBoolean("signed"),
                    rs.getInt("status")
            );
        }

        return order;
    }

    public int addOrder(Order order) throws SQLException {
        String sql = "INSERT INTO orders (user_id, order_code, total_price, signed, status) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = DBConnect2.getPreparedStatement(sql);
        ps.setString(1, order.getUserId());
        ps.setInt(2, order.getOrderCode());
        ps.setInt(3, order.getTotalPrice());
        ps.setBoolean(4, order.isSigned());
        ps.setInt(5, order.getStatus());
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return -1;
    }

    public void updateSignedStatus(int orderId, boolean signed) throws SQLException {
        String sql = "UPDATE orders SET signed = ? WHERE id = ?";
        PreparedStatement ps = DBConnect2.getPreparedStatement(sql);
        ps.setBoolean(1, signed);
        ps.setInt(2, orderId);
        ps.executeUpdate();
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM orders WHERE id = ?";
        PreparedStatement ps = DBConnect2.getPreparedStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }
    public List<Order> getAllOrders() throws SQLException {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders";
        PreparedStatement ps = DBConnect2.getPreparedStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            orders.add(new Order(
                    rs.getInt("id"),
                    rs.getString("user_id"),
                    rs.getInt("order_code"),
                    rs.getInt("total_price"),
                    rs.getDate("order_date").toString(),
                    rs.getBoolean("signed"),
                    rs.getInt("status")
            ));
        }
        return orders;
    }

    public void updateOrder(Order order) throws SQLException {
        String sql = "UPDATE orders SET user_id = ?, order_code = ?, total_price = ?, signed = ?, status = ? WHERE id = ?";
        PreparedStatement ps = DBConnect2.getPreparedStatement(sql);
        ps.setString(1, order.getUserId());
        ps.setInt(2, order.getOrderCode());
        ps.setInt(3, order.getTotalPrice());
        ps.setBoolean(4, order.isSigned());
        ps.setInt(5, order.getStatus());
        ps.setInt(6, order.getId());
        ps.executeUpdate();
    }

}

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.banthatlung.Dao.model.Order" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách hóa đơn</title>
    <style>
        table { border-collapse: collapse; width: 80%; margin: 20px auto; }
        th, td { border: 1px solid #aaa; padding: 8px; text-align: center; }
        th { background-color: #f0f0f0; }
        .btn-detail { padding: 3px 8px; text-decoration: none; background: #28b; color: #fff; border-radius: 3px; }
    </style>
</head>
<body>
<h2 style="text-align:center;">Danh sách hóa đơn của bạn</h2>
<c:if test="${not empty error}">
    <div style="color:red;text-align:center;">${error}</div>
</c:if>
<table>
    <tr>
        <th>Mã đơn</th>
        <th>Ngày đặt</th>
        <th>Tổng tiền</th>
        <th>Trạng thái</th>
        <th>Chi tiết</th>
    </tr>
    <%
        List<Order> orders = (List<Order>)request.getAttribute("orders");
        if (orders != null) {
            for (Order order : orders) {
    %>
    <tr>
        <td><%= order.getOrderCode() %></td>
        <td><%= order.getOrderDate() %></td>
        <td><%= order.getTotalPrice() %> VNĐ</td>
        <td>
            <%
                int st = order.getStatus();
                String statusTxt = "Chờ xác nhận";
                if (st == 2) statusTxt = "Đã xác nhận";
                else if (st == 3) statusTxt = "Đang giao";
                else if (st == 4) statusTxt = "Hoàn thành";
                else if (st == 0) statusTxt = "Đã hủy";
            %>
            <%= statusTxt %>
        </td>
        <td>
            <a class="btn-detail" href="<%= request.getContextPath() %>/orderDetail?id=<%= order.getId() %>">Xem</a>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>
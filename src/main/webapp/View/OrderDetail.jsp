<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.banthatlung.Dao.model.Order" %>
<%@ page import="com.banthatlung.Dao.model.OrderDetail" %>
<%@ page import="com.banthatlung.Dao.model.OrderStatusHistory" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Chi tiết hóa đơn</title>
    <style>
        table { border-collapse: collapse; width: 80%; margin: 20px auto; }
        th, td { border: 1px solid #aaa; padding: 8px; text-align: center; }
        th { background-color: #f0f0f0; }
        h2, h3 { text-align: center; }
    </style>
</head>
<body>
<h2>Chi tiết hóa đơn</h2>
<%
    Order order = (Order) request.getAttribute("order");
    List<OrderDetail> orderDetails = (List<OrderDetail>) request.getAttribute("orderDetails");
    List<OrderStatusHistory> history = (List<OrderStatusHistory>) request.getAttribute("history");
%>
<table>
    <tr><th>Mã đơn</th><td><%= order.getOrderCode() %></td></tr>
    <tr><th>Ngày đặt</th><td><%= order.getOrderDate() %></td></tr>
    <tr><th>Tổng tiền</th><td><%= order.getTotalPrice() %> VNĐ</td></tr>
    <tr><th>Trạng thái hiện tại</th>
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
    </tr>
</table>

<h3>Danh sách sản phẩm</h3>
<table>
    <tr>
        <th>ID sản phẩm</th>
        <th>Số lượng</th>
        <th>Giá</th>
        <th>Thành tiền</th>
    </tr>
    <%
        for (OrderDetail od : orderDetails) {
    %>
    <tr>
        <td><%= od.getProduct_id() %></td>
        <td><%= od.getQuantity() %></td>
        <td><%= od.getPrice() %> VNĐ</td>
        <td><%= od.getQuantity() * od.getPrice() %> VNĐ</td>
    </tr>
    <%
        }
    %>
</table>

<h3>Lịch sử trạng thái</h3>
<table>
    <tr>
        <th>Lúc</th>
        <th>Người thay đổi</th>
        <th>Trạng thái cũ</th>
        <th>Trạng thái mới</th>
        <th>Ghi chú</th>
    </tr>
    <%
        for (OrderStatusHistory h : history) {
    %>
    <tr>
        <td><%= h.getChangeTime() %></td>
        <td><%= h.getChangedBy() %></td>
        <td>
            <%
                String oldSt = "Chờ xác nhận";
                if (h.getOldStatus() == 2) oldSt = "Đã xác nhận";
                else if (h.getOldStatus() == 3) oldSt = "Đang giao";
                else if (h.getOldStatus() == 4) oldSt = "Hoàn thành";
                else if (h.getOldStatus() == 0) oldSt = "Đã hủy";
            %>
            <%= oldSt %>
        </td>
        <td>
            <%
                String newSt = "Chờ xác nhận";
                if (h.getNewStatus() == 2) newSt = "Đã xác nhận";
                else if (h.getNewStatus() == 3) newSt = "Đang giao";
                else if (h.getNewStatus() == 4) newSt = "Hoàn thành";
                else if (h.getNewStatus() == 0) newSt = "Đã hủy";
            %>
            <%= newSt %>
        </td>
        <td><%= h.getNote() %></td>
    </tr>
    <%
        }
    %>
</table>
<br>
<div style="text-align:center;">
    <a href="<%=request.getContextPath()%>/orders">Quay lại danh sách hóa đơn</a>
</div>
</body>
</html>
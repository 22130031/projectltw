package com.banthatlung.Controller;

import com.banthatlung.Dao.OrderDao;
import com.banthatlung.Dao.OrderDetailDao;
import com.banthatlung.Dao.model.Order;
import com.banthatlung.Dao.model.OrderDetail;
import com.banthatlung.Dao.model.OrderStatusHistory;
import com.banthatlung.Dao.db.DBConnect2;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(urlPatterns = {"/orderDetail"})
public class OrderDetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderIdStr = req.getParameter("id");
        if (orderIdStr == null) {
            resp.sendRedirect(req.getContextPath() + "/orders");
            return;
        }
        int orderId = Integer.parseInt(orderIdStr);
        try {
            OrderDao orderDao = new OrderDao();
            OrderDetailDao orderDetailDao = new OrderDetailDao();
            Order order = orderDao.getOrderById(orderId);
            List<OrderDetail> orderDetails = orderDetailDao.getList(orderId);
            List<OrderStatusHistory> history = orderDao.getOrderStatusHistory(orderId);

            req.setAttribute("order", order);
            req.setAttribute("orderDetails", orderDetails);
            req.setAttribute("history", history);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Không lấy được chi tiết hóa đơn!");
        }
        req.getRequestDispatcher("/View/OrderDetail.jsp").forward(req, resp);
    }
}
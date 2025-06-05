package com.banthatlung.Controller;

import com.banthatlung.Dao.OrderDao;
import com.banthatlung.Dao.model.Order;
import com.banthatlung.Dao.db.DBConnect2;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(urlPatterns = {"/orders"})
public class OrderListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("auth") == null) {
            resp.sendRedirect(req.getContextPath() + "/View/login.jsp");
            return;
        }
        String userId = ((com.banthatlung.Dao.model.User) session.getAttribute("auth")).getId();
        try {
            OrderDao orderDao = new OrderDao();
            List<Order> orders = orderDao.getOrdersByUser(userId);
            req.setAttribute("orders", orders);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Không lấy được danh sách hóa đơn!");
        }
        req.getRequestDispatcher("/View/OrderList.jsp").forward(req, resp);
    }
}
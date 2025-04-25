package com.banthatlung.Controller;

import com.banthatlung.Dao.OrderDao;
import com.banthatlung.Dao.OrderDetailDao;
import com.banthatlung.Dao.model.Order;
import com.banthatlung.Dao.model.OrderDetail;
import com.banthatlung.Dao.model.Product;
import com.banthatlung.Dao.model.ProductCart;
import com.banthatlung.services.ProductService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet(urlPatterns = {"/checkOut"})
public class CheckOutController extends HttpServlet {
    OrderDao orderDao = new OrderDao();
    OrderDetailDao orderDetailDao = new OrderDetailDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession(false);

        ProductCart productCart;
        if(session==null){
            System.out.println("session is null");
        }
        HashMap<Integer, ProductCart> cart = (HashMap<Integer, ProductCart>) session.getAttribute("cart");
        try {
            req.setAttribute("cart", cart);
            req.getRequestDispatcher("/View/CheckOut.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        HttpSession session = req.getSession(false);
        HashMap<Integer, ProductCart> cart = (HashMap<Integer, ProductCart>) session.getAttribute("cart");
        int total =0;
        for(Map.Entry<Integer, ProductCart> entry : cart.entrySet()){
            total += entry.getValue().getProduct().getPrice();
        }
        Order order = new Order( name, address, phone, total);
        int id = orderDao.addOrder(order);
        for(Map.Entry<Integer, ProductCart> entry : cart.entrySet()){
            OrderDetail orderDetail = new OrderDetail(id,entry.getValue().getProduct().getId(),entry.getValue().getQuantity(), (int) (entry.getValue().getProduct().getPrice()*entry.getValue().getQuantity()));
            orderDetailDao.addOrderDetail(orderDetail);
        }
        session.setAttribute("cart", null);
        resp.sendRedirect(req.getContextPath()+"/View/checkOutDone.jsp");
    }
}
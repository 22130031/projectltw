package com.banthatlung.Controller;

import com.banthatlung.Dao.model.Product;
import com.banthatlung.Dao.model.ProductCart;
import com.banthatlung.services.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;

@WebServlet(urlPatterns = "/cart/*")
public class CartController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo();
        if (action == null) {
            action = "/";
        }
        switch (action) {
            case "/cart":

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo();
    }

    public void showCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        HashMap<Integer, ProductCart> carts = (HashMap<Integer, ProductCart>) session.getAttribute("cart");
        req.getRequestDispatcher("/View/Cart.jsp").forward(req, resp);
    }

    public static void addToCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = ProductService.getById(id);
        HttpSession session = req.getSession();
        ProductCart productCart;
        HashMap<Integer, ProductCart> cart = (HashMap<Integer, ProductCart>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
            productCart = new ProductCart(1, product);
            cart.put(id, productCart);

        } else {
            if (cart.containsKey(id)) {
                productCart = cart.get(id);
                productCart.increaseQuantity();
            } else {
                productCart = new ProductCart(1, product);
                cart.put(id, productCart);
            }
        }
        session.setAttribute("cart", cart);
        resp.sendRedirect("/View/Cart.jsp");
    }
}

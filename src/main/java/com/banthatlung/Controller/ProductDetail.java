package com.banthatlung.Controller;

import com.banthatlung.Dao.model.Product;
import com.banthatlung.services.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ProductDetail", value = "/product")
public class ProductDetail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pid = req.getParameter("pid");
        ProductService service = new ProductService();
        Product detail = service.getDetail(pid);
        req.setAttribute("pd", detail);
        req.getRequestDispatcher("/View/product-detail.jsp").forward(req, resp);
        System.out.println(detail.getTitle());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

package com.banthatlung.Controller;

import com.banthatlung.Dao.model.Product;
import com.banthatlung.services.ProductService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
@WebServlet(name = "Search",value = "/search")
public class Search extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String search = req.getParameter("search");
        ProductService service = new ProductService();
        List<Product> products = service.search(search);
        req.setAttribute("productList", products);
        req.getRequestDispatcher("/View/home.jsp").forward(req, resp);
    }
}

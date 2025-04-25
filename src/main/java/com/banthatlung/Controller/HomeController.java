package com.banthatlung.Controller;

import com.banthatlung.Dao.model.Brand;
import com.banthatlung.Dao.model.Product;
import com.banthatlung.services.ProductService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductService();
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        int page = 1; // Mặc định trang 1
        int pageSize = 8; // Mỗi trang 8 sản phẩm

        // Lấy tham số page từ request, nếu có
        String pageParam = req.getParameter("page");
        if (pageParam != null && !pageParam.isEmpty()) {
            page = Integer.parseInt(pageParam);
        }

        List<Product> productList = null;
        try {
            productList = productService.getAll(page, pageSize);

            req.setAttribute("productList", productList);

            // Tính số lượng trang để phân trang
            int totalProducts = productService.getTotalProductCount();
            int totalPages = (int) Math.ceil(totalProducts / (double) pageSize);
            req.setAttribute("totalPages", totalPages);
            req.setAttribute("currentPage", page);

            req.getRequestDispatcher("/View/home.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

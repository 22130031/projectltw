package com.banthatlung.Controller;

import com.banthatlung.Dao.model.Product;
import com.banthatlung.Dao.model.Review;
import com.banthatlung.Dao.model.User;
import com.banthatlung.services.ProductService;
import com.banthatlung.services.ReviewService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "ProductDetail", value = "/product")
public class ProductDetail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pid = req.getParameter("pid");
        System.out.println("pid = " + pid);
        ProductService service = new ProductService();
        Product detail = service.getDetail(pid);
        req.setAttribute("pd", detail);

        ReviewService reviewService = new ReviewService();
        List<Review> list = reviewService.getReviewsByProductId(pid);
        req.setAttribute("reviews", list);
        req.getRequestDispatcher("/View/product-detail.jsp").forward(req, resp);
        System.out.println(pid);
    }
}

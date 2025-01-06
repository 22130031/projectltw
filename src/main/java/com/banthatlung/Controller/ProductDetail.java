package com.banthatlung.Controller;

import com.banthatlung.Dao.model.Product;
import com.banthatlung.Dao.model.Review;
import com.banthatlung.Dao.model.User;
import com.banthatlung.services.ProductService;
import com.banthatlung.services.ReviewService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductDetail", value = "/product")
public class ProductDetail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pid = req.getParameter("pid");
        ProductService service = new ProductService();
        Product detail = service.getDetail(pid);
        req.setAttribute("pd", detail);
        ReviewService reviewService = new ReviewService();
        List<Review> list = reviewService.getReviewsByProductId(pid);
        req.setAttribute("reviews", list);
        req.getRequestDispatcher("/View/product-detail.jsp").forward(req, resp);
        System.out.println(pid);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("auth");
        String uid = user.getId();
        int id = Integer.parseInt(req.getParameter("pid"));
        int rating = Integer.parseInt(req.getParameter("rating"));
        String url = req.getParameter("url");
        String reviewText = req.getParameter("reviewText");
        String reviewDate = req.getParameter("reviewDate");

        Review review = new Review("r", id, uid, rating, url, reviewText, reviewDate);
        ReviewService service = new ReviewService();
        service.addReview(review);

        resp.sendRedirect("/product?pid=" + id);
    }
}

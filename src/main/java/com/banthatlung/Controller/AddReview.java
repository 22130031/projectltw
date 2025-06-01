package com.banthatlung.Controller;

import com.banthatlung.Dao.model.Product;
import com.banthatlung.Dao.model.Review;
import com.banthatlung.Dao.model.User;
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

@WebServlet(name = "AddReview", value = "/review")
public class AddReview extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("auth");
        String uid = user.getId();

        String productId = req.getParameter("pid");

        int rating = Integer.parseInt(req.getParameter("rating"));
        String url = req.getParameter("url");
        String reviewText = req.getParameter("reviewText");
        String reviewDate = (Date.valueOf(LocalDate.now())).toString();

        Review review = new Review("r", Integer.parseInt(productId), uid, rating, url, reviewText, reviewDate);
        ReviewService service = new ReviewService();
        service.addReview(review);

        resp.sendRedirect(req.getContextPath() + "/product?pid=" + productId);

    }
}

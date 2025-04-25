package com.banthatlung.Controller;

import com.banthatlung.Dao.FavoriteDao;
import com.banthatlung.Dao.model.Favorite;
import com.banthatlung.Dao.model.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "AddFavoriteServlet", value = "/add-favorite")
public class AddFavoriteServlet extends HttpServlet {
    private final FavoriteDao favoriteDao = new FavoriteDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("auth");
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/View/login.jsp");
            return;
        }

        // Lấy tham số từ form
        String userId = user.getId();
        int productId = Integer.parseInt(req.getParameter("productId"));
        String productName = req.getParameter("productName");
        String imageUrl = req.getParameter("imageUrl");

        // Kiểm tra xem sản phẩm đã trong danh sách yêu thích chưa
        if (favoriteDao.isFavorite(userId, productId)) {
            resp.sendRedirect(req.getContextPath() + "/product-detail?id=" + productId + "&error=Sản phẩm đã trong danh sách yêu thích");
            return;
        }

        // Thêm sản phẩm yêu thích
        Favorite favorite = new Favorite(userId, productId, productName, imageUrl);
        boolean success = favoriteDao.add(favorite);

        // Chuyển hướng lại trang chi tiết sản phẩm
        String redirectUrl = req.getContextPath() + "/product-detail?id=" + productId;
        if (success) {
            redirectUrl += "&success=Thêm vào yêu thích thành công";
        } else {
            redirectUrl += "&error=Có lỗi xảy ra";
        }
        resp.sendRedirect(redirectUrl);
    }
}
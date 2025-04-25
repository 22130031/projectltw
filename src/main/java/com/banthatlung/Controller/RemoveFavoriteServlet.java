package com.banthatlung.Controller;

import com.banthatlung.Dao.FavoriteDao;
import com.banthatlung.Dao.model.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "RemoveFavoriteServlet", value = "/remove-favorite")
public class RemoveFavoriteServlet extends HttpServlet {
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

        // Xóa sản phẩm yêu thích
        boolean success = favoriteDao.delete(userId, productId);

        // Chuyển hướng lại trang danh sách yêu thích
        String redirectUrl = req.getContextPath() + "/favorite";
        if (success) {
            redirectUrl += "?success=Xóa thành công";
        } else {
            redirectUrl += "?error=Có lỗi xảy ra";
        }
        resp.sendRedirect(redirectUrl);
    }
}
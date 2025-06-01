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
import java.util.List;

@WebServlet(name = "FavoriteServlet", value = "/favorite")
public class FavoriteServlet extends HttpServlet {
    private final FavoriteDao favoriteDao = new FavoriteDao();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/View/favorite.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("auth");
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/View/login.jsp");
            return;
        }
        List<Favorite> favoriteProducts = favoriteDao.getAllByUserId(user.getId());

        req.setAttribute("favoriteProducts", favoriteProducts);
        req.getRequestDispatcher("/View/favorite.jsp").forward(req, resp);
    }
}
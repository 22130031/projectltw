package com.banthatlung.Controller;

import com.banthatlung.Dao.db.User;
import com.banthatlung.services.AuthService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("uname");
        String password = req.getParameter("pass");
        AuthService authService = new AuthService();
        User user = authService.checkLogin(username, password);
        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("auth", user);
            resp.sendRedirect(req.getContextPath() +"/View/home.jsp");
        }else {
            req.setAttribute("error", "Invalid username or password");
            req.getRequestDispatcher("/View/Login.jsp").forward(req, resp);
        }
    }
}

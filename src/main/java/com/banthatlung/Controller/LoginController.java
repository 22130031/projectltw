package com.banthatlung.Controller;

import com.banthatlung.Dao.model.User;
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
        String hashpass = PasswordUtils.encryptPassword(password);
        AuthService authService = new AuthService();
        User user = authService.checkLogin(username, hashpass);
        if (user != null) {
            System.out.println("Userid"+user.getId());
            HttpSession session = req.getSession();
            session.setAttribute("auth", user);
            resp.sendRedirect(req.getContextPath() +"/View/profile.jsp");
        }
        else {
            req.setAttribute("error", "Invalid username or password");
            req.getRequestDispatcher("/View/Login.jsp").forward(req, resp);
            req.getRequestDispatcher("/View/checkOut.jsp").forward(req, resp);
        }
    }
}

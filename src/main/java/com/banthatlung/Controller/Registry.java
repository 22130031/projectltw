package com.banthatlung.Controller;

import com.banthatlung.Dao.model.User;
import com.banthatlung.services.AuthService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name = "Registry", value = "/register")
public class Registry extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        AuthService authService = new AuthService();

        String fname = req.getParameter("fullname");
        String uname = req.getParameter("username");
        String pwd = req.getParameter("password");
        String cpwd = req.getParameter("cpassword");

        if (!pwd.equals(cpwd)) {
            resp.getWriter().write("Mật khẩu không khớp");
            return;
        }

        User u = new User();
        u.setUsername(uname);
        u.setName(fname);
        u.setPass(pwd);

        if (authService.register(u)) {
            resp.getWriter().write("Đăng ký thành công");
        } else {
            resp.getWriter().write("Tên tài khoản đã tồn tại");
        }
    }
}

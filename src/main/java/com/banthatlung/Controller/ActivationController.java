package com.banthatlung.Controller;

import com.banthatlung.Dao.model.User;
import com.banthatlung.services.ProfileService;
import com.banthatlung.utils.EmailUtil;
import jakarta.mail.MessagingException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

@WebServlet(name = "ActivationController", value = "/activate")
public class ActivationController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("auth");

        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/View/login.jsp");
            return;
        }

        if ("send".equals(action)) {
            // Generate unique activation token
            String token = UUID.randomUUID().toString();
            session.setAttribute("activationToken", token);

            // Create activation link
            String activationLink = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() +
                    req.getContextPath() + "/activate?action=verify&token=" + token + "&userId=" + user.getId();

            try {
                EmailUtil.sendActivationEmail(user.getEmail(), activationLink);
                req.setAttribute("message", "Email kích hoạt đã được gửi!");
                req.getRequestDispatcher("/View/profile.jsp").forward(req, resp);
            } catch (MessagingException e) {
                req.setAttribute("error", "Không thể gửi email kích hoạt!");
                req.getRequestDispatcher("/View/profile.jsp").forward(req, resp);
            }
        } else if ("verify".equals(action)) {
            String token = req.getParameter("token");
            String userId = req.getParameter("userId");
            String sessionToken = (String) session.getAttribute("activationToken");
            System.out.println(token + " " + userId + " " + sessionToken);
            if (token != null && sessionToken != null && token.equals(sessionToken) && userId.equals(user.getId())) {
                ProfileService profileService = new ProfileService();
                try {
                    boolean updated = profileService.activateUserEmail(user.getId());
                    System.out.println(updated);
                    if (updated) {
                        user.setActivated(true);
                        session.setAttribute("auth", user);
                        session.removeAttribute("activationToken");
                        req.setAttribute("message", "Email đã được kích hoạt thành công!");
                    } else {
                        req.setAttribute("error", "Kích hoạt email không thành công!");
                    }
                } catch (SQLException e) {
                    req.setAttribute("error", "Lỗi hệ thống khi kích hoạt email!");
                }
            } else {
                req.setAttribute("error", "Liên kết kích hoạt không hợp lệ!");
            }
            req.getRequestDispatcher("/View/profile.jsp").forward(req, resp);
        }
    }
}
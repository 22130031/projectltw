package com.banthatlung.Controller;

import com.banthatlung.Dao.UserDao;
import com.banthatlung.Dao.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.json.JSONObject;


import java.io.*;

import java.net.HttpURLConnection;
import java.net.URL;

@WebServlet("/auth/google")
public class GoogleAuthServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");

        // Đọc id_token từ request body
        StringBuilder buffer = new StringBuilder();
        try (BufferedReader reader = request.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
        }

        String jsonString = buffer.toString();
        String idTokenString = jsonString.split("\"id_token\":\"")[1].split("\"")[0];

        try {
            // Gửi yêu cầu xác minh token đến Google
            URL url = new URL("https://oauth2.googleapis.com/tokeninfo?id_token=" + idTokenString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            // Phân tích phản hồi JSON từ Google
            JSONObject tokenInfo = new JSONObject(content.toString());

            if (tokenInfo.has("email")) {
                String userId = tokenInfo.getString("sub");
                String email = tokenInfo.getString("email");
                String name = tokenInfo.optString("name", "");
                String picture = tokenInfo.optString("picture", "");

                // Kiểm tra người dùng trong cơ sở dữ liệu
                UserDao userDao = new UserDao();
                User user = userDao.findUserByEmail(email);

                if (user == null) {
                    // Đăng ký người dùng mới
                    user = new User();
                    user.setEmail(email);
                    user.setName(name);
                    user.setUsername(email);
                    user.setPass(""); // Không dùng mật khẩu
                    user.setImage(picture);
                    user.setRole(0); // Role mặc định
                    userDao.registerUser(user);
                    System.out.println("Registered user: " + userId.toString());
                }

                // Lưu thông tin người dùng vào session
                HttpSession session = request.getSession();
                session.setAttribute("auth", user);

                // Gửi phản hồi thành công
                response.getWriter().write("{\"success\": true, \"message\": \"Đăng nhập thành công\"}");
            } else {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("{\"success\": false, \"message\": \"Token không hợp lệ hoặc hết hạn\"}");
            }
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"success\": false, \"message\": \"Lỗi xác minh token: " + e.getMessage() + "\"}");
        }
    }
}

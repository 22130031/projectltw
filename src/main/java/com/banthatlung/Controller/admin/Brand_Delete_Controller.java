package com.banthatlung.Controller.admin;


import com.banthatlung.Dao.BrandDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/admin_Brands/delete"})
public class Brand_Delete_Controller extends HttpServlet {
    BrandDao brandDao = new BrandDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getParameter("id");
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            brandDao.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect(req.getContextPath() + "/admin_Brands");
    }


}

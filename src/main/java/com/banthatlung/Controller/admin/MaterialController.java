package com.banthatlung.Controller.admin;


import com.banthatlung.Dao.db.CategoryDao;
import com.banthatlung.Dao.db.MaterialDao;
import com.banthatlung.Dao.model.Category;
import com.banthatlung.Dao.model.Material;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin_Material"})
public class MaterialController extends HttpServlet {
    MaterialDao materialDao = new MaterialDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        List<Material> materialList = null;
        try {
            materialList = materialDao.getList();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("materialList", materialList);
        req.getRequestDispatcher("/html_admin/admin_Material.jsp").forward(req, resp);
    }
}

package com.banthatlung.Controller.admin;


import com.banthatlung.Dao.MaterialDao;
import com.banthatlung.Dao.model.Material;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin_Materials"})
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
        req.getRequestDispatcher("/html_admin/admin_Materials.jsp").forward(req, resp);
    }
}

package com.banthatlung.Controller;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

public class SimpleTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/plain");
        resp.getWriter().write("SimpleTestServlet is working!");
    }
}
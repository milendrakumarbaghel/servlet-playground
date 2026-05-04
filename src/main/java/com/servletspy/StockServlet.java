package com.servletspy;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/stock")
public class StockServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        res.setContentType("text/html");

        String productId = req.getParameter("productId");

        if (productId == null) {
            res.getWriter().println("Product ID required");
            return;
        }

        if (productId.equals("1023")) {
            res.getWriter().println("Product: Laptop<br>Stock: 10<br>Status: Available");
        } else if (productId.equals("1024")) {
            res.getWriter().println("Product: Mobile<br>Stock: 0<br>Status: Out of Stock");
        } else {
            res.getWriter().println("Product not found");
        }
    }
}
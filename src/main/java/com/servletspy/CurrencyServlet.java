package com.servletspy;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/convert")
public class CurrencyServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        res.setContentType("text/html");

        try {
            double amount = Double.parseDouble(req.getParameter("amount"));
            String from = req.getParameter("from");
            String to = req.getParameter("to");

            double rate = 0;

            if (from.equals("USD") && to.equals("INR")) {
                rate = 83.0;
            } else if (from.equals("INR") && to.equals("USD")) {
                rate = 1.0 / 83.0;
            } else {
                res.getWriter().println("Conversion not supported");
                return;
            }

            double result = amount * rate;

            res.getWriter().println("Converted Amount: " + result);

        } catch (Exception e) {
            res.getWriter().println("Invalid input");
        }
    }
}
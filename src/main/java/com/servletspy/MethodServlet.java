package com.servletspy;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/method")
public class MethodServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {
        res.getWriter().println("GET request");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {
        res.getWriter().println("POST request");
    }
}
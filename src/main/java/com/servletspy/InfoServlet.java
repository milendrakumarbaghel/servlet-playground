package com.servletspy;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/info")
public class InfoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        res.getWriter().println("URI: " + req.getRequestURI());
        res.getWriter().println("URL: " + req.getRequestURL());
        res.getWriter().println("Context Path: " + req.getContextPath());
        res.getWriter().println("Servlet Path: " + req.getServletPath());
    }
}
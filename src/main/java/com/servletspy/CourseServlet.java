package com.servletspy;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/courses")
public class CourseServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        res.setContentType("text/html");

        String dept = req.getParameter("department");

        if (dept == null) {
            res.getWriter().println("Department required");
            return;
        }

        if (dept.equalsIgnoreCase("CS")) {
            res.getWriter().println("Courses: Java, DSA, DBMS");
        } else if (dept.equalsIgnoreCase("ME")) {
            res.getWriter().println("Courses: Thermodynamics, Fluid Mechanics");
        } else if (dept.equalsIgnoreCase("EE")) {
            res.getWriter().println("Courses: Circuits, Power Systems");
        } else {
            res.getWriter().println("Invalid Department");
        }
    }
}
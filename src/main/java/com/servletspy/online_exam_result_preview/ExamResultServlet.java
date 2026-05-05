package com.servletspy.online_exam_result_preview;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/exam-result")
public class ExamResultServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet Initialized");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String roll = req.getParameter("roll");
        String m1Str = req.getParameter("m1");
        String m2Str = req.getParameter("m2");
        String m3Str = req.getParameter("m3");

        boolean isValid = true;
        int m1 = 0, m2 = 0, m3 = 0;

        // Basic validation
        if (name == null || name.isBlank()) isValid = false;
        if (roll == null || roll.isBlank()) isValid = false;

        try {
            m1 = Integer.parseInt(m1Str);
            m2 = Integer.parseInt(m2Str);
            m3 = Integer.parseInt(m3Str);

            if (m1 < 0 || m1 > 100) isValid = false;
            if (m2 < 0 || m2 > 100) isValid = false;
            if (m3 < 0 || m3 > 100) isValid = false;

        } catch (Exception e) {
            isValid = false;
        }

        if (isValid) {
            int total = m1 + m2 + m3;
            double percentage = total / 3.0;
            String status;

            if (percentage >= 75) status = "Distinction";
            else if (percentage >= 60) status = "First Class";
            else if (percentage >= 40) status = "Pass";
            else status = "Fail";

            // Set attributes
            req.setAttribute("name", name);
            req.setAttribute("roll", roll);
            req.setAttribute("m1", m1);
            req.setAttribute("m2", m2);
            req.setAttribute("m3", m3);
            req.setAttribute("total", total);
            req.setAttribute("percentage", percentage);
            req.setAttribute("status", status);

            // Forward
            req.getRequestDispatcher("/exam_result_preview.jsp").forward(req, resp);
        } else {

            // Redirect back
            resp.sendRedirect("exam_result_form.jsp");
        }
    }

    @Override
    public void destroy() {
        System.out.println("Servlet Destroyed");
    }
}
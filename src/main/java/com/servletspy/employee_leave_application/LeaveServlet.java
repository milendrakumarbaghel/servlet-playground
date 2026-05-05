package com.servletspy.employee_leave_application;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/leave-application")
public class LeaveServlet extends HttpServlet {

    @Override
    public void init() {
        System.out.println("Leave Servlet Initialized");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println("LeaveServlet: doPost called");

        String name = req.getParameter("name");
        String empId = req.getParameter("empId");
        String dept = req.getParameter("dept");
        String type = req.getParameter("type");
        String daysStr = req.getParameter("days");
        String reason = req.getParameter("reason");

        System.out.println("Received - name: " + name + ", empId: " + empId + ", dept: " + dept +
                         ", type: " + type + ", days: " + daysStr + ", reason: " + reason);

        boolean isValid = true;
        int days = 0;

        // Validation
        if (name == null || name.isBlank()) {
            isValid = false;
            System.out.println("Validation failed: name is blank");
        }
        if (empId == null || empId.isBlank()) {
            isValid = false;
            System.out.println("Validation failed: empId is blank");
        }
        if (dept == null || dept.isBlank()) {
            isValid = false;
            System.out.println("Validation failed: dept is blank");
        }
        if (type == null || type.isBlank()) {
            isValid = false;
            System.out.println("Validation failed: type is blank");
        }

        try {
            days = Integer.parseInt(daysStr);
            if (days < 1 || days > 10) {
                isValid = false;
                System.out.println("Validation failed: days out of range: " + days);
            }
        } catch (Exception e) {
            isValid = false;
            System.out.println("Validation failed: days parsing error: " + e.getMessage());
        }

        if (reason == null || reason.trim().length() < 10) {
            isValid = false;
            System.out.println("Validation failed: reason too short or blank");
        }

        if (isValid) {
            System.out.println("LeaveServlet: Validation PASSED - forwarding to review page");

            // Business logic
            String message;

            if (days > 5) {
                message = "This leave request requires manager approval";
            } else {
                message = "This leave request can be processed normally";
            }

            // Set attributes
            req.setAttribute("name", name);
            req.setAttribute("empId", empId);
            req.setAttribute("dept", dept);
            req.setAttribute("type", type);
            req.setAttribute("days", days);
            req.setAttribute("reason", reason);
            req.setAttribute("message", message);

            System.out.println("LeaveServlet: All attributes set. Message: " + message);

            // Forward
            req.getRequestDispatcher("/employee_leave_application_review.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/employee_leave_application.jsp");
        }
    }

    @Override
    public void destroy() {
        System.out.println("Leave Servlet Destroyed");
    }
}

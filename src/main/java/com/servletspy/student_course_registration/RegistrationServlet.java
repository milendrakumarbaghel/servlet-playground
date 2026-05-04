package com.servletspy.student_course_registration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("Servlet Initialized");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String ageStr = req.getParameter("age");
        String course = req.getParameter("course");
        String batch = req.getParameter("batch");

        boolean isValid = true;
        int age = 0;

        // Use RegistrationValidator to centralize validation logic
        if (!RegistrationValidator.isNameValid(name)) isValid = false;
        if (!RegistrationValidator.isEmailValid(email)) isValid = false;

        Integer parsedAge = RegistrationValidator.parseAndValidateAge(ageStr);
        if (parsedAge == null) {
            isValid = false;
        } else {
            age = parsedAge;
        }

        if (!RegistrationValidator.isCourseValid(course)) isValid = false;
        if (!RegistrationValidator.isBatchValid(batch)) isValid = false;

        if(isValid) {
            req.setAttribute("name", name);
            req.setAttribute("email", email);
            req.setAttribute("age", age);
            req.setAttribute("course", course);
            req.setAttribute("batch", batch);

            req.getRequestDispatcher("/success.jsp").forward(req, resp);

        } else {
            resp.sendRedirect(req.getContextPath() + "/register.jsp");
        }
    }

    @Override
    public void destroy() {
        System.out.println("Servlet Destroyed");
    }
}

package com.servletspy.student_course_registration;

import com.servletspy.dao.StudentCourseRegistrationDao;
import com.servletspy.model.StudentCourseRegistration;
import jakarta.servlet.Registration;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/register")
public class StudentCourseRegistrationServlet extends HttpServlet {
    StudentCourseRegistrationDao studentCourseRegistrationDao = new StudentCourseRegistrationDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        if ("delete".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            studentCourseRegistrationDao.delete(id);
            resp.sendRedirect("register");

        } else if ("edit".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            StudentCourseRegistration studentCourseRegistration = studentCourseRegistrationDao.getById(id);
            req.setAttribute("reg", studentCourseRegistration);
            req.getRequestDispatcher("edit.jsp").forward(req, resp);

        } else {
            List<StudentCourseRegistration> list = studentCourseRegistrationDao.getAllRegistrations();
            req.setAttribute("list", list);
            req.getRequestDispatcher("list.jsp").forward(req, resp);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String idStr = req.getParameter("id");
        StudentCourseRegistration studentCourseRegistration = new StudentCourseRegistration();
        studentCourseRegistration.setName(req.getParameter("name"));
        studentCourseRegistration.setEmail(req.getParameter("email"));
        studentCourseRegistration.setAge(Integer.parseInt(req.getParameter("age")));
        studentCourseRegistration.setCourse(req.getParameter("course"));
        studentCourseRegistration.setBatch(req.getParameter("batch"));

        if (idStr == null || idStr.isEmpty()) {
            studentCourseRegistrationDao.add(studentCourseRegistration); // CREATE
        } else {
            studentCourseRegistration.setId(Integer.parseInt(idStr));
            studentCourseRegistrationDao.update(studentCourseRegistration); // UPDATE
        }

        resp.sendRedirect("register");
    }

}
package com.servletspy;

import com.servletspy.utils.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        String user = req.getParameter("username");
        String pass = req.getParameter("password");

        boolean isValid = DBUtil.checkUser(user, pass);

        if (isValid) {
            req.setAttribute("msg", "Login Successful");
        } else {
            req.setAttribute("msg", "Invalid Credentials");
        }

        req.getRequestDispatcher("/loginResult.jsp").forward(req, res);
    }
}
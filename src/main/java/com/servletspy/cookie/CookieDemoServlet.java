package com.servletspy.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cookie")
public class CookieDemoServlet extends HttpServlet {

    private static final String COOKIE_NAME = "visitorName";

    @Override
    public void init() {
        System.out.println("CookieDemoServlet initialized");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setAttribute("currentCookieValue", getCookieValue(req));
        req.getRequestDispatcher("/cookie.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String action = req.getParameter("action");

        if ("clear".equalsIgnoreCase(action)) {
            Cookie cookie = new Cookie(COOKIE_NAME, "");
            cookie.setPath(req.getContextPath());
            cookie.setMaxAge(0);
            cookie.setHttpOnly(true);
            resp.addCookie(cookie);
        } else {
            String value = req.getParameter("value");
            if (value != null && !value.isBlank()) {
                Cookie cookie = new Cookie(COOKIE_NAME, value.trim());
                cookie.setPath(req.getContextPath());
                cookie.setMaxAge(60 * 60 * 24 * 7); // 7 days
                cookie.setHttpOnly(true);
                resp.addCookie(cookie);
            }
        }

        resp.sendRedirect(req.getContextPath() + "/cookie");
    }

    private String getCookieValue(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        if (cookies == null) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (COOKIE_NAME.equals(cookie.getName())) {
                return cookie.getValue();
            }
        }
        return null;
    }


    @Override
    public void destroy() {
        System.out.println("CookieDemoServlet destroyed");
    }
}



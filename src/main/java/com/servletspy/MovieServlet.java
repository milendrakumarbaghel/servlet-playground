package com.servletspy;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/rating")
public class MovieServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        res.setContentType("text/html");

        String movie = req.getParameter("movieName");

        if (movie == null || movie.isEmpty()) {
            res.getWriter().println("Movie name required");
            return;
        }

        if (movie.equalsIgnoreCase("Inception")) {
            res.getWriter().println("Rating: 8.8<br>Genre: Sci-Fi<br>Reviews: Excellent");
        } else if (movie.equalsIgnoreCase("Interstellar")) {
            res.getWriter().println("Rating: 8.6<br>Genre: Sci-Fi<br>Reviews: Mind-blowing");
        } else {
            res.getWriter().println("Movie not found");
        }
    }
}
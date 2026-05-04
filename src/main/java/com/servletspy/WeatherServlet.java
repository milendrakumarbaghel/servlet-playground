package com.servletspy;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/weather")
public class WeatherServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        res.setContentType("text/html");

        String city = req.getParameter("city");

        if (city == null || city.trim().isEmpty()) {
            res.getWriter().println("Error: City cannot be empty");
            return;
        }

        String output;

        if (city.equalsIgnoreCase("Seoni")) {
            output = "Temp: 39°C, Humidity: 60%, Forecast: Hot";
        } else if (city.equalsIgnoreCase("Indore")) {
            output = "Temp: 42°C, Humidity: 80%, Forecast: Very Hot";
        } else {
            output = "Error: City not found";
        }

        res.getWriter().println("<h2>Weather for " + city + "</h2>");
        res.getWriter().println(output);
    }
}
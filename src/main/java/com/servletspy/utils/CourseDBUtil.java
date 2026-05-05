package com.servletspy.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class CourseDBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/course_db";
    private static final String USER = "root";
    private static final String PASS = "admin";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASS);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

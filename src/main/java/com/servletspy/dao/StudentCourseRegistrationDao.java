package com.servletspy.dao;

import com.servletspy.model.StudentCourseRegistration;
import com.servletspy.utils.CourseDBUtil;
import com.servletspy.utils.DBUtil;
import jakarta.servlet.Registration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentCourseRegistrationDao {
    public void add(StudentCourseRegistration studentCourseRegistration) {
        String query = "INSERT INTO registrations(name,email,age,course,batch) VALUES (?,?,?,?,?)";

        try(Connection connection = CourseDBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, studentCourseRegistration.getName());
            preparedStatement.setString(2, studentCourseRegistration.getEmail());
            preparedStatement.setInt(3, studentCourseRegistration.getAge());
            preparedStatement.setString(4, studentCourseRegistration.getCourse());
            preparedStatement.setString(5, studentCourseRegistration.getBatch());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<StudentCourseRegistration> getAllRegistrations() {
        List<StudentCourseRegistration> list = new ArrayList<>();

        String query = "SELECT * FROM registrations";

        try(Connection connection = CourseDBUtil.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)) {

            while(resultSet.next()) {
                StudentCourseRegistration studentCourseRegistration = new StudentCourseRegistration();
                studentCourseRegistration.setId(resultSet.getInt("id"));
                studentCourseRegistration.setName(resultSet.getString("name"));
                studentCourseRegistration.setEmail(resultSet.getString("email"));
                studentCourseRegistration.setAge(resultSet.getInt("age"));
                studentCourseRegistration.setCourse(resultSet.getString("course"));
                studentCourseRegistration.setBatch(resultSet.getString("batch"));
                list.add(studentCourseRegistration);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public void delete(int id) {
        String sql = "DELETE FROM registrations WHERE id=?";
        try (Connection con = CourseDBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public StudentCourseRegistration getById(int id) {
        String sql = "SELECT * FROM registrations WHERE id=?";

        StudentCourseRegistration studentCourseRegistration = null;
        try (Connection con = CourseDBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                studentCourseRegistration = new StudentCourseRegistration();
                studentCourseRegistration.setId(id);
                studentCourseRegistration.setName(rs.getString("name"));
                studentCourseRegistration.setEmail(rs.getString("email"));
                studentCourseRegistration.setAge(rs.getInt("age"));
                studentCourseRegistration.setCourse(rs.getString("course"));
                studentCourseRegistration.setBatch(rs.getString("batch"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return studentCourseRegistration;
    }

    public void update(StudentCourseRegistration studentCourseRegistration) {
        String query = "UPDATE registrations SET name=?, email=?, age=?, course=?, batch=? WHERE id=?";

        try (Connection con = CourseDBUtil.getConnection();

             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, studentCourseRegistration.getName());
            ps.setString(2, studentCourseRegistration.getEmail());
            ps.setInt(3, studentCourseRegistration.getAge());
            ps.setString(4, studentCourseRegistration.getCourse());
            ps.setString(5, studentCourseRegistration.getBatch());
            ps.setInt(6, studentCourseRegistration.getId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

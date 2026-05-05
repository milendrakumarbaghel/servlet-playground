<%@ page import="java.util.List, com.servletspy.model.StudentCourseRegistration" %><%--
  Created by IntelliJ IDEA.
  User: milendrakumarbaghel
  Date: 04/05/26
  Time: 4:34 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Registrations</title>
</head>
<body>
<h2>Registrations</h2>
<a href="form.jsp">Add New</a>
<table border="1">

    <tr>
        <th>ID</th><th>Name</th><th>Email</th><th>Age</th><th>Course</th><th>Batch</th><th>Action</th>
    </tr>

    <%
        List<StudentCourseRegistration> list = (List<StudentCourseRegistration>) request.getAttribute("list");
        for(StudentCourseRegistration r : list){
    %>

    <tr>
        <td><%= r.getId() %></td>
        <td><%= r.getName() %></td>
        <td><%= r.getEmail() %></td>
        <td><%= r.getAge() %></td>
        <td><%= r.getCourse() %></td>
        <td><%= r.getBatch() %></td>
        <td>
            <a href="register?action=edit&id=<%= r.getId() %>">Edit</a>
            <a href="register?action=delete&id=<%= r.getId() %>">Delete</a>
        </td>
    </tr>
    <% } %>
</table>
</body>
</html>

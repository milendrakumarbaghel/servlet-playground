<%--
  Created by IntelliJ IDEA.
  User: milendrakumarbaghel
  Date: 30/04/26
  Time: 11:48 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Page</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/student-course-register" method="post">

        Name: <input type="text" name="name"><br><br>
        Email: <input type="email" name="email"><br><br>
        Age: <input type="number" name="age"><br><br>

        Course:
        <select name="course">
            <option value="">Select</option>
            <option>Java Full Stack</option>
            <option>Python Full Stack</option>
            <option>MERN Stack</option>
            <option>Data Analytics</option>
        </select><br><br>

        Batch:
        <select name="batch">
            <option value="">Select</option>
            <option>Morning</option>
            <option>Afternoon</option>
            <option>Evening</option>
        </select><br><br>

        <button type="submit">Register</button>
    </form>
</body>
</html>

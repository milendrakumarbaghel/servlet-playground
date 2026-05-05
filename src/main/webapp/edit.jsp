<%--
  Created by IntelliJ IDEA.
  User: milendrakumarbaghel
  Date: 04/05/26
  Time: 4:39 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Edit Registration Details</title>
</head>
<body>
<form action="register" method="post">
    <input type="hidden" name="id" value="${reg.id}">
    Name: <input type="text" name="name" value="${reg.name}"><br>
    Email: <input type="text" name="email" value="${reg.email}"><br>
    Age: <input type="number" name="age" value="${reg.age}"><br>
    Course: <input type="text" name="course" value="${reg.course}"><br>
    Batch: <input type="text" name="batch" value="${reg.batch}"><br>

    <button type="submit">Update</button>
</form>
</body>
</html>

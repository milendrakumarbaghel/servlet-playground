<%--
  Created by IntelliJ IDEA.
  User: milendrakumarbaghel
  Date: 04/05/26
  Time: 4:46 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Student Course Registration</title>
</head>
<body>
<h2>Student Course Registration</h2>

<form action="register" method="post">

    Name: <input type="text" name="name" required><br><br>
    Email: <input type="email" name="email" required><br><br>
    Age: <input type="number" name="age" min="1" required><br><br>

    Course:
    <select name="course" required>
        <option value="">--Select Course--</option>
        <option value="Java">Java</option>
        <option value="Python">Python</option>
        <option value="Web Development">Web Development</option>
    </select>

    <br><br>

    Batch:
    <select name="batch" required>
        <option value="">--Select Batch--</option>
        <option value="Morning">Morning</option>
        <option value="Afternoon">Afternoon</option>
        <option value="Evening">Evening</option>
    </select>

    <br><br>
    <button type="submit">Register</button>

</form>
<br>

<a href="register">View All Registrations</a>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: milendrakumarbaghel
  Date: 04/05/26
  Time: 1:03 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Leave Application</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/leave-application" method="post">
        Name: <input type="text" name="name"><br><br>
        Employee ID: <input type="text" name="empId"><br><br>
        Department: <input type="text" name="dept"><br><br>

        Leave Type:
        <select name="type">
            <option value="">Select</option>
            <option>Sick Leave</option
            <option>Casual Leave</option>
            <option>Emergency Leave</option>
            <option>Work From Home</option>
        </select><br><br>

        Leave Days: <input type="number" name="days"><br><br>

        Reason:<br>
        <textarea name="reason"></textarea><br><br>

        <button type="submit">Apply</button>
    </form>
</body>
</html>

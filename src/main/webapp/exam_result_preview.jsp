<%--
  Exam Result Preview Page - Display calculated results
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Result</title>
</head>
<body>

<h2>Result Preview</h2>

Name: ${name} <br>
Roll No: ${roll} <br><br>

Marks:<br>
Subject 1: ${m1} <br>
Subject 2: ${m2} <br>
Subject 3: ${m3} <br><br>

Total: ${total} <br>
Percentage: ${percentage} % <br>
Status: ${status} <br>

</body>
</html>
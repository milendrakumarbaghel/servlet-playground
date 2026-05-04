<%--
  Created by IntelliJ IDEA.
  User: milendrakumarbaghel
  Date: 29/04/26
  Time: 2:49 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result Page</title>
</head>
<body>

<h2>This is Result JSP</h2>

<p>
    Message from Servlet:
    <%= request.getAttribute("msg") %>
</p>

</body>
</html>

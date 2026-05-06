<%--
  Cookie Demo Page
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cookie Demo</title>
    <style>
        body { font-family: Arial, sans-serif; max-width: 700px; margin: 40px auto; padding: 20px; }
        .box { border: 1px solid #ddd; padding: 20px; border-radius: 8px; margin-bottom: 20px; }
        input, button { padding: 10px; font-size: 14px; }
        button { cursor: pointer; }
        .value { font-weight: bold; color: #1565c0; }
    </style>
</head>
<body>
    <h1>Cookie Demo</h1>

    <div class="box">
        <p>Current cookie value for <code>visitorName</code>:</p>
        <p class="value"><%= request.getAttribute("currentCookieValue") != null ? request.getAttribute("currentCookieValue") : "[not set]" %></p>
    </div>

    <div class="box">
        <h3>Set Cookie</h3>
        <form action="${pageContext.request.contextPath}/cookie" method="post">
            <input type="hidden" name="action" value="set">
            <input type="text" name="value" placeholder="Enter your name">
            <button type="submit">Save Cookie</button>
        </form>
    </div>

    <div class="box">
        <h3>Clear Cookie</h3>
        <form action="${pageContext.request.contextPath}/cookie" method="post">
            <input type="hidden" name="action" value="clear">
            <button type="submit">Clear Cookie</button>
        </form>
    </div>

    <p>
        <a href="${pageContext.request.contextPath}/index.jsp">Back to Home</a>
    </p>
</body>
</html>


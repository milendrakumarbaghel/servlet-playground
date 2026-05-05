<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Exam Form</title>
</head>
<body>

<h2>Enter Exam Details</h2>

<form action="${pageContext.request.contextPath}/exam-result" method="post">

    Name: <input type="text" name="name"><br><br>
    Roll No: <input type="text" name="roll"><br><br>

    Subject 1: <input type="text" name="m1"><br><br>
    Subject 2: <input type="text" name="m2"><br><br>
    Subject 3: <input type="text" name="m3"><br><br>

    <button type="submit">Calculate Result</button>

</form>

</body>
</html>
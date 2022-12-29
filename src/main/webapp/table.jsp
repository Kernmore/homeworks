<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 29.12.2022
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Table</title>
</head>
<body>

<h2> Your answers are below: </h2>

<table border="1">

    <c:forEach items="${answerList}" var="i">
    <tr>
        <td><c:out value="${i.getQuestion()}"/> </td>
        <td><c:out value="${i.getAnswer()}"/> </td>
    </tr>
    </c:forEach>
</table>

<br> <a href="/">Go Back</a>

</body>
</html>

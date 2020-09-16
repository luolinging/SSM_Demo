<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>list</title>
    </head>
    <body>
        <h3>查询了学生的信息</h3>
        <c:forEach items="${list}" var="student">
            ${student.id}
        </c:forEach>
    </body>
</html>

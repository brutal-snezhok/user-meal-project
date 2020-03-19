<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Meals</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>
<table>
    <c:forEach items="${meals}" var="meal">
        <tr>
                <c:choose>
                    <c:when test="${meal.excess}">
                        <td bgcolor="red"> <c:out value="${meal}"/></td>
                    </c:when>
                    <c:otherwise>
                        <td bgcolor="green"> <c:out value="${meal}"/></td>
                    </c:otherwise>
                </c:choose>
        </tr>
    </c:forEach>
</table>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11.01.2021
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<ul>
    <c:forEach items="${languages}" var="lang">
        <li><c:out value="${lang}"/></li>
    </c:forEach>
</ul>
<c:out value="${requestScope.attr2.id}"/><br/>
<c:out value="${sessionScope.attr1}"/><br/>
<c:out value="${applicationScope.attr3}"/><br/>
</body>
</html>
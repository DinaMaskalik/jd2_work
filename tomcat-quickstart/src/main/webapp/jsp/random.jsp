<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11.01.2021
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Random Number</h1>
<%! String s="Hello "; %>
<% s = s + "world!"; %>
<h1><%=s%></h1>
<h2><%= Math.random() %></h2>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="salary" scope="session" value="${500*3}"/>
<c:out value="${salary}"/>

<c:choose>
    <c:when test="${salary>1000}">
        I am rich
    </c:when>
    <c:otherwise>
        I am poor
    </c:otherwise>
</c:choose>
</body>
</html>

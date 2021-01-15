<%--
  Created by IntelliJ IDEA.
  User: Dina Maskalik
  Date: 15.01.2021
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
<div width="100%">
    <table style="width:80%" border="1">
        <tr>
            <th>URL</th>
            <c:forEach items="${terms}" var="term">
            <td>${term}</td>
            </c:forEach>
            <th>TOTAL</th>

        </tr>
        <c:forEach items="${result.resultItemDtoList}" var="item">

            <tr>
                <td>${item.searchUrl}</td>
            <c:forEach items="${terms}" var="term">
                <td>${item.termsCountMap[term]}</td>
            </c:forEach>
            <td>XXX</td>
            </tr>
        </c:forEach>
    </table>

    <br>
    <a href="/web-crawler">Back</a>
    </br>
</div>
</body>
</html>

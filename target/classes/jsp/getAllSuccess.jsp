<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Website Result</title>
</head>
<body>
    <h1>Success</h1>

    <h4>All websites</h4>
    <table align="left" border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>URL</th>
            <th>Country</th>
        </tr>
        <c:forEach items="${websiteList}" var="website">
        <tr>
            <td>${website.id}</td>
            <td>${website.name}</td>
            <td>${website.url}</td>
            <td>${website.country}</td>
        </tr>
        </c:forEach>
    </table>

</body>
</html>

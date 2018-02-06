<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 04.02.2018
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/main.css">
</head>
<body>
<h1>Hello!!!</h1>

<form action="/saveUser" method="post" enctype="multipart/form-data">
    <input type="" name="name" placeholder="name">
    <input type="file" name="avatar" placeholder="avatar">
    <input type="email" name="email" placeholder="email">
    <input type="submit" name="" placeholder="">

    <br>

    <c:forEach items="${users}" var="user">
        <h2>${user.name}</h2>
        <img src="${user.avatar}" alt="">
    </c:forEach>

</form>

</body>
</html>

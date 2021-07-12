<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="/admin/login" method="post">
    <input type="text" name="uid" placeholder="id">
    <input type="password" name="upw" placeholder="pw">
    <input type="submit" value="로그인">
</form>
</body>
</html>
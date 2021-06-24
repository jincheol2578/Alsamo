<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021-06-23
  Time: 오전 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>아이디/비밀번호 찾기</title>
</head>
<body>
<form action="/user/findPw" method="post">
    <input type="text" name="uid" placeholder="찾으실 아이디 입력">
    <input type="text" name="uemail" placeholder="이메일 입력">
    <input type="submit" value="찾기">
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021-06-23
  Time: 오후 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>아이디 찾기</title>
</head>
<body>
<div><h3>ID : ${requestScope.user.uid}</h3></div>
<form action="/user/findId" method="post">
    <input type="text" name="uemail" placeholder="이메일 입력">
    <input type="text" name="uid" placeholder="이름 입력">
    <input type="submit" value="찾기">
</form>
<div><a href="/user/login">
    <button>로그인</button>
</a></div>

</body>
</html>

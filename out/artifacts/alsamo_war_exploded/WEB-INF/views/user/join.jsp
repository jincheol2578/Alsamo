<%--
  Created by IntelliJ IDEA.
  User: heck_
  Date: 2021-06-12
  Time: 오후 6:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
<form action="/user/join" method="post">
    <div><input type="text" name="uid" placeholder="아이디"></div>
    <div><input type="text" name="upw" placeholder="비밀번호"></div>
    <div><input type="text" name="unm" placeholder="이름"></div>
    <div><input type="text" name="uemail" placeholder="이메일"></div>
    <div><input type="submit" value="회원가입">
        <a href="/user/login">
            <button>로그인화면</button>
        </a></div>
</form>
</body>
</html>

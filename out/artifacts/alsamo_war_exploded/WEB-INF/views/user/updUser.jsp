<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021-06-23
  Time: 오전 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원정보 수정</title>
</head>
<body>
<form action="/user/updUser" method="post">
    <div><input type="email" name="uemail" placeholder="이메일" value="${requestScope.uemail}" readonly></div>
    <div><input type="password" name="upw" placeholder="비밀번호"></div>
    <div><input type="submit" value="비밀번호 수정">
        <a href="/user/login">
            <button>로그인화면</button>
        </a></div>
</form>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<%-- 구글이 준 세션 정보만 알아내면 googleJoin이랑 여기랑 합칠것 --%>
</body>
</html>
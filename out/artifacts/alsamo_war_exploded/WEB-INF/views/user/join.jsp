<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
<form>
    <input type="text" name="uid" placeholder="아이디">
    <input type="password" name="upw" placeholder="비밀번호">
    <input type="password" name="upwChk" placeholder="비밀번호확인">
    <input type="email" name="uemail" placeholder="ex)email@example.com">
    <input type="text" name="unm" placeholder="닉네임">
    <input type="submit" value="회원가입">
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: heck_
  Date: 2021-06-19
  Time: 오전 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>구글 회원가입</title>
    <script defer src="/res/js/googleLogin.js"></script>
</head>
<body>

<form id="frm" action="/user/join" method="post">
    <div> 아이디 : <input type="text" name="Glooglesuid" value="${requestScope.googlesUser.uid}" ></div>
    <div> 이름 : <input type="text" name="Glooglesunm" value="${requestScope.googlesUser.unm}"></div>
    <div>이메일 : <input type="text" name="Glooglesuemail" value="${requestScope.googlesUser.uemail}"></div>
    <input type="submit" value="회원가입">
</form>

</body>
</html>

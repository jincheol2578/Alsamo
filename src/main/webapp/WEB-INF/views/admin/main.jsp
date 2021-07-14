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
<button onclick="regCategory()">test</button>

<div>
    태그
<form id="tag" onsubmit="regTag();">
    <input type="text" id="tname">
</form>
    <form onsubmit="regCategory()">
        <input type="text" id="category">
    </form>
    <div id="blockTag"></div>
</div>
    <script src="/res/js/admin/admin.js"></script>
</body>
</html>
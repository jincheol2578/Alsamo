<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
    <div>${requestScope.board.title}</div>
    <div>${requestScope.board.content}</div>
    <div>${requestScope.board.regdate}</div>
    <div>${requestScope.board.writer}</div>
    <a href="/board/write?bcode=${param.bcode}&iboard=${param.iboard}">답글</a>
</body>
</html>

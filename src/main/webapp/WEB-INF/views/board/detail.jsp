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
<form action="delete" method="post" >
        <input type="hidden" name="bcode" value="${param.bcode}">
        <input type="hidden" name="iboard" value="${param.iboard}">
        <input type="submit" value="삭제">
</form>

</body>
</html>

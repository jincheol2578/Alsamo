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

    <c:if test="${sessionScope.loginUser.iuser eq requestScope.board.iuser}">
<%--        TODO: js로 폼태그안에 submit 말고 button으로 만들어서 post나 get방식 선택할수있게 만들기--%>
    <form action="delete" method="post" >
        <input type="hidden" name="bcode" value="${param.bcode}">
        <input type="hidden" name="iboard" value="${param.iboard}">
        <input type="hidden" name="iuser" value="${requestScope.board.iuser}">
        <input type="submit" value="삭제">
    </form>
        <a href="/board/write?bcode=${param.bcode}&iboard=${param.iboard}&edit=1">수정</a>
    </c:if>

</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>${requestScope.board.title}</div>
<div>${requestScope.board.content}</div>
<div>${requestScope.board.regdate}</div>
<div>${requestScope.board.writer}</div>
<a href="/board/write?bcode=${param.bcode}&iboard=${param.iboard}">답글</a>

<c:if test="${sessionScope.loginUser.iuser eq requestScope.board.iuser}">
    <%--        TODO: js로 폼태그안에 submit 말고 button으로 만들어서 post나 get방식 선택할수있게 만들기--%>
    <a href="/board/delete?bcode=${param.bcode}&iboard=${param.iboard}&delete=1">삭제</a>
    <a href="/board/modify?bcode=${param.bcode}&iboard=${param.iboard}&modify=1">수정</a>
</c:if>

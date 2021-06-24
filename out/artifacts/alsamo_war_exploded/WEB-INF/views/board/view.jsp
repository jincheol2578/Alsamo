<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>${requestScope.board.btitle}</div>
<div>${requestScope.board.bctnt}</div>
<div>${requestScope.board.brdt}</div>
<div>${requestScope.board.writer}</div>
<a href="/board/write?bcd=${param.bcd}&bno=${param.bno}">답글</a>

<c:if test="${sessionScope.loginUser.uno eq requestScope.board.uno}">
    <%--        TODO: js로 폼태그안에 submit 말고 button으로 만들어서 post나 get방식 선택할수있게 만들기--%>
    <a href="/board/delete?bcd=${param.bcd}&bno=${param.bno}&delete=1">삭제</a>
    <a href="/board/modify?bcd=${param.bcd}&bno=${param.bno}&modify=1">수정</a>
</c:if>

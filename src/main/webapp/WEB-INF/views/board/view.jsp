<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="viewContainer">
    <div class="title-row">
        <div class="boardtitle">
            <span>${requestScope.board.btitle}</span>
        </div>
    </div>
    <div class="boardInfo-row">
        <div class="memberInfo">
            <span class="writerInfo">${requestScope.board.writer}</span>
        </div>
        <div class="boardInfo">
            <span class="infoBody">${requestScope.board.brdt}</span>
            <span class="infoHead">작성일</span>
        </div>

    </div>
    <div class="boardCtnt-row">
        <div class="boardCtnt">
            <span>${requestScope.board.bctnt}</span>
        </div>
    </div>

    <a href="/board/write?bcd=${param.bcd}&bno=${param.bno}">답글</a>

    <c:if test="${sessionScope.loginUser.uno eq requestScope.board.uno}">
        <%--        TODO: js로 폼태그안에 submit 말고 button으로 만들어서 post나 get방식 선택할수있게 만들기--%>
        <a href="/board/delete?bcd=${param.bcd}&bno=${param.bno}&delete=1">삭제</a>
        <a href="/board/modify?bcd=${param.bcd}&bno=${param.bno}&modify=1">수정</a>
    </c:if>
</div>

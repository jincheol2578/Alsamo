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
<%-- TODO:추천, 비추천버튼 만들기--%>
<form id="repFrm" onsubmit="return false;">
    <c:if test="${empty sessionScope.loginUser}">
        <input type="text" id="repnm" placeholder="이름">
        <input type="password" id="reppw" placeholder="비밀번호">
    </c:if>
    <textarea id="repctnt" placeholder="댓글을 입력하세요"></textarea>
    <input type="button" id="insBtn" value="작성">
</form>
<div id="replyList" data-user-pk="${sessionScope.loginUser.uno}"></div>

<script defer src="/res/js/board/view.js?ver=5"></script>
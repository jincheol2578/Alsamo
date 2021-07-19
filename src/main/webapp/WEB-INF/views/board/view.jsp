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
    <div class="boardRec-row">
        <div class="recBody">
            <button type="button" id="upRecBtn">
                <%--                <img src="">--%>
                업
                <span id="cntUp"></span>
            </button>
            <button tpye="button" id="downRecBtn">
                다운
                <span id="cntDown"></span>
            </button>
        </div>
    </div>


    <a href="/board/write?bcd=${param.bcd}&bno=${param.bno}">답글</a>

    <c:if test="${sessionScope.loginUser.uno eq requestScope.board.uno || requestScope.board.uno == 0}">
        <a href="/board/delete?bcd=${param.bcd}&bno=${param.bno}&delete=1">삭제</a>
        <a href="/board/modify?bcd=${param.bcd}&bno=${param.bno}&modify=1">수정</a>
    </c:if>

    <form id="repFrm" onsubmit="return false;">
        <c:if test="${empty sessionScope.loginUser}">
            <input type="text" id="repnm" placeholder="이름">
            <input type="password" id="reppw" placeholder="비밀번호">
        </c:if>
        <textarea id="repctnt" placeholder="댓글을 입력하세요"></textarea>
        <input type="button" id="insBtn" value="작성">
    </form>
    <div id="replyList" data-user-pk="${sessionScope.loginUser.uno}"></div>

</div>
<script defer src="/res/js/board/view.js?ver=16"></script>
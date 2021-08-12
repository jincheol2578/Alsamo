<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="containerCenter">
    <div class="viewContainer">
        <div class="title-row">
            <h1 class="boardtitle">${requestScope.board.btitle}</h1>
        </div>
        <div class="boardInfo-row">
            <div class="memberInfo">
                <p class="writerInfo">${requestScope.board.writer}</p>
            </div>
            <div class="boardInfo">
                <p class="infoBody">${requestScope.board.brdt}</p>
            </div>

        </div>
        <div class="boardCtnt-row">
            <div class="boardCtnt">
                <span>${requestScope.board.bctnt}</span>
            </div>
        </div>
        <div class="boardRec-row">

            <button type="button" class="btn btn-outline-secondary" id="upRecBtn">
                업
                <i class="far fa-thumbs-up"></i>
                <span id="cntUp"></span>
            </button>
            <button tpye="button" class="btn btn-outline-secondary" id="downRecBtn">
                다운
                <i class="far fa-thumbs-down"></i>
                <span id="cntDown"></span>
            </button>

        </div>
        <div class="ReplyDelUpdContainer">
            <button class="btn btn-outline-secondary"><a href="/board/write?bcd=${param.bcd}&bno=${param.bno}">답글</a>
            </button>

            <c:if test="${sessionScope.loginUser.uno eq requestScope.board.uno || requestScope.board.uno == 0}">
                <button class="btn btn-outline-secondary"><a href="/board/delete?bcd=${param.bcd}&bno=${param.bno}&delete=1">삭제</a>
                </button>
                <button class="btn btn-outline-secondary"><a href="/board/modify?bcd=${param.bcd}&bno=${param.bno}&modify=1">수정</a>
                </button>
            </c:if>
            <c:if test="${sessionScope.loginUser.authno eq 1 || sessionScope.loginUser.authno eq 2}">
                <button id="regNotice" class="btn btn-outline-secondary"></button>
            </c:if>
        </div>
        <div class="repFrmContainer">
            <form id="repFrm" onsubmit="return false;">
                <div class="repIdPwContainer">
                    <c:if test="${empty sessionScope.loginUser}">
                        <input type="text" class="form-control" id="repnm" maxlength="11" placeholder="이름">
                        <input type="password" class="form-control" id="reppw" maxlength="10" placeholder="비밀번호">
                    </c:if>
                </div>
                <div class="repTxtArea">
                    <textarea id="repctnt" class="form-control" maxlength="600" placeholder="댓글을 입력하세요"></textarea>
                </div>
                <div class="repBtn">
                    <input type="button" class="btn btn-secondary" id="insBtn" value="작성">
                </div>
            </form>
            <div id="replyList" data-user-pk="${sessionScope.loginUser.uno}"></div>
        </div>

    </div>
</div>


<script defer src="/res/js/board/view.js"></script>
<link href="/res/css/board/view.css" rel="stylesheet"/>
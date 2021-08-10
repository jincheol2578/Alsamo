<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="containerCenter">
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
            <a href="/board/write?bcd=${param.bcd}&bno=${param.bno}">답글</a>

            <c:if test="${sessionScope.loginUser.uno eq requestScope.board.uno || requestScope.board.uno == 0}">
                <a href="/board/delete?bcd=${param.bcd}&bno=${param.bno}&delete=1">삭제</a>
                <a href="/board/modify?bcd=${param.bcd}&bno=${param.bno}&modify=1">수정</a>
            </c:if>
        </div>
        <div class="repFrmContainer">
            <form id="repFrm" onsubmit="return false;">
                <div class="repIdPwContainer">
                    <c:choose>
                        <c:when test="${empty sessionScope.loginUser}">
                            <input type="text" class="form-control" id="repnm" placeholder="이름">
                            <input type="password" class="form-control" id="reppw" placeholder="비밀번호">
                        </c:when>
                        <c:otherwise>
                            <input type="text" class="form-control" value="${sessionScope.loginUser.uid}" id="repnm"
                                   placeholder="이름" readonly>
                            <input type="password" class="form-control" id="reppw" placeholder="비밀번호" readonly>
                        </c:otherwise>
                    </c:choose>
                    <input type="button" class="btn btn-secondary" id="insBtn" value="작성">
                </div>
                <div class="repTxtArea">
                    <textarea id="repctnt" class="form-control" placeholder="댓글을 입력하세요"></textarea>
                </div>
            </form>
            <div id="replyList" data-user-pk="${sessionScope.loginUser.uno}"></div>
        </div>
    </div>
</div>
<%--                <c:if test="${empty sessionScope.loginUser}">--%>
<%--                    <div class="repIdPwContainer">--%>
<%--                        <input type="text" class="form-control" id="repnm" placeholder="이름">--%>
<%--                        <input type="password" class="form-control" id="reppw" placeholder="비밀번호">--%>
<%--                </c:if>--%>
<%--                <input type="button" class="btn btn-secondary" id="insBtn" value="작성">--%>
<%--                    </div>--%>
<%--                <div class="repTxtArea">--%>
<%--                    <textarea id="repctnt" class="form-control" placeholder="댓글을 입력하세요"></textarea>--%>
<%--                </div>--%>
<%--            </form>--%>
<%--            <div id="replyList" data-user-pk="${sessionScope.loginUser.uno}"></div>--%>
<%--        </div>--%>
<%--    </div>--%>
</div>
</div>
<script defer src="/res/js/board/view.js"></script>
<link href="/res/css/board/view.css" rel="stylesheet"/>
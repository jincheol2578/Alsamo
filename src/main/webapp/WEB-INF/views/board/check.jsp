<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="containerCenter">
    <div class="loginMsgContainer">
        <c:if test="${param.delete eq 1}">
            <form  action="/board/delete" method="post">
                <input class="form-control" type="hidden" name="bno" value="${param.bno}">
                <c:if test="${requestScope.board.uno eq 0}">
                    <div><input type="password" name="bpw" placeholder="비밀번호를 입력하세요" autofocus required></div>
                </c:if>
                <div>
                    <input type="submit" value="삭제">
                    <input type="button" value="취소" onclick="window.history.back();">
                </div>
            </form>
        </c:if>

        <c:if test="${param.modify eq 1}">
            <form id="checkModify" action="/board/write" method="get">
                <input type="hidden" name="modify" value="1">
                <input type="hidden" name="bno" value="${param.bno}">
                <c:if test="${requestScope.board.uno eq 0}">
                    <div><input type="password" name="bpw" placeholder="비밀번호를 입력하세요" autofocus required></div>
                </c:if>
<%--                <div>--%>
<%--                    <input type="submit" class="btn btn-secondary" value="수정">--%>
<%--                    <input type="button" class="btn btn-secondary" value="취소" onclick="window.history.back();">--%>
<%--                </div>--%>
            </form>
            <div class="modifyBtn">
            <button class="btn btn-secondary" type="submit" form="checkModify">수정</button>
            <button class="btn btn-secondary btn2" onclick="window.history.back();">취소</button>
            </div>
        </c:if>
    </div>
</div>
<link rel="stylesheet" href="/res/css/board/boardModify.css">
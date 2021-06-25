<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${param.delete eq 1}">
    <form action="/board/delete" method="post">
        <input type="hidden" name="bno" value="${param.bno}">
        <c:if test="${requestScope.board.uno ne sessionScope.loginUser.uno and
        sessionScope.loginUser.auth_no eq 1}">
            <div><input type="password" name="bpw" placeholder="비밀번호를 입력하세요" autofocus required></div>
        </c:if>
        <div>
            <input type="submit" value="삭제">
            <input type="button" value="취소" onclick="window.history.back();">
        </div>
    </form>
</c:if>

<c:if test="${param.modify eq 1}">
    <form action="/board/write" method="get">
        <input type="hidden" name="modify" value="1">
        <input type="hidden" name="bno" value="${param.bno}">
        <c:if test="${requestScope.board.uno ne sessionScope.loginUser.uno and
        sessionScope.loginUser.auth_no eq 1}}">
            <div><input type="password" name="bpw" placeholder="비밀번호를 입력하세요" autofocus required></div>
        </c:if>
        <div>
            <input type="submit" value="수정">
            <input type="button" value="취소" onclick="window.history.back();">
        </div>
    </form>
</c:if>
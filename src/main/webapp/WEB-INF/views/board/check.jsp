<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="containerMsg">
    <div class="check-container">
        <div><i class="fas fa-exclamation-triangle fa-5x"></i></div>
        <c:if test="${param.delete eq 1}">
            <form action="/board/delete" method="post">
                <input type="hidden" name="bno" value="${param.bno}">
                <c:if test="${requestScope.board.uno eq 0}">
                    <div><input type="password" name="bpw" class="form-control" placeholder="비밀번호를 입력하세요" autofocus required></div>
                </c:if>
                <div>
                    <input type="submit" class="btn btn-outline-secondary" value="삭제">
                    <input type="button" class="btn btn-outline-secondary" value="취소" onclick="window.history.back();">
                </div>
            </form>
        </c:if>

        <c:if test="${param.modify eq 1}">
            <form action="/board/write" method="get">
                <input type="hidden" name="modify" value="1">
                <input type="hidden" name="bno" value="${param.bno}">
                <c:if test="${requestScope.board.uno eq 0}">
                    <div><input type="password" name="bpw" class="form-control" placeholder="비밀번호를 입력하세요" autofocus required></div>
                </c:if>
                <div>
                    <input type="submit" class="btn btn-outline-secondary" value="수정">
                    <input type="button" class="btn btn-outline-secondary" value="취소" onclick="window.history.back();">
                </div>
            </form>
        </c:if>
    </div>
</div>
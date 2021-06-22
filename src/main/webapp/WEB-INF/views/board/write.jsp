<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="if" uri="http://java.sun.com/jsp/jstl/core" %>


<form action="
<c:choose>
    <c:when test="${empty param.modify}">write</c:when>
    <c:otherwise>modify</c:otherwise>
</c:choose>
" method="post">
<c:if test="${empty param.modify}">
    <c:choose>
        <c:when test="${empty requestScope.board}">
        <select name="bcode">
            <c:forEach var="category" items="${requestScope.categoryList}" begin="1">
                <c:choose>
                    <c:when test="${category.bcode eq param.bcode}">
                        <option value="${category.bcode}" selected="selected">${category.bnm}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${category.bcode}">${category.bnm}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
        </c:when>
        <c:otherwise>
            <input type="hidden" name="bcode" value="${requestScope.board.bcode}">
            <input type="hidden" name="group_idx" value="${requestScope.board.group_idx}">
            <input type="hidden" name="group_ord" value="${requestScope.board.group_ord}">
            <input type="hidden" name="group_dept" value="${requestScope.board.group_dept}">
        </c:otherwise>
    </c:choose>
</c:if>
    <c:if test="${not empty param.modify}">
        <input type="hidden" name="iuser" value="${requestScope.board.iuser}">
        <input type="hidden" name="iboard" value="${param.iboard}">
        <input type="hidden" name="board_pw" value="${requestScope.board_pw}">
    </c:if>
    <input type="text" name="title" placeholder="제목">
    <textarea name="content" placeholder="내용"></textarea>
    <input type="submit" value="글쓰기">
</form>

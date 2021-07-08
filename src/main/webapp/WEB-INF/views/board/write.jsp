<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="if" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<%-- summernote 적용부분--%>
<script src="/res/summernote/summernote-lite.js"></script>
<script src="/res/summernote/lang/summernote-ko-KR.js"></script>

<link rel="stylesheet" href="/res/summernote/summernote-lite.css">
<%--  --%>
<form action="
<c:choose>
    <c:when test="${empty param.modify}">write</c:when>
    <c:otherwise>modify</c:otherwise>
</c:choose>
" method="post">
    <c:if test="${empty param.modify}">
        <c:choose>
            <c:when test="${empty requestScope.board}">
                <select name="bcd">
                    <c:forEach var="category" items="${requestScope.categoryList}" begin="1">
                        <c:choose>
                            <c:when test="${category.bcd eq param.bcd}">
                                <option value="${category.bcd}" selected="selected">${category.bnm}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${category.bcd}">${category.bnm}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </c:when>
            <c:otherwise>
                <input type="hidden" name="bcd" value="${requestScope.board.bcd}">
                <input type="hidden" name="bidx" value="${requestScope.board.bidx}">
                <input type="hidden" name="bord" value="${requestScope.board.bord}">
                <input type="hidden" name="bdept" value="${requestScope.board.bdept}">
            </c:otherwise>
        </c:choose>
    </c:if>
    <c:if test="${not empty param.modify}">
        <input type="hidden" name="uno" value="${requestScope.board.uno}">
        <input type="hidden" name="bno" value="${param.bno}">
        <input type="hidden" name="bpw" value="${requestScope.bpw}">
    </c:if>
    <input type="text" name="btitle" placeholder="제목">
    <textarea id="summernote" name="bctnt"></textarea>
    <input type="submit" value="글쓰기">
</form>

<script src="/res/summernote/summernote.js?ver=1"></script>
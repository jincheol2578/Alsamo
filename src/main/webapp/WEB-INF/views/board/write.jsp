<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="if" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<%-- summernote 적용부분--%>
<script src="/res/summernote/summernote-lite.js"></script>
<script src="/res/summernote/lang/summernote-ko-KR.js"></script>

<link rel="stylesheet" href="/res/summernote/summernote-lite.css">
<div class="containerCenter">
    <form id="write-form" action="
<c:choose>
    <c:when test="${empty param.modify}">write</c:when>
    <c:otherwise>modify</c:otherwise>
</c:choose>
" method="POST">
        <div class="write-header">
            <c:if test="${empty param.modify}">
                <c:choose>
                    <c:when test="${empty requestScope.board && empty requestScope.reBoard}">
                        <div class="head-category">
                        <select name="bcd" class="form-select" aria-label="Default select example">
                            <c:forEach var="category" items="${requestScope.categoryList}" begin="2">
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
                        </div>
                    </c:when>
                    <c:otherwise>
                        <input type="hidden" name="bno" value="${param.bno}">
                        <input type="hidden" name="bcd" value="${param.bcd}">
                        <input type="hidden" name="bidx" value="${requestScope.reBoard.bidx}">
                        <input type="hidden" name="bord" value="${requestScope.reBoard.bord}">
                        <input type="hidden" name="bdept" value="${requestScope.reBoard.bdept}">
                    </c:otherwise>
                </c:choose>
            </c:if>
            <c:if test="${not empty param.modify}">
                <input type="hidden" name="bno" value="${param.bno}">
                <input type="hidden" name="uno" value="${requestScope.board.uno}">
                <input type="hidden" name="bpw" value="${requestScope.board.bpw}">
            </c:if>
            <div class="head-title">
            <input type="text" class="form-control writeTitle" name="btitle" placeholder="제목" maxlength="40"
                   value="${requestScope.board.btitle}">
            <c:if test="${empty sessionScope.loginUser && param.modify ne 1}">
                <input type="password" class="form-control writePwd" name="bpw" placeholder="비밀번호" value="${param.bpw}">
            </c:if>
            </div>
        </div>
        <div class="write-main">
            <textarea id="summernote" name="bctnt">${requestScope.board.bctnt}</textarea>
        </div>
        <div class="write-footer">
            <input class="btn btn-secondary" type="submit" value="작성">
        </div>
    </form>
</div>
<script src="/res/summernote/summernote.js"></script>
<link rel="stylesheet" href="/res/css/board/write.css"/>
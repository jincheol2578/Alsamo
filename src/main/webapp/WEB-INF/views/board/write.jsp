<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="if" uri="http://java.sun.com/jsp/jstl/core" %>


<form action="/board/write" method="post">
    <select name="bcode">
        <c:forEach var="category" items="${requestScope.categoryList}">
            <c:choose>
                <c:when test="${category.bcode} eq ${param.bcode}">
                    <option value="${category.bcode}" selected="selected">${category.bnm}</option>
                </c:when>
                <c:otherwise>
                    <option value="${category.bcode}">${category.bnm}</option>
                </c:otherwise>
            </c:choose>
        </c:forEach>

    </select>
    <input type="text" name="title" placeholder="제목">
    <textarea name="content" placeholder="내용" ></textarea>
    <input type="submit" value="글쓰기">
</form>

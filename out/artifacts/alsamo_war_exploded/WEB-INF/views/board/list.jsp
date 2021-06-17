<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table>
    <tr>
        <td>글번호</td>
        <td>작성자</td>
        <td>제목</td>
        <td>작성일</td>
    </tr>
    <c:forEach var="item" items="${requestScope.boardList}">
        <tr onclick="location.href='detail?bcode=${item.bcode}&iboard=${item.iboard}'">
            <td>${item.iboard}</td>
            <td>${item.writer}</td>
            <td>${item.title}</td>
            <td>${item.regdate}</td>
        </tr>
    </c:forEach>
</table>

<a href="write?bcode=${param.bcode}">글쓰기</a>

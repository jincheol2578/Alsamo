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
        <tr onclick="location.href='view?bcd=${item.bcd}&bno=${item.bno}'">
            <td>${item.bno}</td>
            <td>${item.writer}</td>
            <td>${item.btitle}</td>
            <td>${item.brdt}</td>
        </tr>
    </c:forEach>
</table>
<a href="write?bcd=${param.bcd}">글쓰기</a>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="boardContainer">
    <div class="boardBtn">
        <div class="float-left"></div>
        <div class="float-right">
            <a href="write?bcd=${param.bcd}">
                <button type="button" class="btn btn-secondary">글쓰기</button>
            </a>
        </div>
    </div>

    <table class="table">
        <tr>
            <th>글번호</th>
            <th>작성자</th>
            <th>제목</th>
            <th>작성일</th>
        </tr>
        <c:forEach var="item" items="${requestScope.boardList}">
            <tr id="boardClick" onclick="location.href='view?bcd=${item.bcd}&bno=${item.bno}'">
                <td>${item.bno}</td>
                <td>${item.writer}</td>
                <td class="bright">${item.btitle}</td>
                <td>${item.brdt}</td>
            </tr>
        </c:forEach>
    </table>
</div>

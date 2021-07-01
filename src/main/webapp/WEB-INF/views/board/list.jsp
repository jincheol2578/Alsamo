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

<%-- TODO:부트스트랩 적용필요함--%>
<ul class="pagination">
    <c:if test="${paging.curRange ne 1}">
        <li class="firstPage" onclick="moveToPage(${param.bcd},1)">&#171;</li>
    </c:if>
    <c:if test="${paging.curRange ne 1}">
        <li class="firstPage" onclick="moveToPage(${param.bcd},${paging.prevPage})">&#60;</li>
    </c:if>

    <c:forEach var="pageNum" begin="${paging.startPage}" end="${paging.endPage}">
        <c:choose>
            <c:when test="${pageNum eq paging.curPage}">
                <li class="active" onclick="moveToPage(${param.bcd},${pageNum})">${pageNum}</li>
            </c:when>
            <c:otherwise>
                <li onclick="moveToPage(${param.bcd},${pageNum})">${pageNum}</li>
            </c:otherwise>
        </c:choose>
    </c:forEach>

    <c:if test="${paging.curPage ne paging.pageCnt && paging.pageCnt > 0}">
        <li onclick="moveToPage(${param.bcd},${paging.nextPage })">&#62;</li>
    </c:if>
    <c:if test="${paging.curRange ne paging.rangeCnt && paging.rangeCnt > 0}">
        <li href="#" onclick="moveToPage(${param.bcd},${paging.pageCnt })">&#187;</li>
    </c:if>

</ul>

<script defer>
    function moveToPage(bcd, page){
        location.href = "/board/list?bcd="+bcd+"&page="+page;
    }
</script>


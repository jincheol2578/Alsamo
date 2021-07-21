<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
            <th>조회수</th>
        </tr>

        <c:forEach var="item" items="${requestScope.boardList}" varStatus="status">
            <tr id="boardClick" class="boardClick">
                <input type="hidden" id="userPk" value="${item.uno}">
                <td>${item.bno}</td>
                <td class="" id="${status.index}" onclick="makeUl(${status.index});">${item.writer}
                </td>
                <td class="bright" onclick="location.href='view?bcd=${item.bcd}&bno=${item.bno}'">${item.btitle}</td>
                <td>${item.brdt}</td>
                <td>${item.bhit}</td>

            </tr>
        </c:forEach>
    </table>
    <div id="paggingBox">
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
    </div>
</div>
<script defer>
    function moveToPage(bcd, page) {
        location.href = "/board/list?bcd=" + bcd + "&page=" + page;
    }
</script>
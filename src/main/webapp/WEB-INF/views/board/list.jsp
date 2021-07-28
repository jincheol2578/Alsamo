<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="boardContainer">
    <div class="boardList">
        <table class="table">
            <thead class="thead">
            <tr>
                <th>글번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
                <th>조회수</th>
                <th>추천수</th>
            </tr>
            </thead>
            <tbody class="notice">
            </tbody>
            <tbody class="boardList">
            <c:forEach var="item" items="${requestScope.boardList}" varStatus="status">
            <tr id="boardClick" class="boardClick">
                <td>${item.bno}</td>
                <td class="" id="${status.index}"
                <c:if test="${item.uno !=0}">onclick="makeUl(${status.index},${item.uno});"</c:if>>${item.writer}
                </td>
                <td class="bright"
                    onclick="location.href='view?bcd=${item.bcd}&bno=${item.bno}'">${item.btitle}</td>
                <td>${item.brdt}</td>
                <td>${item.bhit}</td>
                <td>${item.rec}</td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="boardBtn">
        <div class="float-left"></div>
        <div class="float-right">
            <a href="write?bcd=${param.bcd}">
                <button type="button" class="btn btn-secondary">글쓰기</button>
            </a>
        </div>
    </div>

    <div id="pagingBox">
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

    <div class="boardSearch">
        <form onsubmit="return false;">
            <select id="searchType">
                <option value="1">제목+내용</option>
                <option value="2">제목</option>
                <option value="3">내용</option>
                <option value="4">작성자</option>
            </select>
            <input type="text" id="searchText">
            <button id="searchBtn">검색</button>
        </form>
    </div>
</div>



<script src="/res/js/board/list.js"></script>
<link rel="stylesheet" href="/res/css/board/list.css">
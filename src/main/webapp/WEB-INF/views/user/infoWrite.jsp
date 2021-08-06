<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="infoWriteContainer">
    <table class="table table-hover" id="infoWriteTable">
        <tr>
            <th></th>
            <th></th>
            <th>total ${infoUser.countBoardList} </th>
        </tr>
        <c:forEach var="item" items="${requestScope.infoUser.boardList}">
            <tr>
                <td><a href="/board/view?bcd=${item.bcd}&bno=${item.bno}">${item.btitle}</a></td>
                <td><a href="/board/view?bcd=${item.bcd}&bno=${item.bno}">${item.bctnt}</a></td>
                <td><a href="/board/view?bcd=${item.bcd}">
                    <div>${item.bcd} </div>
                </a>
                    <div>${item.brdt}</div>
                </td>

            </tr>
        </c:forEach>
    </table>

    <div id="pagingBox">
        <ul class="pagination">
            <c:if test="${paging.curRange ne 1}">
                <li class="firstPage" onclick="moveToPage(${param.uno},1)">&#171;</li>
            </c:if>
            <c:if test="${paging.curRange ne 1}">
                <li class="firstPage" onclick="moveToPage(${param.uno},${paging.prevPage})">&#60;</li>
            </c:if>

            <c:forEach var="pageNum" begin="${paging.startPage}" end="${paging.endPage}">
                <c:choose>
                    <c:when test="${pageNum eq paging.curPage}">
                        <li class="active" onclick="moveToPage(${param.uno},${pageNum})">${pageNum}</li>
                    </c:when>
                    <c:otherwise>
                        <li onclick="moveToPage(${param.uno},${pageNum})">${pageNum}</li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <c:if test="${paging.curPage ne paging.pageCnt && paging.pageCnt > 0}">
                <li onclick="moveToPage(${param.uno},${paging.nextPage })">&#62;</li>
            </c:if>
            <c:if test="${paging.curRange ne paging.rangeCnt && paging.rangeCnt > 0}">
                <li href="#" onclick="moveToPage(${param.uno},${paging.pageCnt })">&#187;</li>
            </c:if>
        </ul>
    </div>

</div>

<script defer src="/res/js/user/infoWrite.js"></script>
<link rel="stylesheet" href="/res/css/user/infoWrite.css">
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

    <ul id="infoPagging">
        <c:forEach var="Page" begin="1" end="${requestScope.maxPage}">
            <li class="paggingLi">
                    <span onclick="active(${requestScope.infoUser.uno},${Page})">
        <font color="#000000">
            <c:if test="${requestScope.infoUser.page == Page}">font color="#bbbbbb"></c:if>
        ${Page}</font>
                    </span>
            </li>
        </c:forEach>
    </ul>

</div>


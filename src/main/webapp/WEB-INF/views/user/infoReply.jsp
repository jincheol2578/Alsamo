<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="infoReplyContainer">
<table class="table table-hover" id="infoReplyTable">
    <tr>
        <th></th>
        <th></th>
        <th>Total ${infoUser.countReplyList}</th>
    </tr>
    <c:forEach var="repItem" items="${requestScope.infoUser.replyList}">
        <tr>
            <td><a href="">댓글 바로가기</a></td>
            <td><a href="">${repItem.repctnt} </a></td>
            <td><a href="">
                <div> ${repItem.bnm} </div>
            </a>
                <div>${repItem.reprdt}</div>
            </td>
        </tr>
    </c:forEach>
</table>
</div>
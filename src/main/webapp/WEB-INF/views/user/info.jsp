<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>이름</div>
<div>내가 쓴 글</div>
<c:forEach var="item"  items="${requestScope.infoUser.boardList}">
    <div>글번호 ${item.uno}</div>
    <div>글쓴이 ${item.writer}</div>
    <div>글제목 ${item.btitle}</div>
</c:forEach>
<div>Total</div>
<div>${item.countBoardList}</div>

<br>

<%--<div>내가 쓴 댓글</div>--%>
<%--<c:forEach var="item"  items="${requestScope.infoUser.replyList}">--%>
<%--    <div>${item.replyList}</div>--%>
<%--</c:forEach>--%>
<%--<div>Total</div>--%>
<%--<div>${item.countReplyList}</div>--%>
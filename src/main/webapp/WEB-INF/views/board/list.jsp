<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021-06-14
  Time: 오후 1:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div><h3>${sessionScope.loginUser.unm}님 환영합니다.</h3></div>

<div>
    <table>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>글쓴이</th>
            <th>작성일시</th>
        </tr>
        <c:forEach items="${requestScope.list}" var="item">
            <tr>
                <td>${item.iboard}</td>
                <td>${item.title}</td>
                <td>${item.unm}</td>
                <td>${item.refdate}</td>
            </tr>
        </c:forEach>

    </table>
</div>


</body>
</html>

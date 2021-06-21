<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>메인화면</title>
</head>
<body>
<%--카테고리 템플릿으로 옮길예정--%>
<c:forEach var="list" items="${requestScope.categoryList}">
    <div>${list.bnm}</div>
</c:forEach>
</body>
</html>

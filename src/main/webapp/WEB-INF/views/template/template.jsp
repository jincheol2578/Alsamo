<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>${requestScope.btitle}</title>
    <link rel="stylesheet" href="/res/css/common.css">
</head>
<body>
<div id="container">
    <tiles:insertAttribute name="header" />
    <section>
        <ul>
            <tiles:importAttribute name="menuList"/>
            <c:forEach var="list" items="${menuList}">
                <li><a href="/board/list?bcd=${list.bcd}">${list.bnm}</a></li>
            </c:forEach>
        </ul>
        <tiles:insertAttribute name="content" />
    </section>
    <footer>
        Copyright 2021.
    </footer>
</div>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<header>
    <h1>헤더</h1>
    <ul>
        <tiles:importAttribute name="menuList"/>
        <c:forEach var="list" items="${menuList}">
            <li><a href="/board/list?bcode=${list.bcode}">${list.bnm}</a></li>
        </c:forEach>
    </ul>
</header>
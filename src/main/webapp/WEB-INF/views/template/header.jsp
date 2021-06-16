<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <h1>헤더</h1>
    ${sessionScope.categoryList}
    <ul>
        <c:forEach var="list" items="${sessionScope.categoryList}">
            <li>${list.bnm}</li>
        </c:forEach>
    </ul>
</header>
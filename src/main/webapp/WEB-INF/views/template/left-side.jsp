<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<div class="border-end bg-white" id="sidebar-wrapper">
    <div class="sidebar-heading border-bottom bg-light" onclick="goHome();">Alsamo</div>
    <div class="list-group list-group-flush">
        <tiles:importAttribute name="menuList"/>
        <c:forEach var="list" items="${menuList}" varStatus="status">
            <div onclick="moveToBoard(${list.bcd});" class="list-group-item list-group-item-action list-group-item-light p-3"><a href="/board/list?bcd=${list.bcd}">${list.bnm}</a></div>
        </c:forEach>
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/alcohol/alcoholList">알콜
            위키</a>
    </div>
</div>

<script>
    function moveToBoard(num){
        location.href='/board/list?bcd='+num
    }
</script>
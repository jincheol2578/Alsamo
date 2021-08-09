<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="alContainer">
    <div id="upContent">
        <div id="searchWiki">
            <input class="form-control input-lg" id="searchWhat" onkeyup="enterKey();" type="text" value="" placeholder="검색 입력.">
            <button onclick="searchName();" class="btn btn-default">검색</button>
        </div>

        <div id="ulContainer">
            <ul>
                <li>추천 검색어 : </li>
                <li id="Whiskey" onclick="searchWhat('위스키');">위스키</li>
                <li id="Rum" onclick="searchWhat('럼');">럼</li>
                <li id="Jim" onclick="searchWhat('진');">진</li>
                <li id="Tequila" onclick="searchWhat('데킬라');">데킬라</li>
                <li id="Vodka" onclick="searchWhat('보드카');">보드카</li>
            </ul>
        </div>

    </div>

    <div id="downContent">
        <c:if test="${not empty requestScope.alcohol.alImg}">
            <div><img id="alImg" src="${requestScope.alcohol.alImg}"></div>
        </c:if>
        <table id="alcoholTable">${requestScope.alcohol.alTable}</table>
        <br>
        <div id="alcoholContent">${requestScope.alcohol.content}</div>
    </div>

</div>
<link href="/res/css/alcohol/alcoholList.css" rel="stylesheet"/>
<script src="/res/js/alchohol/alcoholList.js"></script>
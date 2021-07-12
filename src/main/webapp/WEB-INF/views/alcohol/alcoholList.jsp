<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="alContainer">
    <div class="alcoholKindsContainer">
        <div class="ulContainer">
            <ul>
                <li id="Whiskey" onclick="getWhiskey();">위스키</li>
                <li id="Rum" onclick="getRum();">럼</li>
                <li id="Jim" onclick="getJim();">진</li>
                <li id="Tequila" onclick="getTequila();">데킬라</li>
                <li id="Vodka" onclick="getVodka();">보드카</li>
            </ul>
        </div>
    </div>
    <div id="searchWiki">
        <input class="whatsearch" onkeyup="enterKey();" type="text" value="" placeholder="검색 입력.">
        <button onclick="searchName();">검색</button>
    </div>
    <br>
    <div class="contentContainer">
        <div><h2 id="alcoholName">${requestScope.alcohol.name}</h2></div>
        <c:if test="${not empty requestScope.alcohol.alImg}">
            <div><img id="alImg" src="${requestScope.alcohol.alImg}"></div>
        </c:if>
        <table id="alcoholTable">${requestScope.alcohol.alTable}</table>
        <br>
        <div id="alcoholContent">${requestScope.alcohol.content}</div>
    </div>

</div>
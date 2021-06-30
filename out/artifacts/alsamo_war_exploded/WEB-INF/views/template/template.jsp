<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>${requestScope.btitle}</title>
    <link rel="stylesheet" href="/res/css/common.css">
    <link rel="stylesheet" href="/res/css/myPage.css">
    <link rel="stylesheet" href="/res/css/board.css">
    <link rel="stylesheet" href="/res/css/layout.css">

    <%-- 부트 스트랩--%>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <script defer src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <script defer src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>

    <script defer src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>

    <%-- 반응형 웹 --%>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Google 로그인 -->
    <meta name="google-signin-scope" content="profile email">
    <meta name="google-signin-client_id"
          content="227252070132-70dn36407laql4s9m54qvqcq1ib7gq9m.apps.googleusercontent.com">
    <script src="https://apis.google.com/js/platform.js?onload=onLoad" async defer></script>
    <script def src="/res/js/googleLogin.js"></script>
    <script def src="/res/js/common.js "></script>

</head>
<body>
<div id="container">
    <div id="header"><tiles:insertAttribute name="header"/></div>

    <div id="section">
        <ul>
            <tiles:importAttribute name="menuList"/>
            <c:forEach var="list" items="${menuList}">
                <li><a href="/board/list?bcd=${list.bcd}">${list.bnm}</a></li>
            </c:forEach>
        </ul>
        <tiles:insertAttribute name="content"/>
    </div>

    <div id="footer">
        Copyright 2021.
    </div>
</div>
</body>
</html>
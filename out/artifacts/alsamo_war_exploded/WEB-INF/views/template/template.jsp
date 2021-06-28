<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>${requestScope.btitle}</title>
    <link rel="stylesheet" href="/res/css/common.css">
    <link rel="stylesheet" href="/res/css/myPage.css">

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
    <tiles:insertAttribute name="header"/>
    <section>
        <ul>
            <tiles:importAttribute name="menuList"/>
            <c:forEach var="list" items="${menuList}">
                <li><a href="/board/list?bcd=${list.bcd}">${list.bnm}</a></li>
            </c:forEach>
        </ul>
        <tiles:insertAttribute name="content"/>
    </section>
    <footer>
        Copyright 2021.
    </footer>
</div>
</body>
</html>
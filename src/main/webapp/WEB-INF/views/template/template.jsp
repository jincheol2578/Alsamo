<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
<link>
<meta charset="utf-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
<meta name="description" content=""/>
<meta name="author" content=""/>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="/res/assets/favicon.ico"/>
<!-- Core theme CSS (includes Bootstrap)-->
<link href="/res/css/styles.css" rel="stylesheet"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script defer src="/res/js/scripts.js"></script>
<title>${requestScope.btitle}</title>
<link rel="stylesheet" href="/res/css/common.css">

<%--부트스트랩--%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script defer src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script defer src="/res/js/common.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<%--Swiper--%>
<link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.css">
<link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css">
<script src="https://unpkg.com/swiper/swiper-bundle.js"></script>
<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

</head>
<body>
<div class="d-flex" id="wrapper">
    <tiles:insertAttribute name="left-side"/>
    <div id="page-content-wrapper">
        <tiles:insertAttribute name="header"/>
        <div class="container-fluid">
            <tiles:insertAttribute name="content"/>
            <ul>
                <tiles:importAttribute name="menuList"/>
                <c:forEach var="list" items="${menuList}">
                    <li><a href="/board/list?bcd=${list.bcd}">${list.bnm}</a></li>
                </c:forEach>
            </ul>
        </div>
        <div class="container-fluid">
            <tiles:insertAttribute name="footer"/>
        </div>
    </div>

</div>

</body>
</html>
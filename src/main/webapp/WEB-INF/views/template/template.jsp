<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>${requestScope.title}</title>
</head>
<body>
<div id="container">
    <tiles:insertAttribute name="header" />
    <section>
        <tiles:insertAttribute name="content" />
    </section>
    <footer>
        Copyright 2021.
    </footer>
</div>
</body>
</html>
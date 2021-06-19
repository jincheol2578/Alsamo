<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021-06-14
  Time: 오후 1:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>글쓰기</title>
</head>
<body>
    <form action="/board/write" method="post">
        제목 : <input type="text" name="title">
        내용 : <textarea name="cmt"></textarea>
    </form>

</body>
</html>

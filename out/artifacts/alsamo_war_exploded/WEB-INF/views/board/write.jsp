<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>글쓰기</title>
</head>
<body>
    <form action="write" method="post">
        <input type="text" name="title" placeholder="제목">
        <textarea name="content" placeholder="내용" ></textarea>
        <input type="submit" value="글쓰기">
    </form>
</body>
</html>

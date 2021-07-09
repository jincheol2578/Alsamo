<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="loginMsg">
    <div>${requestScope.Msg}</div>
    <a href="/board/list">
        <button>초기화면</button>
    </a>
</div>


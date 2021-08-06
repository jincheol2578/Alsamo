<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="containerMsg">
    <div class="loginMsgContainer">
        <div><i class="fas fa-exclamation-triangle fa-5x"></i></div>
        <div class="msg">${requestScope.Msg}</div>
        <div><a href="/">
            <button class="btn btn-secondary">초기화면</button>
        </a></div>
    </div>

</div>
<link rel="stylesheet" href="/res/css/user/loginErr.css">
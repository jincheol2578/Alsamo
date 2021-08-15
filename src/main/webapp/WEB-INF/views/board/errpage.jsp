<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="containerMsg">
    <div class="loginMsgContainer">
        <div><i class="fas fa-exclamation-triangle fa-5x"></i></div>
        <div class="msg">
            비밀번호가 틀리거나 잘못된 접근입니다.
        </div>
        <div>
            <button class="btn btn-secondary" onclick="history.back();">뒤로가기</button>
        </div>
    </div>

</div>
<link rel="stylesheet" href="/res/css/user/loginErr.css">
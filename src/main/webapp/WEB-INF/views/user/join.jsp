<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="containerCenter">
    <div class="joinContainer">
        <form action="/user/join" method="post" onsubmit="return chckPw();">
            <div class="form-group">
                <label for="inputName">아이디</label>
                <input type="text" class="form-control" name="uid" id="inputId" placeholder="아이디" maxlength="20" xrequired>
            </div>
            <div class="form-group">
                <label for="inputName">이름</label>
                <input type="text" class="form-control" name="unm" id="inputName" placeholder="닉네임" maxlength="20" required>
            </div>
            <div class="form-group">
                <label for="InputEmail">이메일 주소</label>
                <input type="email" class="form-control" name="uemail" id="InputEmail" placeholder="example@gmail.com" maxlength="30" required>
            </div>
            <div class="form-group">
                <label for="inputPassword">비밀번호</label>
                <input type="password" class="form-control" name="upw" id="inputPassword" placeholder="비밀번호" minlength="6" maxlength="12" required>
            </div>
            <div class="form-group">
                <label for="inputPasswordChck">비밀번호 확인</label>
                <input type="password" class="form-control"  id="inputPasswordChck" placeholder="비밀번호 확인" minlength="6" maxlength="12" required>
            </div>
            <div id="checkPwMsg"></div>
            <div class="form-group text-center">
                <button type="submit" id="join-submit" class="btn btn-secondary">
                    <i class="fa fa-check spaceLeft"></i> 회원가입
                </button>
            </div>
        </form>
    </div>
</div>

<script src="/res/js/user/join.js/"></script>

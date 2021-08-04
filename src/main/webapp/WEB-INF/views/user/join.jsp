<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="cenContainer">
<div class="joinContainer">
    <form action="/user/join" method="post" onsubmit="return chckPw();">
        <div class="form-group">
            <label for="inputName">아이디</label>
            <input type="text" class="form-control" name="uid" id="inputId" placeholder="아이디을 입력해 주세요" required>
        </div>
        <div class="form-group">
            <label for="inputName">이름</label>
            <input type="text" class="form-control" name="unm" id="inputName" placeholder="이름을 입력해 주세요" required>
        </div>
        <div class="form-group">
            <label for="InputEmail">이메일 주소</label>
            <input type="email" class="form-control" name="uemail" id="InputEmail" placeholder="이메일 주소를 입력해주세요" required>
        </div>
        <div class="form-group">
            <label for="inputPassword">비밀번호</label>
            <input type="password" class="form-control" name="upw" id="inputPassword" placeholder="비밀번호를 입력해주세요" required>
        </div>
        <div class="form-group">
            <label for="inputPasswordChck">비밀번호 확인</label>
            <input type="password" class="form-control"  id="inputPasswordChck" placeholder="비밀번호 확인을 위해 다시한번 입력 해 주세요" required>
        </div>
        <div id="checkPwMsg"></div>
        <div class="form-group text-center">
            <button type="submit" id="join-submit" class="btn btn-secondary">
                회원가입<i class="fa fa-check spaceLeft"></i>
            </button>
            <button type="button" class="btn btn-secondary">
                <a class="joinAtag" href="/home">가입취소</a><i class="fa fa-times spaceLeft"></i>
            </button>
        </div>
    </form>
</div>
</div>

<script src="/res/js/user/join.js/"></script>
<link rel="stylesheet" href="/res/css/user/join.css">
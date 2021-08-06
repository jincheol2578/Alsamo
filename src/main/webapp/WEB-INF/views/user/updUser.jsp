<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021-06-23
  Time: 오전 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="containerCenter">
    <div class="updUserContainer">
<form action="/user/updUser" method="post">
    <div class="form-group">
        <label for="InputEmail">이메일 주소</label>
        <input type="email" class="form-control" name="uemail" id="InputEmail" value="${requestScope.uemail}"
               placeholder="이메일 주소를 입력해주세요" readonly>
    </div>
    <div class="form-group">
        <label for="inputPassword">비밀번호</label>
        <input type="password" class="form-control" name="upw" id="inputPassword" placeholder="비밀번호를 입력해주세요" required>
    </div>
    <div class="form-group">
        <label for="inputPasswordChck">비밀번호 확인</label>
        <input type="password" class="form-control" id="inputPasswordChck" placeholder="비밀번호 확인을 위해 다시한번 입력 해 주세요"
               required>
    </div>
    <div id="checkPwMsg"></div>
    <div class="form-group text-center">
        <button type="submit" id="join-submit" class="btn btn-secondary">
            비밀번호 변경<i class="fa fa-check spaceLeft"></i>
        </button>
    </div>
</form>
</div>
</div>
<script src="/res/js/user/updUser.js/"></script>

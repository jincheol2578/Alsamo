<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021-06-23
  Time: 오전 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="containerCenter">

    <div class="findPwContainer">
        <h2>비밀번호 찾기</h2>
        <form action="/user/findPw" method="post">
            <div class="form-group">
                <label for="findPwInputEmail1">이메일 주소</label>
                <input type="email" name="uemail" class="form-control" id="findPwInputEmail1" placeholder="이메일을 입력하세요"
                       required>
            </div>
            <div class="form-group">
                <label for="findPwInputName">아이디</label>
                <input type="text" name="uid" class="form-control" id="findPwInputName" placeholder="아이디를 입력하세요"
                       required>
            </div>
            <button type="submit" class="btn btn-secondary">찾기</button>
        </form>
    </div>
</div>
<link rel="stylesheet" href="/res/css/user/findPw.css">
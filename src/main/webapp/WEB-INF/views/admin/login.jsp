<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="containerCenter">
    <div class="adminChckdContainer">
        <div class="adminLoginMsg"><i class="fas fa-exclamation-triangle fa-2x"></i>
            <h2>관리자 확인!!</h2><i class="fas fa-exclamation-triangle fa-2x"></i></div>
        <form action="/admin/login" method="post">
            <div class="form-group">
                <label for="exampleInputId">아이디</label>
                <input type="text" name="uid" class="form-control" id="exampleInputId" placeholder="아이디를 입력하세요"
                       required>
            </div>
            <div class="form-group">
                <label for="exampleInputPassword">비밀번호</label>
                <input type="password" name="upw" class="form-control" id="exampleInputPassword" placeholder="비밀번호를 입력하세요"
                       required>
            </div>
            <button type="submit" class="btn btn-secondary">로그인</button>
        </form>
    </div>
</div>

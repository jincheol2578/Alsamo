<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021-06-23
  Time: 오후 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="containerCenter">

    <div class="findIdContainer">
        <h2>아이디 찾기</h2>
        <form action="/user/findId" method="post">
            <div class="form-group">
                <label for="exampleInputEmail1">이메일 주소</label>
                <input type="email" name="uemail" class="form-control" id="exampleInputEmail1" placeholder="이메일을 입력하세요"
                       required>
            </div>
            <div class="form-group">
                <label for="exampleInputName">이름</label>
                <input type="text" name="unm" class="form-control" id="exampleInputName" placeholder="이름을 입력하세요"
                       required>
            </div>
            <button type="submit" class="btn btn-secondary">찾기</button>
        </form>
    </div>
</div>
<link rel="stylesheet" href="/res/css/user/findId.css">
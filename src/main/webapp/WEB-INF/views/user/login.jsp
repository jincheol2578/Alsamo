<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021-06-11
  Time: 오후 4:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Google 로그인 -->
    <meta name="google-signin-scope" content="profile email">
    <meta name="google-signin-client_id"
          content="227252070132-70dn36407laql4s9m54qvqcq1ib7gq9m.apps.googleusercontent.com">
    <script src="https://apis.google.com/js/platform.js?onload=onLoad" async defer></script>
    <script def src="/res/js/googleLogin.js"></script>
    <title>로그인</title>
</head>
<body>
<h1>로그인</h1>
<div><h3>${errMsg}</h3></div>
<idv><h3>${msg}</h3></idv>
<idv><h3>${authkeyErr}</h3></idv>
<div>
    <form action="/user/login" method="post">
        <div><input type="text" name="uid" placeholder="아이디"></div>
        <div><input type="text" name="upw" placeholder="비밀번호"></div>
        <div><input type="submit" value="로그인"></div>
    </form>
    <a href="/user/join">
        <button>회원가입</button>
    </a></div>
<%-- 구글 로그인 버튼--%>
<div class="g-signin2" data-onsuccess="onSignIn"></div>

<%--로그 아웃--%>
<a href="#" onclick="signOut();">Sign out</a>
</div>
</body>
</html>

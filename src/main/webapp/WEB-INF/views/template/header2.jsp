<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
    <div class="container-fluid">
        <button class="btn btn-primary" id="sidebarToggle">사이드바</button>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span
                class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mt-2 mt-lg-0">
                <li class="nav-item"><a class="nav-link" href="http://localhost:8080/">Home</a></li>

                <%-- Todo list link 활용 방안 생각 --%>
                <li class="nav-item"><a class="nav-link" href="#!">Link</a></li>
                <c:choose>
                    <c:when test="${empty sessionScope.loginUser}">
                        <li class="nav-item"><a class="nav-link" onclick="openModal();" href="#!">Login</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button"
                               data-bs-toggle="dropdown" aria-haspopup="true"
                               aria-expanded="false">${sessionScope.loginUser.uid}</a>

                            <div class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="/user/logout">Logout</a>
                                <a class="dropdown-item" href="/user/myPage">MyPage</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#!">Something else here</a>
                            </div>
                        </li>
                    </c:otherwise>
                </c:choose>

            </ul>
        </div>
    </div>
</nav>
<div id="modal" class="displayNone" >
    <div class="modal_content">
        <a href="#" onclick="closeModal();"><img id="modalBtnClose" class="X" src="/img/close.png"></a>
        <div><h3>${errMsg}</h3></div>
        <idv><h3>${requestScope.msg}</h3></idv>
        <div><h3>${authkeyErr}</h3></div>
        <form class="loginForm" action="/user/login" method="post">
            <div><input class="loginProperty" type="text" name="uid" placeholder="아이디"></div>
            <div><input class="loginProperty" type="text" name="upw" placeholder="비밀번호"></div>
            <div><input class="loginBtn" type="submit" value="로그인"></div>
            <div><a href="/user/join">
                <button class="loginBtn" type="button">회원가입</button>
            </a></div>
        </form>
    </div>
</div>
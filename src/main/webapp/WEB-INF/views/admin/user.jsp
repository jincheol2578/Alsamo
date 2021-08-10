<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="layoutSidenav">
    <div class="chooseContainer">
        <ul class="chooseUl">
            <li class="chooseLi">
                <div><a href="/admin/board" >게시판관리</a></div>
            </li>
            <li class="chooseLi adminNow">
                <div><a href="/admin/user">유저관리</a></div>
            </li>

        </ul>
    </div>
    <div id="layoutSidenav_content">

            <div class="container-fluid px-4">
                <%--                유저 관리        --%>
                <div class="card mb-4">
                    <div class="card-header">
                        유저 관리
                    </div>

                    <div class="card-body">
                        <div class="">
                            <select id="authorize">
                                <option value="all">전체보기</option>
                                <option value="general">일반유저</option>
                                <option value="unAuthorize">미인증유저</option>
                                <option value="block">차단유저</option>
                            </select>
                        </div>
                        <div class="Card-body-content">
                            <div>아이디, 닉네임, 이메일로 검색할 수 있습니다.</div>
                            <input class="Card-body-input" type="search" id="searchText" placeholder="Search for ...">
                        </div>
                        <table id="datatablesSimple" class="dataTable-table">
                            <thead>
                            <tr>
                                <th>No</th>
                                <th>아이디</th>
                                <th>닉네임</th>
                                <th>이메일</th>
                                <th>가입일</th>
                                <th>권한</th>
                                <th>기타</th>
                            </tr>
                            </thead>
                            <tbody>
                            </tbody>
                        </table>
                        <div id="pagination" class="dataTable-pagination">
                        </div>
                    </div>
                </div>
            </div>

        <footer class="py-4 bg-light mt-auto">
            <div class="container-fluid px-4">
                <div class="d-flex align-items-center justify-content-between small">
                    <div class="text-muted">Copyright &copy; Your Website 2021</div>
                    <div>
                        <a href="#">Privacy Policy</a>
                        &middot;
                        <a href="#">Terms &amp; Conditions</a>
                    </div>
                </div>
            </div>
        </footer>
    </div>
</div>
<link href="/res/css/admin/styles.css" rel="stylesheet"/>
<script src="/res/js/admin/user.js"/>
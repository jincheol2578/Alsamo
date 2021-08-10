<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="layoutSidenav">
    <div class="chooseContainer">
        <ul class="chooseUl">
            <li class="chooseLi adminNow">
                <div><a href="/admin/board">게시판관리</a></div>
            </li>
            <li class="chooseLi">
                <div><a href="/admin/user">유저관리</a></div>
            </li>

        </ul>
    </div>
    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid px-4">
                <div class="card mb-4">
                    <div class="card-header">카테고리</div>
                    <div class="category card-body">
                        <div class="category-list">
                            <ul id="categoryList"></ul>
                        </div>
                        <div class="category-text">
                            <input type="text" id="txtCategory" class="dataTable-input">
                        </div>
                        <div>

                        </div>
                    </div>
                </div>
                <%--                게시글 관리        --%>
                <div class="card mb-4">
                    <div class="card-header">
                        등록된 태그가 포함된 게시물만 표시합니다. 태그를 등록해 주세요.
                    </div>
                    <div class="card-body">
                        <ul id="tagBox" class="tagBox"></ul>
                        <input type="text" id="txtTag" class="dataTable-input">
                    </div>
                    <div class="card-body table-responsive">
                        <table id="datatablesSimple" class="dataTable-table ">
                            <thead>
                            <tr>
                                <th><input class="form-check-input" type="checkbox" id="allChk"></th>
                                <th>글번호</th>
                                <th>작성자</th>
                                <th>제목</th>
                                <th>조회</th>
                                <th>추천</th>
                                <th>작성일</th>
                            </tr>
                            </thead>
                            <tbody>
                            </tbody>
                        </table>
                        <button class="btn btn-secondary" onclick="delBoard()">삭제</button>
                        <div id="pagination">
                        </div>
                    </div>
                </div>
            </div>
        </main>
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

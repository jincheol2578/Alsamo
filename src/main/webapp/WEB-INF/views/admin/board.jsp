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
                        <div class="card-body">
                            <div class="category-list">
                                <ul id="categoryList"></ul>
                            </div>
                            <div class="category-text">
                                <input type="text" id="txtCategory" class="dataTable-input">
                                <button id="regCategory" class="btn btn-secondary">작성</button>
                            </div>
                        </div>
                        <div class="card-body">
                            <ol class="category-tip">
                                <li>게시판이 삭제되면 복구할 수 없습니다.</li>
                                <li>전체 게시판과 공지사항을 제외한 게시판의 이름과 순서를 변경할 수 있습니다.</li>
                                <li>새로운 게시판을 생성할 수 있습니다.</li>
                            </ol>
                        </div>
                    </div>
                </div>
                <%--                게시글 관리        --%>
                <div class="card mb-4">
                    <div class="card-header">
                        게시글 관리
                    </div>
                    <div class="card-body">
                        <div>등록된 태그가 포함된 게시물만 표시합니다. 태그를 등록해 주세요.</div>
                        <ul id="tagBox" class="tag-box"></ul>
                        <input type="text" id="txtTag" class="dataTable-input">
                    </div>
                    <div class="card-body table-responsive">
                        <table id="datatablesSimple" class="dataTable-table">
                            <thead>
                            <tr>
                                <th><input class="form-check-input" type="checkbox" id="allChk"></th>
                                <th>글번호</th>
                                <th>제목</th>
                                <th>작성자</th>
                                <th>조회</th>
                                <th>추천</th>
                                <th>작성일</th>
                            </tr>
                            </thead>
                            <tbody>
                            </tbody>
                        </table>
                        <button class="btn btn-secondary" id="deleteBtn">삭제</button>
                        <div id="pagination">
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <footer class="py-4 bg-light mt-auto">
            <div class="container-fluid px-4">
                <div class="d-flex align-items-center justify-content-between small">
                    <div class="text-muted">Copyright 2021. Alsamo All pictures cannot be copied without permission.</div>
                    <div>
                        <i class="fab fa-github"></i> <a href="https://github.com/jincheol2578">JINCHEOL KIM</a>
                        &middot;
                        <i class="fab fa-github"></i> <a href="https://github.com/heckevil">heckevil</a>
                    </div>
                </div>
            </div>
        </footer>
    </div>
</div>
<link href="/res/css/admin/styles.css" rel="stylesheet"/>
<link href="/res/css/admin/board.css" rel="stylesheet"/>
<script src="/res/js/admin/board.js"/>
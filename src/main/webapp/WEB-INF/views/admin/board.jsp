<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>Alsamo - 관리자</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet"/>
    <link href="/res/css/admin/styles.css" rel="stylesheet"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
            crossorigin="anonymous"></script>
</head>
<div id="layoutSidenav">
    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid px-4">
                <h1 class="mt-4">게시판 관리</h1>
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
                    <div class="card-body">
                        <table id="datatablesSimple" class="dataTable-table">
                            <thead>
                            <tr>
                                <th><input type="checkbox" id="allChk"></th>
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
                        <button onclick="delBoard()">삭제</button>
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
<script src="/res/js/admin/board.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
<script src="/res/js/admin/scripts.js"></script>
</body>
</html>

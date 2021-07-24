<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="infoNameContainer">
    <div id="infoCategory">
        <div><h2>${requestScope.infoUser.boardList[0].writer} 님의 프로필</h2></div>
        <div>
            <ul>
                <li><a href="/user/infowrite?uno=${requestScope.infoUser.boardList[0].uno}">게시글</a></li>
                <li><a href="/user/inforeply?uno=${requestScope.infoUser.boardList[0].uno}">댓글</a></li>

            </ul>
        </div>
    </div>
</div>

<div class="infoContent">
    <div class="infoUpper">
        <table class="table table-hover" id="infoWriteTable">
            <tr>
                <th></th>
                <th></th>
                <th>total ${infoUser.countBoardList} </th>
            </tr>
            <c:forEach var="item" items="${requestScope.infoUser.boardList}" begin="0" end="5">
                <tr>
                    <td><a href="/board/view?bcd=${item.bcd}&bno=${item.bno}">${item.btitle}</a></td>
                    <td><a href="/board/view?bcd=${item.bcd}&bno=${item.bno}">${item.bctnt}</a></td>
                    <td><a href="/board/view?bcd=${item.bcd}">
                        <div>${item.bcd}</div>
                    </a>
                        <div>${item.brdt}</div>
                    </td>

                </tr>
            </c:forEach>
        </table>

    </div>

    <br>
    <div class="infoDowner">
        <div>내가 쓴 댓글</div>

        <table class="table table-hover" id="infoReplyTable">
            <tr>
                <th></th>
                <th></th>
                <th>Total ${infoUser.countReplyList}</th>
            </tr>
            <c:forEach var="repItem" items="${requestScope.infoUser.replyList}" begin="0" end="5">
                <tr>
                    <td><a href="">댓글 바로가기</a></td>
                    <td><a href="">${repItem.repctnt} </a></td>
                    <td><a href="">
                        <div> 게시판 ${repItem.bnm} </div>
                    </a>
                        <div>${repItem.reprdt}</div>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

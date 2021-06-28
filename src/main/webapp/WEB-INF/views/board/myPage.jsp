<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="if" uri="http://java.sun.com/jsp/jstl/core" %>


<div id="container">

    <div class="content" action="/user/modUser">
        <div><h3>${sessionScope.loginUser.uid} 님</h3></div>
        <table>
            <tr>
                <div>
                    <th class="title">이메일</th>
                    <th class="prapoties"><input class="inputUser" type="text" name="uemail"
                                                 value="${sessionScope.loginUser.uemail}">
                    </th>
                </div>
            </tr>
            <tr>
                <div>
                    <td class="title">이름</td>
                    <td class="prapoties"><input class="inputUser" type="text" name="unm"
                                                 value="${sessionScope.loginUser.unm}"></td>
                </div>
            </tr>
        </table>
        <div class="button_container"><input class="button" type="submit" value="적용"></div>


        <div><a href="/board/list"><button class="button" type="button">취소</button></a></div>

        </form>


    </div>
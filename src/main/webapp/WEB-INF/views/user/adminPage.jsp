<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form action="/user/updUserMark" method="post" enctype="multipart/form-data" id="frm" onsubmit="return imgChk();">
    User 마크 선택 : <input type="file" name="profileImg" accept="image/*">
    계층 선택 : <select name="authNo">
    <option value="1">Superadmim</option>
    <option value="2">Admim</option>
    <option value="3">GenaralUser</option>
</select>
    <input type="submit" value="변경하기">
</form>


<script>
    var freElem = document.getElementsByName('#frm');

    function umgChk() {
        if (freElem.profileImg.length === 0) {
            alert('이미지를 선택 해주세요');
            return false;
        }
    }

</script>
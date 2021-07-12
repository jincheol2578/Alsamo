<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<form id="tag">
    <input type="text" id="tname">
    <input type="button" onclick="regTag();">
</form>
</body>
<script>
    function regTag() {
        const tname = document.getElementById('tname');
        const tnameVal = tname.value;
        const param = {
            tname: tnameVal
        };

        const init = {
            method: 'POST',
            body: JSON.stringify(param),
            headers:{
                'accept' : 'application/json',
                'content-type' : 'application/json;charset=UTF-8'
            }
        };
        fetch('/admin/tag',init)
        .then((res)=>{
            return res.json();
        })
    }
</script>
</html>
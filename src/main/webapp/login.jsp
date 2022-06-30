<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2022/6/30
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href="LoginCss.css" rel="stylesheet" type="text/css">
    <title>login</title>
</head>
<body>
<div id="div1">
<form action="mydb" method="post" id="loginform">
    姓名<input type="text" name="name"> <br>
    密码<input type="password" name="password"> <br>
    <button type="button" id="login">提交</button>
    <span id="span1"></span>

</form>
</div>
</body>
<script type="text/javascript">
    //首先绑定 点击事件
    console.log("你好")
    let lo = document.querySelector("#login");
    //取得表单
    let fo = document.querySelector("#loginform");
    let us = fo.name;
    let ps = fo.password;
    let span = document.querySelector("#span1");
    console.log(fo)
    lo.onclick=function () {
        //判空方法
        console.log(us.value.length)
        console.log(ps.value.length)
        if(us.value.length==0) {
            span.innerHTML="no name"
            return;
        }
        else if(ps.value.length==0) {
            span.innerHTML="no upwd"
            return;
        }
        else {
            console.log("提交")
            fo.submit();
        }

    }


</script>
</html>

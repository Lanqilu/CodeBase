<%--
  Created by IntelliJ IDEA.
  User: 88524
  Date: 2020/12/19
  Time: 下午 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.5.1.js"></script>
    <script>
        function a() {
            $.post({
                url: "${pageContext.request.contextPath}/t2",
                data: {"name": $("#username").val()},
                success: function (data) {
                    alert(data);
                    console.log("data:" + data)
                },
                error: function () {

                }
            })
        }

    </script>
</head>
<body>
<%--失去焦点的时候发起一个请求到后台--%>
<input type="text" id="username" onblur="a()">
</body>
</html>

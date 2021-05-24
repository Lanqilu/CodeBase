<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 88524
  Date: 2020/12/19
  Time: 下午 03:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍展示页面</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <style>
        a {
            text-decoration: none;
            color: black;
            font-size: 18px;
        }

        h3 {
            width: 180px;
            height: 38px;
            margin: 40px auto;
            text-align: center;
            line-height: 38px;
            background: bisque;
            border-radius: 5px;
        }


    </style>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>
                        <a href="${pageContext.request.contextPath}/book/allBook">书籍列表</a>
                    </small>
                </h1>
            </div>
            <div class="col-md-4 column">
                <form class="form-inline" action="${pageContext.request.contextPath}/book/queryBook" method="post">
                    <input type="text" name="queryBookName" class="form-control" placeholder="输入查询书籍的名称">
                    <input type="submit" value="查询" class="btn btn-primary">
                    <span style="color: crimson;font-weight:bold ">${error}</span>
                </form>
            </div>

        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th> 编号</th>
                    <th> 名称</th>
                    <th> 数量</th>
                    <th> 详情</th>
                    <th> 操作</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="book" items="${list}">
                    <tr>
                        <td>${book.bookID}</td>
                        <td>${book.bookName}</td>
                        <td>${book.bookCounts}</td>
                        <td>${book.detail}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/book/toUpdateBook?id=${book.bookID}">修改</a>
                            &nbsp;|&nbsp;
                            <a href="${pageContext.request.contextPath}/book/deleteBook/${book.bookID}">删除</a>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>

            </table>
        </div>
    </div>

</div>


<h3>
    <a href="${pageContext.request.contextPath}/book/toAddBook">新增书籍页面</a>
</h3>


</body>
</html>

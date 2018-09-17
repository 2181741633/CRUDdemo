<%--
  Created by IntelliJ IDEA.
  User: Knight-VS-Monster
  Date: 2018/9/11
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap-3.3.7/dist/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/static/jquery-1.12.4.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/layer/layer.js" type="text/javascript"></script>
</head>
<body>
<div class="container">
    <form action="${pageContext.request.contextPath}/fileupload" enctype="multipart/form-data" method="post">
        <input type="email" name="email">
        <input type="file" placeholder="选择文件">
        <button type="submit" class="btn btn-info btn-sm">提交</button>
    </form>
</div>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | Data Tables</title>
    <jsp:include page="${root}/WEB-INF/page/common/cs_01.jsp"/>

</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <jsp:include page="${root}/WEB-INF/page/common/header.jsp"/>
    <!-- Left side column. contains the logo and sidebar -->
    <jsp:include page="${root}/WEB-INF/page/common/leftmenu.jsp"/>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- /.content -->
        <div><a href="#" style="font-size: 50px">请点击左边菜单</a></div>
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="${root}/WEB-INF/page/common/footer.jsp"/>

</div>

<jsp:include page="${root}/WEB-INF/page/common/js_01.jsp"/>
<script>
    $(function () {
        $('#example1').DataTable();
    })
</script>
</body>
</html>


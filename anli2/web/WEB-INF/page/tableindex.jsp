<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | Data Tables</title>
    <jsp:include page="${root}/WEB-INF/page/common/cs_01.jsp"/>

</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">`

    <jsp:include page="${root}/WEB-INF/page/common/header.jsp"/>
    <!-- Left side column. contains the logo and sidebar -->
    <jsp:include page="${root}/WEB-INF/page/common/leftmenu.jsp"/>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
        <button class="btn btn-success btn-sm btn-flat" id="btnAddClazz">新增班级</button>
        <button class="btn btn-info btn-sm btn-flat" id="btnDFindClazz">查询班级</button>
        <button class="btn btn-danger btn-sm btn-flat" id="btnDelsClazz">删除班级</button>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li><a href="#">班级</a></li>
            <li class="active">查询</li>
        </ol>
    </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">

                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">班级列表</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="example2" class="table table-bordered table-hover">
                                <thead>
                                <tr style="background-color: oldlace">
                                    <th><input type="checkbox" name="allcheck" id="allC"> 全选/取消</th>
                                    <th class="text-center">序号</th>
                                    <th class="text-center">班级名称</th>
                                    <th class="text-center">学生数量</th>
                                    <th class="text-center">教师名称</th>
                                    <th class="text-center">创建时间</th>
                                    <th class="text-center">操作</th>
                                </tr>
                                </thead>

                                <tbody>
                                <c:forEach items="${clazzPage.objects}" var="clazz" varStatus="status">

                                    <tr id="${clazz.id}">
                                        <td><input type="checkbox" name="check" value="${clazz.id}"></td>
                                        <td class="text-center">${status.count}</td>
                                        <td class="text-center">${clazz.name}</td>
                                        <td class="text-center">${clazz.count}</td>
                                        <td class="text-center">${clazz.teacher}</td>
                                        <td class="text-center">${clazz.createTimeText}</td>
                                        <td class="text-center">
                                            <a href="#" class="btn btn-danger btn-sm btn-flat btnDelClazz">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            <a href="#" class="btn btn-warning btn-sm btn-flat bntUpdClazz">更改</a></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                                <tfoot>
                                <tr>
                                    <td colspan="7">
                                        <div class="box-footer clearfix">
                                            <ul class="pagination no-margin pull-left">
                                                <li>第${clazzPage.pageNo}页</li>
                                                <li>---</li>
                                                <li>共${clazzPage.pageCount}页</li>
                                            </ul>
                                            <ul class="pagination pagination-sm no-margin pull-right">
                                                <li><a href="${root}/clazz/select.do?PageNo=1&PageSize=8">首页</a></li>

                                                <c:if test="${!clazzPage.first}">
                                                    <li>
                                                        <a href="${root}/clazz/select.do?PageNo=${clazzPage.pageNo-1}&PageSize=8">«上一页</a>
                                                    </li>
                                                </c:if>

                                                <c:if test="${!clazzPage.last}">
                                                    <li>
                                                        <a href="${root}/clazz/select.do?PageNo=${clazzPage.pageNo+1}&PageSize=8">下一页»</a>
                                                    </li>
                                                </c:if>

                                                <li>
                                                    <a href="${root}/clazz/select.do?PageNo=${clazzPage.lastPage}&PageSize=8">尾页</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </td>
                                </tr>
                                </tfoot>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="${root}/WEB-INF/page/common/footer.jsp"/>
</div>


<div style="display: none" id="layerAddClazz">
    <div class="box box-info">
        <div class="box-header with-border">
            <h3 class="box-title">Horizontal Form</h3>
        </div>
        <!-- /.box-header -->
        <!-- form start -->
        <form class="form-horizontal" id="formforClazz">
            <div class="box-body">
                <div class="form-group">
                    <label for="clazzName" class="col-sm-2 control-label">班级名称</label>

                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="clazzName" placeholder="ClazzName" name="clazzName">
                    </div>
                </div>
                <div class="form-group">
                    <label for="teacherName" class="col-sm-2 control-label">教师名称</label>

                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="teacherName" placeholder="TeacherName"
                               name="teacherName">
                    </div>
                </div>
            </div>
            <!-- /.box-body -->
            <div class="box-footer">
                <button type="button" class="btn btn-success" id="layser_btnsubmit">提交</button>
                <button type="button" class="btn btn-warning pull-right" id="layser_btnno">取消</button>
            </div>
            <!-- /.box-footer -->
        </form>
    </div>
</div>
<jsp:include page="${root}/WEB-INF/page/common/js_01.jsp"/>
<script>
    $(function () {
        $('#example1').DataTable();
        $("#btnAddClazz").click(function () {
            layer.open({
                title: "添加班级信息",
                type: 1,
                area: ['520px', '300px'],
                content: $("#layerAddClazz")
            });
        });
        $("#layser_btnsubmit").click(function () {
            var url = "${root}/clazz/add.do";
            var sa = $("#formforClazz").serialize();
            $.post(url, sa, function (data) {
                if (data == "ok") {
                    layer.msg("信息添加成功!", {time: 700}, function () {
                        $("#formforClazz").get(0).reset();
                        layer.closeAll();
                    });
                };
            });
        });
        $("#layser_btnno").click(function () {
            $("#formforClazz").get(0).reset();
            layer.closeAll();
        });
        $("#btnDFindClazz").click(function () {
            window.location.href = "${root}/clazz/select.do";
        });
        /* $("#example2").DataTable({
             "language": {
                 "sProcessing": "处理中...",
                 "sLengthMenu": "显示 _MENU_ 项结果",
                 "sZeroRecords": "没有匹配结果",
                 "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                 "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                 "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                 "sInfoPostFix": "",
                 "sSearch": "搜索:",
                 "sUrl": "",
                 "sEmptyTable": "未搜索到数据",
                 "sLoadingRecords": "载入中..."
                 "oPaginate": {,
                 "sInfoThousands": ",",
                     "sFirst": "首页",
                     "sPrevious": "上页",
                     "sNext": "下页",
                     "sLast": "末页"
                 },
                 "oAria": {
                     "sSortAscending": ": 以升序排列此列",
                     "sSortDescending": ": 以降序排列此列"
                 }
             }
         });*/
        $(".btnDelClazz").click(function () {
            var id = $(this).parents("tr").attr("id");
            layer.confirm('狠心让我离开吗?', {icon: 3, title: '提示'}, function (index) {
                $.ajax({
                    type: "POST",
                    url: "${root}/clazz/del.do",
                    data: {"id": id},
                    success: function (msg) {
                        if (msg == "ok") {
                            layer.msg("删除成功!", {time: 700}, function () {
                                layer.close(index);
                                window.location.reload();
                            });
                        }
                    }
                });
            });
        });

        $("#btnDelsClazz").click(function () {
            var arr = new Array();
            var i = 0;
            $("input:checkbox[name='check']").each(function () {
                if ($(this).is(":checked")) {
                    arr[i] = $(this).val();
                    i = i + 1;
                }
            });
            var url = "${root}/clazz/dels.do";
            var data = {"arr": arr};
            layer.confirm('狠心让我离开吗?', {icon: 3, title: '提示'}, function (index) {
                $.post(url, data, function (msg) {
                    if (msg == "ok") {
                        layer.msg("删除成功!", {time: 700}, function () {
                            layer.close(index);
                            window.location.reload();
                        });
                    }
                });
            });
        });

        $("#allC").click(function () {
            var checked = $("#allC").is(":checked");
            $("input:checkbox[name='check']").each(function () {
                $(this).prop("checked", checked);
            })
        });
    })
</script>
</body>
</html>


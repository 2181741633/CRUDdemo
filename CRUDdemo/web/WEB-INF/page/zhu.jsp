<%--
  Created by IntelliJ IDEA.
  User: Knight-VS-Monster
  Date: 2018/9/5
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap-3.3.7/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h1>员工部门信息表</h1>
        </div>
    </div>
    <section class="content-header pull-right">
        <button class="btn btn-success btn-sm btn-flat" id="btnAddDept">新增员工</button>
        <button class="btn btn-danger btn-sm btn-flat" id="btnDelsDept">删除员工</button>
    </section>
    <br>
    <div class="row">
        <div class="col-md-12">

            <%-- 主要数据表--%>
            <table class="table table-hover">
                <tr>
                    <th><input type="checkbox" id="check_all"></th>
                    <th>员工编号</th>
                    <th>员工姓名</th>
                    <th>性别</th>
                    <th>邮箱</th>
                    <th>所属部门</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${pageinfo.list}" var="page">
                    <tr>
                        <td><input type="checkbox" class="checkbox_litter"></td>
                        <td>${page.uId}</td>
                        <td>${page.uName}</td>
                        <td>${page.uGender}</td>
                        <td>${page.uEmail}</td>
                        <td>${page.dept.dName}</td>
                        <td>
                            <button class="btn btn-primary updata_btn" upid="${page.uId}">
                                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                编辑
                            </button>
                            <button class="btn btn-danger delete_btn" delid="${page.uId}">
                                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                删除
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>


    <%--数据表分页--%>
    <div class="row">
        <div class="col-md-6">
            第${pageinfo.pageNum}页，共${pageinfo.pages}页，共 ${pageinfo.total} 条记录。
        </div>
        <div class="pull-right">
            <ul class="pagination">
                <c:if test="${pageinfo.isFirstPage}">
                    <li class="disabled"><a href="${pageContext.request.contextPath}/page?pageno=1">首页</a></li>
                </c:if>
                <c:if test="${!pageinfo.isFirstPage}">
                    <li><a href="${pageContext.request.contextPath}/page?pageno=1">首页</a></li>
                </c:if>
                <c:if test="${pageinfo.hasPreviousPage}">
                    <li>
                        <a href="${pageContext.request.contextPath}/page?pageno=${pageinfo.pageNum-1}"
                           aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:forEach items="${pageinfo.navigatepageNums}" var="pageNum">
                    <c:if test="${pageNum == pageinfo.pageNum}">
                        <li class="active"><a href="#">${pageNum}</a></li>
                    </c:if>
                    <c:if test="${pageNum != pageinfo.pageNum}">
                        <li><a href="${pageContext.request.contextPath}/page?pageno=${pageNum}">${pageNum}</a></li>
                    </c:if>
                </c:forEach>
                <c:if test="${pageinfo.hasNextPage}">
                    <li>
                        <a href="${pageContext.request.contextPath}/page?pageno=${pageinfo.pageNum+1}"
                           aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>

                <c:if test="${pageinfo.isLastPage}">
                    <li class="disabled"><a
                            href="${pageContext.request.contextPath}/page?pageno=${pageinfo.pages}">尾页</a></li>
                </c:if>
                <c:if test="${!pageinfo.isLastPage}">
                    <li><a href="${pageContext.request.contextPath}/page?pageno=${pageinfo.pages}">尾页</a></li>
                </c:if>
            </ul>
        </div>
    </div>

</div>

<%--添加模态框--%>
<div style="display: none" id="layeraddUser">
    <div class="box box-info">
        <!-- form start -->
        <form class="form-horizontal" id="formforDepts">
            <div class="box-body">
                <div class="form-group">
                    <label for="userName" class="col-sm-2 control-label">员工名称</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="userName" placeholder="userName" name="uName">
                        <span class="help-block"></span>
                    </div>
                </div>

                <div class="form-group">
                    <label for="emailName" class="col-sm-2 control-label">邮箱名称</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="emailName" placeholder="emailName" name="uEmail">
                        <span class="help-block"></span>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">性别</label>
                    <div class="col-sm-10">
                        <input type="radio" name="uGender" value="男" checked="checked">男
                        <input type="radio" name="uGender" value="女">女
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">部门</label>
                    <select class="col-sm-3" id="selectDept" name="dId">

                    </select>
                </div>

            </div>
            <!-- /.box-body -->
            <div class="box-footer">
                <div class="col-md-6">
                    <button type="button" class="btn btn-success" id="layser_btnsubmit">提交</button>
                </div>
                <div class="col-md-6">
                    <button type="button" class="btn btn-warning pull-right" id="layser_btnno">取消</button>
                </div>
            </div>
            <!-- /.box-footer -->
        </form>
    </div>
</div>

<%--修改模态框--%>
<div style="display: none" id="layerupdateUser">
    <div class="box box-info">
        <!-- form start -->
        <form class="form-horizontal" id="formforUpdate">
            <div class="box-body">
                <div class="form-group">
                    <label for="userName" class="col-sm-2 control-label">员工名称</label>
                    <div class="col-sm-10">
                        <p class="form-control-static" id="upuserName_static"></p>
                    </div>
                </div>

                <div class="form-group">
                    <label for="emailName" class="col-sm-2 control-label">邮箱名称</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="upemailName" placeholder="emailName" name="uEmail">
                        <span class="help-block"></span>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">性别</label>
                    <div class="col-sm-10">
                        <input type="radio" name="uGender" value="男" checked="checked">男
                        <input type="radio" name="uGender" value="女">女
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">部门</label>
                    <select class="col-sm-3" id="upselectDept" name="dId">

                    </select>
                </div>

            </div>
            <!-- /.box-body -->
            <div class="box-footer">
                <div class="col-md-6">
                    <button type="button" class="btn btn-success" id="uplayser_btnsubmit">提交</button>
                </div>
                <div class="col-md-6">
                    <button type="button" class="btn btn-warning pull-right" id="uplayser_btnno">取消</button>
                </div>
            </div>
            <!-- /.box-footer -->
        </form>
    </div>
</div>
</body>
<script src="${pageContext.request.contextPath}/static/jquery-1.12.4.min.js"></script>
<script src="${pageContext.request.contextPath}/static/bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/layer/layer.js" type="text/javascript"></script>
<script>
    $(function () {
        /*新增按钮点击事件*/
        $("#btnAddDept").click(function () {
            getDepts("#selectDept");
            $("#userName").next("span").text("");
            $("#emailName").next("span").text("");
            $("#emailName").parent().removeClass("has-success has-error");
            $("#userName").parent().removeClass("has-success has-error");
            layer.open({
                title: "添加员工信息",
                type: 1,
                area: ['520px', '300px'],
                content: $("#layeraddUser")/*弹出新增模态框*/
            });
        });
        /* 编辑按钮点击事件*/
        $(".updata_btn").click(function () {
            getDepts("#upselectDept");
            var upid = $(this).attr("upid");
            $("#uplayser_btnsubmit").attr("up_upid", upid);
            $.ajax({
                url: "${pageContext.request.contextPath}/uname/" + upid,
                type: "GET",
                success: function (result) {
                    console.log(result);
                    $("#upuserName_static").text(result.uName);
                    $("#upemailName").val(result.uEmail);
                    $("#formforUpdate input[name=uGender]").val([result.uGender]);
                    $("#formforUpdate select[name=dId]").val([result.dId]);
                }
            });
            layer.open({
                title: "修改员工信息",
                type: 1,
                area: ['520px', '300px'],
                content: $("#layerupdateUser")/*弹出修改模态框*/
            });
        });
        /*新增模态框用户名校验方法*/
        $("#userName").change(function () {
            var user = $("#userName").val();
            var usercheck = /(^[a-zA-Z0-9_-]{3,16}$)|(^[\u2E80-\u9FFF]{2,5}$)/
            $("#userName").parent().removeClass("has-success has-error");
            $("#userName").next("span").text("");
            if (!usercheck.test(user)) {
                show_msg("#userName", "error", "用户名必须是2-5位的汉字或者6-16位的英文或数字！");
            } else {
                var url = "${pageContext.request.contextPath}/findcf";
                var data = "uName=" + $("#userName").val();
                $.post(url, data, function (result) {
                    if (result == "ok") {
                        show_msg("#userName", "success", "用户名可用");
                        $("#layser_btnsubmit").attr("ajax-check", "success");
                    } else {
                        show_msg("#userName", "error", "用户名不可用");
                        $("#layser_btnsubmit").attr("ajax-check", "error");
                    }
                });
                show_msg("#userName", "success", "用户名可用");
            }
        });
        /*新增模态框邮箱验证方法*/
        $("#emailName").change(function () {
            var email = $("#emailName").val();
            var emailcheck = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
            $("#emailName").parent().removeClass("has-success has-error");
            $("#emailName").next("span").text("");
            if (!emailcheck.test(email)) {
                show_msg("#emailName", "error", "邮箱格式不正确！");
            } else {
                show_msg("#emailName", "success", "邮箱可用");
            }
        });
        /*修改模态框邮箱验证方法*/
        $("#upemailName").change(function () {
            var email = $("#upemailName").val();
            var emailcheck = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
            $("#upemailName").parent().removeClass("has-success has-error");
            $("#upemailName").next("span").text("");
            if (!emailcheck.test(email)) {
                show_msg("#upemailName", "error", "邮箱格式不正确！");
                $("#uplayser_btnsubmit").attr("ajax-check", "success");
            } else {
                show_msg("#upemailName", "success", "邮箱可用");
                $("#uplayser_btnsubmit").attr("ajax-check", "error");
            }
        });
        /*新增信息的提交*/
        $("#layser_btnsubmit").click(function () {
            if ($(this).attr("ajax-check") == "error" || $("#userName").val().length == 0 || $("#emailName").val().length == 0) {
                return false;
            }
            var url = "${pageContext.request.contextPath}/users";
            var sa = $("#formforDepts").serialize();
            $.post(url, sa, function (data) {
                if (data == "ok") {
                    layer.msg("信息添加成功!", {time: 700}, function () {
                        $("#formforDepts").get(0).reset();
                        layer.closeAll();
                    });
                }
            });
            window.location.reload();
        });
        /*新增模态框关闭*/
        $("#layser_btnno").click(function () {
            $("#formforDepts").get(0).reset();
            layer.closeAll();
        });
        /*修改模态框关闭*/
        $("#uplayser_btnno").click(function () {
            $("#formforUpdate").get(0).reset();
            layer.closeAll();
        });

        /*修改信息的提交*/
        $("#uplayser_btnsubmit").click(function () {
            if ($("#upemailName").attr("ajax-check") == "error" || $("#upemailName").val().length == 0) {
                return false;
            }
            $.ajax({
                url: "${pageContext.request.contextPath}/update/" + $(this).attr("up_upid"),
                type: "PUT",
                data: $("#formforUpdate").serialize(),
                success: function () {
                    layer.msg("信息修改成功!", {time: 700}, function () {
                        $("#formforUpdate").get(0).reset();
                        layer.closeAll();
                    });
                }
            })
            window.location.reload();
        })

        /*用户名邮箱  <span> 验证的方法*/
        function show_msg(show, flag, msg) {
            if ("success" == flag) {
                $(show).parent().addClass("has-success");
                $(show).next("span").text(msg);
            } else if ("error" == flag) {
                $(show).parent().addClass("has-error");
                $(show).next("span").text(msg);
            }
        }

        /*部门获取*/
        function getDepts(ele) {
            $(ele).empty();
            $.ajax({
                url: "${pageContext.request.contextPath}/depts",
                type: "GET",
                success: function (result) {
                    $.each(result, function () {
                        var opption = $("<option></option>").append(this.dName).attr("value", this.dId);
                        $(ele).append(opption);
                    });
                }
            });
        }

        /*点击单个按钮删除*/
        $(".delete_btn").click(function () {
            var del_name = $(this).parents("tr").find("td:eq(2)").text();
            var delid = $(this).attr("delid");
            layer.confirm('要让' + del_name + '离开吗?', {icon: 3, title: '提示'}, function (index) {
                $.ajax({
                    url: "${pageContext.request.contextPath}/del/" + delid,
                    type: "DELETE",
                    success: function () {
                        layer.msg("删除成功!", {time: 700}, function () {
                            layer.close(index);
                            window.location.reload();
                        });
                    }
                });
            });
        });

        /*点击表头选择框  全选*/
        $("#check_all").click(function () {
            var flag = $(this).prop("checked");
            $(".checkbox_litter").each(function () {
                $(".checkbox_litter").prop("checked", flag);
            })
        });

        /*选中列表的多选框  表头选择框也被选中 全选*/
        $(".checkbox_litter").click(function () {
            var flag = $(".checkbox_litter:checked").length == $(".checkbox_litter").length;
            $("#check_all").prop("checked", flag);
        });

        /*批量删除*/
        $("#btnDelsDept").click(function () {
            var unames = "";
            var delids = "";
            $(".checkbox_litter:checked").each(function () {
                unames += $(this).parents("tr").find("td:eq(2)").text() + "；";
                delids += $(this).parents("tr").find("td:eq(1)").text() + "-";
            });
            unames = unames.substring(0, unames.length - 1);
            delids = delids.substring(0, delids.length - 1);
            layer.confirm('要让【' + unames + '】离开吗?', {icon: 3, title: '提示'}, function (index) {
                $.ajax({
                    url: "${pageContext.request.contextPath}/del/" + delids,
                    type: "DELETE",
                    success: function () {
                        layer.msg("删除成功!", {time: 700}, function () {
                            layer.close(index);
                            window.location.reload();
                        });
                    }
                })
            });
        });
    })
</script>
</html>

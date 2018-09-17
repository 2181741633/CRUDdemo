
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | Log in</title>
    <jsp:include page="${root}/WEB-INF/page/common/cs_02.jsp"/>
</head>
<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <a href="#"><b>登录</b></a>
    </div>
    <!-- /.login-logo -->
    <div class="login-box-body">

        <form action="${root}/user/login.do" method="post">
            <div class="form-group has-feedback">
                <input type="text" class="form-control" placeholder="用户名" name="name">
                <span class="glyphicon glyphicon-user form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="text" class="form-control" placeholder="密码" name="password">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="row">
                <div class="col-xs-7">
                    <div class="checkbox icheck">
                        <label>
                            <input type="checkbox">记住密码
                        </label>
                    </div>
                </div>
                <!-- /.col -->
                <div class="col-xs-5">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">登录</button>
                </div>
                <!-- /.col -->
            </div>
        </form>

     <div>
         <div class="row">
             <div class="col-xs-12">
                      <span class="has-error help-block" style="color: orangered">${msg}</span>
             </div>
         </div>
     </div>

        <div class="social-auth-links text-center">
            <p>- OR -</p>
            <div class="row">
                <div class="col-xs-6">
                    <a href="#" type="button" class="btn btn-warning btn-block btn-flat">忘记密码</a>
                </div>
                <div class="col-xs-6">
                    <a href="${root}/zhuce.jsp" class="btn btn-info btn-block btn-flat">注册</a>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- jQuery 3 -->
<script src="../../bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="../../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="../../plugins/iCheck/icheck.min.js"></script>
<script>
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' /* optional */
        });


    });
</script>
</body>
</html>


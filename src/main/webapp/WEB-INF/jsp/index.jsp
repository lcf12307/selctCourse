<%--
  Created by IntelliJ IDEA.
  User: Phoenix
  Date: 2016/12/21
  Time: 下午10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/tag.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>学生选课系统</title>
    <%@include file="common/header.jsp"%>
    <link href="/dist/css/main-page.css" rel="stylesheet">
</head>
<body>

    <div id="main">
        <div id="login-view">
            <div class="cover">
                <div class="login-form">
                    <div class="form-group">
                        <input type="text" class="form-control login-field" value="" placeholder="Enter your name" id="userId" />
                        <label class="login-field-icon fui-user"></label>
                    </div>

                    <div class="form-group">
                        <input type="password" class="form-control login-field" value="" placeholder="Password" id="userPassword" />
                        <label class="login-field-icon fui-lock"></label>
                    </div>

                    <div class="form-group">
                        <select class="form-control select select-primary" id="userType" data-toggle="select">
                            <option value="0" selected>学生</option>
                            <option value="1">教师</option>
                            <option value="2">管理员</option>
                        </select>
                    </div>

                    <a class="btn btn-primary btn-lg btn-block" id="loginButton">Log in</a>
                    <a class="login-link" href="#">Lost your password?</a>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="errorModal" tabindex="-1" role="dialog" aria-labelledby="errorModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">警告</h4>
                </div>
                <div class="modal-body" id="errorContent">用户名或密码不得为空！</div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-dismiss="modal">关闭</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>

    <script src="/dist/js/vendor/jquery.min.js"></script>
    <script src="/dist/js/vendor/video.js"></script>
    <script src="/dist/js/flat-ui.min.js"></script>
    <script src="/js/loginPage.js" type="text/javascript"></script>
</body>
</html>

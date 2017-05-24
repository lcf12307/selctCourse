<%--
  Created by IntelliJ IDEA.
  User: Phoenix
  Date: 2016/12/25
  Time: 下午2:56
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: Phoenix
  Date: 2016/12/23
  Time: 上午12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/tag.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>管理员——管理中心</title>
    <%@ include file="common/header.jsp"%>
    <link href="/dist/css/student-page.css" rel="stylesheet">
    <script>
        var model=[];
        model.managerId = ${managerId};
    </script>
</head>
<body>
<div class="modal fade" id="infoModal" tabindex="-1" role="dialog" aria-labelledby="modalInfoLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="modalInfoLabel"></h4>
            </div>
            <div class="modal-body" id="modalInfoContent"></div>
            <div class="modal-footer">
                <button id="modalBtn" type="button" class="btn btn-danger" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<div class="container">

    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand">课程中心</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"> <c:out value="您好，${managerName}!"/> <span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#">个人信息</a></li>
                            <li class="divider"></li>
                            <li><a href="./logout">退出</a></li>
                        </ul>
                    </li>
                </ul>
            </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
    </nav>

    <div id="content" class="container-fluid">
        <div class="col-md-2">
            <ul class="nav nav-pills nav-stacked" role="tablist">
                <li role="presentation" id="addStudentBtn"><a href="#">添加学生</a></li>
                <li role="presentation" id="delStudentBtn"><a href="#">删除学生</a></li>
                <li role="presentation" id="addTeacherBtn"><a href="#">添加教师</a></li>
                <li role="presentation" id="delTeacherBtn"><a href="#">删除教师</a></li>
                <li role="presentation" id="addCourseBtn"><a href="#">添加课程</a></li>
                <li role="presentation" id="delCourseBtn"><a href="#">删除课程</a></li>
                <li role="presentation" id="authorityControlBtn"><a href="#">权限控制</a></li>
            </ul>
        </div>
        <div class="col-md-10">
            <ol class="breadcrumb">
                <li class="active"><a href="#">首页</a></li>
                <li><a id="nextLineList"></a></li>
            </ol>

            <div id="contentDiv"></div>


        </div>
    </div>
</div>

<script src="/dist/js/vendor/jquery.min.js"></script>
<script src="/dist/js/vendor/video.js"></script>
<script src="/dist/js/flat-ui.min.js"></script>
<script src="/js/managerPage.js" type="text/javascript"></script>
</body>
</html>
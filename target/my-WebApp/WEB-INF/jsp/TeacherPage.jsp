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
    <title>教师——选课中心</title>
    <%@ include file="common/header.jsp"%>
    <link href="/dist/css/student-page.css" rel="stylesheet">
    <script>
        var model=[];
        model.teacherId = ${teacherId};
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
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"> <c:out value="您好，${teacherName}!"/> <span class="caret"></span></a>
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
                <li role="presentation" id="showStudentTableBtn"><a href="#">学生名单</a></li>
                <li role="presentation" id="inputGradeBtn"><a href="#">成绩录入</a></li>
                <li role="presentation" id="userCenterBtn"><a href="#">个人中心</a></li>
            </ul>
        </div>
        <div class="col-md-10">
            <ol class="breadcrumb">
                <li class="active"><a href="#">首页</a></li>
                <li><a id="nextLineList"></a></li>
            </ol>
            <div id="studentListDiv" hidden>

            </div>
            <div id="inputGradeListDiv" hidden>

            </div>
        </div>
    </div>
</div>

<script src="/dist/js/vendor/jquery.min.js"></script>
<script src="/dist/js/vendor/video.js"></script>
<script src="/dist/js/flat-ui.min.js"></script>
<script src="/js/teacherPage.js" type="text/javascript"></script>
</body>
</html>

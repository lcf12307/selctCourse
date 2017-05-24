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
    <title>学生——选课中心</title>
    <%@ include file="common/header.jsp"%>
    <link href="/dist/css/student-page.css" rel="stylesheet">
    <script>
        var model=[];
        model.stuId = ${stuId};
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
                <a class="navbar-brand">选课系统</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"> <c:out value="您好，${stuName}!"/> <span class="caret"></span></a>
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
                <li role="presentation" id="showCourseTableBtn"><a href="#">查看课表</a></li>
                <li role="presentation" id="selectCourseBtn"><a href="#">教学选课</a></li>
                <li role="presentation" id="queryGradeBtn"><a href="#">查询成绩</a></li>
                <li role="presentation" id="userCenterBtn"><a href="#">个人中心</a></li>
            </ul>
        </div>
        <div class="col-md-10">
            <ol class="breadcrumb">
                <li class="active"><a href="#">首页</a></li>
                <li><a id="nextLineList"></a></li>
            </ol>
            <table hidden class="table table-striped table-hover" id="courseTable">
                <tr>
                    <th>课程编号</th>
                    <th>课程名称</th>
                    <th>授课老师名</th>
                    <th>课程时长</th>
                    <th>课程学分</th>
                    <th>课程状态</th>
                </tr>
            </table>
            <table hidden class="table table-striped table-hover" id="allCourseTable">
                <tr>
                    <th>课程编号</th>
                    <th>课程名称</th>
                    <th>授课老师名</th>
                    <th>课程时长</th>
                    <th>课程学分</th>
                    <th>课程状态</th>
                </tr>
            </table>
            <table hidden class="table table-striped table-hover" id="gradeTable">
                <tr>
                    <th>课程编号</th>
                    <th>课程名称</th>
                    <th>授课老师名</th>
                    <th>课程时长</th>
                    <th>课程学分</th>
                    <th>课程成绩</th>
                </tr>
            </table>
        </div>
    </div>
</div>

    <script src="/dist/js/vendor/jquery.min.js"></script>
    <script src="/dist/js/vendor/video.js"></script>
    <script src="/dist/js/flat-ui.min.js"></script>
    <script src="/js/studentPage.js" type="text/javascript"></script>
</body>
</html>

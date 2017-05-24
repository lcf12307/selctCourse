/**
 * Created by Phoenix on 2016/12/23.
 */

function modalInfo(title, content) {
    $('#modalInfoLabel').text(title);
    $('#modalInfoContent').empty();
    $('#modalInfoContent').append(content);
    $('#infoModal').modal();
}

var courseListJson;

$('#showCourseTableBtn').click(function () {
    $('#nextLineList').text("查询课表");
    $('#allCourseTable').hide();
    $('#courseTable').show();
    $('#gradeTable').hide();
    var url = "http://localhost:8080/student/"+model.stuId+"/courses";
    $.ajax({
        type: 'GET',
        url: url,
        dataType: 'json',
        success: function (jsonResult) {
            var key = "courseList";
            var courseList = jsonResult[key];
            var studentAuthority = jsonResult["studentAuthority"];
            $('#courseTable tr:not(:first)').empty();
            for (var index in courseList) {
                var head = "<tr>";
                var body = "<td>"+courseList[index].courseId+"</td>"+
                           "<td>"+courseList[index].courseName+"</td>"+
                           "<td><a href='#'>"+courseList[index].teacherName+"</a></td>"+
                           "<td>"+courseList[index].coureTime+"</td>"+
                           "<td>"+courseList[index].courseCredit+"</td>"+
                           "<td><a href=\"#\" class=\"btn-lg btn-danger\" disabled=\"无法退课\">退课</a></td>";
                var tail = "</tr>";
                $('#courseTable tr:last').after(head+body+tail);
                $('#courseTable tr:last:last').find("td:nth-child(3)").on("click",(function closure(tmpIndex){
                    return function() {
                        $('#modalInfoLabel').text("教师信息");
                        $('#modalInfoContent').empty();
                        $('#modalInfoContent').append("<a>教师姓名:"+courseList[tmpIndex].teacherInfo.teacherName+"</a><br/>");
                        $('#modalInfoContent').append("<a>教师性别:"+courseList[tmpIndex].teacherInfo.teacherSex+"</a><br/>");
                        $('#modalInfoContent').append("<a>教师职称:"+courseList[tmpIndex].teacherInfo.teacherRanks+"</a><br/>");
                        $('#modalInfoContent').append("<a>教师学院:"+courseList[tmpIndex].teacherDeptName+"</a>");
                        $('#infoModal').modal();
                    }
                })(index));
                // 选课权限开放, 更改属性添加监听事件
                if(studentAuthority == 1) {
                    $('#courseTable tr:last:last').find("td:nth-child(6)").find('a').removeAttr("disabled");
                    $('#courseTable tr:last:last').find("td:nth-child(6)").find('a').on("click",(function closure(tmpIndex){
                        return function() {
                            var url = "http://localhost:8080/student/quit";
                            $.ajax({
                                type: 'POST',
                                url: url,
                                contentType: 'application/json',
                                dataType: 'json',
                                data: JSON.stringify({
                                    studentId: model.stuId,
                                    courseId: courseList[tmpIndex].courseId,
                                    teacherId: courseList[tmpIndex].teacherInfo.teacherId
                                }),
                                success: function (jsonResult) {
                                    if(jsonResult.result==1) {
                                        $('#modalInfoLabel').text("结果");
                                        $('#modalInfoContent').empty();
                                        $('#modalInfoContent').text("退课成功");
                                        $('#modalBtn').click(function() {
                                            $('#showCourseTableBtn').click();
                                            $('#modalBtn').unbind();
                                        });
                                        $('#infoModal').modal();
                                    } else {
                                        alert("退课失败");
                                    }
                                },
                                error: function (e) {
                                    alert("ERRR");
                                }
                            });
                        }
                    })(index));
                }
                else {
                    modalInfo("提示","现在不是选课时间");
                }
            }

        },
        error: function (e) {
            alert("Err");
        }
    });
});


$('#queryGradeBtn').click(function () {
    $('#nextLineList').text("查询成绩");
    $('#courseTable').hide();
    $('#allCourseTable').hide();
    $('#gradeTable').show();
    var url = "http://localhost:8080/student/"+model.stuId+"/grades";
    $.ajax({
        type: 'GET',
        url: url,
        dataType: 'json',
        success: function (jsonResult) {
            courseListJson = jsonResult;
            $('#gradeTable').show();
            var key = "courseList";
            var courseList = jsonResult[key];
            $('#gradeTable tr:not(:first)').empty();
            for (var index in courseList) {
                var head = "<tr>";
                var body = "<td>"+courseList[index].courseId+"</td>"+
                    "<td>"+courseList[index].courseName+"</td>"+
                    "<td><a href='#'>"+courseList[index].teacherName+"</a></td>"+
                    "<td>"+courseList[index].coureTime+"</td>"+
                    "<td>"+courseList[index].courseCredit+"</td>"+
                    "<td>"+courseList[index].courseGrade+"</td>";
                var tail = "</tr>";
                $('#gradeTable tr:last').after(head+body+tail);
                $('#gradeTable tr:last').find("td:nth-child(3)").on("click",(function closure(tmpIndex){
                    return function() {
                        $('#modalInfoLabel').text("教师信息");
                        $('#modalInfoContent').empty();
                        $('#modalInfoContent').append("<a>教师姓名:"+courseList[tmpIndex].teacherInfo.teacherName+"</a><br/>");
                        $('#modalInfoContent').append("<a>教师性别:"+courseList[tmpIndex].teacherInfo.teacherSex+"</a><br/>");
                        $('#modalInfoContent').append("<a>教师职称:"+courseList[tmpIndex].teacherInfo.teacherRanks+"</a><br/>");
                        $('#modalInfoContent').append("<a>教师学院:"+courseList[tmpIndex].teacherDeptName+"</a>");
                        $('#infoModal').modal();
                    }
                })(index));
            }
        },
        error: function (e) {
            alert("Err");
        }
    });
});

$('#userCenterBtn').click(function () {
    $('#nextLineList').text("用户中心");
    $('#courseTable').hide();
    $('#allCourseTable').hide();
    $('#gradeTable').hide();
});

$('#selectCourseBtn').click(function() {
    $('#nextLineList').text("教学选课");
    $('#courseTable').hide();
    $('#allCourseTable').show();
    $('#gradeTable').hide();
    var url = "http://localhost:8080/student/"+model.stuId+"/selection";
    $.ajax({
        type: 'GET',
        url: url,
        dataType: 'json',
        success: function (jsonResult) {
            var studentAuthority = jsonResult["studentAuthority"];
            courseListJson = jsonResult;
            $('#allCourseTable').show();
            var key = "courseList";
            var courseList = jsonResult[key];
            $('#allCourseTable tr:not(:first)').empty();
            for (var index in courseList) {
                var head = "<tr>";
                var body = "<td>"+courseList[index].courseId+"</td>"+
                    "<td>"+courseList[index].courseName+"</td>"+
                    "<td><a href='#'>"+courseList[index].teacherName+"</a></td>"+
                    "<td>"+courseList[index].coureTime+"</td>"+
                    "<td>"+courseList[index].courseCredit+"</td>";
                if(courseList[index].isSelected == 1)
                    body+="<td><a href=\"#\" class=\"btn-lg btn-default\" disabled=\"disabled\">已选</a></td>";
                else
                    body+="<td><a href=\"#\" class=\"btn-lg btn-success\" >选课</a></td>";
                var tail = "</tr>";
                $('#allCourseTable tr:last').after(head+body+tail);
                $('#allCourseTable tr:last').find("td:nth-child(3)").on("click",(function closure(tmpIndex){
                    return function() {
                        $('#modalInfoLabel').text("教师信息");
                        $('#modalInfoContent').empty();
                        $('#modalInfoContent').append("<a>教师姓名:"+courseList[tmpIndex].teacherInfo.teacherName+"</a><br/>");
                        $('#modalInfoContent').append("<a>教师性别:"+courseList[tmpIndex].teacherInfo.teacherSex+"</a><br/>");
                        $('#modalInfoContent').append("<a>教师职称:"+courseList[tmpIndex].teacherInfo.teacherRanks+"</a><br/>");
                        $('#modalInfoContent').append("<a>教师学院:"+courseList[tmpIndex].teacherDeptName+"</a>");
                        $('#infoModal').modal();
                    }
                })(index));
                if(studentAuthority == 1) {
                    $('#allCourseTable tr:last:last').find("td:nth-child(6)").find('a').removeAttr("disabled");
                    $('#allCourseTable tr:last:last').find("td:nth-child(6)").find('a').on("click",(function closure(tmpIndex){
                        return function() {
                            var url = "http://localhost:8080/student/selectcourse";
                            $.ajax({
                                type: 'POST',
                                url: url,
                                contentType: 'application/json',
                                dataType: 'json',
                                data: JSON.stringify({
                                    studentId: model.stuId,
                                    courseId: courseList[tmpIndex].courseId,
                                    teacherId: courseList[tmpIndex].teacherInfo.teacherId
                                }),
                                success: function (jsonResult) {
                                    if(jsonResult.result == 1) {
                                        $('#modalInfoLabel').text("结果");
                                        $('#modalInfoContent').empty();
                                        $('#modalInfoContent').text("选课成功");
                                        $('#modalBtn').click(function() {
                                            $('#selectCourseBtn').click();
                                            $('#modalBtn').unbind();
                                        });
                                        $('#infoModal').modal();
                                    } else {
                                        $('#modalInfoLabel').text("警告");
                                        $('#modalInfoContent').empty();
                                        $('#modalInfoContent').text("不可重复选课");
                                        $('#infoModal').modal();
                                    }

                                },
                                error: function (e) {
                                    $('#modalInfoLabel').text("警告");
                                    $('#modalInfoContent').empty();
                                    $('#modalInfoContent').text("不可重复选课");
                                    $('#infoModal').modal();
                                }
                            });
                        }
                    })(index));
                }
                else {
                    modalInfo("提示","现在不是选课时间！");
                }
            }
        },
        error: function (e) {
            alert("Err");
        }
    });
});


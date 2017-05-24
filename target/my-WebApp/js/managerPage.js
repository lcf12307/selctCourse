/**
 * Created by Phoenix on 2016/12/24.
 */
function modalInfo(title, content) {
    $('#modalInfoLabel').text(title);
    $('#modalInfoContent').empty();
    $('#modalInfoContent').append(content);
    $('#infoModal').modal();
}

$('#addStudentBtn').click(function () {
    $('#contentDiv').empty();
    $('#contentDiv').append(
        '<div id="studentRegTable">' +
            '<div class="form-group has-feedback">' +
                '<h3 class="name-title">姓名</h3>' +
                '<input id="nameinput" type="text" placeholder="请输入姓名" class="form-control" style="width: 200px;"/>' +
                '<span class="input-icon fui-check-inverted"></span>' +
            '</div>' +
            '<div class="form-group has-feedback">' +
                '<h3 class="name-title">学号</h3>' +
                '<input id="idinput" type="text" placeholder="请输入学号" class="form-control" style="width: 200px;"/>' +
                '<span class="input-icon fui-check-inverted"></span>' +
            '</div>' +
            '<div>' +
                '<h3 class="sex-title">性别</h3>' +
                '<label class="radio"><input type="radio" name="optionsRadios" id="optionsRadios1" value="男" data-toggle="radio">男</label>' +
                '<label class="radio"><input type="radio" name="optionsRadios" id="optionsRadios2" value="女" data-toggle="radio">女</label>' +
            '</div>' +
            '<div>' +
                '<h3 class="name-title">专业</h3>' +
                '<select id="majorSelection" class="form-control select select-primary" data-toggle="select"></select>' +
            '</div>' +
            '<div id="submitdiv" class="col-md-3">'+
                '<a href="#" class="btn btn-large btn-block btn-primary col-md">提交</a>' +
            '</div>'+
        '</div>');

    var url = "http://localhost:8080/admin/"+model.managerId+"/majorlist";
    var majorList;
    $.ajax({
        type: 'GET',
        url: url,
        dataType: 'json',
        success: function (jsonResult) {
            majorList = jsonResult["majorInfoList"];
            for(var index in jsonResult["majorInfoList"]) {
                var majorInfo = jsonResult["majorInfoList"][index];
                $('#majorSelection').append('<option value='+ '"'+index+'"' +'>'+'<a hidden>'+majorInfo.majorId+'</a>'+majorInfo.majorName+'</option>');
            }
        },
        error: function (e) {
            alert("ERR");
        }
    });
    $('#submitdiv').click(function () {
        var studentName = $('#nameinput').val();;
        var studentId = $('#idinput').val();
        var studentSex = $('.radio').find('input:radio:checked').val();
        var majorId = majorList[Number($('#majorSelection').val())].majorId;
        var url = "http://localhost:8080/admin/addstudent";
        $.ajax({
            type: 'POST',
            url: url,
            contentType: 'application/json',
            dataType: 'json',
            data: JSON.stringify({
                studentId: studentId,
                studentName: studentName,
                studentSex: studentSex,
                majorId: majorId
            }),
            success: function (jsonResult) {
                modalInfo("提示","添加成功！");
            },
            error: function (e) {
                modalInfo("提示","添加失败！");
            }
        });
    });
});

$('#addCourseBtn').click(function () {
    $('#contentDiv').empty();
    $('#contentDiv').append(
        '<div id="courseRegTable">' +
            '<div class="form-group has-feedback">' +
                '<h3 class="name-title">课程名称</h3>' +
                '<input id="nameinput" type="text" placeholder="请输入课程名称" class="form-control" style="width: 200px;"/>' +
                '<span class="input-icon fui-check-inverted"></span>' +
            '</div>' +
            '<div class="form-group has-feedback">' +
                '<h3 class="name-title">课程代号</h3>' +
                '<input id="idinput" type="text" placeholder="请输入课程代号" class="form-control" style="width: 200px;"/>' +
                '<span class="input-icon fui-check-inverted"></span>' +
            '</div>' +
            '<div class="form-group has-feedback">' +
                '<h3 class="name-title">课程学时</h3>' +
                '<input id="timeinput" type="text" placeholder="请输入课程学时" class="form-control" style="width: 200px;"/>' +
                '<span class="input-icon fui-check-inverted"></span>' +
            '</div>' +
            '<div class="form-group has-feedback">' +
                '<h3 class="name-title">课程学分</h3>' +
                '<input id="creditinput" type="text" placeholder="请输入课程学分" class="form-control" style="width: 200px;"/>' +
                '<span class="input-icon fui-check-inverted"></span>' +
            '</div>' +
            '<div id="submitCourseDiv" class="col-md-3">'+
                '<a href="#" class="btn btn-large btn-block btn-primary col-md">提交</a>' +
            '</div>'+
        '</div>'
    );

    $('#submitCourseDiv').click(function () {
        var courseName = $('#nameinput').val();
        var courseId = $('#idinput').val();
        var courseTime = $('#timeinput').val();
        var courseCredit = $('#creditinput').val();
        var url = "http://localhost:8080/admin/addcourse";
        $.ajax({
            type: 'POST',
            url: url,
            contentType: 'application/json',
            dataType: 'json',
            data: JSON.stringify({
                courseName: courseName,
                courseId: courseId,
                courseTime: courseTime,
                courseCredit: courseCredit
            }),
            success: function (jsonResult) {
                modalInfo("提示","添加成功！");
            },
            error: function (e) {
                modalInfo("提示","添加失败！");
            }
        });
    });
});

$('#addTeacherBtn').click(function () {
    $('#contentDiv').empty();
    $('#contentDiv').append(
        '<div id="teacherRegTable">' +
            '<div class="form-group has-feedback">' +
                '<h3 class="name-title">姓名</h3>' +
                '<input id="nameinput" type="text" placeholder="请输入姓名" class="form-control" style="width: 200px;"/>' +
                '<span class="input-icon fui-check-inverted"></span>' +
            '</div>' +
            '<div class="form-group has-feedback">' +
                '<h3 class="name-title">工号</h3>' +
                '<input id="idinput" type="text" placeholder="请输入工号" class="form-control" style="width: 200px;"/>' +
                '<span class="input-icon fui-check-inverted"></span>' +
            '</div>' +
            '<div class="form-group has-feedback">' +
                '<h3 class="name-title">职称</h3>' +
                '<input id="rankinput" type="text" placeholder="请输入职称" class="form-control" style="width: 200px;"/>' +
                '<span class="input-icon fui-check-inverted"></span>' +
            '</div>' +
            '<div>' +
                '<h3 class="sex-title">性别</h3>' +
                '<label class="radio"><input type="radio" name="optionsRadios" id="optionsRadios1" value="男" data-toggle="radio">男</label>' +
                '<label class="radio"><input type="radio" name="optionsRadios" id="optionsRadios2" value="女" data-toggle="radio">女</label>' +
            '</div>' +
            '<div>' +
                '<h3 class="name-title">所属系</h3>'+
                '<select id="deptSelection" class="form-control select select-primary" data-toggle="select"></select>'+
            '</div>' +
            '<div id="submitTeacherDiv" class="col-md-3">'+
                '<a href="#" class="btn btn-large btn-block btn-primary col-md">提交</a>' +
            '</div>'+
        '</div>');

    var url = "http://localhost:8080/admin/"+model.managerId+"/deptlist";
    var deptList;
    $.ajax({
        type: 'GET',
        url: url,
        dataType: 'json',
        success: function (jsonResult) {
            deptList = jsonResult["deptInfoList"];
            for(var index in jsonResult["deptInfoList"]) {
                var deptInfo = jsonResult["deptInfoList"][index];
                $('#deptSelection').append('<option value='+ '"'+index+'"' +'>'+'<a hidden>'+deptInfo.deptId+'</a>'+deptInfo.deptName+'</option>');
            }
        },
        error: function (e) {
            alert("ERR");
        }
    });
    $('#submitTeacherDiv').click(function () {
        var teacherName = $('#nameinput').val();
        var teacherId = $('#idinput').val();
        var teacherRank = $('#rankinput').val();
        var teacherSex = $('.radio').find('input:radio:checked').val();
        var deptId = deptList[Number($('#deptSelection').val())].deptId;
        var url = "http://localhost:8080/admin/addteacher";
        $.ajax({
            type: 'POST',
            url: url,
            contentType: 'application/json',
            dataType: 'json',
            data: JSON.stringify({
                teacherName: teacherName,
                teacherId: teacherId,
                teacherSex: teacherSex,
                teacherRank: teacherRank,
                deptId: deptId
            }),
            success: function (jsonResult) {
                modalInfo("提示","添加成功！");
            },
            error: function (e) {
                modalInfo("提示","添加失败！");
            }
        });
    });
});

$('#delStudentBtn').click(function () {
    $('#contentDiv').empty();
    var url = "http://localhost:8080/admin/"+model.managerId+"/students";
    $.ajax({
        type: 'GET',
        url: url,
        dataType: 'json',
        success: function (jsonResult) {
            $('#contentDiv').append('<table class="table table-striped table-hover"><tr><th>学号</th><th>姓名</th><th>性别</th><th>专业</th><th>删除</th></tr>');
            $('#inputGradeListDiv').append('</table>');
            for(var index in jsonResult["studentlist"]) {
                var stuTable = $('#contentDiv').find('table');
                var targetTable = stuTable.find('tr').last();
                var stu = jsonResult["studentlist"][index];
                targetTable.after('<tr>'+'<td>'+stu.studentId+'</td>'+
                    '<td>'+stu.studentName+'</td>'+
                    '<td>'+stu.studentSex+'</td>'+
                    '<td>'+stu.majorName+'</td>'+
                    '<td>' +
                    '<span class="btn-grp"><a hidden>stu.studentId</a><button class="btn btn-danger" type="button">删除</button></span>' +
                    '</td>'+'</tr>');
            }
            $('.btn-grp').on('click', function () {
                var stuId = $(this).parent().parent().find("td:nth-child(1)").text();
                var url = "http://localhost:8080/admin/delstudent";
                $.ajax({
                    type: 'POST',
                    url: url,
                    contentType: 'application/json',
                    dataType: 'json',
                    data: JSON.stringify({
                        studentId: stuId
                    }),
                    success: function (jsonResult) {
                        modalInfo("提示","删除成功！");
                        $('#modalBtn').click(function () {
                            $('#delStudentBtn').click();
                            $('#modalBtn').unbind();
                        });

                    },
                    error: function (e) {
                        modalInfo("提示","删除失败！");
                    }
                });
            });
        },
        error: function (e) {
            alert("Err");
        }
    });
});

$('#delCourseBtn').click(function () {
    $('#contentDiv').empty();
    var url = "http://localhost:8080/admin/"+model.managerId+"/courses";
    $.ajax({
        type: 'GET',
        url: url,
        dataType: 'json',
        success: function (jsonResult) {
            $('#contentDiv').append('<table class="table table-striped table-hover"><tr><th>课程号</th><th>课程名</th><th>时间</th><th>学分</th><th>删除</th></tr>');
            $('#inputGradeListDiv').append('</table>');
            for(var index in jsonResult["courselist"]) {
                var coutseTable = $('#contentDiv').find('table');
                var targetTable = coutseTable.find('tr').last();
                var course = jsonResult["courselist"][index];
                targetTable.after('<tr>'+'<td>'+course.courseId+'</td>'+
                    '<td>'+course.courseName+'</td>'+
                    '<td>'+course.courseTime+'</td>'+
                    '<td>'+course.courseCredit+'</td>'+
                    '<td>' +
                    '<span class="btn-grp"><button class="btn btn-danger" type="button">删除</button></span>' +
                    '</td>'+'</tr>');
            }
            $('.btn-grp').on('click', function () {
                var courseId = $(this).parent().parent().find("td:nth-child(1)").text();
                var url = "http://localhost:8080/admin/delcourse";
                $.ajax({
                    type: 'POST',
                    url: url,
                    contentType: 'application/json',
                    dataType: 'json',
                    data: JSON.stringify({
                        courseId: courseId
                    }),
                    success: function (jsonResult) {
                        modalInfo("提示","删除成功！");
                        $('#modalBtn').click(function () {
                            $('#delCourseBtn').click();
                            $('#modalBtn').unbind();
                        });

                    },
                    error: function (e) {
                        modalInfo("提示","删除失败！");
                    }
                });
            });
        },
        error: function (e) {
            alert("Err");
        }
    });
});

$('#delTeacherBtn').click(function () {
    $('#contentDiv').empty();
    var url = "http://localhost:8080/admin/"+model.managerId+"/teachers";
    $.ajax({
        type: 'GET',
        url: url,
        dataType: 'json',
        success: function (jsonResult) {
            $('#contentDiv').append('<table class="table table-striped table-hover"><tr><th>工号</th><th>姓名</th><th>性别</th><th>学院</th><th>职称</th><th>删除</th></tr>');
            $('#inputGradeListDiv').append('</table>');
            for(var index in jsonResult["teacherlist"]) {
                var teacherTable = $('#contentDiv').find('table');
                var targetTable = teacherTable.find('tr').last();
                var teacher = jsonResult["teacherlist"][index];
                targetTable.after('<tr>'+
                    '<td>'+teacher.teacherId+'</td>'+
                    '<td>'+teacher.teahcerName+'</td>'+
                    '<td>'+teacher.teacherSex+'</td>'+
                    '<td>'+teacher.deptName+'</td>'+
                    '<td>'+teacher.teacherRank+'</td>'+
                    '<td>' +
                    '<span class="btn-grp"><button class="btn btn-danger" type="button">删除</button></span>' +
                    '</td>'+'</tr>');
            }
            $('.btn-grp').on('click', function () {
                var teacherId = $(this).parent().parent().find("td:nth-child(1)").text();
                var url = "http://localhost:8080/admin/delteacher";
                $.ajax({
                    type: 'POST',
                    url: url,
                    contentType: 'application/json',
                    dataType: 'json',
                    data: JSON.stringify({
                        teacherId: teacherId
                    }),
                    success: function (jsonResult) {
                        modalInfo("提示","删除成功！");
                        $('#modalBtn').click(function () {
                            $('#delTeacherBtn').click();
                            $('#modalBtn').unbind();
                        });

                    },
                    error: function (e) {
                        modalInfo("提示","删除失败！");
                    }

                });
            });

        },
        error: function (e) {
            alert("Err");
        }
    });
});

$('#authorityControlBtn').click(function () {
    $('#contentDiv').empty();
    $('#contentDiv').append(
        '<div id="startSelectDiv" class="col-md-3">'+
            '<a href="#" class="btn btn-large btn-block btn-primary col-md">允许选课</a>' +
        '</div>'+
        '<div id="endSelectDiv" class="col-md-3">'+
            '<a href="#" class="btn btn-large btn-block btn-primary col-md">结束选课</a>' +
        '</div>');

    var url = "http://localhost:8080/admin/changeauthority";
    $('#startSelectDiv').click(function () {
        $.ajax({
            type: 'POST',
            url: url,
            contentType: 'application/json',
            dataType: 'json',
            data: JSON.stringify({
                studentAuthority: 1
            }),
            success: function (jsonResult) {
                modalInfo("提示","选课权限开启成功！");
            },
            error: function (e) {
                modalInfo("提示","选课权限开启失败！");
            }
        });
    });

    $('#endSelectDiv').click(function () {
        $.ajax({
            type: 'POST',
            url: url,
            contentType: 'application/json',
            dataType: 'json',
            data: JSON.stringify({
                studentAuthority: 0
            }),
            success: function (jsonResult) {
                modalInfo("提示","选课权限关闭成功！");
            },
            error: function (e) {
                modalInfo("提示","选课权限关闭失败！");
            }
        });
    });
});
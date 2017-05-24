/**
 * Created by Phoenix on 2016/12/24.
 */
$('#showStudentTableBtn').click(function() {
    $('#studentListDiv').show();
    $('#inputGradeListDiv').hide();
    var url = "http://localhost:8080/teacher/"+model.teacherId+"/studentlist";
    $.ajax({
        type: 'GET',
        url: url,
        dataType: 'json',
        success: function (jsonResult) {
            var key = "courseList";
            var courseList = jsonResult[key];
            $('#studentListDiv').empty();
            for (var index in courseList) {

                var heading = '<div class="alert alert-info" role="alert">'+courseList[index].courseName+'</div>';
                $('#studentListDiv').append(heading);
                $('#studentListDiv').append('<table class="table table-striped table-hover"><tr><th>学号</th><th>姓名</th><th>性别</th><th>专业</th><th>系</th></tr>');
                $('#studentListDiv').append('</table>');
                for(var stuIndex in courseList[index].studentListItemList) {
                    var stuTable = $('#studentListDiv').find('table').last();
                    var targetTable = stuTable.find('tr').last();
                    var student = courseList[index].studentListItemList[stuIndex];
                    targetTable.after('<tr>'+'<td>'+student.studentId+'</td>'+'<td>'+student.studentName+'</td>'+'<td>'+student.studentSex+'</td>'+
                                      '<td>'+student.majorName+'</td>'+'<td>'+student.deptName+'</td>'+'</tr>');
                }
            }

        },
        error: function (e) {
            alert("Err");
        }
    });
});

$('#inputGradeBtn').click(function () {
    $('#studentListDiv').hide();
    $('#inputGradeListDiv').show();
    var url = "http://localhost:8080/teacher/"+model.teacherId+"/gradelist";
    $.ajax({
        type: 'GET',
        url: url,
        dataType: 'json',
        success: function (jsonResult) {
            var key = "courseList";
            var courseList = jsonResult[key];
            $('#inputGradeListDiv').empty();
            for (var index in courseList) {

                var heading = '<div class="alert alert-info" role="alert">'+courseList[index].courseName+'</div>';
                $('#inputGradeListDiv').append(heading);
                $('#inputGradeListDiv').append('<table class="table table-striped table-hover"><tr><th>课程代号</th><th>学号</th><th>姓名</th><th>专业</th><th>成绩</th><th>录入</th></tr>');
                $('#inputGradeListDiv').append('</table>');
                for(var stuIndex in courseList[index].studentGradeListItemList) {
                    var stuTable = $('#inputGradeListDiv').find('table').last();
                    var targetTable = stuTable.find('tr').last();
                    var student = courseList[index].studentGradeListItemList[stuIndex];
                    targetTable.after('<tr>'+'<td>'+courseList[index].courseId+'</td>'+'<td>'+student.studentId+'</td>'+'<td>'+student.studentName+'</td>'+'<td>'+student.majorName+'</td>'+
                        '<td>'+student.studentGrade+'</td>'+'<td><div class="input-group"><input type="text" class="form-control"><span class="input-group-btn"><button class="btn btn-default" type="button">提交</button></span></div></td>'+'</tr>');
                }
                $('.input-group-btn').on('click',function() {
                    var courseId = $(this).parent().parent().parent().parent().find("td:nth-child(1)").text();
                    var studentId = $(this).parent().parent().parent().parent().find("td:nth-child(2)").text();
                    var grade = $(this).parent().find('input').val();
                    var url = "http://localhost:8080/teacher/updategrade";
                    $.ajax({
                        type: 'POST',
                        url: url,
                        contentType: 'application/json',
                        dataType: 'json',
                        data: JSON.stringify({
                            studentId: studentId,
                            courseId: courseId,
                            teacherId: model.teacherId,
                            grade: grade
                        }),
                        success: function (jsonResult) {
                            $('#modalInfoLabel').text("成功");
                            $('#modalInfoContent').empty();
                            $('#modalInfoContent').text("成绩录入成功");
                            $('#modalBtn').click(function () {
                                $('#inputGradeBtn').click();
                                $('#modalBtn').unbind();
                            });

                        },
                        error: function (e) {

                        }
                    });
                })
            }

        },
        error: function (e) {
            alert("Err");
        }
    });
});
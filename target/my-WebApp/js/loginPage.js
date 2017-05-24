/**
 * Created by Phoenix on 2016/12/22.
 */
$('#loginButton').click(function(){
    if($('#userId').val()=="" || $('#userPassword').val()=="") {
        $('#errorModal').modal();
    }
    else {
        $.ajax({
            type: 'POST',
            url: 'login',
            contentType: 'application/json',
            dataType: 'json',
            data: JSON.stringify({
                userId: $("#userId").val(),
                userPassword: $("#userPassword").val(),
                userType: $("#userType").val(),
                isExist: 0
            }),
            success: function (jsonResult) {
                if (jsonResult.isExist === 1) {
                    var targetUrl = "student/" + jsonResult.userId;
                    window.location.href = targetUrl;
                } else if(jsonResult.isExist === 2) {
                    var targetUrl = "teacher/" + jsonResult.userId;
                    window.location.href = targetUrl;
                } else if(jsonResult.isExist === 3) {
                    var targetUrl = "admin/" + jsonResult.userId;
                    window.location.href = targetUrl;
                } else {
                    $('#errorContent').text("用户名或密码错误!");
                    $('#errorModal').modal();
                }
            },
            error: function (e) {
                alert("ERRR");
            }
        });
    }
});
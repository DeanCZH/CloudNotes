/**
 * Created by jinglingmei on 15/10/29.
 */
//login
$(function(){
   $("#login").click(function(){
        login();
   });



});



function login(){
    var username = $('#username').val();
    var password = $('#password').val();
    if(username == ""|| password ==""){
        return ;
    }
    $.ajax({
        type:"post",
        url:basepath+"user/login.do",
        dataType:"json",
        data:{"userName":username,"userPassWord":password},
        success:function(resultresponse) {
            if (resultresponse.status == 0) {
                //登录成功
                location.href = "index.jsp";
            } else {
                alert(resultresponse.message);
                $("#password").val("");
            }
        },
        error:function(XMLHttpRequest,status,statusText){
            alert("请求失败");
        }
    });
}
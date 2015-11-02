/**
 * Created by jinglingmei on 15/10/29.
 */
//login
$(function(){
    //记住帐号功能
    $("#username").val(getCookie("userName"));
    $("#password").val(getCookie("passWord"));

    $("#log_out").click(function () {
       logout();
    });

   $("#button_login").click(function(){
        login();
   });

    $("#register_button").click(function(){
       register();
    });

    $(function(){
        hiden1();
    });

});

function hiden1(){
    for(i = 1 ; i < 7; i++){
        $("#waring_"+i).hide();
    }
}



function register(){

    var username = $("#register_username").val();
    var password = $("#register_password").val();
    var repassword = $("#register_repassword").val();
    var useremail = $("#register_emial").val();


    //校验用户名格式
    var reg_username = /^\w{3,20}$/;
    if(!reg_username.test(username)){
        $("#waring_3").text("用户名不能少于6位").css({color:"red"}).show();
        return;
    }else{
        $("#waring_3").hide();
    }


    if(password.length <= 3){

        $("#waring_4").text("密码不能于3位").css({color:"red"}).show();
        return;
    }else{
        $("#waring_4").hide();
    }

    if(password != repassword){
        $("#waring_5").text("两次输入的密码不一致!请重新输入").css({color:"red"}).show();
        return ;
    }else{
        $("#waring_5").hide();
    }
    //检查邮箱格式
    var reg_email = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
    if(!reg_email.test(useremail)){
        $("#waring_6").text("邮箱格式不对").css({color:"red"}).show();
        return ;
    }else{
        $("#waring_6").hide();
    }



    var user = {
        "userName" :username,
        "userPassWord":password,
        "userEmail":useremail
    };
    $.ajax({
        type: "post",
        url: basepath + "user/register.do",
        dateType: "json",
        data: user,
        success: function (result) {
            if (result.status == 0) {
                //注册失败
                $("#waring_3").text(result.message).css({color:"red"}).show();
            } else {
                location.href = "";

            }
        },
        error: function (xhr, status, error) {
            alert("请求失败.");
        }
    });

}


function login(){
    var username = $('#username').val();
    var password = $('#password').val();
    var checked = $('#rememberpassword').prop('checked');
    if(username == ""|| password ==""){
        return ;
    }
    $.ajax({
        type:"post",
        url:basepath+"user/login.do",
        cache:false,
        dataType:"json",
        data:{"userName":username,"userPassWord":password},
        success:function(result) {
            if (result.status == 0) {
                //登录失败
                $("#waring_1").text(result.message).css({color:"red"}).show();
                $("#password").val("");
            } else {
                //登录成功

                if(checked == true){
                    addCookie("userName",result.data.userName,5);
                    addCookie("passWord",result.data.userPassWord,5);

                }else{
                    deleteCookie("userName");
                    deleteCookie("passWord");
                }
                location.href = "main.html";
            }
        },
        error:function(XMLHttpRequest,status,statusText){
            console.log("error");
            alert("请求失败");
        }
    });
}

//退出登录
function logout(){
    $.ajax({
        type:"post",
        url:basepath+"user/logout.do",
        dataType:"json",
        data:{},
        success:function(result){
            if(result.status == 0){
                //退出失败
                alert(result.message);
            }else{
                //退出成功
                deleteCookie(getCookie())
                location.href = "login.html";
            }
        },
        error:function(XMLHttpRequest,status,statusText){
            console.log("error");
            alert("请求失败");
        }



    });
}
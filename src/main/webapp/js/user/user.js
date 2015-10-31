/**
 * Created by jinglingmei on 15/10/29.
 */
//login
$(function(){
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
        $("#waring_3").html("用户名不能少于6位").show();
        return;
    }else{
        $("#waring_3").hide();
    }

    if(password.length < 3){
        $("waring_4").text("密码不但少于3位").show();
        return ;
    }else{
        $("waring_4").hide();
    }

    if(password != repassword){
        $("waring_5").text("两次输入的密码不一致!请重新输入").show();
        return ;
    }else{
        $("waring_5").hide();
    }
    //检查邮箱格式
    var reg_email = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
    if(!reg_email.test(useremail)){
        $("waring_6").text("邮箱格式不对").show();
        return ;
    }else{
        $("waring_6").hide();
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
                $("waring_1").text(reslut.message).show();
            } else {
                location.href = "";
                $("#zc").attr("class", "sig sig_out");
                $("#dl").attr("class", "log log_in");
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
                alert(result.message);
                $("#password").val("");
            } else {
                //登录成功
                console.log("success");
                location.href = "main.html";
            }
        },
        error:function(XMLHttpRequest,status,statusText){
            console.log("error");
            alert("请求失败");
        }
    });
}
/**
 * Created by jinglingmei on 15/11/1.
 */
//添加cookie
function addCookie(name,value,time){
    var str = name+"="+escape(value);
    if(time > 0){
        var ms = time * 3600 * 1000;
        var date = new Date();
        date.setTime(date.getTime()+ms);
        str += "; expires="+date.toGMTString();
    }
    document.cookie = str;
}

//获取cookie
function getCookie(name){
    var arrStr = document.cookie.split("; ");

    for(var i = 0; i < arrStr.length;i++){
        var temp = arrStr[i].split("=");
        if(temp[0] == name)
            return unescape(temp[1]);

    }
    return "";
}


//删除cookie
function deleteCookie(name){
    var exp = new Date();
    exp.setTime(exp.getTime()-1000);
    var tempname = getCookie(name);
    if(tempname != null){
        document.cookie = name + "=" + tempname +";expires=" + exp.toGMTString();
    }
}
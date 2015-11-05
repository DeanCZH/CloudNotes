/**
 * Created by jinglingmei on 15/11/4.
 */
$(function () {
    getNotesList();
})





function getNotesList(){
    username = getCookie("userName");
    $.ajax({
        type:"get",
        url:basepath+"note/listNotes-"+username+".do",
        dataType:"json",
        data:{},
        success:function(result){
            if(result.status == 1){
                var list = result.data;
                $(list).each(function (i) {
                    $('#note_'+(i+1)).css("border","3px solid #009FCC");
                    $('#note_'+(i+1)+' a h4').text(this.noteTitle);

                    $('#note_'+(i+1)+' a p:eq(0)').text(timeStamp2String(this.noteCreateTime));
                    $('#note_'+(i+1)+' a p:eq(1)').text(this.noteContent);

                });
            }
        },
        error:function(XMLHttpRequest,status,statusText){
            console.log("error");
            alert("请求失败");
        }
    })
}



function timeStamp2String(time){
    var datetime = new Date();
    datetime.setTime(time);
    var year = datetime.getFullYear();
    var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
    var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
    var hour = datetime.getHours()< 10 ? "0" + datetime.getHours() : datetime.getHours();
    var minute = datetime.getMinutes()< 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
    var second = datetime.getSeconds()< 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
    return year + "-" + month + "-" + date;
}
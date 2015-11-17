/**
 * Created by jinglingmei on 15/11/4.
 */
$(function () {
    getNotesList();


});





//获取笔记列表
function getNotesList(){
    username = getCookie("userName");
    $.ajax({
        type:"get",
        url:basepath+"note/listNotes="+username+".do",
        dataType:"json",
        data:{},
        success:function(result){
            if(result.status == 1){
                var list = result.data;
                $(list).each(function (i) {
                    $('#note_'+(i+1)).css("border","3px solid #009FCC");
                    $('#note_'+(i+1)+' a p:eq(0)').text(this.noteId).hide();
                    $('#note_'+(i+1)+' a h4').text(this.noteTitle);

                    $('#note_'+(i+1)+' a p:eq(1)').text(timeStamp2String(this.noteCreateTime));
                    $('#note_'+(i+1)+' a p:eq(2)').html(this.noteContent);

                });
            }
        },
        error:function(XMLHttpRequest,status,statusText){
            console.log("error");
            alert("请求失败");
        }
    })
}


//查看笔记内容
function getNoteContent(noteId){
    $.ajax({
        type:"get",
        url:basepath+"note/noteContent="+noteId+".do",
        dataType:"json",
        data:{},
        success:function(result){
            if(result.status == 1){
                $('#note_id').text(result.data.noteId);
                $('#note_title').text(result.data.noteTitle);
                $('#note_updatetime').text(timeStamp2String(result.data.noteUpdateTime));
                $('#note_content').html(result.data.noteContent);
            }
        },
        error:function(XMLHttpRequest,status,statusText){
            console.log("error");
            alert("请求失败");
        }
    });
}

//编辑笔记
function editorNoteContent(noteId){
    var noteTitle = $('#note_editor_title').html();
    var noteContent = CKEDITOR.instances.note_editor_content.getData();


    $.ajax({
        type:"post",
        url:basepath+"note/updateNote="+noteId+".do",
        dataType:"json",
        data:{"noteId":noteId,"noteTitle":noteTitle,"noteContent":noteContent},
        success:function(result){
            if(result.status == 1){
                alert("修改成功!");
                $('#note_editor_title').val("");

                $('#right_page1,#right_page3,#right_page4').hide();
                $('#right_page2').show();
                getNoteContent(noteId);
            }
        },
        error:function(XMLHttpRequest,status,statusText){
            console.log("error");
            alert("请求失败");
        },
    });
}

//新建笔记
function createNote(){
    var userId =getCookie("userId");
    var noteTitle = $("#note_add_title").val();
    var noteContent = CKEDITOR.instances.note_add_content.getData();
    $.ajax({
        type:"post",
        url:basepath+"note/createNote.do",
        dataType:"json",
        data:{"noteUserId":userId,"noteTitle":noteTitle,"noteContent":noteContent},
        success:function(result){
            if(result.status == 1){
                alert(result.message);
                $("#note_add_title").val(" ");
                CKEDITOR.instances.note_add_content.setData(" ");
                $('#right_page1').show();
                $('#right_page2,#right_page3,#right_page4').hide();
                getNotesList();
            }else if(result.status == 0){
                alert(result.message);
            }
        },
        error:function(XMLHttpRequest,status,statusText){
            console.log("error");
            alert("请求失败");
        }
    });
}

//删除笔记
function deleteNote(noteId){
    $.ajax({
        type:"delete",
        url:basepath+"note/delete="+noteId+".do",
        dataType:"json",
        data:{},
        success:function(result){
            if(result.status == 1){
                alert(result.message);
                location.href="main.html";
            }
        },
        error:function(XMLHttpRequest,status,statusText){
            console.log("error");
            alert("请求失败");
        }
    });
}

//切换界面
$(function(){
    $(document).on('click',"#note_1,#note_2,#note_3,#note_4,#note_5,#note_6,#note_7,#note_8,#note_9",function(){
        var noteId = $(this).find("p:eq(0)").html();
        $('#right_page1,#right_page3,#right_page4').hide();
        $('#right_page2').show();
        getNoteContent(noteId);
    });

    $(document).on('click',"#my_note", function () {
        $('#right_page1').show();
        $('#right_page2,#right_page3,#right_page4').hide();
        getNotesList();
    });

    $(document).on('click',"#My_notes", function () {
        $('#right_page1').show();
        $('#right_page2,#right_page3,#right_page4').hide();
        getNotesList();
    });

    $(document).on('click',"#create_note", function () {
        $('#right_page3').show();
        $('#right_page2,#right_page1,#right_page4').hide();
    });

    $(Document).on('click',"#add_note", function () {
       createNote();
    });

    $(Document).on('click',"#editor_btn", function () {
        var noteId = $("#note_id").html();
        var noteTitle = $('#note_title').html();
        var noteContent = $('#note_content').html();
        $('#right_page4').show();
        $('#right_page2,#right_page1,#right_page3').hide();
        $('#note_editor_id').val(noteId);
        $('#note_editor_title').val(noteTitle);
        CKEDITOR.instances.note_editor_content.setData(noteContent);

    });

    $(document).on('click',"#editor_note_btn",function(){
        var noteId=$("#note_editor_id").val();
        editorNoteContent(noteId);
    })

    $(document).on('click',"#delete_btn",function(){
        var noteId=$("#note_id").html();
        deleteNote(noteId);
    })
});







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


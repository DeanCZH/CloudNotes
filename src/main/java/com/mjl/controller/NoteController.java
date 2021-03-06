package com.mjl.controller;

import com.mjl.model.po.Note;
import com.mjl.model.po.User;
import com.mjl.model.vo.ResultResponse;
import com.mjl.service.NoteServiceI;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Alvin on 15/11/4.
 */
@Controller
@RequestMapping(value = "/note")
public class NoteController {

    @Resource
    NoteServiceI noteServiceI;

    //显示所有笔记
    @RequestMapping(value = "listNotes={userName}" ,method = RequestMethod.GET)
    @ResponseBody
    public ResultResponse ListAllNotes(@PathVariable String userName){
        ResultResponse res = new ResultResponse();
        User dbuser = noteServiceI.ListAllNotesByUserName(userName);
        if(dbuser != null) {
            List<Note> noteList = dbuser.getNotes();

            res.setStatus(1);
            res.setMessage("查询成功");
            res.setData(noteList);
            return res;
        }
        res.setStatus(0);
        res.setMessage("查询失败");
        return res;
    }

    //显示笔记内容
    @RequestMapping(value = "noteContent={noteId}" ,method = RequestMethod.GET)
    @ResponseBody
    public ResultResponse NoteContent(@PathVariable int noteId){
        Note dbnote = noteServiceI.ListNoteContentByNoteId(noteId);
        ResultResponse res = new ResultResponse();
        res.setStatus(1);
        res.setMessage("查询成功");
        res.setData(dbnote);
        return res;
    }


    //更新笔记
    @RequestMapping(value = "updateNote={noteId}" ,method = RequestMethod.POST)
    @ResponseBody
    public ResultResponse UpdateNote(@PathVariable int noteId,String noteTitle,String noteContent){
        Note dbnote = new Note();
        dbnote.setNoteId(noteId);
        dbnote.setNoteTitle(noteTitle);
        dbnote.setNoteContent(noteContent);
        System.out.println("notetitle!!"+dbnote.getNoteTitle());
        System.out.println("noteCOntetn!!"+dbnote.getNoteContent());


        noteServiceI.UpdateNote(dbnote);
        ResultResponse res = new ResultResponse();
        res.setStatus(1);
        res.setMessage("更新成功");
        res.setData(dbnote);
        return res;
    }

    //创建笔记
    @RequestMapping(value = "createNote" ,method = RequestMethod.POST)
    @ResponseBody
    public ResultResponse CreateNote(Note note){
        Note dbnote =note;
        ResultResponse rs = new ResultResponse();
        if(null != dbnote.getNoteTitle() && null !=dbnote.getNoteContent()){
            noteServiceI.addNote(dbnote);
            rs.setStatus(1);
            rs.setMessage("创建笔记成功!");
            return rs;
        }
        rs.setMessage("创建笔记失败");
        return rs;
    }

    @RequestMapping(value = "delete={noteId}" ,method = RequestMethod.DELETE)
    @ResponseBody
    public ResultResponse DeleteNote(@PathVariable int noteId){
        noteServiceI.DeleteNoteByNoteId(noteId);
        ResultResponse rs = new ResultResponse();
        rs.setStatus(1);
        rs.setMessage("删除成功!");
        return rs;
    }


}

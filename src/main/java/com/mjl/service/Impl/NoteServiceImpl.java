package com.mjl.service.Impl;

import com.mjl.dao.NoteDaoI;
import com.mjl.dao.UserDaoI;
import com.mjl.model.po.Note;
import com.mjl.model.po.User;
import com.mjl.service.NoteServiceI;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;


/**
 * Created by Alvin on 15/11/4.
 */
@Service
public class NoteServiceImpl implements NoteServiceI{

    @Resource
    NoteDaoI noteDaoI;

    @Resource
    UserDaoI userDaoI;


    public User ListAllNotesByUserName(String username) {
        return userDaoI.findUserAndNotesByUserName(username);
    }

    public Note ListNoteContentByNoteId(int id) {
        return noteDaoI.findNoteByNoteId(id);
    }

    public void addNote(Note note) {
        if(null != note){
            note.setNoteCreateTime(new Timestamp(new Date().getTime()));
            noteDaoI.addNote(note);
        }
    }
}

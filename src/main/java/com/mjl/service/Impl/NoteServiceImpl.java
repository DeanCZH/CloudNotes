package com.mjl.service.Impl;

import com.mjl.dao.NoteDaoI;
import com.mjl.dao.UserDaoI;
import com.mjl.model.po.Note;
import com.mjl.model.po.User;
import com.mjl.service.NoteServiceI;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Alvin on 15/11/4.
 */
public class NoteServiceImpl implements NoteServiceI{

    @Resource
    NoteDaoI noteDaoI;

    @Resource
    UserDaoI userDaoI;


    public User ListAllNotesByUserName(String username) {
        return userDaoI.findUserAndNotesByUserName(username);
    }
}

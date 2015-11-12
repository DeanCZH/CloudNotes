package com.mjl.service;

import com.mjl.model.po.Note;
import com.mjl.model.po.User;

import java.util.List;

/**
 * Created by Alvin on 15/11/4.
 */
public interface NoteServiceI {
    public User ListAllNotesByUserName(String username);
    public Note ListNoteContentByNoteId(int id);
    public void addNote(Note note);
    public void UpdateNote(Note note);
    public void DeleteNoteByNoteId(int noteId);
}

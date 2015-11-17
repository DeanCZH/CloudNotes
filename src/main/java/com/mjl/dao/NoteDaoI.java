package com.mjl.dao;

import com.mjl.model.po.Note;
import com.mjl.model.po.User;

/**
 * Created by Alvin on 15/11/3.
 */
public interface NoteDaoI {
    public void addNote(Note note);
    public Note findNoteByNoteId(int noteId);
    public void updateNote(Note note);
    public void deleteNoteByNoteId(int noteId);
}

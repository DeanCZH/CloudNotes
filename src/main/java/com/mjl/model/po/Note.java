package com.mjl.model.po;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Alvin on 15/11/3.
 */
public class Note implements Serializable{
    private int noteId;
    private int noteUserId;
    private String noteTitle;
    private String noteContent;
    private Timestamp noteCreateTime;
    private Timestamp noteUpdateTime;

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public int getNoteUserId() {
        return noteUserId;
    }

    public void setNoteUserId(int noteUserId) {
        this.noteUserId = noteUserId;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    public Timestamp getNoteCreateTime() {
        return noteCreateTime;
    }

    public void setNoteCreateTime(Timestamp noteCreateTime) {
        this.noteCreateTime = noteCreateTime;
    }

    public Timestamp getNoteUpdateTime() {
        return noteUpdateTime;
    }

    public void setNoteUpdateTime(Timestamp noteUpdateTime) {
        this.noteUpdateTime = noteUpdateTime;
    }

    @Override
    public String toString() {
        return "Note{" +
                "noteId=" + noteId +
                ", noteUserId=" + noteUserId +
                ", noteTitle='" + noteTitle + '\'' +
                ", noteContent='" + noteContent + '\'' +
                ", noteCreateTime=" + noteCreateTime +
                ", noteUpdateTime=" + noteUpdateTime +
                '}';
    }
}

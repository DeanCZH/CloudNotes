package com.mjl.mybatisTest;

import com.mjl.dao.NoteDaoI;
import com.mjl.model.po.Note;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Alvin on 15/11/4.
 */
public class NoteDaoTest {
    private static ApplicationContext ac;
    private static NoteDaoI noteDaoI;

    static{
        ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        noteDaoI = (NoteDaoI) ac.getBean("NoteDaoI");
    }

    @Test
    public void addTest(){
        Note testNote = new Note();
        testNote.setNoteUserId(1);
        testNote.setNoteTitle("好无聊哦");
        testNote.setNoteContent("怎么办,哎哎哎!!!!!!好忧伤");
        testNote.setNoteCreateTime(new Timestamp(new Date().getTime()));
        noteDaoI.addNote(testNote);
    }

    @Test
    public void findNoteByNoteIdTest(){
        Note testnote = noteDaoI.findNoteByNoteId(1);
        System.out.println(testnote.toString());
    }

}

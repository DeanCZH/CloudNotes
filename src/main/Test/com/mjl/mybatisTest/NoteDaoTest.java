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
        testNote.setNoteTitle("据说要文艺一点");
        testNote.setNoteContent("啊,让我快快成长,成为一个大神!");
        testNote.setNoteCreateTime(new Timestamp(new Date().getTime()));
        noteDaoI.addNote(testNote);
    }
}

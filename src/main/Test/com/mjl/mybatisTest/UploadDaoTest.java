package com.mjl.mybatisTest;

import com.mjl.dao.UploadDaoI;
import com.mjl.model.po.Upload;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Alvin on 15/11/18.
 */
public class UploadDaoTest {
    private static ApplicationContext ac;
    private static UploadDaoI uploadDaoI;
    static {
        ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        uploadDaoI = (UploadDaoI) ac.getBean("uploadDaoI");
    }

    @Test
    public void addTest(){
        Upload upload = new Upload();
        upload.setUploadUserId(1);
        upload.setUploadUrlList("test/erdsf.jpg;");
        upload.setUploadCreateTime(new Timestamp(new Date().getTime()));
        uploadDaoI.add(upload);
    }

    @Test
    public void selectTest(){
        Upload tempUpload = uploadDaoI.selete(1);
        System.out.println(tempUpload.toString());
    }

    @Test
    public void deleteTest(){
        uploadDaoI.delete(2);
    }

    @Test
    public void updateTest(){
        Upload upload = uploadDaoI.selete(1);
        upload.setUploadUrlList("test/upload.jpg");
        uploadDaoI.update(upload);
    }
}

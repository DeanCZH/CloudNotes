package com.mjl.Util;

import java.io.*;

/**
 * Created by Alvin on 15/11/15.
 */
public class LogFileWrite {
    File file = new File(Constant.USER_LOG_FILE_PATH);
    FileOutputStream fos = null;

    public void writer(String str){
        try {
            fos = new FileOutputStream(file,true);
            byte[] b = str.getBytes();
            fos.write(b);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}

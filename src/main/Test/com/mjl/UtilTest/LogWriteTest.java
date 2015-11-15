package com.mjl.UtilTest;

import com.mjl.Util.LogFileWrite;
import org.junit.Test;

/**
 * Created by Alvin on 15/11/15.
 */
public class LogWriteTest {

    @Test
    public void WriteTest(){
        LogFileWrite logFileWrite = new LogFileWrite();
        logFileWrite.writer("qcvcxvcxt");
    }
}

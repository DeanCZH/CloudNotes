package com.mjl.jsonTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mjl.model.po.User;

import org.junit.Test;

import java.io.IOException;

/**
 * Created by Alvin on 15/10/28.
 */
public class jsonTest {


    @Test
    public void jsonTest() throws IOException {
        String s= "{\"userName\":\"123\"}";
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(s,User.class);
        System.out.println(mapper.writeValueAsString(user));
    }
}

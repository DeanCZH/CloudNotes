package com.mjl.jsonTest;

import com.mjl.model.User;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.ObjectMapper;
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

package TestData;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class TestDataReader {

    public static TestObject readTestData(String fileName){
        TestObject to = null;
        try {
            File a = new File("./src/test/resources/APLinkTest/"+fileName+".json");
            to = new ObjectMapper().readValue(a,TestObject.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return to;
    }
}

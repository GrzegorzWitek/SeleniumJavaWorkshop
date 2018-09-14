package TestData;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TestObject {
    @JsonProperty("objectName")
    public String objectName;
    @JsonProperty("testData")
    public List<TestData> testDataList;
    @JsonProperty("portalLocator")
    public String portalLocator;
    @JsonProperty("portalLink")
    public String portalLink;

    public String getTestDataValueFor(String testDataName){
        for (TestData data:testDataList) {
            if(data.name.equals(testDataName))
                return data.value;
        }
        return null;
    }
}

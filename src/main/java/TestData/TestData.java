package TestData;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestData {
    @JsonProperty("name")
    public String name;
    @JsonProperty("value")
    public String value;
}

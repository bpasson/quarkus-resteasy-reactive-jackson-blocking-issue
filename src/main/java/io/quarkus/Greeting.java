package io.quarkus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Greeting {

    @JsonProperty("message")
    public String message;

    public String getMessage() {
        return message;
    }

    public static Greeting withMessage(String message) {
        Greeting greeting = new Greeting();
        greeting.message = message;
        return greeting;
    }
}

package com.cvt.rabbitmqexample;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SimplePracticalTipMessage {
    private final String text;

    public SimplePracticalTipMessage(@JsonProperty("text") String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "SimplePracticalTipMessage{" +
                "text='" + text + '\'' +
                '}';
    }
}

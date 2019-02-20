package com.cvt.rabbitmqexample;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class PracticalTipMessage implements Serializable{

    private final String text;
    private final int priority;
    private final boolean secret;

    public PracticalTipMessage(@JsonProperty("text") String text,
                               @JsonProperty("priority") int priority,
                               @JsonProperty("secret") boolean secret) {
        this.text = text;
        this.priority = priority;
        this.secret = secret;
    }

    public String getText() {
        return text;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isSecret() {
        return secret;
    }

    @Override
    public String toString() {
        return "PracticalTipMessage{" +
                "text='" + text + '\'' +
                ", priority=" + priority +
                ", secret=" + secret +
                '}';
    }
}

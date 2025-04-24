package com.accenture.accenturetest.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.validation.ObjectError;

import java.util.Collection;

@Data
public class BodyResponseConfig<T> {
    @JsonProperty("data")
    private T data;
    @JsonProperty("message")
    private String message;

    public BodyResponseConfig() {
    }

    public BodyResponseConfig(String message) {
        this.message = message;
    }

    public BodyResponseConfig(T data, String message) {
        this.data = data;
        this.message = message;
    }

}

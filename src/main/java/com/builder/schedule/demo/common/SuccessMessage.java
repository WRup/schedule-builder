package com.builder.schedule.demo.common;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuccessMessage {
    private String description;

    public SuccessMessage(String description) {
        this.description = description;
    }
}

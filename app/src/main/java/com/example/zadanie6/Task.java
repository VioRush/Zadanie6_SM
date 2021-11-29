package com.example.zadanie6;

import java.util.Date;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Task {
    private UUID id;
    private String name;
    private Date date;
    private boolean done;

    public Task() {
        id = UUID.randomUUID();
        date = new Date();
    }

    /*
    public Task(String nazwa, boolean d) {
        id = UUID.randomUUID();
        date = new Date();
        name = nazwa;
        done = d;
    } */
}

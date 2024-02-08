package com.parsing.leon.model;

import lombok.Data;

import java.util.List;

@Data
public class EventResponse {
    private String vtag;
    private List<Event> events;
}

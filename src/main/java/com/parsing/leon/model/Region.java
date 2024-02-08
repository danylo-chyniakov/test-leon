package com.parsing.leon.model;

import lombok.Data;

import java.util.List;

@Data
public class Region {
    private String  id;
    private String name;
    private List<League> leagues;
}

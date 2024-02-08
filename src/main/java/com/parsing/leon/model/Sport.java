package com.parsing.leon.model;

import lombok.Data;

import java.util.List;

@Data
public class Sport {
    private String id;
    private String name;
    private List<Region> regions;
}

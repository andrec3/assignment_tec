package com.cruzandre.assignment.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Juke {
    private String id;
    private String model;
    //private ArrayList<JukeComponent> jukeComponent;
    private JukeComponent[] components;
}

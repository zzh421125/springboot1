package com.example.springboot.demo;

import java.io.Serializable;
import java.util.List;

/**
 * #date：2020/12/3 <br/>
 * #param:  <br/>
 * #return: <br/>
 */
public class QryExelDTO implements Serializable{

    private String name;

    private List<String> programs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPrograms() {
        return programs;
    }

    public void setPrograms(List<String> programs) {
        this.programs = programs;
    }
}

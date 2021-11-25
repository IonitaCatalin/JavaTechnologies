package com.jtechnologies.labs5.models;

import com.jtechnologies.labs5.enums.ResourceType;

import java.io.Serializable;
import java.util.List;


public class Resource implements Serializable {

    private final ResourceType rt;
    private int id;

    public Resource(int id, ResourceType resourceType) {
        this.rt = resourceType;
    }


    public int getId() {
        return id;
    }

    public String getRt() {
        return rt.toString();
    }

    @Override
    public String toString() {
        return "Resource{" +
                "rt=" + rt +
                ", id=" + id +
                '}';
    }
}

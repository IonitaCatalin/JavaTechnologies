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

    public ResourceType getRt() {
        return rt;
    }

}

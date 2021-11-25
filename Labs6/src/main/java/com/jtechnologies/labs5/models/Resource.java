package com.jtechnologies.labs5.models;

import com.jtechnologies.labs5.enums.ResourceType;

import java.io.Serializable;
import java.util.List;


public class Resource implements Serializable {

    private final Integer id;
    private final ResourceType rt;

    public Resource(Integer id, ResourceType resourceType) {
        this.id = id;
        this.rt = resourceType;
    }

    public Integer getId() {
        return id;
    }

    public ResourceType getRt() {
        return rt;
    }

}

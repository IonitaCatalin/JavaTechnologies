package com.jtechnologies.labs5.enums;

public enum ResourceType {
    ROOM("room"),
    VIDEO_PROJECT("video_projector");


    private String type;
    ResourceType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return this.type;
    }

    public ResourceType toResource(String str) {
        for(ResourceType resource:ResourceType.values()) {
            if(resource.type.equalsIgnoreCase(str)) {
                return resource;
            }
        }
        return null;
    }

}

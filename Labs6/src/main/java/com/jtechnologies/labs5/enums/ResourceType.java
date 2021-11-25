package com.jtechnologies.labs5.enums;

public enum ResourceType {
    ROOM_401("room_401"),
    ROOM_309("room_309"),
    ROOM_213("room_213"),
    ROOM_350("room_350"),
    VIDEO_PROJECT_A("video_projector_a"),
    VIDEO_PROJECTOR_B("video_projector_b");

    private String type;
    ResourceType(String type) {
        this.type = type;
    }

    public String getResource() {
        return this.type;
    }

    static public ResourceType toResource(String str) {
        for(ResourceType resource:ResourceType.values()) {
            if(resource.type.equalsIgnoreCase(str)) {
                return resource;
            }
        }
        return null;
    }

}

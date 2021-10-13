package com.javatechnologies.labs2.util;

public class Request {
    private String category;
    private String value;
    private String key;

    public Request(String category, String value, String key) {
        this.category = category;
        this.value = value;
        this.key = key;
    }

    public String getCategory() {
        return category;
    }

    public String getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "Request{" +
                "category='" + category + '\'' +
                ", value='" + value + '\'' +
                ", key='" + key + '\'' +
                '}';
    }
}

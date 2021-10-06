package com.laboratories.labs1;
import javax.servlet.http.HttpServletRequest;

public class Request {
    private int value;
    private String key;
    private boolean mock,sync;

    public Request(HttpServletRequest request) {
        this.value = Integer.parseInt(request.getParameter("value"));
        this.key = request.getParameter("key");
        this.mock = Boolean.parseBoolean(request.getParameter("mock"));
        this.sync = Boolean.parseBoolean(request.getParameter("sync"));
    }

    public int getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }

    public boolean isMock() {
        return mock;
    }

    public boolean isSync() {
        return sync;
    }

    @Override
    public String toString() {
        return "Request{" +
                "value=" + value +
                ", key='" + key + '\'' +
                ", mock=" + mock +
                ", sync=" + sync +
                '}';
    }
}

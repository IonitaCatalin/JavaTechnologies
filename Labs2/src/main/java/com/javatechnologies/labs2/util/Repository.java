package com.javatechnologies.labs2.util;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private static Repository single_instance = null;

    private static List<Request> requests ;

    private Repository()
    {
        requests = new ArrayList<>();
    }

    public static List<Request> getRequests() {
        return requests;
    }

    public static void pushRequest(Request request) {
        requests.add(request);
    }

    public static Repository getInstance()
    {
        if (single_instance == null)
            single_instance = new Repository();

        return single_instance;
    }
}

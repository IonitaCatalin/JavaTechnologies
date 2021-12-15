package com.javatech.labs8;

import com.javatech.labs8.controller.UserController;

import javax.faces.bean.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;

@ApplicationPath("api/v1")
@ApplicationScoped
public class ApplicationConfig extends Application {
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(UserController.class);
    }

    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }
}
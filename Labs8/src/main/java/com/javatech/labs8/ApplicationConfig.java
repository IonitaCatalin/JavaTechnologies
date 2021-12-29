package com.javatech.labs8;

import com.javatech.labs8.controller.ContestController;
import com.javatech.labs8.controller.DocumentController;
import com.javatech.labs8.controller.UserController;
import com.javatech.labs8.exceptions.mappers.*;

import javax.faces.bean.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;

@ApplicationPath("api/v1")
@ApplicationScoped
public class ApplicationConfig extends Application {
    private void addRestResourceClasses(Set<Class<?>> resources) {

        // Bind API Controllers
        resources.add(UserController.class);
        resources.add(DocumentController.class);
        resources.add(ContestController.class);

        // Bind Exception Mappers
        resources.add(TranslatableConflictMapper.class);
        resources.add(TranslatableNotFoundMapper.class);
        resources.add(TranslatableBadRequestMapper.class);
        resources.add(TranslatableUnauthorizedMapper.class);
        resources.add(TranslatableServerErrorMapper.class);

    }

    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }
}
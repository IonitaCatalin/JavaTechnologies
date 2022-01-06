package com.javatech.labs9;

import com.javatech.labs9.controller.ContestController;
import com.javatech.labs9.controller.DocumentController;
import com.javatech.labs9.controller.UserController;
import com.javatech.labs9.exceptions.mappers.*;
import com.javatech.labs9.filters.AuthenticationFilter;
import com.javatech.labs9.filters.AuthorizationFilter;

import javax.faces.bean.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;

@ApplicationPath("api/v1")
@ApplicationScoped
public class ApplicationConfig extends Application {
    private void addRestResourceClasses(Set<Class<?>> resources) {
        // Bind authorization and authentication filters
        resources.add(AuthenticationFilter.class);
        resources.add(AuthorizationFilter.class);

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
        resources.add(TranslatableNoResultExceptionMapper.class);

    }

    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }
}
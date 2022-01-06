package com.javatech.labs9.annotations;

import com.javatech.labs9.pemissions.Role;

import javax.ws.rs.NameBinding;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@NameBinding
@Retention(RUNTIME)
@Target({TYPE,METHOD})
public @interface JWTTokenRequired {
    Role[] Permissions() default {Role.AUTHOR};
}

package com.javatech.labs7.interceptors;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountInterceptor implements Serializable {


    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception {
        System.out.println("Entering method:" + context.getMethod().getName());

        Object result = context.proceed();

        System.out.println("Leaving method: " + context.getMethod().getName() );

        return result;
    }

}

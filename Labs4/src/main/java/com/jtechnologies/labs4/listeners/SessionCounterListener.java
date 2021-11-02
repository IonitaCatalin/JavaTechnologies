package com.jtechnologies.labs4.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionCounterListener implements HttpSessionListener {

    private static int count;

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        System.out.println("session created: " + event.getSession().getId());
        count++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        count--;
    }

    public static int getCount() {
        return count;
    }

}
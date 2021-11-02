package com.jtechnologies.labs4.beans;

import com.jtechnologies.labs4.listeners.SessionCounterListener;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class SessionBean implements Serializable {

    public void logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }

    public int getSessionCount() {
        return SessionCounterListener.getCount();
    }

}
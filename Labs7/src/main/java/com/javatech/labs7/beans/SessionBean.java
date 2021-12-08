package com.javatech.labs7.beans;


import com.javatech.labs7.enums.AccountRoleType;
import com.javatech.labs7.models.Account;
import com.javatech.labs7.services.AccountService;
import com.javatech.labs7.utils.SessionRole;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.util.logging.Logger;

@ManagedBean
@SessionScoped
public class SessionBean {

    @Inject
    AccountService accountService;

    @Inject
    private Logger logger;

    @Inject
    SessionRole sessionRole;

    private AccountRoleType roleType;
    private String name;
    private String pw;
    private String result;

    public void login(){
        sessionRole.setRoleType(accountService.login(new Account(name, pw)));

        if(sessionRole.getRoleType() != null){
            result = "Success";
        }else{
            result = "Name or password incorrect";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public AccountRoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(AccountRoleType roleType) {
        this.roleType = roleType;
    }
}
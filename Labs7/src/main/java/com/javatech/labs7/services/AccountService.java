package com.javatech.labs7.services;

import com.javatech.labs7.enums.AccountRoleType;
import com.javatech.labs7.interceptors.AccountInterceptor;
import com.javatech.labs7.models.Account;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Objects;

@Stateless
@Interceptors(AccountInterceptor.class)
public class AccountService {
    @PersistenceContext(unitName = "persistence/reviewer")
    EntityManager em;

    public void register(Account account){
        em.persist(account);
    }

    public AccountRoleType login(Account account){
        List<Account> accountList = em.createNamedQuery("Account.findOne", Account.class)
                .setParameter("name", account.getName())
                .setParameter("pw", account.getPw())
                .getResultList();

        System.out.println(accountList.size());
        if (accountList.size() != 0) {
            for (AccountRoleType roleType : AccountRoleType.values()) {
                if (Objects.equals(roleType.getRole(), accountList.get(0).getRole())) {
                    return roleType;
                }
            }
        }
        return null;

    }
}
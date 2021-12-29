package com.javatech.labs8.service;

import com.javatech.labs8.dtos.UserRegisterDTO;
import com.javatech.labs8.dtos.UserUpdateDTO;
import com.javatech.labs8.entity.Account;
import com.javatech.labs8.exceptions.AccountAlreadyExistsException;
import com.javatech.labs8.pemissions.Role;
import com.javatech.labs8.repository.AccountRepository;

import javax.inject.Inject;

public class AccountService {

    @Inject
    protected AccountRepository accountRepository;

    public void create(UserRegisterDTO user) throws AccountAlreadyExistsException {

        boolean exists = !accountRepository.checkIfExists(user.getUsername());
        if(!exists) {
            accountRepository.save(new Account(user.getUsername(),user.getPassword(), Role.AUTHOR.toString()));
        } else {
            throw new AccountAlreadyExistsException();
        }

    }
    public void delete(Long id) {
        accountRepository.deleteById(Account.class,id);
    }

    public void update(Long id, UserUpdateDTO user) {

    }

}

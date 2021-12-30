package com.javatech.labs8.service;

import com.javatech.labs8.dtos.AccountDTO;
import com.javatech.labs8.dtos.AccountLoginDTO;
import com.javatech.labs8.dtos.AccountRegisterDTO;
import com.javatech.labs8.dtos.AccountUpdateDTO;
import com.javatech.labs8.entity.Account;
import com.javatech.labs8.exceptions.AccountAlreadyExistsException;
import com.javatech.labs8.exceptions.AccountInvalidCredentialsException;
import com.javatech.labs8.exceptions.AccountNotFoundException;
import com.javatech.labs8.pemissions.Role;
import com.javatech.labs8.repository.AccountRepository;

import javax.inject.Inject;

public class AccountService {

    @Inject
    protected AccountRepository accountRepository;

    public void create(AccountRegisterDTO user) throws AccountAlreadyExistsException {

        boolean exists = accountRepository.checkIfExists(user.getUsername());

        if(!exists) {
            accountRepository.save(new Account(user.getUsername(),user.getPassword(), Role.AUTHOR.toString()));
        } else {
            throw new AccountAlreadyExistsException();
        }


    }

    public AccountDTO findById(Long id) throws AccountNotFoundException {
        boolean exists = accountRepository.checkIfExistsById(id);

        if(!exists) {
            Account account = accountRepository.findById(Account.class,id);
            AccountDTO accountDTO = new AccountDTO();

            accountDTO.setUsername(account.getName());
            accountDTO.setPassword(account.getPassword());
            accountDTO.setRole(account.getRole());
            accountDTO.setId(account.getId());

            return accountDTO;
        } else {
            throw new AccountNotFoundException();
        }
    }

    public Role getAccountRole(Long id) {
        boolean exists = accountRepository.checkIfExistsById(id);

        if(exists) {
            return Role.fromString(accountRepository.findById(Account.class,id).getRole());
        }
        return null;
    }

    public Long validate(AccountLoginDTO user) throws AccountInvalidCredentialsException, AccountNotFoundException {
        boolean exists = accountRepository.checkIfExists(user.getUsername());

        if(exists) {
            Account account = accountRepository.getUserByName(user.getUsername());

            if(account.getPassword().equals(user.getPassword())) {
                return account.getId();
            } else {
                throw new AccountInvalidCredentialsException();
            }
        } else {
            throw new AccountNotFoundException();
        }
    }

    public void remove(Long id) throws AccountNotFoundException{
        boolean exists = accountRepository.checkIfExistsById(id);

        if(exists) {
            accountRepository.deleteById(Account.class, id);
        } else {
            throw new AccountNotFoundException();
        }
    }

    public void update(Long id, AccountUpdateDTO user) {

    }

    public void updateRole(Long id, Role newRole) throws AccountNotFoundException {
        boolean exists = accountRepository.checkIfExistsById(id);

        if(exists) {

        } else {
            throw new AccountNotFoundException();
        }
    }

}

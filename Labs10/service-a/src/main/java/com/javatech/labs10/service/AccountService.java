package com.javatech.labs10.service;

import com.javatech.labs10.dtos.AccountDTO;
import com.javatech.labs10.dtos.AccountLoginDTO;
import com.javatech.labs10.dtos.AccountRegisterDTO;
import com.javatech.labs10.dtos.AccountUpdateDTO;
import com.javatech.labs10.entity.Account;
import com.javatech.labs10.exceptions.AccountAlreadyExistsException;
import com.javatech.labs10.exceptions.AccountInvalidCredentialsException;
import com.javatech.labs10.exceptions.AccountNotFoundException;
import com.javatech.labs10.pemissions.Role;
import com.javatech.labs10.repository.AccountRepository;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class AccountService {

    @Inject
    protected AccountRepository accountRepository;

    public AccountDTO get(Long accountId) throws AccountNotFoundException {
        boolean exists = accountRepository.checkIfExistsById(accountId);

        if(exists) {
            Account account = accountRepository.findById(Account.class, accountId);
            AccountDTO accountDTO = new AccountDTO();

            accountDTO.setId(account.getId());
            accountDTO.setUsername(account.getName());

            return accountDTO;
        } else {
            throw new AccountNotFoundException();
        }
    }

    public List<AccountDTO> gets() {

        List<AccountDTO> accountsDTO = new ArrayList<>();
        for(Account account : accountRepository.getAll()) {
            AccountDTO accountDTO = new AccountDTO();

            accountDTO.setId(account.getId());
            accountDTO.setUsername(account.getName());

            accountsDTO.add(accountDTO);
        }

        return accountsDTO;
    }

    public void create(AccountRegisterDTO user) throws AccountAlreadyExistsException {

        boolean exists = accountRepository.checkIfExists(user.getUsername());

        if(!exists) {
            accountRepository.save(new Account(user.getUsername(),user.getPassword(), Role.AUTHOR.toString()));
        } else {
            throw new AccountAlreadyExistsException();
        }


    }


    public Role getAccountRole(Long id) {

        Account account = accountRepository.findById(Account.class, id);

        if(account != null) {
            return Role.fromString(account.getRole());
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

    }

}

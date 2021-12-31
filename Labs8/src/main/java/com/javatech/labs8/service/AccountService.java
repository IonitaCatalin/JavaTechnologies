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

package com.javatech.labs8.service;

import com.javatech.labs8.dtos.DocumentAddDTO;
import com.javatech.labs8.entity.Account;
import com.javatech.labs8.entity.Document;
import com.javatech.labs8.exceptions.DocumentAuthorNotFoundException;
import com.javatech.labs8.exceptions.DocumentInvalidOwnershipException;
import com.javatech.labs8.exceptions.DocumentNotFoundException;
import com.javatech.labs8.pemissions.Role;
import com.javatech.labs8.repository.AccountRepository;
import com.javatech.labs8.repository.DocumentRepository;

import javax.inject.Inject;
import java.util.Collections;
import java.util.List;

public class DocumentService {

    @Inject
    protected DocumentRepository documentRepository;

    @Inject
    protected AccountRepository accountRepository;

    @Inject
    protected AccountService accountService;


    public void create(DocumentAddDTO addDocument, Long id) {
        boolean exists = accountRepository.checkIfExistsById(id);

        if(exists) {
            Account account = accountRepository.findById(Account.class,id);
            Document document = new Document(addDocument.getName(), addDocument.getName(), addDocument.getType());

            document.setAuthors(Collections.singletonList(account));
            documentRepository.save(document);
        }
    }

    public void remove(Long id, Long userId) throws DocumentNotFoundException, DocumentInvalidOwnershipException {
        boolean exists = documentRepository.checkIfExistsById(id);

        if(exists) {

            Document document = documentRepository.findById(Document.class,id);

            Account author = null;

            for(Account account: document.getAuthors()) {
                if(account.getId().equals(userId)) {
                    author = account;
                }
            }

            if(author != null) {
                documentRepository.deleteById(Document.class, id);
            } else {
                throw new DocumentInvalidOwnershipException();
            }

        } else {
            throw new DocumentNotFoundException();
        }
    }

    public void removeAuthorFromDocument(Long id, Long userId,Long authorId) throws DocumentAuthorNotFoundException,
            DocumentInvalidOwnershipException, DocumentNotFoundException  {
        boolean exists = documentRepository.checkIfExistsById(id);

        if(exists) {
            Document document = documentRepository.findById(Document.class, id);
            Account author = null;

            for(Account account: document.getAuthors()) {
                if(account.getId().equals(userId)) {
                    author = account;
                }
            }

            if(author != null) {
                List<Account> authors = document.getAuthors();

                Account accountToRemove = null;

                for(Account account : authors) {
                    if(account.getId().equals(authorId)){
                        accountToRemove = account;
                    }
                }

                if(accountToRemove != null) {

                    List<Account> documentAuthors = document.getAuthors();
                    documentAuthors.remove(accountToRemove);
                    document.setAuthors(documentAuthors);

                    documentRepository.save(document);
                } else {
                    throw new DocumentAuthorNotFoundException();
                }
            } else {
                throw new DocumentInvalidOwnershipException();
            }


        } else {
            throw new DocumentNotFoundException();
        }
    }

    public void addAuthorToDocument(Long documentId,Long authorId, Long userId) {
        boolean exists = documentRepository.checkIfExistsById(documentId);

        if(exists) {
            Document document = documentRepository.findById(Document.class, documentId);
        } else {
            throw new DocumentNotFoundException();
        }
    }


    public void findByName(String name) {

    }

}

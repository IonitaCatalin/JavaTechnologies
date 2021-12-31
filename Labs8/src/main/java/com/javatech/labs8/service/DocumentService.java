package com.javatech.labs8.service;

import com.javatech.labs8.dtos.*;
import com.javatech.labs8.entity.Account;
import com.javatech.labs8.entity.Document;
import com.javatech.labs8.exceptions.DocumentAuthorAlreadyExistsException;
import com.javatech.labs8.exceptions.DocumentAuthorNotFoundException;
import com.javatech.labs8.exceptions.DocumentInvalidOwnershipException;
import com.javatech.labs8.exceptions.DocumentNotFoundException;
import com.javatech.labs8.repository.AccountRepository;
import com.javatech.labs8.repository.DocumentRepository;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DocumentService {

    @Inject
    protected DocumentRepository documentRepository;

    @Inject
    protected AccountRepository accountRepository;


    public DocumentDTO get(Long documentId)  throws DocumentNotFoundException{
        boolean exists = documentRepository.checkIfExistsById(documentId);

        if(exists) {
            Document document = documentRepository.findById(Document.class, documentId);

                DocumentDTO documentDTO = new DocumentDTO();
                List<DocumentAuthorDTO> documentAuthorsDTO = new ArrayList<>();
                List<DocumentReferenceDTO> documentReferencesDTO = new ArrayList<>();

                for(Account account: document.getAuthors()) {
                   DocumentAuthorDTO authorDTO = new DocumentAuthorDTO();

                   authorDTO.setId(account.getId());
                   authorDTO.setName(account.getName());

                   documentAuthorsDTO.add(authorDTO);
                }

                for(Document reference : document.getBibliography()) {
                    DocumentReferenceDTO referenceDTO = new DocumentReferenceDTO();

                    referenceDTO.setId(reference.getId());
                    referenceDTO.setName(reference.getName());

                    documentReferencesDTO.add(referenceDTO);
                }

                documentDTO.setContent(document.getContent());
                documentDTO.setName(document.getName());
                documentDTO.setId(document.getId());
                documentDTO.setAuthors(documentAuthorsDTO);
                documentDTO.setReferences(documentReferencesDTO);

                return documentDTO;

        } else {
            throw new DocumentNotFoundException();
        }

    }

    public List<DocumentDTO> gets() {

        List<DocumentDTO> documentsDTO = new ArrayList<>();

        for(Document document : documentRepository.getAll()) {

            DocumentDTO documentDTO = new DocumentDTO();
            List<DocumentAuthorDTO> documentAuthorsDTO = new ArrayList<>();
            List<DocumentReferenceDTO> documentReferencesDTO = new ArrayList<>();

            for(Account author: document.getAuthors()) {
                DocumentAuthorDTO documentAuthorDTO = new DocumentAuthorDTO();

                documentAuthorDTO.setName(author.getName());
                documentAuthorDTO.setId(author.getId());

                documentAuthorsDTO.add(documentAuthorDTO);
            }

            for(Document reference: document.getBibliography()) {
                DocumentReferenceDTO documentReferenceDTO = new DocumentReferenceDTO();

                documentReferenceDTO.setName(reference.getName());
                documentReferenceDTO.setId(reference.getId());

                documentReferencesDTO.add(documentReferenceDTO);
            }

            documentDTO.setId(document.getId());
            documentDTO.setType(document.getType());
            documentDTO.setName(document.getName());
            documentDTO.setContent(document.getContent());
            documentDTO.setAuthors(documentAuthorsDTO);
            documentDTO.setReferences(documentReferencesDTO);

            documentsDTO.add(documentDTO);

        }
        return documentsDTO;

    }


    public void create(DocumentAddDTO addDocument, Long id) {
        boolean exists = accountRepository.checkIfExistsById(id);

        if(exists) {
            Account account = accountRepository.findById(Account.class,id);
            Document document = new Document(addDocument.getName(), addDocument.getName(), addDocument.getType());

            document.setAuthors(Collections.singletonList(account));
            documentRepository.save(document);
        }
    }

    public void remove(Long id, Long accountId) throws DocumentNotFoundException, DocumentInvalidOwnershipException {
        boolean exists = documentRepository.checkIfExistsById(id);

        if(exists) {

            Document document = documentRepository.findById(Document.class,id);

            Account author = null;

            for(Account account: document.getAuthors()) {
                if(account.getId().equals(accountId)) {
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

    public void removeAuthorFromDocument(Long id, Long accountId,Long authorId) throws DocumentAuthorNotFoundException,
            DocumentInvalidOwnershipException, DocumentNotFoundException  {
        boolean exists = documentRepository.checkIfExistsById(id);

        if(exists) {
            Document document = documentRepository.findById(Document.class, id);
            Account author = null;

            for(Account account: document.getAuthors()) {
                if(account.getId().equals(accountId)) {
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

    public List<DocumentDTO> getPersonal(Long accountId) {

        List<DocumentDTO> documentsDTO = new DocumentDTO;

        for(Document document : documentRepository.getAll()) {
            Account author = (Account) document.getAuthors()
                    .stream()
                    .filter(a -> a.getId().equals(accountId))
                    .findFirst()
                    .orElse(null);

            if(author != null) {
              DocumentDTO documentDTO = new DocumentDTO();

              documentDTO.setContent(document.getContent());
              documentDTO.setType(document.getType());
              documentDTO.setName(document.getName());
              documentDTO.setId(document.getId());

              List<DocumentAuthorDTO> authorsDTO = new ArrayList<>();

              for(Account account : document.getAuthors()) {

              }

              documentsDTO.add(documentDTO);
            }

        }

        return documentsDTO;
    }


    public void addAuthorToDocument(Long documentId,Long authorId, Long accountId) {
        boolean exists = documentRepository.checkIfExistsById(documentId);

        if(exists) {
            Document document = documentRepository.findById(Document.class, documentId);
            Account author = null;

            for(Account account: document.getAuthors()) {
                if(account.getId().equals(accountId)) {
                    author = account;
                }
            }

            if(author != null) {
                boolean existsAuthor = accountRepository.checkIfExistsById(authorId);

                if(existsAuthor) {
                    List<Account> authors = document.getAuthors();
                    Account authorToAdd = accountRepository.findById(Account.class, authorId);

                    if(!authors.contains(authorToAdd)) {
                        authors.add(authorToAdd);
                        document.setAuthors(authors);

                        documentRepository.save(document);

                    } else {
                        throw new DocumentAuthorAlreadyExistsException();
                    }

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


}

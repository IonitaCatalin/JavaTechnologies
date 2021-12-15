package com.javatech.labs8.service;

import com.javatech.labs8.entity.Contest;
import com.javatech.labs8.entity.Document;
import com.javatech.labs8.entity.User;
import com.javatech.labs8.stamps.RegistrationStamp;
import com.javatech.labs8.repository.ContestRepository;
import com.javatech.labs8.repository.DocumentRepository;
import com.javatech.labs8.repository.UserRepository;
import com.javatech.labs8.security.AuthorizedUser;
import com.javatech.labs8.security.UserRole;
import org.primefaces.model.file.UploadedFile;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ApplicationService {
    @Inject
    protected UserRepository userRepository;

    @Inject
    protected DocumentRepository documentRepository;

    @Inject
    protected ContestRepository contestRepository;

    @Inject
    protected RegistrationStamp registrationStamp;

    @Inject
    AuthorizedUser authorizedUser;


    public List<User> listUsers() {
        return userRepository.getEntities();
    }

    public UserRole[] listRoles() {
        return UserRole.values();
    }

    public List<Document> viewDocuments() {
        return documentRepository.getEntities();
    }


    public boolean login(User user) {
        User usr = userRepository.getUserByName(user.getName());
        if (user.getPassword().equals(usr.getPassword())) {
            authorizedUser.setId(usr.getId());
            authorizedUser.setName(usr.getName());
            authorizedUser.setRole(usr.getRole());
            return true;
        }
        return false;
    }


    public void register(User user) {
        userRepository.save(user);
    }

    public void addDocument(UploadedFile fileUpload) {
        if (fileUpload != null) {
            Document document = new Document();
            document.setName("My Document Is Nice");
            document.setContent(fileUpload.getContent());
            document.setContentType(fileUpload.getContentType());
            document.setAuthors(new HashSet<>(Arrays.asList(userRepository.findById(User.class, authorizedUser.getId()))));
            documentRepository.save(document);
        }
    }

    public void addContest(Contest contest) {
        contest.setRegistrationStamp(registrationStamp.getStamp());
        contestRepository.save(contest);
    }
}

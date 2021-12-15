package com.javatech.labs8;

import com.javatech.labs8.entity.Contest;
import com.javatech.labs8.entity.Document;
import com.javatech.labs8.repository.ContestRepository;
import com.javatech.labs8.security.AuthorizedUser;
import com.javatech.labs8.service.ApplicationService;
import org.primefaces.model.file.UploadedFile;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Decorator
public abstract class Application {
    @Inject
    @Delegate
    @Any
    ApplicationService applicationService;

    @Inject
    ContestRepository contestRepository;

    @Inject
    AuthorizedUser authorizedUser;


    public void addDocument(UploadedFile file) {
        if (authorizedUser.hasPermission("document:write"))
            if (contestRepository.getEntities().stream().anyMatch(it -> it.getStartTime().before(new Date()) && it.getEndTime().after(new Date())))
                applicationService.addDocument(file);
    }


    public List<Document> viewDocuments() {
        if (authorizedUser.hasPermission("document:read")) {
            return applicationService.viewDocuments();
        }
        return new ArrayList<>();
    }


    public void addContest(Contest contest) {
        if (authorizedUser.hasPermission("contest:write")) {
            applicationService.addContest(contest);
        }
    }

}

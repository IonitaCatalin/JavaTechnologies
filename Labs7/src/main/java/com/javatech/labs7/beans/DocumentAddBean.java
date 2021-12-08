package com.javatech.labs7.beans;

import com.javatech.labs7.services.DocumentService;

import javax.inject.Inject;
import java.util.logging.Logger;

public class DocumentAddBean {

    @Inject
    private Logger logger;

    @Inject
    DocumentService documentService;


}

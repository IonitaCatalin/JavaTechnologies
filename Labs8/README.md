# **Requirements**

Continue the application created in [the previous lab](https://profs.info.uaic.ro/~acf/tj/labs/lab_07.html), exposing some functionalities through various Web services.

1.  (2p) Create RESTful Web services using **JAX-RS** that allow the interaction with at least one JPA entity, implementing CRUD operations. For example, the application may offer the following services:
 
    -   _AddDocumentService_ that allows adding a new document;
    -   _UpdateDocumentService_ that allows replacing an existing document;
    -   _DeleteDocumentService_ that allows deleting an existing document from the database.
    -   _ViewDocumentService_ that returns a "list" of the documents there were uploaded. The parameter of the web method will be an identifier for the user. If the parameter is null, then all documents should be considered.
    
    Use JSON for representing consumed or produced data. Comment (using OpenAPI) and test at least one service.
    
2.  (1p) Create a **filter** that will act as a cache for the _ViewDocumentService_, storing the parameters of the incoming request and the returned responses. If the documents are modified by the application, reset the cache accordingly.
    
3.  (2p+) Modify the model such that each document has a list of references (its bibliography), each reference being a document existing in the database. Create another service, that will read all the documents and:
    -   verify that there are no circuits in the corresponding directed graph;
    -   establish a possible chronological order of the documents, based on their bibliography.Consider using an asynchronous implementation, both at the client and container side.

# **Explanations**
--

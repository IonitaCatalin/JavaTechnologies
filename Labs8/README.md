


# **Requirements**

Continue the application created in [the previous lab](https://profs.info.uaic.ro/~acf/tj/labs/lab_07.html), exposing some functionalities through various Web services.

1.  ✔️ (2p) Create RESTful Web services using **JAX-RS** that allows the interaction with at least one JPA entity, implementing CRUD operations. For example, the application may offer the following services: ✔
 
    -   _AddDocumentService_ that allows adding a new document;
    -   _UpdateDocumentService_ that allows replacing an existing document;
    -   _DeleteDocumentService_ that allows deleting an existing document from the database.
    -   _ViewDocumentService_ that returns a "list" of the documents there were uploaded. The parameter of the web method will be an identifier for the user. If the parameter is null, then all documents should be considered.
    
    Use JSON for representing consumed or produced data. Comment (using OpenAPI) and test at least one service.
    
2.  ✔️ (1p) Create a **filter** that will act as a cache for the _ViewDocumentService_, storing the parameters of the incoming request and the returned responses. If the documents are modified by the application, reset the cache accordingly. ✔️
    
3.  ✔️ (2p+) Modify the model such that each document has a list of references (its bibliography), each reference being a document existing in the database. Create another service, that will read all the documents and: ✔️
    -   verify that there are no circuits in the corresponding directed graph;
    -   establish a possible chronological order of the documents, based on their bibliography. Consider using an asynchronous implementation, both at the client and container sides.

# **Explanations**

1. For this laboratory, we designed a system for indexing and referencing documents made by a set of users in the system, documents are supposed to be created by the users which are subsequently their authors but, a document can also reference another document made by an author or set of authors. For executing CRUD operations(additions, deletions, interrogations, etc) over the documents, authors, users, and references in the system we have to make calls to the exposed Restful API. The following endpoints, made following the Rest architectural style, are exposed to the user : 

	-	POST	**/api/v1/users/authenticate** -> used for registering an active user into the system, when first registering the user will get the Role of AUTHOR, another role for the designated user will require an admin interaction.
	-  POST	**/api/v1/users/register** -> used for authenticating a user into the system, as a response to the request, a requesting user will receive in the response a JWT generated and signed by the server authority.
	-  GET	**/api/v1/users** -> used for discovering every registered user in the system. This request is protected via the token authorization mechanism. 
	- GET	**/api/v1/users/{accountId}** -> used for getting a certain user account details. This actions also requires ADMIN level rights to complete.
	- DELETE	**/api/v1/users/{accountId}** -> used for deleting a specified user account. This action requires ADMIN level rights to complete.
	- POST	**/api/v1/documents** -> used to create documents and insert them into the system. A newly created document will have as an author the current user who makes a request. The authenticity of the user is ensured by the token provided as a means of authorization since it holds inside of it the unique id of the requesting user.
	- GET	**/api/v1/documents** -> used to get all the documents in the system for every user.
	- GET **/api/v1/documents/me** -> used to get the documents of a requesting user.
	- DELETE	**/api/v1/documents/{documentId}** -> used to delete the document specified by the id. Only one of the authors of the document can delete it.
	-  POST	**/api/v1/documents/{docId}/authors** -> used for adding another author to the document. Only one of the existing authors can add another author to the document. As a side effect of this action, the author that is being added also gets read and write rights over the document.
	- POST	**/api/v1/documents/{docId}/references** -> used for adding references towards another documents for on of the requesting user's documents. **The action of adding a reference to the document will be validated as to not introduce circular references.**
	- DELETE	**/api/v1/documents/{docId}/references/{referenceId}** -> used for deleting on the references from the requesting document specified by id. This action can also only be completed by one of the documents' authors.
	- DELETE **/api/v1/documents/{docId}/authors/{authorId}** -> used for deleting on the authros from the requesting document specified by id. This action can also only be completed by one of the documents' authors.
	- POST	**/api/v1/contests** -> used for creating contests. **A contest is a competition where different authors can add their documents for review. The documents in the competition can only be reviewed by an account with REVIEWER role**.
	- DELETE	**/api/v1/contests/{contestId}** -> used for deleting a contest. **Only an account with ADMIN role can perform this action**.
	- GET	**/api/v1/contests/{contestId}** -> used for getting the contest details such as the name, if it is still running, etc.
	- PUT	**/api/v1/contests/{contestId}** -> used for changing the properties of a contest. This action is necessary to be performed once the timeframe dedicated to that competition ended for changing the running status of the contest.
	- GET **/api/v1/contests/{contestId}/documents/{documentId}** -> used for getting a specific document enrolled in a contest.
	- GET **/api/v1/contests/{contestId}/documents** -> used for getting all the documents enrolled in a contest. Only a **REVIEWER** can get the documents in a contest. 

The implemented application which exposes a Restfull API works by making use of implementation over the JAX-RS specification. The entry point of our application is the class [`ApplicationConfig`](https://github.com/IonitaCatalin/JavaTechnologies/blob/main/Labs8/src/main/java/com/javatech/labs8/ApplicationConfig.java) where we extend the primary Application class and add our resource classes to the set of application resources. We need to specifically add the resource classes which are classes where we used the annotation defined by the JAX-RS specification to indicate the application which instances to bind by their providers at runtime. We also define a class called [`ApplicationResource`](https://github.com/IonitaCatalin/JavaTechnologies/blob/main/Labs8/src/main/java/com/javatech/labs8/ApplicationResources.java) (not to be confused with resources of the API Application class) to act as a producer for our EntityManager related to our persistence API definition, we do this cause we want to inject our EntityManager directly in our [`Repositories`](https://github.com/IonitaCatalin/JavaTechnologies/tree/main/Labs8/src/main/java/com/javatech/labs8/repository) classes. 

To bind a certain method to an endpoint in our API we decided to pack this functionality in a few [`Controller`](https://github.com/IonitaCatalin/JavaTechnologies/tree/main/Labs8/src/main/java/com/javatech/labs8/controller) classes such as [`UserController`](https://github.com/IonitaCatalin/JavaTechnologies/blob/main/Labs8/src/main/java/com/javatech/labs8/controller/UserController.java), [`DocumentController`](https://github.com/IonitaCatalin/JavaTechnologies/blob/main/Labs8/src/main/java/com/javatech/labs8/controller/DocumentController.java), [`ContestController`](https://github.com/IonitaCatalin/JavaTechnologies/blob/main/Labs8/src/main/java/com/javatech/labs8/controller/ContestController.java) in a MVC architectural style. A controller's sole purpose is to bind a certain method using the JAX-RS annotation such as @Path(), @GET, @POST, @PUT to an endpoint in our API. Every controller has its associated [`Service`](https://github.com/IonitaCatalin/JavaTechnologies/tree/main/Labs8/src/main/java/com/javatech/labs8/service) class which is injected directly into the controller. The method inside the controller is called when an HTTP request is made at that specific endpoint bound inside the controller, the controller will call the method inside the service which will use one of the Repository classes to further propagate the requested changes in the database. When a request arrives the POST data inside the respective request is marshmallowed in a class desired by the developer. In our case all the data coming from the user is marshmallowed inside one of our [`DTOs`](https://github.com/IonitaCatalin/JavaTechnologies/tree/main/Labs8/src/main/java/com/javatech/labs8/dtos) classes. For instance the [`DocumentAddDTO`](https://github.com/IonitaCatalin/JavaTechnologies/blob/main/Labs8/src/main/java/com/javatech/labs8/dtos/DocumentAddDTO.java) class contains the informations required by the system to create a document, informations that have to be delivered by the user.

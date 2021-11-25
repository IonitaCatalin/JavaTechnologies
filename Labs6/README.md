
1.  ✔️(2p) Rewrite the  _data access_  layer of the application created in the previous laboratories, implementing the repository classes as  _Enterprise Java Beans_.
    
    -   ✔️ Use the support offered by the EJB technology for implementing  _transactions_.
        
    -   ✔️ Suppose that each exam must be assigned some resources (for example: a room, a video projector, etc) and each resource is in limited number. Create a  _"reservation"_  page, allowing the reservation of a group of resources for a specific exam (all of them, or none).  
        The following enterprise beans must be implemented:
        -   ✔️ A  **stateless session bean**  that offers methods for checking the availability of a resource.
        -   ✔️ A  **stateful session bean**  responsible with the assignment of one or more resource to a specific exam. The assignment should be  _atomic_, either all resources are successfully assigned, or the transaction will be rolled back.  
            
        -   ✔️ A  **singleton session bean**  that keeps an in-memory map of the current assignments. The map will be instantiated at application startup and updated whenever the assignments change.
    
2.  ❌(2p) Create a test case that highlights the performance gain of using various forms of JPA optimizations: second level cache, lazy loading and entity graphs, etc.  
    Use an EJB interceptor in order to monitor the running time of a business method.  
    Create a timer that will trigger the invocation of the business method, using a specified schedule.


# **Explanations**

As this laboratory is focused on **Enterprise Java Beans**, the functionality developed for the [`fifth laboratory`](https://github.com/IonitaCatalin/JavaTechnologies/tree/main/Labs5), was revamped to fit the current scenario. The binding from the models to entities using JPA was kept intact, as in presented in the previous laboratory. 

We transitioned from Services making use injected EntityManagers to using **EJB** injectable interfaces with support for : transactions, concurrency, thread polling. 

For the persistence aspect of the application, the configuration was not subjected to any changes. There are no additional entities tables to add into the database as the **Resource** entity which we intend to use later on is stored exclusively in an in-memory map. 

It is worth mentioning, that as in the previous laboratory for the **EJB** API to work a JNDI is to be defined alongside a ThreadPool.

The first major change when it comes to structuring is the transition from **Services**  to **Repositories** classes. We declared a common interface for a Repository called [`DataRepositoryInterface`](https://github.com/IonitaCatalin/JavaTechnologies/blob/main/Labs6/src/main/java/com/jtechnologies/labs5/repositories/DataRepositoryInterface.java) which uses generics types and exposes a common API for the implementing classes. 
The Repositories used in the project are annotated with the **@LocalBean**, EJB annotation that specified that the EJB interface which is the Repository itself does not uses any client specific views. The implemented Repositories are annotated with either the  **@Stateless** ([`ExamRepository`](https://github.com/IonitaCatalin/JavaTechnologies/blob/main/Labs6/src/main/java/com/jtechnologies/labs5/repositories/ExamRepository.java), [`EnrolmentRepository`](https://github.com/IonitaCatalin/JavaTechnologies/blob/main/Labs6/src/main/java/com/jtechnologies/labs5/repositories/EnrolmentRepository.java), [`StudentRepository`](https://github.com/IonitaCatalin/JavaTechnologies/blob/main/Labs6/src/main/java/com/jtechnologies/labs5/repositories/StudentRepository.java)) or with the **@Singleton** annotation ,in our case, ResourceRepository, meant to store in a in-memory map the assignment of a resource [`Resource`](https://github.com/IonitaCatalin/JavaTechnologies/blob/main/Labs6/src/main/java/com/jtechnologies/labs5/models/Resource.java) with its type of [`ResourceType`](https://github.com/IonitaCatalin/JavaTechnologies/blob/main/Labs6/src/main/java/com/jtechnologies/labs5/enums/ResourceType.java) to an exam. Considering the usage, the repositories are injected using the **@EJB** annotation in the [beans](https://github.com/IonitaCatalin/JavaTechnologies/tree/main/Labs6/src/main/java/com/jtechnologies/labs5/beans) component then binded with the JSP pages.










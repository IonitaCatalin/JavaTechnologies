1.  ✔️(2p) Rewrite the  _data access_  layer of the application created in the previous laboratories, implementing the repository classes as  _Enterprise Java Beans_.
    
    -   ✔️Use the support offered by the EJB technology for implementing  _transactions_.
        
    -   ✔️Suppose that each exam must be assigned some resources (for example: a room, a video projector, etc) and each resource is in limited number. Create a  _"reservation"_  page, allowing the reservation of a group of resources for a specific exam (all of them, or none).  
        The following enterprise beans must be implemented:
        -   ✔️A  **stateless session bean**  that offers methods for checking the availability of a resource.
        -   ❌A  **stateful session bean**  responsible with the assignment of one or more resource to a specific exam. The assignment should be  _atomic_, either all resources are successfully assigned, or the transaction will be rolled back.  
            
        -   ❌A  **singleton session bean**  that keeps an in-memory map of the current assignments. The map will be instantiated at application startup and updated whenever the assignments change.
    
2.  ❌(2p) Create a test case that highlights the performance gain of using various forms of JPA optimizations: second level cache, lazy loading and entity graphs, etc.  
    Use an EJB interceptor in order to monitor the running time of a business method.  
    Create a timer that will trigger the invocation of the business method, using a specified schedule.


# **Explanations**

Soon...


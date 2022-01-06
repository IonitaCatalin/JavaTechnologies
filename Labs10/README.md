# **Requirements**

(1p) ✔️ Run the microservices using an Eclipse Microprofile server implementation (Payara Micro, Open Liberty, Quarkus, etc.)
- Create Docker containers for the microservices. Consider deploying the database also as a container.

(2p) ✔️ Implement simple test cases to highlight the support offered by MicroProfile for writing resilient microservices.
- Use the following: Fallback + Timeout and Retry(0.5p), CircuitBreaker(0.5p), Bulkhead thread-pool(0.5p) and semaphore(0.5p).
- You should be able to invoke the annotated methods and analyze their behaviour.

(1p) ✔️ Implement and test a health check procedure, in order to determine the readiness and the liveness of your service.

(1p) ✔️ Use MicroProfile Metrics API in order to monitor the behaviour of your service.
- Analyze the number of invocations and the response time for at least one method. 

# **Explanations**
 

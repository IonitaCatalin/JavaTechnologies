
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
 
 For this laboratory we used the containerized PayaraMicro microservices that we created in the previous [`laboratory`](https://github.com/IonitaCatalin/JavaTechnologies/tree/main/Labs9), to add a specific set of maintanance features such as health check, metrics and also resilience.

`1`. The entire process of running our microservices as docker containers is further detailed in the previous laboratory which is [Laboratory9](https://github.com/IonitaCatalin/JavaTechnologies/tree/main/Labs9), also details over how to run the database as a container were included. 

`2`.

`3`.

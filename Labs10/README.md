
# **Requirements**

(1p) ✔️ Run the microservices using an Eclipse Microprofile server implementation (Payara Micro, Open Liberty, Quarkus, etc.)
- Create Docker containers for the microservices. Consider deploying the database also as a container.

(2p) ❌ Implement simple test cases to highlight the support offered by MicroProfile for writing resilient microservices.
- Use the following: Fallback + Timeout and Retry(0.5p), CircuitBreaker(0.5p), Bulkhead thread-pool(0.5p) and semaphore(0.5p).
- You should be able to invoke the annotated methods and analyze their behaviour.

(1p) ✔️ Implement and test a health check procedure, to determine the readiness and the liveness of your service.

(1p) ✔️ Use MicroProfile Metrics API to monitor the behavior of your service.
- Analyze the number of invocations and the response time for at least one method. 

# **Explanations**
 
 For this laboratory we used the containerized PayaraMicro microservices that we created in the previous [`laboratory`](https://github.com/IonitaCatalin/JavaTechnologies/tree/main/Labs9), to add a specific set of maintenance features such as health check, metrics, and also resilience.

`1`. The entire process of running our microservices as Docker containers is further detailed in the previous [laboratory](https://github.com/IonitaCatalin/JavaTechnologies/tree/main/Labs9), also details over how to run the database as a container were included. Since docker containers are secluded details over how to include the microservices container and also database container in a network were also included.

`3`. For implementing a HealthCheck for our PayaraMicro microservice we built over the existing mechanisms in the eclipse.microprofile. We extended the class HealthCheck and overloaded the call() function to send a JSON response with details about our microservice health. Two checks were implied [`ServiceLiveHealthCheck`](https://github.com/IonitaCatalin/JavaTechnologies/blob/main/Labs10/service-a/src/main/java/com/javatech/labs10/health/ServiceLiveHealthCheck.java) which check for our microservice health and [`ServiceReadyHealthCheck`](https://github.com/IonitaCatalin/JavaTechnologies/blob/main/Labs10/service-a/src/main/java/com/javatech/labs10/health/ServiceReadyHealthCheck.java) which check for our service readiness. If a user wants to know our service readiness or liveness, all he has to do is make a GET request /health/ready and /health/live endpoints.

`4`. For implementing Metrics for our microservice API we included a new controller called [`MetricController`](https://github.com/IonitaCatalin/JavaTechnologies/blob/main/Labs10/service-a/src/main/java/com/javatech/labs10/metrics/MetricController.java). This controller makes it possible to make requests to increment the number of times a method in the same controller was called. For getting metrics of the called method we can make a GET request to /metrics/application

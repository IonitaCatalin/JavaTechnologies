



# **Requirements**

(3p) ✔️ Add security features to the application created in the previous lab, using standard mechanisms offered by Java EE for:
 -  Authentication, using a JDBC Realm;
 -  Controlling the access to Web resources, using Web constraints;
 -  Securing the business logic components and REST services. 

(2p) ✔️ Expose a CRUD REST resource from the previous lab as a microservice.
- Run the microservice using an Eclipse Microprofile server implementation (Payara Micro, Open Liberty, Quarkus, etc.)
- Create an additional microservice that will invoke the first one.
- Create Docker containers for the microservices. Consider deploying the database also as a container. 


# **Explanations**

For this laboratory, we used the Restful API developed using the JAX-RS specification and Jersey implementation from the previous [laboratory](https://github.com/IonitaCatalin/JavaTechnologies/tree/main/Labs8) to build a system made of 2 microservice, [`service-a`](https://github.com/IonitaCatalin/JavaTechnologies/tree/main/Labs9/service-a) which is encapsulating our aforementioned Restfull API and [`service-b`](https://github.com/IonitaCatalin/JavaTechnologies/tree/main/Labs9/service-b) which calls service-a to obtain data and print in its logging console.

`1`. For the first part of the laboratory, the security mechanism remained unchanged as it was detailed in the previous [`laboratory`](https://github.com/IonitaCatalin/JavaTechnologies/tree/main/Labs8). For a user to make requests to a protected endpoint of the API he must provide a token using the Authorization schema header the Bearer strategy in that specific header. For obtaining a token issued by the service provider a user needs to exchange his login details like username and password to one of the exposed endpoints `labs9/users/authenticate`. In exchange for the username and password, the requesting user will receive a token to use for the following requests. As for the implementation of this detailed strategy, we used 2 ContextRequestFilter: [`AuthorizationFilter`](https://github.com/IonitaCatalin/JavaTechnologies/blob/main/Labs9/service-a/src/main/java/com/javatech/labs9/filters/AuthorizationFilter.java) and [`AuthenticationFilter`](https://github.com/IonitaCatalin/JavaTechnologies/blob/main/Labs9/service-a/src/main/java/com/javatech/labs9/filters/AuthenticationFilter.java) to extract the JWT token from the request, validate it (or throw an exception if the token is invalid), and check that role for the specific user. To imply the validation done by these filters a user needs to annotate a certain endpoint declared in the controller with the [`@JWTTokenRequired`](https://github.com/IonitaCatalin/JavaTechnologies/blob/main/Labs9/service-a/src/main/java/com/javatech/labs9/annotations/JWTTokenRequired.java), we also use this annotation to specify the role of a user that can activate the endpoint.

`2`. For the second part of the laboratory, we need to run our microservices using PayaraMicro. To run either service-a or service-b as a first step it is mandatory to compile the sources consisting of all the classes and dependencies in the respective service. 

This can be done using the `mvn clean package` command which instructs maven to build a .jar and .war file using our sources. The name of the resulted jar also all the dependencies that need to be encapsulated in that specific file are all stated in the `pom.xml` file

After the sources have been compiled the next step to run the actual service is to run the `.jar` file obtained by simply running it as a regular `.jar` file using `java -jar  \target\labs9-microbundle.jar --port 8080` (port 8080 for service-a and 8081 for service-b). 

Considering as in the previous laboratories where we had Payara Server to manage our Database Connection Pools and also JDBC resources used in the process of JNDI lookup, PayaraMicro does not have such a feature and as a result, we have to explicitly create the database-pool and JDBC resource from that pool after the process of booting the server up is done. This can be done by specifying a few commands when running the `.jar` file. 

```
create-jdbc-connection-pool --datasourceclassname org.postgresql.ds.PGSimpleDataSource --restype javax.sql.DataSource demo-pool  
set resources.jdbc-connection-pool.demo-pool.property.password=05032000 resources.jdbc-connection-pool.demo-pool.property.databaseName=reviewer resources.jdbc-connection-pool.demo-pool.property.serverName=172.20.0.1 resources.jdbc-connection-pool.demo-pool.property.user=postgres resources.jdbc-connection-pool.demo-pool.property.portNumber=5432  
  
create-jdbc-resource --enabled=true --poolName=demo-pool --target=domain jdbc/reviewer-micros-a  
create-resource-ref --enabled=true --target=server jdbc/reviewer-micros-a
```
We can attach multiple commands by embedding them in a text file called for instance [`post-boot-commands.txt`](https://github.com/IonitaCatalin/JavaTechnologies/blob/main/Labs9/service-a/post-boot-commands.txt) and adding them in the java -jar command using the argument `--postbootcommandfile <path>`

This does explain briefly how to run a service on the local machine using Maven and Java Runtime Environment.

But this configuration is highly dependent on the local configuration of the machine. If we want to obtain a deploying medium that is operating system agnostic we can use Docker to containerize the PayaraMicro instance and run it inside the Docker Engine in Windows, Linux or Mac, or any other operating system in a production environment.

To specify how to deploy our project to a PayaraMicro service we need to build a Dockerfile which states how our docker image should be composed using as a starting point a generic Payara Micro service image and a Linux bare implementation. 

Each service, be it either [`a`](https://github.com/IonitaCatalin/JavaTechnologies/tree/main/Labs9/service-a) or [`b`](https://github.com/IonitaCatalin/JavaTechnologies/tree/main/Labs9/service-b) has a Dockerfile inside its project structure.

[`Service A`](https://github.com/IonitaCatalin/JavaTechnologies/blob/main/Labs9/service-a/Dockerfile):
```
# We want to start from a payara/micro version 5.2021.10 generic image
FROM payara/micro:5.2021.10

#We want to copy/add the WAR file generated by Maven inside the Docker image
ADD target/labs9.war $PAYARA_PATH

#We want to copy/add the commands to use after boot inside the Docker image
ADD post-boot-commands.txt $PAYARA_PATH

#We specify which executable to be run after the image is running. In our case, we deploy our WAR file in PayaraMicro. Also, we specify to run the file post-boot-commands after the service is booted
ENTRYPOINT ["java", "-jar", "/opt/payara/payara-micro.jar", "--deploy", "/opt/payara/labs9.war", "--postbootcommandfile", "/opt/payara/post-boot-commands.txt"]

```

[`Service B`](https://github.com/IonitaCatalin/JavaTechnologies/blob/main/Labs9/service-b/Dockerfile):
```
# We want to start from a payara/micro version 5.2021.10 generic image
FROM payara/micro:5.2021.10


#We want to copy/add the WAR file generated by Maven inside the Docker image
ADD target/labs9.war $PAYARA_PATH

#We specify which executable to be run after the image is running. In our case, we deploy our WAR file in PayaraMicro
ENTRYPOINT ["java", "-jar", "/opt/payara/payara-micro.jar", "--deploy", "/opt/payara/labs9.war", "--port","8081"]
```

This specific Dockerfile can then be built using the command `docker build -t <tag-name> .` This command will build the Dockerfile inside the current directory.

After the build was done succesfully we can run the docker image using `docker run -p 8080:8080 --network=bridge <container-name> --name <docker-build-name>`.

What is important to know is that we ran the docker image in network bridged mode because our database is also a docker Postgres image thus we can access it by aggregating it to a network and then addressing it over its IP address which can be found by running the following commands:

`docker ps` - to see all the running docker containers
`docker inspect <CONTAINER ID> | grep -w "IPAddress" | awk '{ print $2 }' | head -n 1 | cut -d "," -f1` - to grep the ip of the docker container identified by the container-id 




 

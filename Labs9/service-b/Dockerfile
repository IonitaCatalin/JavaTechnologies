
# Using the Payara Micro 5 snapshot build.
FROM payara/micro:5.2021.10

# Downloads the database connector library

# Adds an application to be loaded
ADD target/labs9.war $PAYARA_PATH
 
ENTRYPOINT ["java", "-jar", "/opt/payara/payara-micro.jar", "--deploy", "/opt/payara/labs9.war", "--port","8081"]


FROM payara/micro:5.2021.10

ADD target/labs10.war $PAYARA_PATH
ADD post-boot-commands.txt $PAYARA_PATH
 
ENTRYPOINT ["java", "-jar", "/opt/payara/payara-micro.jar", "--deploy", "/opt/payara/labs10.war", "--postbootcommandfile", "/opt/payara/post-boot-commands.txt"]


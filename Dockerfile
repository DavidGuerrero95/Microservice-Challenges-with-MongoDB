FROM openjdk:15
VOLUME /tmp
ADD ./target/retos-retos-0.0.1-SNAPSHOT.jar retos.jar
ENTRYPOINT ["java","-jar","/retos.jar"]
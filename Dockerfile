FROM openjdk:17-jdk-slim

WORKDIR /root

COPY ./pom.xml  /root
COPY ./.mvn /root
COPY ./mvnw /root

# RUN mvnw -v

COPY src /root/src

# RUN ./mvnw clean install -DskipTests

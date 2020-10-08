FROM maven as builder
WORKDIR /coding-test-ranking
COPY . .
RUN mvn package spring-boot:repackage

FROM openjdk:11-alpine
COPY --from="builder" /coding-test-ranking/target/ .
EXPOSE 8080
CMD java -jar *.jar
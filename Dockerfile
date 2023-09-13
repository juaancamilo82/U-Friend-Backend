#
# Build stage
#
FROM maven:3.8.3-openjdk-17-slim AS build
ARG DATABASE
ARG DB_URL
ARG DB_USERNAME
ARG DB_PASSWORD
ENV DATABASE=$DATABASE
ENV DB_URL=$DB_URL
ENV DB_USERNAME=$DB_USERNAME
ENV DB_PASSWORD=$DB_PASSWORD
ENV FRONT_CLIENT=$FRONT_CLIENT
ENV SECRET=$SECRET
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:17-alpine
COPY --from=build /home/app/target/u-friend-0.0.1-SNAPSHOT.jar /usr/local/lib/u-friend-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/u-friend-0.0.1-SNAPSHOT.jar"]
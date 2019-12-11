FROM adoptopenjdk/openjdk11:alpine-jre

COPY ./build/libs/loadtest-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch loadtest-0.0.1-SNAPSHOT.jar.jar'

ENTRYPOINT ["java","-jar","loadtest-0.0.1-SNAPSHOT.jar"]
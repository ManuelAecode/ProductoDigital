FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/WebCoursesBack-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} WebCoursesBack.jar
ENTRYPOINT ["java","-jar","/WebCoursesBack.jar"]

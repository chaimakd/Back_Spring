#Java runtime as a parent image
FROM openjdk:11

#Copy the application JAR file to the container
COPY target/tpAchatProject-1.1-SNAPSHOT.jar app.jar

#Expose the port that the application will run on
EXPOSE 8089

#This is the command to run the application
CMD ["java", "-jar", "/app.jar"]

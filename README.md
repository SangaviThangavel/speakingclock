Welcome to Speaking clock Spring application. Follow the instrctions to do the setup.

Clone the repository 

Prerequisites
Java 17 - Install from https://www.oracle.com/java/technologies/downloads/#java17
Make sure that the java -version shows 17

Maven - download and unpack the zip from https://maven.apache.org/download.cgi
and then follow the steps here https://maven.apache.org/guides/getting-started/windows-prerequisites.html


Open the root directory of the app in terminal.

Installing depdendencies - 
mvn clean insall

Running tests -
mvn test

Running the app in localhost - 
mvn spring-boot:run

Once the app successfully started, you can test the app by 
opening http://localhost:8080/speak?time=03:34 in your browser or in postman.
Modify the time param to see the speaking clock in action.
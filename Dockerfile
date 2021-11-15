# Our base build image
FROM maven:3.6.0-jdk-8 as maven

# Copy the project files
COPY ./pom.xml ./pom.xml

# Build all dependencies
RUN mvn dependency:go-offline -B

# Copy your other files
COPY ./src ./src

# Build for release
RUN mvn package -DskipTests

# oOur final base image
FROM openjdk:8-jre-alpine

# Set deployment directory
WORKDIR /my-project

# Copy over the built artifact from the maven image
COPY --from=maven target/spring-boot-starterkit-1.0.jar ./

# Set the startup command to run your binary
CMD ["java", "-jar", "./spring-boot-starterkit-1.0.jar"]

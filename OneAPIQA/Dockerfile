FROM openjdk:8-jre-slim

#A Directory in the base image to copy our depedencies
WORKDIR /usr/share/tag

# Add the project jar & copy dependencies

ADD  target/OneAPIQA-1.0-SNAPSHOT-jar-with-dependencies.jar OneAPIQA-1.0-SNAPSHOT-jar-with-dependencies.jar
ADD resources resources
RUN apt-get update -y
VOLUME test-output test-output
ENTRYPOINT java -cp "OneAPIQA-1.0-SNAPSHOT-jar-with-dependencies.jar:." -Dtestng.dtd.http=true org.testng.TestNG resources/testng.xml

FROM openjdk:17-ea-jdk-slim

RUN mkdir /opt/mega-horoscopo

COPY target/mega-horoscopo-*.jar /opt/mega-horoscopo/app.jar

ENTRYPOINT ["java","-jar","/opt/mega-horoscopo/app.jar"]
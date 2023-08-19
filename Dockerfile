FROM openjdk:17-ea-jdk-slim

RUN mkdir /opt/mega-horoscopo

COPY target/mega-horoscopo-*.jar /opt/mega-horoscopo/app.jar

ENV SPRING_PROFILES_ACTIVE=prod

ENTRYPOINT ["java","-jar","-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE}","/opt/mega-horoscopo/app.jar"]
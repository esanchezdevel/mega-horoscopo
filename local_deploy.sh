#!/bin/bash

echo
echo "===================="
echo "Building application"
echo "===================="
echo

mvn clean package -DskipTests

echo "====================="
echo "Cleaning docker image"
echo "====================="

docker container stop mega-horoscopo
docker container rm mega-horoscopo
docker image rm mega-horoscopo

echo "====================="
echo "Building docker image"
echo "====================="

docker build --tag=mega-horoscopo:latest .

echo "========================"
echo "Running docker container"
echo "========================"

docker run -d --name mega-horoscopo -e SPRING_PROFILES_ACTIVE=dev --network mega-horoscopo -p 8080:8080 mega-horoscopo:latest

echo
echo "===================="
echo "        Finish      "
echo "===================="

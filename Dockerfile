FROM openjdk:8

VOLUME /tmp
ADD target/healthapp-spring.jar healthapp-spring.jar
EXPOSE 8080
WORKDIR /root
ADD wait-for-it.sh /
ADD /target/healthapp-spring.jar /
RUN chmod +x /wait-for-it.sh
RUN chmod +x /healthapp-spring.jar

ENTRYPOINT /wait-for-it.sh healthapp-mysql:3306 --timeout=55 -- java -jar /healthapp-spring.jar




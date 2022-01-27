FROM maven:3.6.1-jdk-8 AS maven_builder

WORKDIR /app

ADD ./demo /app/

RUN ["mvn","clean","install", "-f", "pom.xml"]

FROM tomcat:8.5.43-jdk8

COPY --from=maven_builder /app/target/demo.war /usr/local/tomcat/webapps
RUN ["rm", "/usr/local/tomcat/webapps/manager/META-INF/context.xml"]
RUN ["rm", "/usr/local/tomcat/conf/tomcat-users.xml"]
ADD ./tomcat_conf/context.xml /usr/local/tomcat/webapps/manager/META-INF/context.xml
ADD ./tomcat_conf/tomcat-users.xml /usr/local/tomcat/conf/tomcat-users.xml


EXPOSE 8080
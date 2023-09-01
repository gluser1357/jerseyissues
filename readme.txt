Test code for https://github.com/eclipse-ee4j/jersey/issues/4867

Steps to reproduce:

- install a Tomcat Server 10.1 instance with default settings (requires Java 17)

- package this project as .war and deploy (see config in pom.xml, requires Java 17):
  - mvn clean package tomcat7:redeploy

- run MyClient (output seems to be correct with Jersey 3.1.3)

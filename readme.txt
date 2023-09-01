Test code for https://github.com/eclipse-ee4j/jersey/issues/5404

Steps to reproduce:

- install a Tomcat Server 10.1 instance with default settings (requires Java 17)

- package this project as .war and deploy two times (see config in pom.xml, requires Java 17):
  - mvn clean package tomcat7:redeploy
  - mvn clean package tomcat7:redeploy@webapp2

- open browser and enter
  - http://localhost:8080/jerseyissue-5404/tests/a -> ok
  - http://localhost:8080/jerseyissue-5404/tests/forward -> cross context forward, ClassCastException as described in issue 5404
  - http://localhost:8080/jerseyissue2-5404/tests/a -> ok
  - http://localhost:8080/jerseyissue2-5404/tests/forward -> same context forward, ok

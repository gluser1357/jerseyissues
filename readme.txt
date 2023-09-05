Test code for https://github.com/eclipse-ee4j/jersey/issues/4867

Steps to reproduce:

a) on packaged Jetty Server:
- mvn clean package
- start JettyServer on port 8080

b) on Tomcat 10.1 Server:
- install a Tomcat Server 10.1 instance with default settings (requires Java 17)
- mvn clean package tomcat7:redeploy

for both a) and b)
- open browser and enter
  - http://localhost:8080/jerseyissue-4867-wicket10
  - Add new text field via "Add parameter" -> ok
  - Add new text field via "Add parameter with calling getInputStream() in previous ServletFilter" -> error


Please note that Jersey is actually not involved here in reproducing the bug.
  
The thing is that in some cases (e. g. presence of Content-Type: x-www-form-urlencoded) Jersey
calls httpRequest.getInputStream() at some point to check if POST body contains data or not.
If so, and Jersey runs as servlet filter before Apache Wicket filter, then Wicket
reacts in a different way than in the case that no httpRequest.getInputStream() has been called
in advance, as shown in this example.

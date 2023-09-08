Test code to demonstrate
- missing form data after calling getInputStream in Tomcat 10.1 and Jetty 11(+) in general
- missing form data for calling Jersey as filter, org.glassfish.jersey.servlet.FILTER_FORWARD_ON_404 true and no matching path

===================
Steps to reproduce:
===================

Using Jetty (embedded):
- run RunDemoJetty.java

Using Tomcat:
- install a Tomcat Server 10.1 instance with default settings (requires Java 17)
- package this project as .war and deploy (see config in pom.xml, requires Java 17):
  - mvn clean package tomcat7:redeploy
- run RunDemoTomcat.java

Result after running RunDemoTomcat.java or RunDemoJetty.java:

- /jersey/tests/a just for testing successful path matching (not really relevant here)
- /jersey/nonexisting?q=xy for testing Jersey filter delegation to MyFilter since no @Path matches in Jersey filter
  - since getInputStream() is inherently called (Jersey 3.1.3), form parameters are missing via getParameterMap()
- /other?q=getInputStream for testing simple servlet filter (no Jersey is involved)
  - since getInputStream() is called in servlet filter, form parameters are missing via getParameterMap()
- /other?q=xy for testing simple servlet filter (no Jersey is involved)
  - since getInputStream() is not called, form parameters are added and available via getParameterMap()
    (one query + one form param results to two)

 Filters are defined in web.xml.
 
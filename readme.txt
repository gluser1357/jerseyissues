Test code for https://github.com/eclipse-ee4j/jersey/issues/5402

Steps to reproduce:

- mvn clean package
- start JettyServer as local test server on port 8080
- open browser and enter
  - http://localhost:8080/jerseyissue-5402/tests/a -> endpoint found, ok
  - http://localhost:8080/jerseyissue-5402/tests/createException -> endpoint found that throws test exception, ok
  - http://localhost:8080/jerseyissue-5402/tests/nonexisting -> endpoint not found,
      routing to ExceptionMapper instead of running next servlet filter in the chain
      to allow path handling that jersey doesn't know (SecondFilter)
  
In contrast, if MyExceptionMapper is not registered in MyResourceConfig:
  - re-run mvn and start Jetty as described above
  - http://localhost:8080/jerseyissue-5402/tests/a -> endpoint found, ok
  - http://localhost:8080/jerseyissue-5402/tests/createException -> passed through to DefaultServlet (which serves 500), ok
  - http://localhost:8080/jerseyissue-5402/tests/nonexisting -> SecondFilter called, ok

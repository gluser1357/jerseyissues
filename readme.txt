Demonstrating that a project depending on wicket-commons-fileupload
(which DOES NOT require JUnit in /src/main/java) can be started
in Eclipse IDE (up from 2022+) without problems out of the box:

- TestFromMain.java > Run As...
- TestFromTest.java > Run As...
- Project > Run As JUnit Test
- mvn test

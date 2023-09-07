Test code for https://issues.apache.org/jira/browse/WICKET-7071

Steps to reproduce:

- run Start class from test folder
- open browser and enter
  - http://localhost:8080
  - Add new text field via "Add parameter" -> ok
  - Add new text field via "Add parameter with calling getInputStream() in previous ServletFilter" -> error

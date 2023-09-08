package gluser1357;

public class RunDemoTomcat {

	public static void main(String[] args)
	throws Exception {

		String rootUrl = "http://localhost:8080/jerseyissue-4867";
		//String rootUrl = "http://localhost:30081/jerseyissue-4867";
		System.out.println("Expect tomcat webapp at " + rootUrl + ", use tomcat7 goal to deploy, see pom.xml.\n");
		MyClient.run(rootUrl);
	}
}

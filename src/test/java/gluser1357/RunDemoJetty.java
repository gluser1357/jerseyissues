package gluser1357;

public class RunDemoJetty {

	public static void main(String[] args)
	throws Exception {

		String rootUrl = "http://localhost:8080";
		StartJettyServer.main(new String[0]);
		MyClient.run(rootUrl);
	}
}

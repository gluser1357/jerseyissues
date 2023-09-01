package gluser1357.client;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyClient {

	public static void main(String[] args)
	throws Exception {

		if (true) {
			// GET request to endpoint that Jersey knows
			URL u = new URL("http://localhost:30081/jerseyissue-4867/tests/a");
			HttpURLConnection conn = (HttpURLConnection) u.openConnection();
			requestAndPrint(conn);
		}
		
		if (true) {
			// POST to endpoint that Jersey don't know
			// (the initial data value "1234" should be visible in the output)
			String data = "1234";
			URL u = new URL("http://localhost:30081/jerseyissue-4867/non-existing-path");
			HttpURLConnection conn = (HttpURLConnection) u.openConnection();
			conn.setDoOutput(true);
			conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty( "Content-Length", String.valueOf(data.length()));
			OutputStream os = conn.getOutputStream();
			os.write(data.getBytes());
			requestAndPrint(conn);
		}
	}
	
	private static void requestAndPrint(HttpURLConnection conn)
	throws Exception {
		System.out.println("response code: " + conn.getResponseCode());
		String s = new String(conn.getInputStream().readAllBytes(), "UTF-8");
		System.out.println("Output received: " + s);
	}
}

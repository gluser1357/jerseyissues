package gluser1357;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyClient {

    private static final Logger LOG = LoggerFactory.getLogger(MyClient.class);
    
	public static void run(String rootUrl)
	throws Exception {

		if (true) {
			URL url = new URL(rootUrl + "/jersey/tests/a?q=getInputStream");
			requestAndPrint(url);
		}
		
		if (true) {
			URL url = new URL(rootUrl + "/jersey/nonexisting?q=xy");
			requestAndPrint(url);
		}

		if (true) {
			URL url = new URL(rootUrl + "/other?q=getInputStream");
			requestAndPrint(url);
		}

		if (true) {
			URL url = new URL(rootUrl + "/other?q=xy");
			requestAndPrint(url);
		}

	}
	
	private static void requestAndPrint(URL url)
	throws Exception {

		String data = "form=123";

		LOG.info("");
		LOG.info("url: " + url);
		LOG.info("form data to send: " + data);

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty( "Content-Length", String.valueOf(data.length()));
		OutputStream os = conn.getOutputStream();
		os.write(data.getBytes());

		LOG.info("response code: " + conn.getResponseCode());
		String s = new String(conn.getInputStream().readAllBytes(), "UTF-8");
		LOG.info("Output received: " + s);
		
		Thread.sleep(500);
	}
}

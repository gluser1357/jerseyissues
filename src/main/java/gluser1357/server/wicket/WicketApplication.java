package gluser1357.server.wicket;

import org.apache.wicket.protocol.http.WebApplication;

public class WicketApplication
extends WebApplication {

	public Class<HomePage> getHomePage() {
		return HomePage.class;
	}
}    

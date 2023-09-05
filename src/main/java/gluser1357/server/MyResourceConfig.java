package gluser1357.server;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;

// defined in web.xml! @ApplicationPath("/")
public class MyResourceConfig
extends ResourceConfig {

	public MyResourceConfig() {
		register(MyAPI.class);
		register(SecondFilter.class);
		property(ServletProperties.FILTER_FORWARD_ON_404, true);
		
		// comment out for testing as in readme.txt described
		register(MyExceptionMapper.class);
	}
}

package gluser1357.server;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;

// defined in web.xml! @ApplicationPath("/")
public class MyResourceConfig
extends ResourceConfig {

	public MyResourceConfig() {
		register(MyAPI.class);
		register(PrintFormFilter.class);
		property(ServletProperties.FILTER_FORWARD_ON_404, true); // otherwise 404 on non-matching path

		// remind to not add an ExceptionMapper here for reproducing, see https://github.com/eclipse-ee4j/jersey/issues/5402
	}
}

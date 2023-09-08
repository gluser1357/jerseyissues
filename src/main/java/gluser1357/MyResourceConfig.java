package gluser1357;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// defined in web.xml! @ApplicationPath("/")
public class MyResourceConfig
extends ResourceConfig {

    private static final Logger LOG = LoggerFactory.getLogger(MyResourceConfig.class);

	public MyResourceConfig() {
		
		LOG.info("Running MyResourceConfig init...");
		
		register(MyAPI.class);
		property(ServletProperties.FILTER_FORWARD_ON_404, true);
		
		// comment to test differences between with/without adding an ExceptionMapper
		register(MyExceptionMapper.class);
	}
}

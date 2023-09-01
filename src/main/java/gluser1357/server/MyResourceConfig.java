package gluser1357.server;

import org.glassfish.jersey.server.ResourceConfig;

import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class MyResourceConfig
extends ResourceConfig {
	// uses auto-detection of @Provider and @Path
}

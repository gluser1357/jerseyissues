package gluser1357;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("tests")
public class MyAPI {

    private static final Logger LOG = LoggerFactory.getLogger(MyAPI.class);

	@POST
	@Path("a")
	public static Response a()
	throws Exception {
		LOG.info("MyAPI /tests/a");
		return Response.ok().entity("MyAPI /tests/a ok").build();
	}
}

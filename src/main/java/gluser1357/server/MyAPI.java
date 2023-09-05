package gluser1357.server;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("tests")
public class MyAPI {

	@GET
	@Path("a")
	public static Response a()
	throws Exception {
		System.out.println("MyAPI /tests/a");
		return Response.ok().entity("MyAPI /tests/a ok").build();
	}
	
	@GET
	@Path("createException")
	public static Response createException()
	throws Exception {
		System.out.println("MyAPI /tests/createException");
		throw new Exception();
	}

}
package gluser1357.server;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
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
	@Path("forward")
	public static void forward(@Context ServletContext context, @Context HttpServletRequest request, @Context HttpServletResponse response)
	throws Exception {
		System.out.println("MyAPI /tests/forward");
		ServletContext sc = context.getContext("/jerseyissue2-5404");
		RequestDispatcher dispatcher = sc.getRequestDispatcher("/tests/a");
		dispatcher.forward(request, response);
		System.out.println("MyAPI /tests/forward ok");
	}
}
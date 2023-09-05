package gluser1357.server;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

public class MyExceptionMapper
implements ExceptionMapper<Throwable> {

	@Override
    public Response toResponse(Throwable e) {
		System.out.println("MyExceptionMapper");
		return Response.status(400).entity("ExceptionMapper").build();
	}
}

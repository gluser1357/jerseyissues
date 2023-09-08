package gluser1357;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

public class MyExceptionMapper
implements ExceptionMapper<Throwable> {

    private static final Logger LOG = LoggerFactory.getLogger(MyExceptionMapper.class);
    
	@Override
    public Response toResponse(Throwable e) {
		LOG.info("MyExceptionMapper");
		LOG.error("toResponse: ", e.getMessage());
		return Response.status(404).build();
	}
}

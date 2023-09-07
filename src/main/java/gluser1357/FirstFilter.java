package gluser1357;

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FirstFilter
extends HttpFilter {

    private static final Logger LOG = LoggerFactory.getLogger(FirstFilter.class);

	 @Override
	 public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
	 throws IOException, ServletException {

		 if (request.getContentType() != null && request.getContentType().toLowerCase().contains("application/x-www-form-urlencoded")) {

			 LOG.info("");
			 LOG.info("QueryString: " + request.getQueryString());
			 LOG.info("Content-Type: " + request.getContentType());
			 LOG.info("Content-Length: " + request.getContentLength());
	
			 String query = request.getQueryString();
			 if (query != null && query.contains("addRowWith")) {
				 LOG.info("Call getInputStream()");
				 request.getInputStream();
				 /*
				 try {
					 request.getReader();
				 }
				 catch (Exception e) {
					 LOG.error("getReader(): ", e);
				 }
				 */
			 }
			 
			 LOG.info("Call getParameterMap()");
			 Map<String,String[]> map = request.getParameterMap();
			 LOG.info("Parameter count: " + request.getParameterMap().size());
			 for (String key : map.keySet()) LOG.info("  " + key + "=" + map.get(key));
		 }
		 
		 chain.doFilter(request, response);
	 }
}

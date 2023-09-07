package gluser1357;

import java.io.IOException;

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

		 String query = request.getQueryString();
		 if (query != null && query.contains("addRowWith")) {
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
		 chain.doFilter(request, response);
	 }
}

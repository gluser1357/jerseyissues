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

public class MyFilter
extends HttpFilter {

    private static final Logger LOG = LoggerFactory.getLogger(MyFilter.class);

	 @Override
	 public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
	 throws IOException, ServletException {

		 if (request.getContentType() != null && request.getContentType().toLowerCase().contains("application/x-www-form-urlencoded")) {

			 StringBuilder sb = new StringBuilder();
			 sb.append("\n\n");
			 sb.append("QueryString: " + request.getQueryString() + "\n");
			 sb.append("Content-Type: " + request.getContentType() + "\n");
			 sb.append("Content-Length: " + request.getContentLength() + "\n");
	
			 String query = request.getQueryString();
			 if (query != null && query.contains("getInputStream")) {
				 sb.append("Call getInputStream()" + "\n");
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
			 
			 sb.append("Call getParameterMap()" + "\n");
			 Map<String,String[]> map = request.getParameterMap();
			 sb.append("Parameter count: " + request.getParameterMap().size() + "\n");
			 for (String key : map.keySet()) sb.append("  " + key + "=" + map.get(key) + "\n");
			 
			 //LOG.info("MyFilter received: " + sb + "\n");
			 response.getOutputStream().write(sb.toString().getBytes("UTF-8"));
			 return;
		 }
		 
		 chain.doFilter(request, response);
	 }
}

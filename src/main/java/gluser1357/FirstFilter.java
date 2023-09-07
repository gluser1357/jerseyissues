package gluser1357;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FirstFilter
extends HttpFilter {

	 @Override
	 public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
	 throws IOException, ServletException {

		 String query = request.getQueryString();
		 if (query != null && query.contains("addRowWith")) request.getInputStream();
		 chain.doFilter(request, response);
	 }
}

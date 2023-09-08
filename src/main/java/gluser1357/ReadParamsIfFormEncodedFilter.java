package gluser1357;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ReadParamsIfFormEncodedFilter
extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
	throws IOException, ServletException {

		if ("post".equals(request.getMethod().toLowerCase()) &&
			request.getContentType() != null &&
			request.getContentType().toLowerCase().contains("application/x-www-form-urlencoded")) {
			request.getParameterMap();
		}
		chain.doFilter(request, response);
	}
}

package gluser1357.server;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;

public class SecondFilter
extends HttpFilter {
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	throws IOException, ServletException {
		System.out.println("SecondFilter");
		response.getOutputStream().write("SecondFilter called.".getBytes("UTF-8"));
	}
}

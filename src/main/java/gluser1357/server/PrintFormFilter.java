package gluser1357.server;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PrintFormFilter
extends HttpFilter {

	 @Override
	 public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
	 throws IOException, ServletException {

		System.out.println("PrintFormFilter");
		try {
			String s = request.getHeader("Content-Type");
			s += " ";
			s += new String(request.getInputStream().readAllBytes(), "UTF-8");
			System.out.println("PrintFormFilter received: " + s);
			response.getOutputStream().write(s.getBytes("UTF-8"));
			return;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		chain.doFilter(request, response);
	 }
}

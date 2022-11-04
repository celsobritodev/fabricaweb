package filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;

public class FiltroAutenticacao extends HttpFilter implements Filter {

	
	private static final long serialVersionUID = 1L;

	public FiltroAutenticacao() {
		super();

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		chain.doFilter(request, response);
		System.out.println("passou pelo filtro");
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}

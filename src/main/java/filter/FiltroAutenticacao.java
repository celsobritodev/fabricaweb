package filter;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, urlPatterns = "/*")
public class FiltroAutenticacao extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	public FiltroAutenticacao() {
		super();

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		String uri = httpRequest.getRequestURI();
		
		HttpSession sessao = httpRequest.getSession(false);

		if (sessao!=null || uri.lastIndexOf("login.html") != -1 || uri.lastIndexOf("Autenticador") != -1) {
			System.out.println("seguiu adiante");
			System.out.println("----------------");
			chain.doFilter(request, response);
		} else {
			httpResponse.sendRedirect("login.html");
			System.out.println("passou pelo filtro e foi pra login");
			System.out.println("----------------");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}

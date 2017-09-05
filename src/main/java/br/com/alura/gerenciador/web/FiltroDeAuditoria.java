package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = "/*")
public class FiltroDeAuditoria implements Filter{

		
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		final HttpServletRequest request = (HttpServletRequest) req;
		final HttpServletResponse response = (HttpServletResponse) resp;
		final String uri = request.getRequestURI();
		
		String usuario = "<Deslogado>";
		Cookie cookie = new Cookies(request.getCookies()).getUsuarioLogado();
		
		if(cookie != null) {
			cookie.setMaxAge(2 * 60);
			response.addCookie(cookie);
			
			usuario = cookie.getValue();
		}
		
		System.out.println("Usuario " + usuario + " acessando a URI " + uri);
		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

	
}

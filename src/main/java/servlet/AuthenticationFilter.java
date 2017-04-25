package servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthenticationFilter implements Filter {

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		HttpSession session = req.getSession(false);

		String path = ((HttpServletRequest) req).getRequestURI();

		if (path.startsWith("/Kanwas/login") || path.startsWith("/Kanwas/index") || path.startsWith("/Kanwas/register")) {
			chain.doFilter(request, response);
			System.out.println("Login/index/register oldalon nincs szûrés!");
		} else {
			if (session == null) {
				res.sendRedirect("./login");
				System.out.println("A gyökér nincs bejelentkezve!");
			} else {
				if (session.getAttribute("user") == null) {
					res.sendRedirect("./login");
					System.out.println("A gyökér nincs bejelentkezve, de van valami sessionje!");
				} else {
					System.out.println("A gyökér be van jelentkezve!");
					chain.doFilter(request, response);
				}
			}
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}

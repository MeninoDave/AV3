package servlets;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/homepage")
public class Authentication extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;

	public Authentication() {super();}

	public void destroy() {}

	public void doFilter(ServletRequest sRequest, ServletResponse sResponse, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("Passando por autorizacao");
		
		HttpServletRequest request = (HttpServletRequest) sRequest;
		HttpServletResponse response = (HttpServletResponse) sResponse;
		HttpSession sessao = request.getSession();
		
		String actionParam = request.getParameter("action");
		System.out.println(sessao.getAttribute("logged"));
		
		
		boolean notLogged = (sessao.getAttribute("logged")==null);
		if(actionParam ==null) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/loginForm.jsp");
			rd.forward(request, response);
			System.out.println("Acao nula, indo para a homepage");
			return;
		}
		System.out.println(actionParam);
		boolean protectedAction = !(actionParam.equals("Login") || actionParam.equals("DoLogin") || actionParam.equals("DoNovoUser") || actionParam.equals("NovoUser"));
		
		if(notLogged && protectedAction) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/loginForm.jsp");
			rd.forward(request, response);
			System.out.println("Acao protegida, indo para a homepage");
			return;
		}
		System.out.println("Autorizacao ok!");
		chain.doFilter(request, response);
	}

}

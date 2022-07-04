package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.*;

@WebServlet("/homepage")
public class Homepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Homepage() {
        System.out.println("Entrando na homepage");
    }
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String actionP = req.getParameter("action");
		try {
			connection(actionP,req,resp);
		}catch(Exception e) {
			System.out.println("ERRO NA CONEXÃO! (class Homepage method service().connection())");
			System.out.println(e.getMessage());
		}	
	}
	
	protected void dispatcher(String path, HttpServletRequest request,HttpServletResponse response){
		try {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + path);
			rd.forward(request,response);
		}catch(IOException | ServletException e) {
			System.out.println("ERRO NO REQUEST DISPATCHER DE "+path);
			System.out.println(e.getMessage());
		}
		
	}
	protected void connection(String actionParam,HttpServletRequest request,HttpServletResponse response)throws Exception {
		switch(actionParam) {
		
		case "DoNovoUser":
			dispatcher("cadastroForm.jsp",request,response);
			break;
		case "NovoUser":
			NovoUser n = new NovoUser();
			n.execute(request,response);
			dispatcher("loginForm.jsp",request,response);
			break;
			
		case "Login":
			Login l = new Login();
			String resp = l.execute(request, response);
			if(resp.equals("S")) {
				UpdateForm up = new UpdateForm();
				up.execute(request, response);
				dispatcher("menu.jsp",request,response);
			}else {
				dispatcher("loginForm.jsp",request,response);
			}
			break;
			
		case "Logout":
			Logout lo = new Logout();
			lo.execute(request,response);
			dispatcher("loginForm.jsp",request,response);
			break;
			
		case "AddProduct":
			AddProduct a = new AddProduct();
			a.execute(request, response);
			UpdateForm upd = new UpdateForm();
			upd.execute(request, response);
			dispatcher("menu.jsp",request,response);
			break;
			
		case "Reset":
			Reset r = new Reset();
			r.execute(request, response);
			UpdateForm u = new UpdateForm();
			u.execute(request, response);
			dispatcher("menu.jsp",request,response);
			break;
			
		default:
			dispatcher("loginForm.jsp",request,response);
			break;
		}
		
	}			
}

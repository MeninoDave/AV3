package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import database.Database;

public class Login implements Action{
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Entrando em contato com o servidor");
		Database d = new Database();
		d.checkDatabase();
		
		System.out.println("Realizando login");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		boolean resp = d.validateLogin(d.getfactory(),username,password);
		
		d.close();
		if(resp) {
			System.out.println("Usuario "+ username + "Logado com sucesso!");
			HttpSession s = request.getSession();
			s.setAttribute("logged",username);
			return "S";
		}else {
			return "N";
		}
		
	}
	

}

package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database.Database;


public class NovoUser implements Action{

	
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Cadastrando novo usuario");
		
		String username = request.getParameter("usuario");
		String password = request.getParameter("senha");
		
		System.out.println(username);
		System.out.println(password);
		Database db = new Database();
		db.checkDatabase();
		db.newUser(db.getfactory(),db.obtainLoginID()+1,username,password);
		db.close();
		
		return "loginForm.jsp";
	}
	
}

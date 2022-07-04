package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database.Database;

public class AddProduct implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Inserindo o produto");
		String product = request.getParameter("produto");
		System.out.println(product);
		String temp = request.getParameter("preco");
		System.out.println(temp);
		Double value = Double.parseDouble(temp);
		System.out.println(value);
		String state = request.getParameter("estado");
		System.out.println(state);
		
		Database db = new Database();
		db.insertForm(db.getfactory(),product,value,state);
		db.close();
		
		return "menu.jsp";
	}

}

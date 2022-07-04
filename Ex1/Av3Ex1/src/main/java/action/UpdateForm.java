package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Database;
import models.Produtos;

public class UpdateForm implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Atualizando tabela de produtos");
		ArrayList<Produtos> produtos = new ArrayList<Produtos>();
		Database db = new Database();
		produtos = db.obtainProducts(db.getfactory());
		request.setAttribute("lista", produtos);
		db.close();
		return null;
	}
	
}

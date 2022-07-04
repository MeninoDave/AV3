package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import database.Database;

public class Logout implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Database db = new Database();
		System.out.println("Deletando tabela de produtos");
		db.resetTable(db);
		db.close();
		System.out.println("Realizando logout");
		HttpSession sessao = request.getSession();
		sessao.invalidate();
		return null;
	}

}

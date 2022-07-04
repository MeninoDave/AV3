package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import database.Database;
import models.Produtos;


@WebServlet("/json")
public class Json extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Json() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Database db = new Database();
		ArrayList<Produtos> produtos = db.obtainProducts(db.getfactory());
		db.close();
		
		Gson gson = new Gson();
		String json = gson.toJson(produtos);
		response.setContentType("application/json");
		response.getWriter().print(json);
		
	}

}

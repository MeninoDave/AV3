package database;

import java.sql.*;
import java.util.ArrayList;

import models.Produtos;

public class MetodosSQL {
	
	//Metodo construtor
	public MetodosSQL() {
		
	}
//==================================================================================================================================================
//ESTADO	
	public void insertEstado(Factory f,int id, String estado, double frete,int dias) {
		String sql =  "INSERT INTO estados(ID,ESTADO,FRETE,DIAS) VALUES(?,?,?,?)";
		try {
			PreparedStatement ps = f.getConnection().prepareStatement(sql);
			ps.setInt(1,id);
			ps.setString(2,estado);
			ps.setDouble(3,frete);
			ps.setInt(4, dias);
			
			ps.execute();
		}catch(SQLException e) {
			System.out.println("ERRO AO INSERIR O ESTADO " + estado);
			System.out.println(e.getMessage());
		}	
	}
	
	public double getFrete(Factory f,String estado) {
		String sql = "SELECT FRETE FROM estados WHERE ESTADO = '"+ estado +"'";
		try {
			PreparedStatement ps = f.getConnection().prepareStatement(sql);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			rs.next();
			double resp = rs.getDouble(1);
			return resp;
		}catch(SQLException e) {
			System.out.println("ERRO AO OBTER FRETE DO BANCO DE DADOS (method getFrete())");
			System.out.println(e.getMessage());
			return -1;
		}
	}
	
	public int getDias(Factory f, String estado) {
		String sql = "SELECT DIAS FROM estados WHERE ESTADO = '"+ estado +"'";
		try {
			PreparedStatement ps = f.getConnection().prepareStatement(sql);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			rs.next();
			int resp = rs.getInt(1);
			return resp;
		}catch(SQLException e) {
			System.out.println("ERRO AO OBTER DIAS DO BANCO DE DADOS (method getDias())");
			System.out.println(e.getMessage());
			return -1;
		}
	}
	
//==================================================================================================================================================
//LOGIN		
	public void newUser(Factory f,int id,String username, String password){
		String sql = "INSERT INTO login(ID,USERNAME,SENHA) VALUES (?,?,?)";
		try {
			PreparedStatement ps = f.getConnection().prepareStatement(sql);
			ps.setLong(1,id);
			ps.setString(2,username);
			ps.setString(3,password);
			ps.execute();
		}catch(SQLException e) {
			System.out.println("ERRO AO INSERIR O USUARIO "+username);
			System.out.println(e.getMessage());
		}
	}
	
	public boolean validateLogin(Factory f,String username, String password) {
		String sql = "SELECT * FROM login";
		try {
			PreparedStatement ps = f.getConnection().prepareStatement(sql);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while(rs.next()) {
				if(username.equals(rs.getString(2)) && password.equals(rs.getString(3))) {
					return true;
				}
			}
			return false;
		}catch(SQLException e) {
			System.out.println("ERRO AO BUSCAR LOGIN (method validateLogin())");
			System.out.println(e.getMessage());
			return false;
		}
	}
	
//==================================================================================================================================================
//FORMULARIO
	
	public void insertForm(Factory f,String produto, double preco,String estado) {
		double frete = getFrete(f,estado);
		double total = frete + preco;
		int dias = getDias(f,estado);
		
		System.out.println("Adicionando no banco de dados");
		String sql = "INSERT INTO formulario(ESTADO,PRODUTO,PRECO,FRETE,TOTAL,DIAS) VALUES (?,?,?,?,?,?)";
		try {
			PreparedStatement ps = f.getConnection().prepareStatement(sql);
			ps.setString(1,estado);
			ps.setString(2,produto);
			ps.setDouble(3,preco);
			ps.setDouble(4,frete);
			ps.setDouble(5,total);
			ps.setDouble(6,dias);
			ps.execute();
		}catch(SQLException e) {
			System.out.println("ERRO AO INSERIR O PRODUTO "+produto+" NO BANCO DE DADOS! (method insertForm())");
			System.out.println(e.getMessage());
		}
		
		
	}
	
	//Metodo destrutor da tabela de formulario
	public void resetTable(Database db) {
		String sql = "DROP TABLE formulario";
		try {
			PreparedStatement ps = db.getfactory().getConnection().prepareStatement(sql);
			ps.execute();
		}catch(SQLException e){
			System.out.println("ERRO AO RESETAR TABELA!(method resetTable())");
		}
		db.checkTable("formulario","ESTADO varchar(3),PRODUTO varchar(200),PRECO double,FRETE double,TOTAL double, DIAS int",0);	
	}
	
	
	public ArrayList<Produtos> obtainProducts(Factory f) {
		ArrayList<Produtos>p= new ArrayList<Produtos>();
		String sql = "SELECT * FROM formulario";
		try {
			PreparedStatement ps = f.getConnection().prepareStatement(sql);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while(rs.next()) {
				Produtos produto = new Produtos(rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getDouble(4),rs.getDouble(5),rs.getInt(6));
				p.add(produto);
			}
			return p;
			
		}catch(SQLException e) {
			System.out.println("ERRO AO OBTER ATUALIZAÇÃO DE PRODUTOS (method obtainProducts())");
			System.out.println(e.getMessage());
			return null;
		}
	}

	
}

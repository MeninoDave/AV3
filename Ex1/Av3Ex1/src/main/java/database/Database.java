package database;

import java.sql.*;
import java.util.ArrayList;

import models.Itens.*;

public class Database extends MetodosSQL{
	private Statement stm;
	private Factory f;
	
	//Construtor (tambem checa a existencia ou nao da tabela e ja a cria)
	public Database() {
		this.f = new Factory();
		f.setConnection("jdbc:mysql://localhost:3306/av3ex1?useTimezone=true&serverTimezone=UTC&useSSL=false");
		this.stm = f.getStatement();
	}
	
	public void close() {
		f.closeConnection();
	}
	
	public int obtainLoginID() {
		int result=0;
		try {	
			String sql = "SELECT * FROM login;";
			PreparedStatement ps = this.f.getConnection().prepareStatement(sql);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while(rs.next()) {
				result++;
			}
			return result;
		}catch(SQLException e) {
			System.out.println("ERRO AO OBTER OS VALORES DE ID (method obtainLoginId())");
			System.out.println(e.getMessage());
			return -1;
		}
	}
	
	//retorna a factory
	public Factory getfactory() {
		return this.f;
	}
	
	//checa a existencia da database
	public void checkDatabase() {
		
			checkTable("login", "ID int,USERNAME varchar(150),SENHA varchar(150),PRIMARY KEY(ID)",0);
			checkTable("formulario","ESTADO varchar(3),PRODUTO varchar(200),PRECO double,FRETE double,TOTAL double, DIAS int",0);
			checkTable("estados","ID int,ESTADO varchar(3),FRETE double,DIAS int, PRIMARY KEY(ID)",1);
	}
	
	//checa a existencia da tabela
	public void checkTable(String nome, String atributos, int num) {
		try {
			String sql = "CREATE TABLE "+ nome +"("+atributos+")";
			System.out.println(sql);
			this.stm.execute(sql);
		}catch (SQLException e) {
			String msg = e.getMessage();
			if(msg.equals("Table '"+ nome +"' already exists")) {
				System.out.println("Tabela "+ nome +" ja existe, checando os itens \n ");
			}else {
				System.out.println("ERRO AO CHECAR EXISTENCIA DA TABELA "+ nome +"! (method checkTable())");
				System.out.println(msg);
				return;
			}
		}finally {
			if(num!=0) {
				checkPopulation(nome,num);
			}
		}
	}
	
	//checa se a tabela esta ou nao vazia
	private void checkPopulation(String nome,int num) {
		int result=0;
		try {	
			String sql = "SELECT EXISTS(SELECT 1 FROM "+ nome +");";
			PreparedStatement ps = this.f.getConnection().prepareStatement(sql);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while(rs.next()) {
				if(rs.getInt(1)==1) {
					result = 1;
				}else {
					result = 0;
				}
			}
			if(result==0) {
				populateTable(num);
			}else {
				System.out.println("Tabela já populada! Checagem concluída!");
			}
		}catch(SQLException e){
			System.out.println("ERRO AO CHECAR EXISTENCIA ITENS DA TABELA "+ nome +"! ()method populateTable");
			System.out.println(e.getMessage());
		}
		
	}
	
	//Serve para popular as tabelas (1 para estados)
	private void populateTable(int num) {
		if(num==1) {
			ListaEstados es = new ListaEstados();
			ArrayList<Estado>listaEstados = es.getEstados();
			for(Estado e : listaEstados) {
				insertEstado(f,e.getId(), e.getNome(), e.getFrete(),e.getDias());
			}
		}
	}
	

}

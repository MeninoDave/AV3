package models;

import java.util.ArrayList;
public class Itens {
	
	public static class Estado{
		private int id;
		private String nome;
		private double frete;
		private int dias;
		
		public Estado(int id,String nome, double frete, int dias) {
			this.id=id;
			this.nome=nome;
			this.frete=frete;
			this.dias = dias;
		}
		
		public int getId() {
			return this.id;
		}
		
		public String getNome() {
			return this.nome;
		}
		
		public double getFrete() {
			return this.frete;
		}
		
		public int getDias() {
			return this.dias;
		}
	}
	
	public static class ListaEstados{
		private ArrayList<Estado> estados;
		
		//Construtor
		//Nao consegui pensar em outra maneira, entao la vou eu criar caos no meu codigo uhul!!
		public ListaEstados() {
			ArrayList<Estado> lista = new ArrayList<Estado>();
			Estado es = new Estado (1,"AC",99.40,30);
			lista.add(es);
			es = new Estado(2,"AL",67.3,8);
			lista.add(es);
			es = new Estado(3,"AP",97.2,25);
			lista.add(es);
			es = new Estado(4,"AM",90.1,20);
			lista.add(es);
			es = new Estado(5,"BA",39.9,5);
			lista.add(es);
			es = new Estado(6,"CE",69.8,16);
			lista.add(es);
			es = new Estado(7,"DF",41.7,4);
			lista.add(es);
			es = new Estado(8,"ES",32.6,3);
			lista.add(es);
			es = new Estado(9,"GO",40.5,4);
			lista.add(es);
			es = new Estado(10,"MA",72.4,18);
			lista.add(es);
			es = new Estado(11,"MT",45.3,8);
			lista.add(es);
			es = new Estado(12,"MS",47.2,8);
			lista.add(es);
			es = new Estado(13,"MG",0,1);
			lista.add(es);
			es = new Estado(14,"PA",80.1,15);
			lista.add(es);
			es = new Estado(15,"PB",64.9,10);
			lista.add(es);
			es = new Estado(16,"PR",45.8,5);
			lista.add(es);
			es = new Estado(17,"PE",64.7,10);
			lista.add(es);
			es = new Estado(18,"PI",70.6,12);
			lista.add(es);
			es = new Estado(19,"RJ",35.5,3);
			lista.add(es);
			es = new Estado(20,"RN",67.4,11);
			lista.add(es);
			es = new Estado(21,"RS",55.3,7);
			lista.add(es);
			es = new Estado(22,"RO",92.2,20);
			lista.add(es);
			es = new Estado(23,"RR",98.1,30);
			lista.add(es);
			es = new Estado(24,"SC",50.9,6);
			lista.add(es);
			es = new Estado(25,"SP",30.8,2);
			lista.add(es);
			es = new Estado(26,"SE",66.7,12);
			lista.add(es);
			es = new Estado(27,"TO",81.6,15);
			lista.add(es);
			
			
			this.estados=lista;
		}
		
		public ArrayList<Estado> getEstados(){
			return this.estados;
		}
	}
	
	
}

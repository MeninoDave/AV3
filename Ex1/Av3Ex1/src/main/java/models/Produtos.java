package models;

public class Produtos {
		String produto;
		double valor;
		String estado;
		double frete;
		int dias;
		double total;
		
		//construtor
		public Produtos(String estado, String produto, double valor, double frete, double total, int dias) {
			this.produto=produto;
			this.valor=valor;
			this.estado=estado;
			this.frete=frete;
			this.dias=dias;
			this.total=total;
		}
		
		public String getProduto() {
			return this.produto;
		}
		public double getValor() {
			return this.valor;
		}
		public String getEstado() {
			return this.estado;
		}
		public double getFrete() {
			return this.frete;
		}
		public int getDias() {
			return this.dias;
		}
		public double getTotal() {
			return this.total;
		}
	
}

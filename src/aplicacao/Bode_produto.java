package aplicacao;

public class Bode_produto {
	private int id_bode;
	private int id_produto;
	
	public Bode_produto(int id_bode, int id_produto) {
		this.id_bode = id_bode;
		this.id_produto = id_produto;
	}
	
	public Bode_produto() {
		
	}
	
	public int getId_bode() {
		return id_bode;
	}
	public void setId_bode(int id_bode) {
		this.id_bode = id_bode;
	}
	public int getId_produto() {
		return id_produto;
	}
	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}
	
}

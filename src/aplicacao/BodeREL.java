package aplicacao;

public class BodeREL extends Bode {
	private int id_bode;
	private int id_produto;
	
	public BodeREL() {
		
	}
	
	public BodeREL(int id_bode,int id_produto,String cpfFazendeiro, int id, float peso, String nome, String genero) {
		super(cpfFazendeiro, id, peso, nome, genero);
		this.id_bode = id_bode;
		this.id_produto = id_produto;
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

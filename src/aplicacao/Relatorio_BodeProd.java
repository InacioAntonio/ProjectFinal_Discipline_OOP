package aplicacao;

public class Relatorio_BodeProd extends BodeREL{
	//Produto
	private float preco;
	private float pesoProduto;
	private String categoria;
	//private String descricao;
	private int quantidade;
	//Bode
	private int Id;
	private String nome;

	
	public Relatorio_BodeProd(float preco, float pesoProduto, String categoria, int quantidade, int id ) {
		super();
		this.preco = preco;
		this.pesoProduto = pesoProduto;
		this.categoria = categoria;
		this.Id = id;
		this.quantidade = quantidade;
	}
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public float getPesoProduto() {
		return pesoProduto;
	}
	public void setPesoProduto(float pesoProduto) {
		this.pesoProduto = pesoProduto;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getQuantidade() {
		return this.quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}

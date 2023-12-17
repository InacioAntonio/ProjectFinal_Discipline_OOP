package aplicacao;

public class Relatorio_BodeProd extends BodeREL{
	//Produto
	private float preco;
	private float pesoProduto;
	private String categoria;
	private String descricao;
	private int quantidade;
	//Bode
	private int Id;
	private String nome;
	
	public Relatorio_BodeProd(int id_bode, int id_prod, float preco,float pesoBode, float pesoProduto, String categoria, int quantidade, String nomeBode, String cpfFazendeiro) {	
		super(id_bode,id_prod, cpfFazendeiro, pesoBode, nomeBode);
		this.preco = preco;
		this.pesoProduto = pesoProduto;
		this.categoria = categoria;
		this.Id = id_prod;
		this.quantidade = quantidade;
		this.nome = nomeBode;
	}
	
	public Relatorio_BodeProd(int id_bode, int id_prod, float preco,float pesoBode, float pesoProduto, String categoria, int quantidade, String nomeBode, String cpfFazendeiro, String descricao) {	
		super(id_bode,id_prod, cpfFazendeiro, pesoBode, nomeBode);
		this.preco = preco;
		this.pesoProduto = pesoProduto;
		this.categoria = categoria;
		this.Id = id_prod;
		this.quantidade = quantidade;
		this.nome = nomeBode;
		this.descricao = descricao;
	}
	
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

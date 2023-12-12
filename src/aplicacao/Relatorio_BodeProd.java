package aplicacao;

public class Relatorio_BodeProd extends BodeREL{
	//Produto
	private float preco;
	private float pesoProduto;
	private String categoria;
	private String descricao;
	private int quantidade;
	//Bode
	private String cpfFazendeiro;
	private float pesoBode;
	private String nome;
	private String genero;
	
	public Relatorio_BodeProd(float preco, float pesoProduto, String categoria, String descricao, int quantidade,
			String cpfFazendeiro, float pesoBode, String nome, String genero) {
		super();
		this.preco = preco;
		this.pesoProduto = pesoProduto;
		this.categoria = categoria;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.cpfFazendeiro = cpfFazendeiro;
		this.pesoBode = pesoBode;
		this.nome = nome;
		this.genero = genero;
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getQuantidade() {
		return this.quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getCpfFazendeiro() {
		return cpfFazendeiro;
	}
	public void setCpfFazendeiro(String cpfFazendeiro) {
		this.cpfFazendeiro = cpfFazendeiro;
	}
	public float getPesoBode() {
		return pesoBode;
	}
	public void setPesoBode(float pesoBode) {
		this.pesoBode = pesoBode;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
}

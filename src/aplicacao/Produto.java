package aplicacao;

public class Produto {
	private int id;
	private float preco;
	private float peso;
	private String categoria;
	private String descricao;
	private int Quantidade;
	private String Cpf_fazendeiro;
	public String getCpf_fazendeiro() {
		return Cpf_fazendeiro;
	}

	public void setCpf_fazendeiro(String cpf_fazendeiro) {
		Cpf_fazendeiro = cpf_fazendeiro;
	}

	public int getQuantidade() {
		return Quantidade;
	}

	public void setQuantidade(int quantidade) {
		Quantidade = quantidade;
	}

	public Produto(int id, String categoria, String descricao,int Quantidade,float peso,String cpf_fazendeiro) {
		this.id = id;
		this.categoria = categoria;
		this.descricao = descricao;
		this.Quantidade = Quantidade;
		this.peso = peso;
		this.Cpf_fazendeiro = cpf_fazendeiro;
	}
	public Produto() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}
}

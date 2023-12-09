package aplicacao;

public class Fazendeiro {
	private String nome;
	private String cpf;
	private String senha;
	private int idade;
	private String telefone;
	
	public Fazendeiro(String nome, String cpf, String senha, int idade, String telefone) {
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.idade = idade;
		this.telefone = telefone;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}

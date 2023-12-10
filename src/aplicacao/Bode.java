package aplicacao;

public class Bode {
	private String cpfFazendeiro;
	private int id;
	private float peso;
	private String nome;
	private String genero;
	
	public Bode(String cpfFazendeiro, int id, float peso, String nome, String genero) {
		this.cpfFazendeiro = cpfFazendeiro;
		this.id = id;
		this.peso = peso;
		this.nome = nome;
		this.genero = genero;
	}
	public Bode() {
		
	}
	public String getCpfFazendeiro() {
		return cpfFazendeiro;
	}
	public void setCpfFazendeiro(String cpfFazendeiro) {
		this.cpfFazendeiro = cpfFazendeiro;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
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

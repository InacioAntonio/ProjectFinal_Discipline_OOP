package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private Connection con;
	private String usuario;
	private String senha;
	private String caminho;
	
	public Conexao(String usuario,String senha,String caminho) {
		this.usuario = usuario;
		this.senha = senha;
		this.caminho = caminho;
	}
	
	public void conectar() {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(this.caminho, this.usuario, this.senha);
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public void desconectar() {
		try{
			con.close();
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public Connection getConexao() {
		return this.con;
	}
}

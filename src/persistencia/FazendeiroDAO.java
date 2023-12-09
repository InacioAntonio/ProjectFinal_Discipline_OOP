package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import aplicacao.*;

public class FazendeiroDAO {
	private String inserir = "INSERT INTO Fazendeiro (nome, cpf, senha, idade, telefone) VALUES(?,?,?,?,?)";
	private String deletar = "DELETE FROM Fazendeiro WHERE cpf = ? ";
	private String atualizar = "UPDATE Fazendeiro SET nome = ?, cpf = ?, senha = ?, idade = ?, telefone = ? WHERE cpf = ?";
	private String buscar = "SELECT * FROM Fazendeiro WHERE cpf = ?";
	private BodeDAO bodeDao = new BodeDAO();
	private Conexao con;
	
	public FazendeiroDAO() {
		con = new Conexao("postgres","1234","jdbc:postgresql://localhost:5432/BDbode");
	}
	
	public Fazendeiro buscar(String cpf) {
		Fazendeiro f =  null;
		try {
			con.conectar();
			PreparedStatement instrucao = con.getConexao().prepareStatement(buscar);
			instrucao.setString(1, cpf);
			ResultSet rs = instrucao.executeQuery();
			
			if(rs.next()) {
				f = new Fazendeiro(rs.getString("nome"), rs.getString("cpf"), rs.getString("senha"), rs.getInt("idade"), rs.getString("telefone"));
			}
			con.desconectar();
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		return f;
	}
	
	public void cadastrar(Fazendeiro f) {
		try {
			
			Fazendeiro busca = this.buscar(f.getCpf());
			
			if(busca == null) {
				con.conectar();
				PreparedStatement instrucao = con.getConexao().prepareStatement(inserir);
				instrucao.setString(1, f.getNome());
				instrucao.setString(2, f.getCpf());
				instrucao.setString(3, f.getSenha());
				instrucao.setInt(4, f.getIdade());
				instrucao.setString(5, f.getTelefone());
				
				instrucao.execute();
				con.desconectar();
			}
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public void atualizar(Fazendeiro f) {
		try {
			
			Fazendeiro busca = this.buscar(f.getCpf());
			
			if(busca != null) {
				con.conectar();
				PreparedStatement instrucao = con.getConexao().prepareStatement(atualizar);
				instrucao.setString(1, f.getNome());
				instrucao.setString(2, f.getCpf());
				instrucao.setString(3, f.getSenha());
				instrucao.setInt(4, f.getIdade());
				instrucao.setString(5, f.getTelefone());
				instrucao.setString(6, f.getCpf());
				
				instrucao.execute();
				con.desconectar();
			}
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public void atualizar(Fazendeiro f, String cpfAntigo) {
		try {

			Fazendeiro busca = this.buscar(cpfAntigo);

			if(busca != null) {
				
				bodeDao.desvincular(cpfAntigo);
				
				con.conectar();
				
				PreparedStatement instrucao = con.getConexao().prepareStatement(atualizar);
				instrucao.setString(1, f.getNome());
				instrucao.setString(2, f.getCpf());
				instrucao.setString(3, f.getSenha());
				instrucao.setInt(4, f.getIdade());
				instrucao.setString(5, f.getTelefone());
				instrucao.setString(6, cpfAntigo);
				instrucao.execute();
				
				con.desconectar();
				
				bodeDao.vincular(f.getCpf());
			}
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public void deletar(String cpf) {
		try{

			bodeDao.deletar(cpf);
			
			con.conectar();
			PreparedStatement instrucao = con.getConexao().prepareStatement(deletar);
			instrucao.setString(1, cpf);
			instrucao.execute();
			con.desconectar();
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
}

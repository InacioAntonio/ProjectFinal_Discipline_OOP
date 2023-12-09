package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import aplicacao.*;
import java.util.ArrayList;

public class BodeDAO {		
	private String vinculaBodes = "UPDATE Bode SET cpf_fazendeiro = ? WHERE cpf_fazendeiro = 0";
	private String desvinculaBodes = "UPDATE Bode SET cpf_fazendeiro = 0 WHERE cpf_fazendeiro = ?";	
	private String atualizar = "UPDATE Bode SET cpf_fazendeiro = ?, peso = ?, nome = ?, genero = ?  WHERE id = ?";
	private String buscar = "SELECT * FROM Bode WHERE cpf_fazendeiro = ?";
	private String deletar = "DELETE FROM Bode WHERE cpf_fazendeiro=?";
	private Conexao con;
	
	public BodeDAO() {
		con = new Conexao("postgres","1234","jdbc:postgresql://localhost:5432/BDbode");
	}
	
	public ArrayList<Bode> buscar(String cpf) {
		ArrayList<Bode> bodeBusca = null;
		String cpfFazendeiro, genero, nome;
		int id;
		float peso;
		
		try {
			PreparedStatement instrucao = con.getConexao().prepareStatement(buscar);
			instrucao.setString(1, cpf);
			ResultSet rs = instrucao.executeQuery();
			while(rs.next()) {
				cpfFazendeiro = rs.getString("cpfFazendeiro");
				id = rs.getInt("id");
				peso = rs.getFloat("peso");
				nome = rs.getString("nome");
				genero = rs.getString("genero");
				bodeBusca = new ArrayList<Bode>();
				bodeBusca.add(new Bode(cpfFazendeiro, id,peso,nome,genero));
			}
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		
		return bodeBusca;
	}
	
	public void vincular(String cpf) {
		try {
			con.conectar();
			PreparedStatement instrucao = con.getConexao().prepareStatement(vinculaBodes);
			instrucao.setString(1, cpf);
			instrucao.execute();
			
			con.desconectar();
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public void desvincular(String cpf) {
		try {
			con.conectar();
			PreparedStatement instrucao = con.getConexao().prepareStatement(desvinculaBodes);
			instrucao.setString(1, cpf);
			instrucao.execute();
			
			con.desconectar();
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	
	public void atualizar(Fazendeiro f) {
		//Incompleto
		try {
			con.conectar();
			PreparedStatement desvinculaBode = con.getConexao().prepareStatement(atualizar);
			desvinculaBode.setString(1, f.getCpf());
			desvinculaBode.execute();
			
			con.desconectar();
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public void deletar(String cpf) {
		try {
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

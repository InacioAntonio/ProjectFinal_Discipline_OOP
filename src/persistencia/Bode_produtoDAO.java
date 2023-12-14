package persistencia;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import aplicacao.*;
import java.util.ArrayList;
public class Bode_produtoDAO {
	private String cadastra = "INSERT INTO Bode_produto (id_bode, id_produto) VALUES (?,?);";
	private String buscar = "SELECT * FROM Bode_produto WHERE id_bode=?";
	private String relatorio_geral ="SELECT * FROM relatorio_geral_de_Bodes_Produto WHERE cpf_fazendeiro = ?";
	private String relatorio_associados ="SELECT * FROM relatorio_geral_valores  WHERE cpf_fazendeiro = ?";
	private String deletarProduto = "DELETE FROM Bode_produto WHERE id_produto=?";
	private String deletarBode = "DELETE FROM Bode_produto WHERE id_bode=?";
	private String atualizarProduto = "UPDATE Bode_produto SET id_produto=? WHERE id_bode=?";
	private String atualizarBode = "UPDATE Bode_produto SET id_bode=? WHERE id_produto=?";
	private Conexao con;
	
	public Bode_produtoDAO() {
		con = new Conexao("postgres","1234","jdbc:postgresql://localhost:5432/BDbode");
	}
	public ArrayList<Relatorio_BodeProd> relatorioGeral(String cpfFazendeiro){
		ArrayList<Relatorio_BodeProd> lista = null;
		FazendeiroDAO fd = new FazendeiroDAO();
		Fazendeiro teste = fd.buscar(cpfFazendeiro);
		if (teste != null) {
			try {
				con.conectar();
				PreparedStatement instrucao = con.getConexao().prepareStatement(relatorio_geral);
				instrucao.setString(1,cpfFazendeiro);
				ResultSet rs = instrucao.executeQuery();
				lista = new ArrayList<Relatorio_BodeProd>();
				while(rs.next()) {
					lista.add(new Relatorio_BodeProd(rs.getFloat("preco"), rs.getFloat("peso_produto"), rs.getString("categoria"),rs.getInt("quantidade"),rs.getInt("id")));
				}
				con.desconectar();
			}catch(Exception e) {
				System.out.println(e.toString());
			}
			
			
		}
		return lista;
	}
	public ArrayList<Relatorio_BodeProd> relatorioAssociados(String cpfFazendeiro) {
		ArrayList<Relatorio_BodeProd> lista = null;
		FazendeiroDAO fd = new FazendeiroDAO();
		Fazendeiro teste = fd.buscar(cpfFazendeiro);
		if (teste != null) {
			try {
			con.conectar();
			PreparedStatement instrucao = con.getConexao().prepareStatement(relatorio_associados);
			instrucao.setString(1,cpfFazendeiro);
			ResultSet rs = instrucao.executeQuery();
			lista = new ArrayList<Relatorio_BodeProd>();
			while(rs.next()) {
				lista.add(new Relatorio_BodeProd(rs.getFloat("preco"), rs.getFloat("peso_produto"), rs.getString("categoria"),rs.getInt("quantidade"),rs.getInt("id")));
			}
			con.desconectar();
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		
		
		}
		return lista;
	}
	
	
	public void cadastrar(int id_bode, int id_produto) {
		try {
			con.conectar();
			PreparedStatement instrucao = con.getConexao().prepareStatement(cadastra);
			instrucao.setInt(1, id_bode);
			instrucao.setInt(2, id_produto);
			instrucao.execute();
			con.desconectar();
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public void deletarProduto(int id_produto) {
		try {
			con.conectar();
			PreparedStatement instrucao = con.getConexao().prepareStatement(deletarProduto);
			instrucao.setInt(1, id_produto);
			instrucao.execute();
			con.desconectar();
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public void deletarBode(int id_bode) {
		try {
			con.conectar();
			PreparedStatement instrucao = con.getConexao().prepareStatement(deletarBode);
			instrucao.setInt(1, id_bode);
			instrucao.execute();
			con.desconectar();
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public ArrayList<Bode_produto> buscar(int id_bode) {
		ArrayList<Bode_produto> lista = null;
		try {
			con.conectar();
			lista = new ArrayList<Bode_produto>();
			PreparedStatement instrucao = con.getConexao().prepareStatement(buscar);
			instrucao.setInt(1, id_bode);
			ResultSet rs = instrucao.executeQuery();
			
			while(rs.next()) {
				lista.add(new Bode_produto(rs.getInt("id_bode"), rs.getInt("id_produto")));
			}
			
			con.desconectar();
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		
		return lista;
	}
	
	public void alterarBode(int id_bode, int id_produto) {
		try {
			con.conectar();
			PreparedStatement instrucao = con.getConexao().prepareStatement(atualizarBode);
			instrucao.setInt(1, id_bode);
			instrucao.setInt(2, id_produto);
			instrucao.executeQuery();
			con.desconectar();
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public void alterarProduto(int id_bode, int id_produto) {
		try {
			con.conectar();
			PreparedStatement instrucao = con.getConexao().prepareStatement(atualizarProduto);
			instrucao.setInt(1, id_bode);
			instrucao.setInt(2, id_produto);
			instrucao.executeQuery();
			con.desconectar();
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
}

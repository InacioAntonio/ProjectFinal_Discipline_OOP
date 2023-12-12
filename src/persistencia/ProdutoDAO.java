package persistencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import aplicacao.*;
import java.util.ArrayList;
public class ProdutoDAO {
	private String inserir ="INSERT INTO Produto(categoria,descricao,preco,peso,quantidade)VALUES(?,?,?,?,?)";
	private String buscar = "SELECT * FROM Produto WHERE categoria=? ";
	private String buscarId = "SELECT * FROM Produto WHERE id = ? ";
	private String deletar = "DELETE FROM Produto WHERE categoria = ? ";
	private String deletarId = "DELETE FROM Produto WHERE id=? ";
	private String atualizar = "UPDATE Produto SET categoria = ?, descricao=?, preco=?, peso=?, quantidade=? WHERE categoria = ?";
	private String atualizarId = "UPDATE Produto SET categoria=?, descricao=?, preco=?, peso=?, quantidade=? WHERE id = ?";
	private Conexao con;
	public ProdutoDAO() {
		con = new Conexao("postgres","1234","jdbc:postgresql://localhost:5432/BDbode");
	}
	public void  Cadastrar(Produto p) {
		try {
			con.conectar();
			PreparedStatement instrucao = con.getConexao().prepareStatement(inserir);
			instrucao.setString(1, p.getCategoria());
			instrucao.setString(2, p.getDescricao());
			instrucao.setFloat(3,p.getPreco());
			instrucao.setFloat(4, p.getPeso());
			instrucao.setInt(5, p.getQuantidade());
			instrucao.execute();
			instrucao.close();
			con.desconectar();
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	public ArrayList<Produto> Buscar(String Categoria) {
		ArrayList<Produto> lista = new ArrayList<>();
		try {
			con.conectar();
			PreparedStatement instrucao = con.getConexao().prepareStatement(buscar);
			instrucao.setString(1, Categoria);
			ResultSet rs = instrucao.executeQuery();
			while(rs.next()) {
				Produto p = new Produto(rs.getInt("id"),rs.getString("categoria"),rs.getString("descricao"),rs.getInt("Quantidade"),rs.getFloat("peso"));
				lista.add(p);
			}
			con.desconectar();
			
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		return lista;
	}
	public Produto Buscar(int Auxid) {
		Produto p = null;
		try {
			con.conectar();
			PreparedStatement instrucao = con.getConexao().prepareStatement(buscarId);
			instrucao.setInt(1, Auxid);
			ResultSet rs = instrucao.executeQuery();
			if(rs.next()) {
				p = new Produto(rs.getInt("id"),rs.getString("categoria"),rs.getString("descricao"),rs.getInt("Quantidade"),rs.getFloat("peso"));
			}
			con.desconectar();
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		return p;
	}
	public void Deletar(Produto p) {//Delete Por categoria
		//Precisa Deletar as chaves primeiro 
		try {
				con.conectar();
				PreparedStatement instrucao = con.getConexao().prepareStatement(deletar);
				instrucao.setString(1,p.getCategoria());
				instrucao.execute();
				instrucao.close();
			con.desconectar();
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		
	}
	public void Atualizar(Produto p,String categoriaVelha) {
		// Precisa Atualizar as chaves primeiro
		Produto teste = null;
		teste =this.Buscar(p.getId());
		try {
			if (teste != null) {
				con.conectar();
				PreparedStatement instrucao = con.getConexao().prepareStatement(atualizar);
				instrucao.setString(1,p.getCategoria());
				instrucao.setString(2, p.getDescricao());
				instrucao.setFloat(3, p.getPreco());
				instrucao.setFloat(4, p.getPeso());
				instrucao.setInt(5, p.getQuantidade());
				instrucao.setString(6,categoriaVelha );
				instrucao.execute();
				con.desconectar();
			}else {
				System.out.println("Error");
			}
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	public void Atualizar(Produto p) {
		// Precisa Atualizar as chaves primeiro
		try {
			con.conectar();
			PreparedStatement instrucao = con.getConexao().prepareStatement(atualizarId);
			instrucao.setString(1,p.getCategoria());
			instrucao.setString(2, p.getDescricao());
			instrucao.setFloat(3, p.getPreco());
			instrucao.setFloat(4, p.getPeso());
			instrucao.setInt(5, p.getQuantidade());
			instrucao.setInt(6,p.getId());
			instrucao.execute();
			con.desconectar();
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		
	}
	public void Deletar(int AuxId) {//Delete Por ID
		// Precisa Atualizar as chaves primeiro
		Produto teste = null;
		teste = this.Buscar(AuxId);
		try {
			if (teste !=null){
				con.conectar();
			PreparedStatement instrucao = con.getConexao().prepareStatement(deletarId);
			instrucao.setInt(1, AuxId);
			instrucao.execute();
			instrucao.close();
			}
			
			
			con.desconectar();
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
}

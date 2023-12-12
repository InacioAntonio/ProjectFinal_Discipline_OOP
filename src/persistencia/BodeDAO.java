package persistencia;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import aplicacao.*;
import java.util.ArrayList;

public class BodeDAO {
	private String inserir ="INSERT INTO Bode(nome,cpf_fazendeiro,peso,genero) VALUES(?,?,?,?) ";
	private String vinculaBodes = "UPDATE Bode SET cpf_fazendeiro = ? WHERE cpf_fazendeiro = 0";
	private String desvinculaBodes = "UPDATE Bode SET cpf_fazendeiro = 0 WHERE cpf_fazendeiro = ?";	
	private String atualizar = "UPDATE Bode SET cpf_fazendeiro = ?, peso = ?, nome = ?, genero = ?  WHERE id = ?";
	private String buscar = "SELECT * FROM Bode WHERE cpf_fazendeiro = ?";//Corrigir esse nome para listagem
	private String relatorio = "SELECT * FROM relatorio_geral_de_Bodes";
	private String deletar = "DELETE FROM Bode WHERE cpf_fazendeiro=?";
	private String buscarId = "SELECT * FROM Bode WHERE id = ?";
	private String deletarId = "DELETE FROM Bode WHERE id= ? ";
	private Conexao con;
	
	public BodeDAO() {
		con = new Conexao("postgres","1234","jdbc:postgresql://localhost:5432/BDbode");
	}
	
	public ArrayList<BodeREL> relatorio(){
		ArrayList<BodeREL> relatorioBode = null;
		try {
			con.conectar();
			Statement instrucao = con.getConexao().createStatement();
			ResultSet rs = instrucao.executeQuery(relatorio);
			relatorioBode = new ArrayList<BodeREL>();
			while(rs.next()) {
				relatorioBode.add(new BodeREL(rs.getInt("id_bode"), rs.getInt("id_produto"),rs.getString("cpf_fazendeiro"),rs.getInt("id"),rs.getFloat("peso"),rs.getString("nome"),rs.getString("genero")));
			}
			con.desconectar();
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		
		return relatorioBode;
	}
	public void CadastrarBode(Bode b) {
		Fazendeiro teste = null;
		FazendeiroDAO fd = new FazendeiroDAO();
		
		try {
			teste = fd.buscar(b.getCpfFazendeiro());
			if(teste != null) {
				con.conectar();
				PreparedStatement instrucao = con.getConexao().prepareStatement(inserir);
				instrucao.setString(1,b.getNome());
				instrucao.setString(2, b.getCpfFazendeiro());
				instrucao.setFloat(3,b.getPeso());
				instrucao.setString(4,b.getGenero());
				instrucao.execute();
				instrucao.close();
				con.desconectar();
			}else {
				System.out.println("Error");
			}
			
			
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	public ArrayList<Bode> buscar(String cpf) {
		ArrayList<Bode> bodeBusca = null;
		String cpfFazendeiro, genero, nome;
		int id;
		float peso;
		
		try {
			con.conectar();
			PreparedStatement instrucao = con.getConexao().prepareStatement(buscar);
			instrucao.setString(1, cpf);
			ResultSet rs = instrucao.executeQuery();
			bodeBusca = new ArrayList<Bode>();
			while(rs.next()) {
				cpfFazendeiro = rs.getString("cpf_Fazendeiro");
				id = rs.getInt("id");
				peso = rs.getFloat("peso");
				nome = rs.getString("nome");
				genero = rs.getString("genero");
				bodeBusca.add(new Bode(cpfFazendeiro, id,peso,nome,genero));
			}
			con.desconectar();
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
	
	
	public void atualizar(Bode b,int auxid) {
		//Incompleto
		try {
			FazendeiroDAO fd = new FazendeiroDAO();
			Fazendeiro teste=fd.buscar(b.getCpfFazendeiro());
			if (teste !=null){
				Bode teste2=this.BuscarId(auxid);
				if (teste2!=null) {
					con.conectar();
				PreparedStatement atualiza = con.getConexao().prepareStatement(atualizar);
				atualiza.setString(1, b.getCpfFazendeiro());
				atualiza.setFloat(2,b.getPeso() );
				atualiza.setString(3,b.getNome());
				atualiza.setString(4, b.getGenero());
				atualiza.setInt(5, auxid);
				atualiza.execute();
				atualiza.close();
				}
				
			}else {
				System.out.println("CPF não foi achado");
			}
			
			//Não Entendi esse Desvincula Bode sendo que aqui so preencher tudo que não da erro
			//PreparedStatement desvinculaBode = con.getConexao().prepareStatement(atualizar);
			//desvinculaBode.setString(1, f.getCpf());
			//desvinculaBode.execute();
			
			con.desconectar();
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	public Bode BuscarId(int AuxID) {
		Bode b = null;
		try {
			con.conectar();
			PreparedStatement buscas = con.getConexao().prepareStatement(buscarId);
			buscas.setInt(1, AuxID);
			ResultSet rs =buscas.executeQuery();
			if(rs.next()) {
				b = new Bode(rs.getString("cpf_fazendeiro"),rs.getInt("id"),rs.getFloat("peso"),rs.getString("nome"),rs.getString("genero"));
			}
			con.desconectar();
		}catch(Exception e) {
			System.out.println("Houve Erro"+e);
			
		}
		return b;
		
	}
	public void deletar(String cpf) {
		//Incompleto (Deletar tabela chaves antes)
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
	public void deletar(int AuxId) {
		//Incompleto (Deletar tabela chaves antes)
		Bode teste = this.BuscarId(AuxId);
		try {
			con.conectar();
			if (teste!=null) {
				PreparedStatement instrucao = con.getConexao().prepareStatement(deletarId);
				instrucao.setInt(1, AuxId);
				instrucao.execute();
			}else {
				System.out.println("Error");
			}
			con.desconectar();
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
}

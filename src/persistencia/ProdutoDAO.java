package persistencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import aplicacao.*;
import java.util.ArrayList;
public class ProdutoDAO {
	private String inserir ="INSERT INTO Produto(categoria,descricao)VALUES(?,?)";
	private String buscar = " ";
	private String buscarId = " ";
	private String deletar = " ";
	private String deletarId = " ";
	private String atualizar = " ";
	private Conexao con;
	public ProdutoDAO() {
		con = new Conexao("postgres","1234","jdbc:postgresql://localhost:5432/BDbode");
	}
}

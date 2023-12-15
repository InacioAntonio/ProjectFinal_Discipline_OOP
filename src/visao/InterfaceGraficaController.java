package visao;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.ArrayList;
import java.util.Observable;

import aplicacao.Bode;
import aplicacao.Fazendeiro;
import aplicacao.Produto;
import aplicacao.Relatorio_BodeProd;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import persistencia.BodeDAO;
import persistencia.Bode_produtoDAO;
import persistencia.FazendeiroDAO;
import persistencia.ProdutoDAO;

public class InterfaceGraficaController {
	Fazendeiro fazendeiro, fBusca, fazendeiroSessao;
	FazendeiroDAO fDAO;
	BodeDAO bd;
	ProdutoDAO pd;
	Bode_produtoDAO bpDAO = new Bode_produtoDAO();
	Bode bode;
	Produto produto;
	ArrayList<Bode> listaBode;
	ArrayList<Produto> listaProduto;
	ArrayList<Relatorio_BodeProd> relatorioBodeProduto = new ArrayList<Relatorio_BodeProd>();
	String cpf, nome, senha, telefone, cpfAtualiza;
	int idade;
	
	private ObservableList<Bode> bodes = FXCollections.observableArrayList();
	private ObservableList<Produto> produtos = FXCollections.observableArrayList();

    @FXML
    private TextField ageCadaster;

    @FXML
    private AnchorPane cadasterScreen;

    @FXML
    private TextField cpfCadaster;

    @FXML
    private TextField cpfInput;

    @FXML
    private AnchorPane loginScreen;

    @FXML
    private AnchorPane mainScreen;

    @FXML
    private TextField nameCadaster;

    @FXML
    private TextField numberCadaster;

    @FXML
    private TextField passwdCadaster;

    @FXML
    private PasswordField passwdInput;

    @FXML
    private TableColumn<?, ?> categoriaJfx;

    @FXML
    private TableColumn<?, ?> idBodeJfx;

    @FXML
    private TableColumn<?, ?> idProdutoJfx;
    
    @FXML
    private TableColumn<?, ?> nomeBodeJfx;
    
    @FXML
    private TableColumn<?, ?> pesoBodeJfx;

    @FXML
    private TableColumn<?, ?> pesoProdutoJfx;

    @FXML
    private TableColumn<?, ?> precoJfx;

    @FXML
    private TableColumn<?, ?> qtdJfx;

    @FXML
    private TableView<?> relatorioGeralJfx;
    
    Alert alert;
	
	public void initialize() {
        // TODO
    	loginScreen.setVisible(true);
    	cadasterScreen.setVisible(false);
    	mainScreen.setVisible(false);
    }    
    
    @FXML
	private void handleBtnLogin(){
    	
    	cpf = cpfInput.getText();
    	senha = passwdInput.getText();
		
		fDAO = new FazendeiroDAO();
		try {
			fBusca = fDAO.buscar(cpf);
			if(fBusca != null) {
				if(fBusca.getSenha().equals(senha)) {
					fazendeiroSessao = fBusca;
			    	loginScreen.setVisible(false);
			    	mainScreen.setVisible(true);
				}
			}
		}catch(Exception e) {
			alert =  new Alert(AlertType.CONFIRMATION);
		}
	}
    

    @FXML
	private void handleBtnScreenCadastrar(){
    	loginScreen.setVisible(false);
    	cadasterScreen.setVisible(true);
    }

    @FXML
    private void handleBtnCadastrar() throws Exception{
		cpf = cpfCadaster.getText();
    	fDAO = new FazendeiroDAO();
		if(fDAO.buscar(cpf) == null) {
			nome = nameCadaster.getText();
			idade = Integer.parseInt(ageCadaster.getText());
			telefone = numberCadaster.getText();
			senha = passwdCadaster.getText();
			
			fazendeiro = new Fazendeiro(nome, cpf, senha, idade, telefone);
			fDAO.cadastrar(fazendeiro);
			Alerts.cadaster();
			loginScreen.setVisible(true);
	    	cadasterScreen.setVisible(false);
		}else {
			Alerts.notCadaster();
		}
    }
}

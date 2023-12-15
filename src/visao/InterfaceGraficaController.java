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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import persistencia.BodeDAO;
import persistencia.Bode_produtoDAO;
import persistencia.FazendeiroDAO;
import persistencia.ProdutoDAO;

public class InterfaceGraficaController implements Initializable{
	Fazendeiro fazendeiro, fBusca, fazendeiroSessao;
	FazendeiroDAO fDAO;
	BodeDAO bd;
	ProdutoDAO pd;
	private Bode_produtoDAO bpDAO = new Bode_produtoDAO();
	Bode bode;
	Produto produto;
	ArrayList<Bode> listaBode;
	ArrayList<Produto> listaProduto;
	private ObservableList<Relatorio_BodeProd> relatorioBodeProduto = FXCollections.observableArrayList();
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
    private AnchorPane cadasterBodeScreen;

    @FXML
    private ToggleGroup genero;
   
    @FXML
    private TextField nameBodeCad;
    
    @FXML
    private TextField pesoBodeCad;
    
    @FXML
    private RadioButton femeaCad;

    @FXML
    private TableColumn<Relatorio_BodeProd, String> categoriaJfx;

    @FXML
    private TableColumn<Relatorio_BodeProd, Double> idBodeJfx;

    @FXML
    private TableColumn<Relatorio_BodeProd, Double> idProdutoJfx;
    
    @FXML
    private TableColumn<Relatorio_BodeProd, String> nomeBodeJfx;
    
    @FXML
    private TableColumn<Relatorio_BodeProd, Double> pesoBodeJfx;

    @FXML
    private TableColumn<Relatorio_BodeProd, Double> pesoProdutoJfx;

    @FXML
    private TableColumn<Relatorio_BodeProd, Double> precoJfx;

    @FXML
    private TableColumn<Relatorio_BodeProd, Integer> qtdJfx;

    @FXML
    private TableView<Relatorio_BodeProd> relatorioGeralJfx;
    
    Alert alert;
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub@FXML
    	loginScreen.setVisible(true);
    	cadasterScreen.setVisible(false);
    	mainScreen.setVisible(false);
    	cadasterBodeScreen.setVisible(false);
	}
    
    private void intializeRelatorioGeral() {
    	categoriaJfx.setCellValueFactory(new PropertyValueFactory<Relatorio_BodeProd, String>("Categoria"));
        //idBodeJfx.setCellValueFactory(new PropertyValueFactory<Relatorio_BodeProd, Integer>("PesoProduto"));
        //idProdutoJfx.setCellValueFactory(new PropertyValueFactory<Relatorio_BodeProd, Integer>("Preco"));;
        nomeBodeJfx.setCellValueFactory(new PropertyValueFactory<Relatorio_BodeProd, String>("Nome_Bode"));;
        pesoBodeJfx.setCellValueFactory(new PropertyValueFactory<Relatorio_BodeProd, Double>("PesoBode"));;
        pesoProdutoJfx.setCellValueFactory(new PropertyValueFactory<Relatorio_BodeProd, Double>("PesoProduto"));;
        precoJfx.setCellValueFactory(new PropertyValueFactory<Relatorio_BodeProd, Double>("Preco"));;
        qtdJfx.setCellValueFactory(new PropertyValueFactory<Relatorio_BodeProd, Integer>("Quantidade"));;
        
        relatorioBodeProduto.addAll(bpDAO.relatorioGeral(fazendeiroSessao.getCpf()));
        relatorioGeralJfx.setItems(relatorioBodeProduto);
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
					intializeRelatorioGeral();
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

    @FXML
    private void handleNavigationBodeCad() {
    	mainScreen.setVisible(false);
    	cadasterBodeScreen.setVisible(true);
    }
    
    @FXML
    private void handleBtnCadasterBode() {
    	
    	try {
			bode = new Bode();
			bd  = new BodeDAO();
			bode.setCpfFazendeiro(fazendeiroSessao.getCpf());
			bode.setNome(nameBodeCad.getText());
			bode.setGenero(femeaCad.isSelected() ? "Macho" : "Fêmea");
			bode.setPeso(Float.parseFloat(pesoBodeCad.getText()));
			bd.CadastrarBode(bode);
			Alerts.cadasterBode();
    	}catch(Exception e) {
			Alerts.notCadasterBode();
    	}
	}
}

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
	private ObservableList<Relatorio_BodeProd> relatorioBodes = FXCollections.observableArrayList();
	
	private String cpf, nome, senha, telefone, cpfAtualiza;
	private int idade;
	private int bodeEscolha;
	private ObservableList<Bode> bodes = FXCollections.observableArrayList();
	private ObservableList<Produto> produtos = FXCollections.observableArrayList();

    @FXML
    private TextField ageCadaster;

    @FXML
    private AnchorPane cadasterScreen;
    
    @FXML
    private AnchorPane cadasterProdutoScreen;

    @FXML
    private TextField cpfCadaster;

    @FXML
    private TextField cpfInput;

    @FXML
    private AnchorPane loginScreen;
    
    @FXML
    private AnchorPane relatorioBodeScreen;

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
    private TextField buscarBodeText;
    
    @FXML
    private TextField idBodeProdCad;
    
    @FXML
    private TextField categoriaProdCad;
    
    @FXML
    private TextField pesoProdCad;
    
    @FXML
    private TextField descricaoProdCad;
    
    @FXML
    private TextField qtdProdCad;
    
    @FXML
    private TextField precoProdCad;
    
    @FXML
    private RadioButton femeaCad;

    @FXML
    private TableColumn<Relatorio_BodeProd, String> categoriaJfx;

    @FXML
    private TableColumn<Relatorio_BodeProd, Float> idBodeJfx;

    @FXML
    private TableColumn<Relatorio_BodeProd, Float> idProdutoJfx;
    
    @FXML
    private TableColumn<Relatorio_BodeProd, String> nomeBodeJfx;
    
    @FXML
    private TableColumn<Relatorio_BodeProd, Float> pesoBodeJfx;

    @FXML
    private TableColumn<Relatorio_BodeProd, Float> pesoProdutoJfx;

    @FXML
    private TableColumn<Relatorio_BodeProd, Float> precoJfx;

    @FXML
    private TableColumn<Relatorio_BodeProd, Integer> qtdJfx;
    
    @FXML
    private TableColumn<Relatorio_BodeProd, String> nomeBodeRel;

    @FXML
    private TableColumn<Relatorio_BodeProd, String> categoriaProdRel;

    @FXML
    private TableColumn<Relatorio_BodeProd, Float> pesoBodeRel;
   
    @FXML
    private TableColumn<Relatorio_BodeProd, Float> precoProdutoRel;
    
    @FXML
    private TableColumn<Relatorio_BodeProd, Float> pesoProdutoRel;

    @FXML
    private TableColumn<Bode, Integer> idBodeTable;
    
    @FXML
    private TableColumn<Bode, String> nomeBodeTable;
    
    @FXML
    private TableColumn<Bode, String> generoBodeTable;
    
    @FXML
    private TableColumn<Bode, Float> pesoBodeTable;
    
    @FXML
    private TableView<Relatorio_BodeProd> relatorioGeralJfx;
    
    @FXML
    private TableView<Relatorio_BodeProd> tabelaBodes;
    
    @FXML
    private TableView<Bode>  tabelaBodesBusca;
    
    Alert alert;
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub@FXML
    	loginScreen.setVisible(true);
    	cadasterScreen.setVisible(false);
    	mainScreen.setVisible(false);
    	cadasterBodeScreen.setVisible(false);
    	relatorioBodeScreen.setVisible(false);
    	cadasterProdutoScreen.setVisible(false);
	}
    
    private void intializeRelatorioGeral() {
    	categoriaJfx.setCellValueFactory(new PropertyValueFactory<Relatorio_BodeProd, String>("categoria"));
        //idBodeJfx.setCellValueFactory(new PropertyValueFactory<Relatorio_BodeProd, Integer>("PesoProduto"));
        //idProdutoJfx.setCellValueFactory(new PropertyValueFactory<Relatorio_BodeProd, Integer>("Preco"));;
        nomeBodeJfx.setCellValueFactory(new PropertyValueFactory<Relatorio_BodeProd, String>("nome"));;
        pesoBodeJfx.setCellValueFactory(new PropertyValueFactory<Relatorio_BodeProd, Float>("peso"));;
        pesoProdutoJfx.setCellValueFactory(new PropertyValueFactory<Relatorio_BodeProd, Float>("pesoProduto"));;
        precoJfx.setCellValueFactory(new PropertyValueFactory<Relatorio_BodeProd, Float>("preco"));;
        qtdJfx.setCellValueFactory(new PropertyValueFactory<Relatorio_BodeProd, Integer>("quantidade"));;
        
        relatorioGeralJfx.getItems().clear();
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
			Alerts.notLogin();
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
    	intializeRelatorioGeral();
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
	    	mainScreen.setVisible(true);
	    	cadasterBodeScreen.setVisible(false);
    	}catch(Exception e) {
			Alerts.notCadasterBode();
    	}

    	intializeRelatorioGeral();
	}

    @FXML
    private void handleBtnVoltarBode() {
    	mainScreen.setVisible(true);
    	cadasterBodeScreen.setVisible(false);
    	intializeRelatorioGeral();
    }
    
    @FXML
    private void handleRelatorioBode() {
    	mainScreen.setVisible(false);
    	relatorioBodeScreen.setVisible(true);
    	BuscarBode();
    }
    
    @FXML
    private void handleBtnVoltarRelatorio() {
    	mainScreen.setVisible(true);
    	relatorioBodeScreen.setVisible(false);
    	intializeRelatorioGeral();
    }
    
    private void BuscarBode() {		
    	nomeBodeRel.setCellValueFactory(new PropertyValueFactory<Relatorio_BodeProd, String>("nome"));
    	pesoProdutoRel.setCellValueFactory(new PropertyValueFactory<Relatorio_BodeProd, Float>("pesoProduto"));
    	categoriaProdRel.setCellValueFactory(new PropertyValueFactory<Relatorio_BodeProd, String>("categoria"));
    	pesoBodeRel.setCellValueFactory(new PropertyValueFactory<Relatorio_BodeProd, Float>("peso"));
        precoProdutoRel.setCellValueFactory(new PropertyValueFactory<Relatorio_BodeProd, Float>("preco"));

    	tabelaBodes.getItems().clear();
    	tabelaBodes.setItems(relatorioBodes);
    }

    @FXML
    private void handleNavigationCadProd(){
    	mainScreen.setVisible(false);
    	cadasterProdutoScreen.setVisible(true);
    	initializeTableBode();
    }
    
    @FXML
    private void handleCadProduto(){
    	try {
	    	bodeEscolha = Integer.parseInt(idBodeProdCad.getText());
			produto = new Produto();
			produto.setCategoria(categoriaProdCad.getText());
			produto.setPeso(Float.parseFloat(pesoProdCad.getText()));
			produto.setDescricao(descricaoProdCad.getText());
			produto.setQuantidade(Integer.parseInt(qtdProdCad.getText()));
			produto.setPreco(Float.parseFloat(precoProdCad.getText()));
			bd = new BodeDAO();
			bode = bd.BuscarId(bodeEscolha);
			if(bode !=null) {
				pd = new ProdutoDAO();
				pd.Cadastrar(produto);
				listaProduto = pd.Buscar(produto.getCategoria());
				int ultimoIndice = listaProduto.size()-1;
				bpDAO.cadastrar(bodeEscolha, listaProduto.get(ultimoIndice).getId());
				Alerts.cadasterProd();
			}else {
				Alerts.notCadasterProd();
			}
    	}catch(Exception e) {
    		System.out.println(e.toString());
    	}
		
    }

    private void initializeTableBode() {
    	bd = new BodeDAO();
    	idBodeTable.setCellValueFactory(new PropertyValueFactory<Bode, Integer>("id"));
        nomeBodeTable.setCellValueFactory(new PropertyValueFactory<Bode, String>("nome"));
        generoBodeTable.setCellValueFactory(new PropertyValueFactory<Bode, String>("genero"));
        pesoBodeTable.setCellValueFactory(new PropertyValueFactory<Bode, Float>("peso"));

    	tabelaBodesBusca.getItems().clear();
    	bodes.addAll(bd.buscar(fazendeiroSessao.getCpf()));
    	tabelaBodesBusca.setItems(bodes);
    }
    @FXML
    private void handleBtnVoltarCadProd(){
    	mainScreen.setVisible(true);
    	cadasterProdutoScreen.setVisible(false);
    }
}

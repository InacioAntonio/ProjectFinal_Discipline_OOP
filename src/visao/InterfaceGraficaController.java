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
import javafx.scene.control.TextInputControl;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import persistencia.BodeDAO;
import persistencia.Bode_produtoDAO;
import persistencia.FazendeiroDAO;
import persistencia.ProdutoDAO;

public class InterfaceGraficaController implements Initializable{
	private Fazendeiro fazendeiro, fBusca, fazendeiroSessao;
	private FazendeiroDAO fDAO;
	private BodeDAO bd;
	private ProdutoDAO pd;
	private Bode_produtoDAO bpDAO = new Bode_produtoDAO();
	private Bode bode;
	private Produto produto;
	private ArrayList<Bode> listaBode;
	private ArrayList<Produto> listaProduto;
	private ArrayList<Produto> listaRelProd;
	private Fazendeiro teste;
	private ObservableList<Relatorio_BodeProd> relatorioBodeProduto = FXCollections.observableArrayList();
	private ObservableList<Relatorio_BodeProd> relatorioBodes = FXCollections.observableArrayList();
	
	private String cpf, nome, senha, telefone, cpfAtualiza;
	private int idade;
	private int bodeEscolha;
	private int ultimoIndice;
	private ObservableList<Bode> bodes = FXCollections.observableArrayList();
	private ObservableList<Bode> bodesEdit = FXCollections.observableArrayList();
	private ObservableList<Produto> produtos = FXCollections.observableArrayList();

    @FXML
    private TextField ageCadaster;
    
    @FXML
    private TextField cpfEdit;
    
    @FXML
    private TextField passwdEdit;
    
    @FXML
    private TextField nameEdit;
    
    @FXML
    private TextField numberEdit;
    
    @FXML
    private TextField ageEdit;

    @FXML
    private AnchorPane cadasterScreen;
    
    @FXML
    private AnchorPane cadasterProdutoScreen;
    
    @FXML
    private AnchorPane editContaScreen;

    @FXML
    private TextField cpfCadaster;

    @FXML
    private TextField cpfInput;
    
    @FXML
    private TextField idBodeEditProd;

    @FXML
    private AnchorPane loginScreen;
    
    @FXML
    private AnchorPane relatorioBodeScreen;

    @FXML
    private AnchorPane mainScreen;
    
    @FXML
    private AnchorPane  editProdutoScreen;
    

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
    private AnchorPane editBodeScreen;
    
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
    private TextField categoriaProdEdit;
    
    @FXML
    private TextField pesoProdEdit;
    
    @FXML
    private TextField descricaoProdEdit;
    
    @FXML
    private TextField precoProdEdit;
    
    @FXML
    private TextField idProdEdit;
    
    @FXML
    private TextField qtdProdEdit;
    
    @FXML
    private TextField idBodeEdit;
    
    @FXML
    private RadioButton femeaCad;

    @FXML
    private RadioButton machoCad;
    
    @FXML
    private RadioButton femeaEditBode;
    
    @FXML
    private RadioButton machoEditBod;
    
    @FXML
    private RadioButton editProdBodAdd;
    
    @FXML
    private RadioButton editProdBodRem;
    
    @FXML
    private TextField nomeBodeEdit;
    
    @FXML
    private TextField NomePesoEdit;
    
    @FXML
    private TextField pesoBodeEdit;
    
    
    @FXML
    private TableColumn<Relatorio_BodeProd, String> categoriaJfx;

    @FXML
    private TableColumn<Relatorio_BodeProd, Integer> idBodeJfx;

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
    private TableColumn<Relatorio_BodeProd, Integer> idProdutoTabela;
    
    @FXML
    private TableColumn<Relatorio_BodeProd, String> categoriaProdTabela;
    
    @FXML
    private TableColumn<Relatorio_BodeProd, String> descricaoProdTabela;

    @FXML
    private TableColumn<Bode, Integer> idBodeTable;
    
    @FXML
    private TableColumn<Bode, String> nomeBodeTable;
    
    @FXML
    private TableColumn<Bode, String> generoBodeTable;
    
    @FXML
    private TableColumn<Bode, Float> pesoBodeTable;
    
    @FXML
    private TableColumn<Bode, Integer> idBodeEditTabela;
    
    @FXML
    private TableColumn<Bode, String> nomeBodeEditTabela;
    
    @FXML
    private TableView<Relatorio_BodeProd> relatorioGeralJfx;
    
    @FXML
    private TableView<Relatorio_BodeProd> tabelaBodes;
    
    @FXML
    private TableView<Produto> tabelaEditProduto;
    
    @FXML
    private TableView<Bode>  tabelaBodesBusca;
    
    @FXML
    private TableView<Bode> tabelaBodesEdit;
    
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
    	editProdutoScreen.setVisible(false);
    	editBodeScreen.setVisible(false);
    	editContaScreen.setVisible(false);
	}
    
    private void intializeRelatorioGeral() {
    	categoriaJfx.setCellValueFactory(new PropertyValueFactory<Relatorio_BodeProd, String>("categoria"));
        idBodeJfx.setCellValueFactory(new PropertyValueFactory<Relatorio_BodeProd, Integer>("id_bode"));
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
			if(!cpf.trim().equals("")) {
				fBusca = fDAO.buscar(cpf);
				if(fBusca != null) {	
					if(fBusca.getSenha().equals(senha)) {
						fazendeiroSessao = fBusca;
						intializeRelatorioGeral();
				    	loginScreen.setVisible(false);
				    	mainScreen.setVisible(true);
				    	cpfInput.setText("");
				    	passwdInput.setText("");
					}
				}else {
					Alerts.notLogin();
				}
			}else {
				Alerts.notLogin();
			}
		}catch(Exception e) {
			Alerts.notLogin();
		}
	}
    
    @FXML
    private void handleBtnVoltarCad(){
    	loginScreen.setVisible(true);
    	cadasterScreen.setVisible(false);
    	cpfCadaster.setText("");
		nameCadaster.setText("");
		ageCadaster.setText("");
		numberCadaster.setText("");
		passwdCadaster.setText("");
    }
    
    @FXML
    private void handleBtnSair() {
    	fazendeiroSessao = null;
    	mainScreen.setVisible(false);
    	loginScreen.setVisible(true);
    }

    @FXML
	private void handleBtnScreenCadastrar(){
    	loginScreen.setVisible(false);
    	cadasterScreen.setVisible(true);
    	cpfInput.setText("");
    	passwdInput.setText("");
    }

    @FXML
    private void handleBtnCadastrar(){
		cpf = cpfCadaster.getText();
    	fDAO = new FazendeiroDAO();
    	try {
			if(fDAO.buscar(cpf) == null) {
				nome = nameCadaster.getText();
				idade = Integer.parseInt(ageCadaster.getText());
				telefone = numberCadaster.getText();
				senha = passwdCadaster.getText();
				
				fazendeiro = new Fazendeiro(nome, cpf, senha, idade, telefone);
				fDAO.cadastrar(fazendeiro);
				Alerts.cadaster();
				cpfCadaster.setText("");
				nameCadaster.setText("");
				ageCadaster.setText("");
				numberCadaster.setText("");
				passwdCadaster.setText("");
				loginScreen.setVisible(true);
		    	cadasterScreen.setVisible(false);
			}else {
				Alerts.notCadaster();
			}
    	}catch(Exception e) {
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
			if((femeaCad.isSelected() || machoCad.isSelected()) && !nameBodeCad.getText().trim().equals("")) {
				bode.setCpfFazendeiro(fazendeiroSessao.getCpf());
				bode.setNome(nameBodeCad.getText());
				bode.setGenero(femeaCad.isSelected() ? "Fêmea" : "Macho");
				bode.setPeso(Float.parseFloat(pesoBodeCad.getText()));
				bd.CadastrarBode(bode);
				Alerts.cadasterBode();
				femeaCad.setSelected(false);
				machoCad.setSelected(false);
		    	mainScreen.setVisible(true);
		    	cadasterBodeScreen.setVisible(false);
			}else {
				Alerts.notCadasterBode();
			}

			nameBodeCad.setText("");
			pesoBodeCad.setText("");
			femeaCad.setSelected(false);
			machoCad.setSelected(false);
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
    	tabelaBodes.getItems().clear();	
    	nomeBodeRel.setCellValueFactory(new PropertyValueFactory<Relatorio_BodeProd, String>("nome"));
    	pesoProdutoRel.setCellValueFactory(new PropertyValueFactory<Relatorio_BodeProd, Float>("pesoProduto"));
    	categoriaProdRel.setCellValueFactory(new PropertyValueFactory<Relatorio_BodeProd, String>("categoria"));
    	pesoBodeRel.setCellValueFactory(new PropertyValueFactory<Relatorio_BodeProd, Float>("peso"));
        precoProdutoRel.setCellValueFactory(new PropertyValueFactory<Relatorio_BodeProd, Float>("preco"));

        bpDAO = new Bode_produtoDAO();
        relatorioBodes.addAll(bpDAO.relatorioGeral(fazendeiroSessao.getCpf()));
        
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
			produto = new Produto();
			if(!categoriaProdCad.getText().trim().equals("") && !pesoProdCad.getText().trim().equals("")
					&& !descricaoProdCad.getText().trim().equals("") && !qtdProdCad.getText().trim().equals("")
					&& !precoProdCad.getText().trim().equals("")) {
				produto.setCpf_fazendeiro(fazendeiroSessao.getCpf());
				produto.setCategoria(categoriaProdCad.getText());
				produto.setPeso(Float.parseFloat(pesoProdCad.getText()));
				produto.setDescricao(descricaoProdCad.getText());
				produto.setQuantidade(Integer.parseInt(qtdProdCad.getText()));
				produto.setPreco(Float.parseFloat(precoProdCad.getText()));
			
						
				pd = new ProdutoDAO();
				pd.Cadastrar(produto);
		
			if(!idBodeProdCad.getText().trim().isEmpty()) {
				bodeEscolha = Integer.parseInt(idBodeProdCad.getText());
		
				bd = new BodeDAO();
				bode = bd.BuscarId(bodeEscolha);
				if(bode !=null) {
					listaProduto = pd.Buscar(produto.getCpf_fazendeiro());
			
					if (listaProduto.size()==0) {
						 ultimoIndice = listaProduto.size();
					}else {
						 ultimoIndice = listaProduto.size()-1;
					}
				
					bpDAO.cadastrar(bodeEscolha, listaProduto.get(ultimoIndice).getId());
				}else {
					Alerts.notCadasterProd();
				}
			}
		
				Alerts.cadasterProd();
				idBodeProdCad.setText("");
				pesoProdCad.setText("");
				categoriaProdCad.setText("");
				descricaoProdCad.setText("");
				qtdProdCad.setText("");
				precoProdCad.setText("");
				handleBtnVoltarCadProd();
			}else {
	    		Alerts.notCadasterProd();
			}
    	}catch(Exception e) {
    		Alerts.notCadasterProd();
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
    	intializeRelatorioGeral();
    }
    
    @FXML
    private void handleNavigationEditProd(){
    	mainScreen.setVisible(false);
    	editProdutoScreen.setVisible(true);
    	initializeProductTable();
    }
    
    private void initializeProductTable() {
    	idProdutoTabela.setCellValueFactory(new PropertyValueFactory<Relatorio_BodeProd, Integer>("id"));
    	categoriaProdTabela.setCellValueFactory(new PropertyValueFactory<Relatorio_BodeProd, String>("categoria"));
        descricaoProdTabela.setCellValueFactory(new PropertyValueFactory<Relatorio_BodeProd, String>("descricao"));
        
        pd = new ProdutoDAO();
        
        tabelaEditProduto.getItems().clear();
        listaRelProd = pd.Buscar(fazendeiroSessao.getCpf());
        
        produtos.addAll(pd.Buscar(fazendeiroSessao.getCpf()));
        tabelaEditProduto.setItems(produtos);
    }
    
    @FXML
    private void handleVoltarEditProd() {
    	mainScreen.setVisible(true);
    	editProdutoScreen.setVisible(false);
    	intializeRelatorioGeral();
    }

    @FXML
    private void handleSelectionarProd() {
    	pd = new ProdutoDAO();
    	try {
    		if(idProdEdit.getText().trim().equals("")) {
    			Alerts.typeCampusID();
    		}else {
    			int ProdutoEscolha = Integer.parseInt(idProdEdit.getText());
        		Produto teste = null;
        		teste = pd.Buscar(ProdutoEscolha);
        		if(teste != null ) {
        			produto = new Produto();
	    			produto.setId(ProdutoEscolha);
	    			categoriaProdEdit.setText(teste.getCategoria());
	    			pesoProdEdit.setText(String.valueOf(teste.getPeso()));
	    			descricaoProdEdit.setText(teste.getDescricao());
	    			precoProdEdit.setText(String.valueOf(teste.getPreco()));
	    			qtdProdEdit.setText(String.valueOf(teste.getQuantidade()));
        		}
    		}
    		
    	}catch(Exception e) {
    		Alerts.notEdit();
    		System.out.println(e.toString());
    	}
    }
    @FXML
    private void handleEditProduto() {
    	pd = new ProdutoDAO();
    	try {
    		if(idProdEdit.getText().trim().equals("")) {
    			Alerts.notEdit();
    		}else {
    			int ProdutoEscolha = Integer.parseInt(idProdEdit.getText());
        		Produto teste = null;
        		teste = pd.Buscar(ProdutoEscolha);
        		if(teste != null ) {
        			produto = new Produto();
        			
	    			produto.setId(ProdutoEscolha);
	    			produto.setCpf_fazendeiro(fazendeiroSessao.getCpf());
	    			produto.setCategoria(categoriaProdEdit.getText());
	    			produto.setPeso(Float.parseFloat(pesoProdEdit.getText()));
	    			produto.setDescricao(descricaoProdEdit.getText());
	    			produto.setPreco(Float.parseFloat(precoProdEdit.getText()));
	    			produto.setQuantidade(Integer.parseInt(qtdProdEdit.getText()));
	    			pd.Atualizar(produto);
	    			if(!idBodeEditProd.getText().equals("")) {
		    			if(editProdBodAdd.isSelected()) {
			    				bodeEscolha = Integer.parseInt(idBodeEditProd.getText());
			    				
			    				bd = new BodeDAO();
			    				bode = bd.BuscarId(bodeEscolha);
			    				if(bode !=null) {
			    					pd = new ProdutoDAO();
			    					listaProduto = pd.Buscar(produto.getCpf_fazendeiro());
			    					
			    					if (listaProduto.size()==0) {
			    						 ultimoIndice = listaProduto.size();
			    					}else{
			    						 ultimoIndice = listaProduto.size()-1;
			    					}
			    				
			    					bpDAO.cadastrar(bodeEscolha, listaProduto.get(ultimoIndice).getId());
	
			    	    			Alerts.Edit();
			    				}else{
			    					Alerts.notEdit();
			    				}
		    			}else{
		    				bodeEscolha = Integer.parseInt(idBodeEditProd.getText());
		    				
		    				bd = new BodeDAO();
		    				bode = bd.BuscarId(bodeEscolha);
		    				if(bode !=null) { 
		    					bpDAO.deletarBode(bodeEscolha);
		    	    			Alerts.Edit();
		    				}else {
			    				Alerts.notEdit();
		    				}
		    			}
	    			}
	    			
	    			if(!editProdBodAdd.isSelected() && !editProdBodRem.isSelected())
		    				Alerts.Edit();
	    		
	    			idProdEdit.setText("");
	    			categoriaProdEdit.setText("");
	    			pesoProdEdit.setText("");
	    			descricaoProdEdit.setText("");
	    			precoProdEdit.setText("");
	    			qtdProdEdit.setText("");
	    			idBodeEditProd.setText("");
	    			editProdBodAdd.setSelected(false);
	    			editProdBodRem.setSelected(false);
	    			handleVoltarEditProd();
        		}else {
        			Alerts.notEdit();
        		}
    		}
    		
    	}catch(Exception e) {
    		Alerts.notEdit();
    		System.out.println(e.toString());
    	}
    }
    @FXML
    private void handleDeleteProduto() {
    	pd = new ProdutoDAO();
    
    	try {
    		if(idProdEdit.getText().trim().equals("")) {
    			Alerts.notDelete();
    		}else {
    			int ProdutoEscolha = Integer.parseInt(idProdEdit.getText());
        		Produto teste = null;
        		teste = pd.Buscar(ProdutoEscolha);
        		if(teste != null ) {
        			produto = new Produto();
	    			produto.setId(ProdutoEscolha);
	    			produto.setCategoria(categoriaProdEdit.getText());
	    			produto.setPeso(Float.parseFloat(pesoProdEdit.getText()));
	    			produto.setDescricao(descricaoProdEdit.getText());
	    			produto.setPreco(Float.parseFloat(precoProdEdit.getText()));
	    			produto.setQuantidade(Integer.parseInt(qtdProdEdit.getText()));
	    			bpDAO.deletarProduto(ProdutoEscolha);
	    			pd.Deletar(produto);
	    			Alerts.Delete();
	    			handleVoltarEditProd();
        		}else {
        			Alerts.notDelete();
        		}
    		}
    		
    	}catch(Exception e) {
			Alerts.notDelete();
			System.out.println(e.toString());
    	}
    }
    
    private void initializeTabelaBodes() {
    	idBodeEditTabela.setCellValueFactory(new PropertyValueFactory<Bode, Integer>("id"));
    	nomeBodeEditTabela.setCellValueFactory(new PropertyValueFactory<Bode, String>("nome"));;
        
        bd = new BodeDAO();
        tabelaBodesEdit.getItems().clear();
        bodesEdit.addAll(bd.buscar(fazendeiroSessao.getCpf()));
        tabelaBodesEdit.setItems(bodesEdit);
    }
    
    @FXML
    private void handleNavigationEditBode() {
    	mainScreen.setVisible(false);
    	editBodeScreen.setVisible(true);
    	initializeTabelaBodes();
    }
    
    @FXML
    private void handleBtnVoltarEditBode() {
    	mainScreen.setVisible(true);
    	editBodeScreen.setVisible(false);	
    	intializeRelatorioGeral();
    	idBodeEdit.setText("");
    	nomeBodeEdit.setText("");
		pesoBodeEdit.setText("");
		machoEditBod.setSelected(false);
		femeaEditBode.setSelected(false);
    }
    
    @FXML
    private void handleBtnSelEditBode() {
    	bd = new BodeDAO();
    	pd = new ProdutoDAO();
    	try {
    		if(idBodeEdit.getText().equals("")) {
    			Alerts.typeCampusID();
    		}else {
    			int bodeEscolha = Integer.parseInt(idBodeEdit.getText());
        		Bode teste = null;
        		teste = bd.BuscarId(bodeEscolha);
        		if(teste != null ) {
        			nomeBodeEdit.setText(teste.getNome());
	    			pesoBodeEdit.setText(String.valueOf(teste.getPeso()));
	    			machoEditBod.setSelected(teste.getGenero().equals("Macho"));
	    			femeaEditBode.setSelected(teste.getGenero().equals("Fêmea"));
        		}else {
        			Alerts.bodeNotFoundEdit();
        		}
    		}
    		
    	}catch(Exception e) {
    		Alerts.notEdit();
    		System.out.println(e.toString());
    	}
    }
    
    @FXML 
    private void handleBtnEditBode() {
    	
		if(!idBodeEdit.getText().isEmpty()) {
	    	bode = new Bode();
	    	bode.setCpfFazendeiro(fazendeiroSessao.getCpf());
			bode.setNome(nomeBodeEdit.getText());
			bode.setGenero(femeaEditBode.isSelected() ? "Macho" : "Fêmea");
			bode.setPeso(Float.parseFloat(pesoBodeEdit.getText()));
			bd.atualizar(bode, Integer.parseInt(idBodeEdit.getText()));
			Alerts.editBode();
			handleBtnVoltarEditBode();
		}else {
			Alerts.notEdit();
			Alerts.typeCampusID();
		}
    }
    
    @FXML
    private void handleBtnDeletarBode(){
    	
    	bode = new Bode();
		bd = new BodeDAO();
		bpDAO = new Bode_produtoDAO();
		
    	try {
    		if(idBodeEdit.getText().isEmpty()) {
    			Alerts.typeCampusID();
    		}else {
    			int bodeEscolha = Integer.parseInt(idBodeEdit.getText());
        		Bode teste = null;
        		teste = bd.BuscarId(bodeEscolha);
        		if(teste != null ) {
        			bpDAO.deletarBode(bodeEscolha);
        			bd.deletar(bodeEscolha);
        			Alerts.deleteBode();
        			idProdEdit.setText("");
	    			categoriaProdEdit.setText("");
	    			pesoProdEdit.setText("");
	    			descricaoProdEdit.setText("");
	    			precoProdEdit.setText("");
	    			qtdProdEdit.setText("");
	    			idBodeEditProd.setText("");
	    			editProdBodAdd.setSelected(false);
	    			editProdBodRem.setSelected(false);
        			handleBtnVoltarEditBode();
        		}else {
        			Alerts.bodeNotFoundEdit();
        		}
    		}
    		
    	}catch(Exception e) {
    		Alerts.notEdit();
    		System.out.println(e.toString());
    	}
    }
    
    @FXML
    private void handleBtnEditContaNav() {
    	mainScreen.setVisible(false);
    	editContaScreen.setVisible(true);
 
    	cpfEdit.setText(fazendeiroSessao.getCpf());
    	passwdEdit.setText(fazendeiroSessao.getSenha());
    	nameEdit.setText(fazendeiroSessao.getNome());
    	numberEdit.setText(fazendeiroSessao.getTelefone());
    	ageEdit.setText(String.valueOf(fazendeiroSessao.getIdade()));
    }
    
    @FXML
    private void handleBtnVoltarEdit(){
    	mainScreen.setVisible(true);
    	editContaScreen.setVisible(false);
    	intializeRelatorioGeral();
    }
    
    @FXML
    private void handleBtnEditar() {
    	try {
    		
    		if(!cpfEdit.getText().trim().equals("")&& !passwdEdit.getText().trim().equals("") && !nameEdit.getText().trim().equals("") ) {
				fDAO = new FazendeiroDAO();
		    	fazendeiro = new Fazendeiro();
		    	
		    	teste = fDAO.buscar(cpfEdit.getText());
		    	if(teste == null || teste.getCpf().equals(fazendeiroSessao.getCpf())) {
			    	fazendeiro.setCpf(cpfEdit.getText());
			    	fazendeiro.setIdade(Integer.parseInt(ageEdit.getText()));
			    	fazendeiro.setNome(nameEdit.getText());
			    	fazendeiro.setSenha(passwdEdit.getText());
			    	fazendeiro.setTelefone(numberEdit.getText());	
			    	fDAO.atualizar(fazendeiro, fazendeiroSessao.getCpf());
			    	fazendeiroSessao = fazendeiro;
			    	Alerts.updateConta();
			    	handleBtnVoltarEdit();
		    	}else {
	        		Alerts.notUpdateConta();
		    	}
    		}else {
        		Alerts.notUpdateConta();
    		}
    	}catch(Exception e) {
    		System.out.println(e.toString());
    		Alerts.notUpdateConta();
    	}
    }
    
    @FXML
    private void handleBtnExcluir() {
    	fDAO = new FazendeiroDAO();
    	fDAO.deletar(fazendeiroSessao.getCpf());
    	Alerts.deleteConta();
		fazendeiroSessao = null;
    	loginScreen.setVisible(true);
    	editContaScreen.setVisible(false);
    }
}
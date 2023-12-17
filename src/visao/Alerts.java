package visao;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public abstract class Alerts {
	
	public static void notLogin() {
		Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Login");
	    alert.setHeaderText("Não foi possível realizar login");
	    alert.setContentText("E-mail ou senha incorretos, ou conta não existente");
	    alert.showAndWait();
	}
	
	public static void cadaster() {
	 	Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Cadastro");
	    alert.setHeaderText("Usuário foi cadastrado");
	    alert.setContentText("Usuário cadastrado com sucesso");
	    alert.showAndWait();
	}
	
	public static void notCadaster() {
		 Alert alert = new Alert(AlertType.INFORMATION);
		 alert.setTitle("Cadastro");
		 alert.setHeaderText("Usuário não foi cadastrado");
		 alert.setContentText("Não foi possível cadastrar este usuário");
		 alert.showAndWait();
	}
	
	public static void cadasterBode() {
		Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Cadastro bode");
	    alert.setHeaderText("Bode foi cadastrado");
	    alert.setContentText("Bode cadastrado com sucesso");
	    alert.showAndWait();
	}
	
	public static void notCadasterBode() {
		 Alert alert = new Alert(AlertType.INFORMATION);
		 alert.setTitle("Cadastro bode");
		 alert.setHeaderText("Bode não foi cadastrado");
		 alert.setContentText("Não foi possível cadastrar este bode");
		 alert.showAndWait();
	}

	public static void cadasterProd() {
		 Alert alert = new Alert(AlertType.INFORMATION);
		 alert.setTitle("Cadastro produto");
		 alert.setHeaderText("Produto cadastrado");
		 alert.setContentText("Porduto cadastrado com sucesso");
		 alert.showAndWait();
	}
	
	public static void notCadasterProd() {
		 Alert alert = new Alert(AlertType.INFORMATION);
		 alert.setTitle("Cadastro produto");
		 alert.setHeaderText("Produto não foi cadastrado");
		 alert.setContentText("Não foi possível cadastrar este produto");
		 alert.showAndWait();
	}
	public static void Edit() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Atualizar");
		alert.setHeaderText("Atualização bem sucedida");
		alert.setContentText("Atualização Realizada com Sucesso");
		alert.showAndWait();
	}
	public static void notEdit() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Atualizar");
		alert.setHeaderText("Atualização mal sucedida");
		alert.setContentText("Atualização NÃO foi Realizada com Sucesso");
		alert.showAndWait();
	}
	public static void Delete() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Deletar");
		alert.setHeaderText("Exclusão bem sucedida");
		alert.setContentText("Exclusão  foi Realizada com Sucesso");
		alert.showAndWait();
	}
	
	public static void notDelete() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Deletar");
		alert.setHeaderText("Exclusão mal sucedida");
		alert.setContentText("Exclusão  não foi Realizada com Sucesso");
		alert.showAndWait();
	}
	
	public static void typeCampusID() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Preencher campus ID");
		alert.setHeaderText("Não é possível selecionar este ID");
		alert.setContentText("Preenchar o campus ID para poder selecionar");
		alert.showAndWait();
	}
	
	public static void editBode() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Editar bode");
		alert.setHeaderText("Bode alterado");
		alert.setContentText("Bode alterado com sucesso");
		alert.showAndWait();
	}
	
	public static void bodeNotFoundEdit() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Editar Bode");
		alert.setHeaderText("Bode não encontrado");
		alert.setContentText("Não foi encontrado bode com este ID");
		alert.showAndWait();
	}
	
	public static void deleteBode() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Deletar Bode");
		alert.setHeaderText("Bode deletado");
		alert.setContentText("Bode deletado com sucesso");
		alert.showAndWait();
	}
}

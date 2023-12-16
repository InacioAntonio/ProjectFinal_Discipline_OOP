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
	
}

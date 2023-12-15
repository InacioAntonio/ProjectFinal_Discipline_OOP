package visao;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Alerts {
	
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
	public static void notLoguin() {
		Alert alert = new Alert(AlertType.INFORMATION);
		
		alert.setTitle("Login");
		alert.setHeaderText("Usuário Incorreto");
		alert.setContentText("Não foi possivel realizar o loguin deste usuário");
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
}

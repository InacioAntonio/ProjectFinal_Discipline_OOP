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
}

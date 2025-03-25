package application;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.security.crypto.bcrypt.BCrypt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
public class LoginController {
	@FXML
	Button butonLogin;
	@FXML
	TextField inputUsername;
	@FXML
	PasswordField inputPassword;
	@FXML
	private void handleLogin() throws SQLException, Exception {
		String username = inputUsername.getText();
		String password = inputPassword.getText();
		try {
			DBOperations jb = new DBOperations();
			jb.connect();

			ResultSet user = jb.getUserByUsername(username);
			if(user.next()) {
			if ( BCrypt.checkpw(password, user.getString("parola"))) {
				FXMLLoader loader = new FXMLLoader(getClass().getResource(user.getString("rol").equals("admin") ? "AplicatieAdmin.fxml" : "AplicatieClient.fxml"));
				Stage stage = (Stage) inputUsername.getScene().getWindow();
				stage.setScene(new Scene(loader.load()));
				stage.show();
			} 
			}
			jb.disconnect();} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	@FXML
	private void inregistreazaFurnizor() throws SQLException, Exception {
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("RegisterFurnizor.fxml"));
		 AnchorPane root = loader.load();
		 RegisterController controller = loader.getController();
		 controller.setMainController(this);
		 Scene scene = new Scene(root);
		 stage.setScene(scene);
		 stage.show();
	}
	@FXML
	private void inregistrareClient() throws SQLException, Exception {
		Stage stage = new Stage();
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("Register.fxml"));
		 AnchorPane root = loader.load();
		 RegisterClientController controller = loader.getController();
		 controller.setMainController(this);
		 Scene scene = new Scene(root);
		 stage.setScene(scene);
		 stage.show();
	}
}

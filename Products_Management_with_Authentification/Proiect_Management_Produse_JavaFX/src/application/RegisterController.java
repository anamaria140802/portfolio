package application;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.security.crypto.bcrypt.BCrypt;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController {
	
	@FXML
	 private TextField inputNumeF;
	 @FXML
	 private TextField inputPrenumeF;
	 @FXML
	 private TextField inputAdresaF;
	 @FXML private TextField inputUsername;

		@FXML private TextField inputPassword;

		private LoginController mainController;

		public void setMainController(LoginController mainController) {

		this.mainController = mainController;

		}
	@FXML
    private void creeareCont() throws ClassNotFoundException, SQLException, Exception {
    
	String nume = inputNumeF.getText();

	String prenume = inputPrenumeF.getText();

	String adresa = inputAdresaF.getText();
	String user = inputUsername.getText();

	String parola = inputPassword.getText();
	String hashedPass = BCrypt.hashpw(parola, BCrypt.gensalt());
	DBOperations jb = new DBOperations();
  
	jb.connect();
	jb.adaugaFurnizor(nume, prenume, adresa);
	jb.adaugaUtilizator(user, hashedPass,"admin");
	ResultSet userCreated = jb.getUserByUsername(user);
	//jb.adaugaFurnizor(nume, prenume, adresa,userCreated.getInt("idutilizator"));
	jb.adaugaFurnizor(nume, prenume, adresa);
	jb.disconnect();

	// Close the window

	Stage stage = (Stage) inputNumeF.getScene().getWindow();

	stage.close();

	// Refresh the main table

	if (mainController != null) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("AplicatieAdmin.fxml"));
		Stage stage1 = (Stage) mainController.inputUsername.getScene().getWindow();
		stage1.setScene(new Scene(loader.load()));
		stage.show();
	}
	}
}

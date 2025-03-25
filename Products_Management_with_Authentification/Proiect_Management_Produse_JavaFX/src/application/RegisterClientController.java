package application;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.security.crypto.bcrypt.BCrypt;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterClientController {
	@FXML private TextField inputNumeC;

	@FXML private TextField inputPrenumeC;

	@FXML private TextField inputAdresaC;

	@FXML private TextField inputEmailC;
	@FXML private TextField inputUsername;

	@FXML private TextField inputPassword;

	private LoginController mainController;

	public void setMainController(LoginController mainController) {

	this.mainController = mainController;

	}
	
	@FXML
	private void creeareCont() throws SQLException, Exception {

		String nume = inputNumeC.getText();

		String prenume = inputPrenumeC.getText();

		String adresa = inputAdresaC.getText();

		String email = inputEmailC.getText();
		String user = inputUsername.getText();

		String parola = inputPassword.getText();
		DBOperations jb = new DBOperations();
		String hashedPass = BCrypt.hashpw(parola, BCrypt.gensalt());
		jb.connect();

		jb.adaugaUtilizator(user, hashedPass,"client");
		ResultSet userCreated = jb.getUserByUsername(user);
		//jb.adaugaClient(nume, prenume, adresa, email,userCreated.getInt("idutilizator"));
		jb.adaugaClient(nume, prenume, adresa, email);
		jb.disconnect();

		// Close the window

		Stage stage = (Stage) inputNumeC.getScene().getWindow();

		stage.close();

		// Refresh the main table

		if (mainController != null) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("AplicatieClient.fxml"));
			Stage stage1 = (Stage) mainController.inputUsername.getScene().getWindow();
			stage1.setScene(new Scene(loader.load()));
			stage1.show();
		}

	}
}

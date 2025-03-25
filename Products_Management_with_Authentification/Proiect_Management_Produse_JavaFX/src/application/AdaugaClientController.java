package application;

import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdaugaClientController {
	@FXML private TextField inputNumeC;

	@FXML private TextField inputPrenumeC;

	@FXML private TextField inputAdresaC;

	@FXML private TextField inputEmailC;

	private AplicatieController mainController;

	public void setMainController(AplicatieController mainController) {

		this.mainController = mainController;

	}

	@FXML
	private void adaugaClient() throws SQLException, Exception {

		String nume = inputNumeC.getText();

		String prenume = inputPrenumeC.getText();

		String adresa = inputAdresaC.getText();

		String email = inputEmailC.getText();

		DBOperations jb = new DBOperations();

		jb.connect();

		jb.adaugaClient(nume, prenume, adresa, email);

		jb.disconnect();

		// Close the window

		Stage stage = (Stage) inputNumeC.getScene().getWindow();

		stage.close();

		// Refresh the main table

		if (mainController != null) {

			mainController.incarcaClienti();

		}
	}
}

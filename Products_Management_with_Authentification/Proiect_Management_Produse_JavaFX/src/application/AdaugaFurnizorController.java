package application;

import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdaugaFurnizorController {
	@FXML
	private TextField inputNumeF;
	@FXML
	private TextField inputPrenumeF;
	@FXML
	private TextField inputAdresaF;
	private AplicatieController mainController;

	public void setMainController(AplicatieController mainController) {

		this.mainController = mainController;

	}

	@FXML

	private void adaugaFurnizor() throws SQLException, Exception {

		String nume = inputNumeF.getText();
		String prenume = inputPrenumeF.getText();
		String adresa =inputAdresaF.getText();
		DBOperations jb = new DBOperations();
		jb.connect();
		jb.adaugaFurnizor(nume, prenume, adresa);
		jb.disconnect();

		// Close the window

		Stage stage = (Stage) inputNumeF.getScene().getWindow();

		stage.close();

		// Refresh the main table

		if (mainController != null) {

			mainController.incarcaFurnizori();

		}
	}
}

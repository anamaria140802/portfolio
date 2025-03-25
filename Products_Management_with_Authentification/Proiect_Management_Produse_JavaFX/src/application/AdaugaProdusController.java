package application;

import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdaugaProdusController {
	@FXML
	private TextField inputDenumire;
	@FXML
	private TextField inputDescriere;
	@FXML
	private TextField inputCantitate;

	private AplicatieController mainController;

	public void setMainController(AplicatieController mainController) {

		this.mainController = mainController;

	}
	@FXML

	private void adaugaProdus() throws SQLException, Exception {

		String denumire = inputDenumire.getText();
		String descriere = inputDescriere.getText();
		Integer cantitate =Integer.parseInt(inputCantitate.getText());

		DBOperations jb = new DBOperations();


		jb.connect();
		jb.adaugaProdus(denumire, descriere, cantitate);
		jb.disconnect();
		// Close the window

		Stage stage = (Stage) inputDenumire.getScene().getWindow();

		stage.close();

		// Refresh the main table

		if (mainController != null) {

			mainController.incarcaProduse();

		}
	}
}

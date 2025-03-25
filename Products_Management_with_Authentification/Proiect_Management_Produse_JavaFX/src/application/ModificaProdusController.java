package application;

import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ModificaProdusController {
	@FXML
	private TextField inputDenumireM;
	@FXML
	private TextField inputDescriereM;
	@FXML
	private TextField inputCantitateM;
	private Produs produs;

	private AplicatieController mainController;

	public void initData(Produs produs, AplicatieController mainController) {

		this.produs = produs;

		this.mainController = mainController;

		inputDenumireM.setText(produs.getDenumire());
		inputDescriereM.setText(produs.getDescriere());
		inputCantitateM.setText(produs.getCantitate().toString());

	}

	@FXML

	private void modificaProdus() throws SQLException, Exception {

		// Perform the update

		DBOperations jb = new DBOperations();
		jb.connect();
		 String denumire = inputDenumireM.getText();
		 String descriere = inputDescriereM.getText();
		 String cantitate =inputCantitateM.getText();

		String[] valori = { denumire, descriere, cantitate };
		String[] campuri = { "denumire", "descriere","cantitate" };
		jb.modificaTabela("produse", "idproduse", produs.getIdProdus(), campuri, valori);
		jb.disconnect();

		// Close the window

		Stage stage = (Stage) inputDenumireM.getScene().getWindow();

		stage.close();

		// Refresh the main table

		mainController.incarcaProduse();

	}
}

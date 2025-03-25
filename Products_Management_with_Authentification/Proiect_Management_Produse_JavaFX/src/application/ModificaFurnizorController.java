package application;

import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ModificaFurnizorController {
	@FXML private TextField inputNumeFM;

	@FXML private TextField inputPrenumeFM;

	@FXML private TextField inputAdresaFM;

	private Furnizor furnizor;

	private AplicatieController mainController;

	public void initData(Furnizor furnizor, AplicatieController mainController) {

		this.furnizor = furnizor;

		this.mainController = mainController;

		inputNumeFM.setText(furnizor.getNume());
		inputPrenumeFM.setText(furnizor.getPrenume());
		inputAdresaFM.setText(furnizor.getNume());

	}

	@FXML

	private void modificaFurnizor() throws SQLException, Exception {
		// Perform the update

		DBOperations jb = new DBOperations();
		jb.connect();
		 String nume = inputNumeFM.getText();
		 String prenume = inputPrenumeFM.getText();
		 String adresa =inputAdresaFM.getText();
		String[] valori = { nume,prenume, adresa};
		String[] campuri = { "nume", "prenume", "adresa" };
		jb.modificaTabela("furnizor", "idfurnizor", furnizor.getIdFurnizor(), campuri, valori);
		jb.disconnect();

		// Close the window

		Stage stage = (Stage) inputNumeFM.getScene().getWindow();

		stage.close();

		// Refresh the main table

		mainController.incarcaFurnizori();

	}
}

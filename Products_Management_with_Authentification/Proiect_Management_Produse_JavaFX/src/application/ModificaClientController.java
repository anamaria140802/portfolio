package application;

import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ModificaClientController {
	@FXML private TextField inputNumeCM;

	@FXML private TextField inputPrenumeCM;

	@FXML private TextField inputAdresaCM;

	@FXML private TextField inputEmailCM;

	private Client client;

	private AplicatieController mainController;

	public void initData(Client client, AplicatieController mainController) {

		this.client = client;

		this.mainController = mainController;

		inputNumeCM.setText(client.getNume());

		inputPrenumeCM.setText(client.getPrenume());

		inputAdresaCM.setText(client.getAdresa());

		inputEmailCM.setText(client.getEmail());

	}

	@FXML

	private void modificaClient() throws SQLException, Exception {

		// Get the updated values from the fields

		String nume = inputNumeCM.getText();

		String prenume = inputPrenumeCM.getText();

		String adresa = inputAdresaCM.getText();

		String email = inputEmailCM.getText();

		// Perform the update

		DBOperations jb = new DBOperations();

		jb.connect();

		String[] valori = { nume, prenume, adresa, email };

		String[] campuri = { "nume", "prenume", "adresa", "email" };

		jb.modificaTabela("clienti", "idclient", client.getIdClient(), campuri, valori);

		jb.disconnect();

		// Close the window

		Stage stage = (Stage) inputNumeCM.getScene().getWindow();

		stage.close();

		// Refresh the main table

		mainController.incarcaClienti();

	}

}
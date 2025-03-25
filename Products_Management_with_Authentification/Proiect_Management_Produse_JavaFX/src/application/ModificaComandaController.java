package application;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ModificaComandaController  implements Initializable {
	@FXML
	 private ComboBox comboboxIdClientCM;
	 @FXML
	 private ComboBox comboboxIdFurnizorCM;
	 @FXML
	 private TextField inputDataComandaCM;
	 @FXML
	 private TextField inputStatusCM;
	 @FXML
	 private TextField inputValoareComandaCM;

	private Comanda comanda;

	private AplicatieController mainController;

	public void initData(Comanda comanda, AplicatieController mainController) {

		this.comanda = comanda;
		this.mainController = mainController;
		 comboboxIdClientCM.setValue(comanda.getIdClientC());
		 comboboxIdFurnizorCM.setValue(comanda.getIdFurnizorC());
		 inputDataComandaCM.setText(comanda.getDataComanda().toString());
		 inputStatusCM.setText(comanda.getStatus());
		 inputValoareComandaCM.setText(comanda.getValoareComanda().toString());

	}
	DBOperations jb ;
	@Override
	 public void initialize(URL url, ResourceBundle rb) {
		 jb = new DBOperations();
		 if(comboboxIdClientCM != null) {
			 ObservableList<Integer>dateidClienti = FXCollections.observableArrayList();
			 try {
				 jb.connect();
				 ResultSet rs = jb.vedeTabela("clienti");
				 while(rs.next()) {
					 dateidClienti.add(rs.getInt("idclient"));
					 
				 }
				 jb.disconnect();
				 comboboxIdClientCM.setItems(dateidClienti);
				 
			 }catch(Exception e) {
				 System.err.println(e.getMessage());
			 }
		 }
		 
		 if(comboboxIdFurnizorCM != null) {
			 ObservableList<Integer>dateidFurnizori = FXCollections.observableArrayList();
			 try {
				 jb.connect();
				 ResultSet rs = jb.vedeTabela("furnizori");
				 while(rs.next()) {
					 dateidFurnizori.add(rs.getInt("idfurnizor"));
				 }
				 jb.disconnect();
				 comboboxIdFurnizorCM.setItems(dateidFurnizori);
			 }catch(Exception e) {
				 System.err.println(e.getMessage());
			 }
		 }
	}
	
	
	@FXML
	private void modificaComanda() throws SQLException, Exception {
		// Perform the update

		DBOperations jb = new DBOperations();

		jb.connect();
		String idclient = (String) comboboxIdClientCM.getValue().toString();
		 String idfurnizor = (String) comboboxIdFurnizorCM.getValue().toString();
		 String dataComanda =inputDataComandaCM.getText().toString();
		 String status = inputStatusCM.getText().toString();
		 String valoareComanda = inputValoareComandaCM.getText().toString();

		String[] valori = { idclient, idfurnizor ,dataComanda, status, valoareComanda };
		String[] campuri = { "idclient", "idfurnizor","dataComanda", "status", "valoareComanda" };
		jb.modificaTabela("comenzi", "idcomanda", comanda.getIdComanda(), campuri, valori);
		jb.disconnect();
		// Close the window

		Stage stage = (Stage) inputDataComandaCM.getScene().getWindow();

		stage.close();

		// Refresh the main table

		mainController.incarcaComanda();

	}
}

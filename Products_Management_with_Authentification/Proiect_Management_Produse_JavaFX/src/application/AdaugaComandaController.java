package application;

import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdaugaComandaController  implements Initializable{
	@FXML
	private ComboBox comboboxIdClientC;
	@FXML
	private ComboBox comboboxIdFurnizorC;
	@FXML
	private TextField inputDataComandaC;
	@FXML
	private TextField inputStatusC;
	@FXML
	private TextField inputValoareComandaC;

	private AplicatieController mainController;

	public void setMainController(AplicatieController mainController) {

		this.mainController = mainController;

	}
	DBOperations jb ;
	@Override
	 public void initialize(URL url, ResourceBundle rb) {
		 jb = new DBOperations();
		 if(comboboxIdClientC != null) {
			 ObservableList<Integer>dateidClienti = FXCollections.observableArrayList();
			 try {
				 jb.connect();
				 ResultSet rs = jb.vedeTabela("clienti");
				 while(rs.next()) {
					 dateidClienti.add(rs.getInt("idclient"));
					 
				 }
				 jb.disconnect();
				 comboboxIdClientC.setItems(dateidClienti);
				 
			 }catch(Exception e) {
				 System.err.println(e.getMessage());
			 }
		 }
		 
		 if(comboboxIdFurnizorC != null) {
			 ObservableList<Integer>dateidFurnizori = FXCollections.observableArrayList();
			 try {
				 jb.connect();
				 ResultSet rs = jb.vedeTabela("furnizori");
				 while(rs.next()) {
					 dateidFurnizori.add(rs.getInt("idfurnizor"));
				 }
				 jb.disconnect();
				 comboboxIdFurnizorC.setItems(dateidFurnizori);
			 }catch(Exception e) {
				 System.err.println(e.getMessage());
			 }
		 }
	}
	
	@FXML
	private void adaugaComanda() throws SQLException, Exception {
		Integer idclient = (Integer) comboboxIdClientC.getValue();
		Integer idfurnizor = (Integer) comboboxIdFurnizorC.getValue();
		Date dataComanda = Date.valueOf(inputDataComandaC.getText().toString());
		String status = inputStatusC.getText().toString();
		Double valoareComanda = Double.valueOf(inputValoareComandaC.getText().toString());

		DBOperations jb = new DBOperations();
		jb.connect();
		jb.adaugaComanda(idfurnizor, idclient, dataComanda, status,valoareComanda);
		jb.disconnect();
		Stage stage = (Stage) inputStatusC.getScene().getWindow();

		stage.close();

		// Refresh the main table

		if (mainController != null) {

			mainController.incarcaComanda();

		}}
}

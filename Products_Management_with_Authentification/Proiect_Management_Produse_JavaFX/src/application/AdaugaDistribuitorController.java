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

public class AdaugaDistribuitorController implements Initializable {
	@FXML
	private ComboBox comboboxIdProdusD;
	@FXML
	private ComboBox comboboxIdFurnizorD;
	@FXML
	private TextField inputPretUnitarD;
	@FXML
	private TextField inputNumeDistribuitorD;
	@FXML
	private TextField inputStocDisponibilD;
	private AplicatieController mainController;

	public void setMainController(AplicatieController mainController) {

		this.mainController = mainController;

	}
	DBOperations jb ;
	@Override
	 public void initialize(URL url, ResourceBundle rb) {
		 jb = new DBOperations();
		 if(comboboxIdProdusD != null) {
			 ObservableList<Integer>dateidProduse = FXCollections.observableArrayList();
			 try {
				 jb.connect();
				 ResultSet rs = jb.vedeTabela("produse");
				 while(rs.next()) {
					 dateidProduse.add(rs.getInt("idprodus"));
					 
				 }
				 jb.disconnect();
				 comboboxIdProdusD.setItems(dateidProduse);
				 
			 }catch(Exception e) {
				 System.err.println(e.getMessage());
			 }
		 }
		 
		 if(comboboxIdFurnizorD != null) {
			 ObservableList<Integer>dateidFurnizori = FXCollections.observableArrayList();
			 try {
				 jb.connect();
				 ResultSet rs = jb.vedeTabela("furnizori");
				 while(rs.next()) {
					 dateidFurnizori.add(rs.getInt("idfurnizor"));
				 }
				 jb.disconnect();
				 comboboxIdFurnizorD.setItems(dateidFurnizori);
			 }catch(Exception e) {
				 System.err.println(e.getMessage());
			 }
		 }
	}

	@FXML
	private void adaugaDistribuitor() throws SQLException, Exception {
		DBOperations jb = new DBOperations();
		Integer idprodus = (Integer) comboboxIdProdusD.getValue();
		Integer idfurnizor = (Integer) comboboxIdFurnizorD.getValue();
		String numeDistribuitor = inputNumeDistribuitorD.getText().toString();
		Double pretUnitar =Double.valueOf(inputPretUnitarD.getText().toString());
		Integer stocDisponibil =Integer.valueOf( inputStocDisponibilD.getText().toString());
		jb.connect();
		jb.adaugaDistribuitor(idprodus, idfurnizor, numeDistribuitor, pretUnitar,stocDisponibil);
		jb.disconnect();

		// Close the window

		Stage stage = (Stage) inputPretUnitarD.getScene().getWindow();

		stage.close();

		// Refresh the main table

		if (mainController != null) {

			mainController.incarcaDistribuitori();

		}
	}
}

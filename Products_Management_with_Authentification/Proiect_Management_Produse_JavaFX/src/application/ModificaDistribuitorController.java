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

public class ModificaDistribuitorController  implements Initializable {
	@FXML
	 private ComboBox comboboxIdProdusDM;
	 @FXML
	 private ComboBox comboboxIdFurnizorDM;
	 @FXML
	 private TextField inputPretUnitarDM;
	 @FXML
	 private TextField inputNumeDistribuitorDM;
	 @FXML
	 private TextField inputStocDisponibilDM;

	private Distribuitor distribuitor;

	private AplicatieController mainController;

	public void initData(Distribuitor distribuitor, AplicatieController mainController) {

		this.distribuitor = distribuitor;

		this.mainController = mainController;

		comboboxIdProdusDM.setValue(distribuitor.getIdProdusD());
		comboboxIdFurnizorDM.setValue(distribuitor.getIdFurnizorD());
		inputPretUnitarDM.setText(distribuitor.getPretUnitar().toString());
		inputNumeDistribuitorDM.setText(distribuitor.getNumeDistribuitor());
		inputStocDisponibilDM.setText(distribuitor.getStocDisponibil().toString());

	}
	DBOperations jb ;
	@Override
	 public void initialize(URL url, ResourceBundle rb) {
		 jb = new DBOperations();
	if(comboboxIdProdusDM != null) {
		 ObservableList<Integer>dateidProduse = FXCollections.observableArrayList();
		 try {
			 jb.connect();
			 ResultSet rs = jb.vedeTabela("produse");
			 while(rs.next()) {
				 dateidProduse.add(rs.getInt("idprodus"));
				 
			 }
			 jb.disconnect();
			 comboboxIdProdusDM.setItems(dateidProduse);
			 
		 }catch(Exception e) {
			 System.err.println(e.getMessage());
		 }
	 }
	 
	 if(comboboxIdFurnizorDM != null) {
		 ObservableList<Integer>dateidFurnizori = FXCollections.observableArrayList();
		 try {
			 jb.connect();
			 ResultSet rs = jb.vedeTabela("furnizori");
			 while(rs.next()) {
				 dateidFurnizori.add(rs.getInt("idfurnizor"));
			 }
			 jb.disconnect();
			 comboboxIdFurnizorDM.setItems(dateidFurnizori);
		 }catch(Exception e) {
			 System.err.println(e.getMessage());
		 }
	 }
	}
	@FXML
	private void modificaDistribuitor() throws SQLException, Exception {
		// Perform the update
		jb = new DBOperations();
		 jb.connect();

		 String idprodus =  (String) comboboxIdProdusDM.getValue().toString();
		 String idfurnizor = (String) comboboxIdFurnizorDM.getValue().toString();
		 String numeDistribuitor = inputNumeDistribuitorDM.getText().toString();
		 String pretUnitar =inputPretUnitarDM.getText().toString();
		 String stocDisponibil =inputStocDisponibilDM.getText().toString();

		 String[] valori = { idprodus, idfurnizor ,numeDistribuitor, pretUnitar, stocDisponibil };
		 String[] campuri = { "idprodus", "idfurnizor","numeDistribuitor", "pretUnitar", "stocDisponibil" };
		 jb.modificaTabela("distribuitor", "iddistribuitor", distribuitor.getIdDistribuitor(), campuri, valori);
		 jb.disconnect();

		// Close the window

		Stage stage = (Stage) inputPretUnitarDM.getScene().getWindow();

		stage.close();

		// Refresh the main table

		mainController.incarcaDistribuitori();

	}
}

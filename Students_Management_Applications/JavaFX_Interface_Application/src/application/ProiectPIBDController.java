package application;
import java.io.IOException;
import java.net.URL;
import java.net.http.HttpRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ProiectPIBDController implements Initializable{
	private static Integer index_of_modified_object=0;
	@FXML
	private TableView<Elev> tabela_Elevi;
	@FXML
	private Label label;
	 @FXML
	 private Tab tab_Elevi;
	 @FXML
	 private Button buton_IncarcareElevi;
	 @FXML
	 private TableColumn<Elev, Integer> atribut_idelevi;
	 @FXML
	 private TableColumn<Elev, String> atribut_NumeE;
	 @FXML
	 private TableColumn<Elev, String> atribut_PrenumeE;
	 @FXML
	 private TableColumn<Elev, String> atribut_ClasaE;
	 @FXML
	 private TableColumn<Elev, String> atribut_MediaE;
	 @FXML
	 private TextField inputnumeE;
	 @FXML
	 private TextField inputprenumeE;
	 @FXML
	 private TextField inputclasaE;
	 @FXML
	 private TextField inputmedieE;
	 @FXML
	 private TextField inputnumeEM;
	 @FXML
	 private TextField inputprenumeEM;
	 @FXML
	 private TextField inputclasaEM;
	 @FXML
	 private TextField inputmedieEM;
	 @FXML
	 private Tab tab_Teme;
	 @FXML
	 private TableView<Tema> tabela_Teme;
	 @FXML
	 private Button buton_IncarcareTeme;
	 @FXML
	 private TableColumn<Tema, Integer> atribut_idteme;
	 @FXML
	 private TableColumn<Tema, String> atribut_MaterieT;
	 @FXML
	 private TableColumn<Tema, String> atribut_SubiectT;
	 @FXML
	 private TableColumn<Tema, Integer> atribut_PunctajT;
	 @FXML
	 private TextField inputmaterieT;
	 @FXML
	 private TextField inputsubiectT;
	 @FXML
	 private TextField inputpunctajT;
	 @FXML
	 private TextField inputmaterieTM;
	 @FXML
	 private TextField inputsubiectTM;
	 @FXML
	 private TextField inputpunctajTM;
	 @FXML
	 private Tab tab_Realizare;
	 @FXML
	 private TableView<Realizare> tabela_Realizare;
	 @FXML
	 private Button buton_IncarcareRealizare;
	 @FXML
	 private TableColumn<Realizare, Integer> atribut_idtemeR;
	 @FXML
	 private TableColumn<Realizare, Integer> atribut_ideleviR;
	 @FXML
	 private TableColumn<Realizare, Integer> atribut_idrealizare;
	 @FXML
	 private TableColumn<Realizare, String> atribut_TermenR;
	 @FXML
	 private TableColumn<Realizare, String> atribut_TipR;
	 @FXML
	 private TableColumn<Realizare, String> atribut_FormatR;
	 @FXML
	 private ComboBox combobox_elevi;
	 @FXML
	 private ComboBox combobox_teme;
	 @FXML
	 private TextField inputtermen;
	 @FXML
	 private TextField inputtip;
	 @FXML
	 private TextField inputformat;
	 @FXML
	 private ComboBox combobox_eleviM;
	 @FXML
	 private ComboBox combobox_temeM;
	 @FXML
	 private TextField inputtermenM;
	 @FXML
	 private TextField inputtipM;
	 @FXML
	 private TextField inputformatM;
	 private ObservableList<Elev> dateElevi;
	 private ObservableList<Realizare> dateRealizare;
	 private ObservableList<Tema> dateTeme;
	 private DBOperations jb;
	 @Override
	 public void initialize(URL url, ResourceBundle rb) {
		 jb = new DBOperations();
		 jb = new DBOperations();
		 if(combobox_elevi != null) {
			 ObservableList<Integer>dateidElevi = FXCollections.observableArrayList();
			 try {
				 jb.connect();
				 ResultSet rs = jb.vedeTabela("elevi");
				 while(rs.next()) {
					 dateidElevi.add(rs.getInt("idelevi"));
					 
				 }
				 jb.disconnect();
				 combobox_elevi.setItems(dateidElevi);
				 
			 }catch(Exception e) {
				 System.err.println(e.getMessage());
			 }
		 }
		 
		 if(combobox_teme != null) {
			 ObservableList<Integer>dateidTeme = FXCollections.observableArrayList();
			 try {
				 jb.connect();
				 ResultSet rs = jb.vedeTabela("teme");
				 while(rs.next()) {
					 dateidTeme.add(rs.getInt("idteme"));
				 }
				 jb.disconnect();
				 combobox_teme.setItems(dateidTeme);
			 }catch(Exception e) {
				 System.err.println(e.getMessage());
			 }
		 }
		 if(combobox_eleviM != null) {
			 ObservableList<Integer>dateidElevi = FXCollections.observableArrayList();
			 try {
				 jb.connect();
				 ResultSet rs = jb.vedeTabela("elevi");
				 while(rs.next()) {
					 dateidElevi.add(rs.getInt("idelevi"));
					 
				 }
				 jb.disconnect();
				 combobox_eleviM.setItems(dateidElevi);
				 
			 }catch(Exception e) {
				 System.err.println(e.getMessage());
			 }
		 }
		 
		 if(combobox_temeM != null) {
			 ObservableList<Integer>dateidTeme = FXCollections.observableArrayList();
			 try {
				 jb.connect();
				 ResultSet rs = jb.vedeTabela("teme");
				 while(rs.next()) {
					 dateidTeme.add(rs.getInt("idteme"));
				 }
				 jb.disconnect();
				 combobox_temeM.setItems(dateidTeme);
			 }catch(Exception e) {
				 System.err.println(e.getMessage());
			 }
		 }
	 } 
	 
	 @FXML
	 private void incarcaElevi() throws SQLException, Exception{
		 atribut_idelevi.setCellValueFactory(new PropertyValueFactory<>("idelev"));
		 atribut_NumeE.setCellValueFactory(new PropertyValueFactory<>("nume"));
		 atribut_PrenumeE.setCellValueFactory(new PropertyValueFactory<>("prenume"));
		 atribut_ClasaE.setCellValueFactory(new PropertyValueFactory<>("clasa"));
		 atribut_MediaE.setCellValueFactory(new PropertyValueFactory<>("media"));
		 jb.connect();
		 dateElevi = FXCollections.observableArrayList();
		 ResultSet rs = jb.vedeTabela("elevi");
		 while(rs.next()) {
			 dateElevi.add(new Elev(rs.getInt("idelevi"), rs.getString("nume"), rs.getString("prenume"), rs.getString("clasa"), rs.getInt("media")));
			 
		 }
		 jb.disconnect();
		 
		 tabela_Elevi.setItems(null);
		 tabela_Elevi.setItems(dateElevi);
	 }
	 
	 @FXML
	 private void startAdaugaElevi() throws IOException{
		 Stage stage = new Stage();
		 AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("AdaugaElevi.fxml"));
		 Scene scene = new Scene(root);
		 stage.setScene(scene);
		 stage.show();
	 }
	 
	 @FXML
	 private void adaugaElevi() throws SQLException, Exception{
		 String nume = inputnumeE.getText();
		 String prenume = inputprenumeE.getText();
		 String clasa = inputclasaE.getText();
		 Integer medie =Integer.parseInt( inputmedieE.getText());
		 jb.connect();
		 jb.adaugaElev(nume, prenume, clasa, medie);
		 jb.disconnect();
		 
	 }
	 
	 @FXML
	 private void incarcaTema() throws SQLException, Exception{
		 jb.connect();
		 dateTeme = FXCollections.observableArrayList();
		 ResultSet rs = jb.vedeTabela("teme");
		 while(rs.next()) {
			 dateTeme.add(new Tema(rs.getInt("idteme"), rs.getString("materie"), rs.getString("subiect"),rs.getInt("punctaj")));
		 }
		 atribut_idteme.setCellValueFactory(new PropertyValueFactory<>("idteme"));
		 atribut_MaterieT.setCellValueFactory(new PropertyValueFactory<>("materie"));
		 atribut_SubiectT.setCellValueFactory(new PropertyValueFactory<>("subiect"));
		 atribut_PunctajT.setCellValueFactory(new PropertyValueFactory<>("punctaj"));
		 
		 tabela_Teme.setItems(null);
		 tabela_Teme.setItems(dateTeme);
		 jb.disconnect();
	 }
	 
	 @FXML
	 private void startAdaugaTema() throws IOException{
		 Stage stage = new Stage();
		 AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("AdaugaTeme.fxml"));
		 Scene scene = new Scene(root);
		 stage.setScene(scene);
		 stage.show();
	 }
	 @FXML
	 private void adaugaTeme() throws SQLException, Exception{
		 String materie = inputmaterieT.getText();
		 String subiect = inputsubiectT.getText();
		 Integer punctaj =Integer.parseInt(inputpunctajT.getText());
		 
		 jb.connect();
		 jb.adaugaTema(materie, subiect, punctaj);
		 jb.disconnect();
		 
	 }
	 
	 @FXML
	 private void incarcaRealizare() throws SQLException, Exception{
		 jb.connect();
		 dateRealizare =FXCollections.observableArrayList();
		 ResultSet rs = jb.vedeTabela("realizare");
		 
		 while(rs.next()) {
			 dateRealizare.add(new Realizare(rs.getInt("idrealizare"),rs.getInt("idelevi"),
					 rs.getInt("idteme"),rs.getString("termen"),rs.getString("tip"),rs.getString("format")));
			 
		 }
		 atribut_idrealizare.setCellValueFactory(new PropertyValueFactory<>("idrealizare"));
		 atribut_ideleviR.setCellValueFactory(new PropertyValueFactory<>("ideleviR"));
		 atribut_idtemeR.setCellValueFactory(new PropertyValueFactory<>("idtemeR"));
		 atribut_TermenR.setCellValueFactory(new PropertyValueFactory<>("termen"));
		 atribut_TipR.setCellValueFactory(new PropertyValueFactory<>("tip"));
		 atribut_FormatR.setCellValueFactory(new PropertyValueFactory<>("format"));
		 
		 tabela_Realizare.setItems(null);
		 tabela_Realizare.setItems(dateRealizare);
		 jb.disconnect();
	 }
	 
	 @FXML
	 private void startAdaugaRealizare() throws IOException{
		 Stage stage = new Stage();
		 AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("AdaugaRealizare.fxml"));
		 Scene scene = new Scene(root);
		 stage.setScene(scene);
		 stage.show();
	 }
	 
	 @FXML
	 private void adaugaRealizare() throws SQLException, Exception{
		 Integer idelevi = (Integer) combobox_elevi.getValue();
		 Integer idteme = (Integer) combobox_teme.getValue();
		 String termen = inputtermen.getText().toString();
		 String tip = inputtip.getText().toString();
		 String format = inputformat.getText().toString();
		 jb.connect();
		 jb.adaugaRealizare(idelevi, idteme, termen, tip,format);
		 jb.disconnect();
	 }
	 
	 @FXML
	 private void stergeElevi()throws SQLException, Exception {
		 String delete=String.valueOf(dateElevi.get(tabela_Elevi.getSelectionModel().getSelectedIndex()).getIdElev());
		 dateElevi.remove(tabela_Elevi.getSelectionModel().getSelectedIndex());
		 jb.connect();
		 jb.stergeDateTabela(delete, "elevi", "idelevi");
		 jb.disconnect();
	 }
	 
	 @FXML
	 private void stergeTeme()throws SQLException, Exception {
		 String delete=String.valueOf(dateTeme.get(tabela_Teme.getSelectionModel().getSelectedIndex()).getIdTeme());
		 dateTeme.remove(tabela_Teme.getSelectionModel().getSelectedIndex());
		 jb.connect();
		 jb.stergeDateTabela(delete, "teme", "idteme");
		 jb.disconnect();
	 }
	 
	 @FXML
	 private void stergeRealizare()throws SQLException, Exception {
		 String delete=String.valueOf(dateRealizare.get(tabela_Realizare.getSelectionModel().getSelectedIndex()).getIdRealizare());
		 dateRealizare.remove(tabela_Realizare.getSelectionModel().getSelectedIndex());
		 jb.connect();
		 jb.stergeDateTabela(delete, "realizare", "idrealizare");
		 jb.disconnect();
	 }
	 
	 @FXML
	 private void modificaElevi()throws SQLException, Exception {
		jb.connect();
		String Nume = inputnumeEM.getText();
		String Prenume =  inputprenumeEM.getText();
		String Clasa =  inputclasaEM.getText();
		String Media= inputmedieEM.getText();
		String[] valori = { Nume, Prenume, Clasa, Media  };
		String[] campuri = { "nume", "prenume","clasa", "media" };
		jb.modificaTabela("elevi", "idelevi", index_of_modified_object, campuri, valori);
		jb.disconnect();
	 }
	 @FXML
	 private void startModificaElevi() throws IOException{
		 index_of_modified_object=dateElevi.get(tabela_Elevi.getSelectionModel().getSelectedIndex()).getIdElev();
		 Stage stage = new Stage();
		 AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("ModificaElevi.fxml"));
		 Scene scene = new Scene(root);
		 stage.setScene(scene);
		 stage.show();
	 }
	 
	 @FXML
	 private void modificaTeme()throws SQLException, Exception {
		jb.connect();
		String Materie = inputmaterieTM.getText();
		String Subiect = inputsubiectTM.getText();
		String Punctaj =inputpunctajTM.getText();
		String[] valori = { Materie,Subiect, Punctaj};
		String[] campuri = { "materie", "subiect", "punctaj" };
		jb.modificaTabela("teme", "idteme", index_of_modified_object, campuri, valori);
		jb.disconnect();
	 }
	 @FXML
	 private void startModificaTeme() throws IOException{
		 index_of_modified_object=dateTeme.get(tabela_Teme.getSelectionModel().getSelectedIndex()).getIdTeme();
		 Stage stage = new Stage();
		 AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("ModificaTeme.fxml"));
		 Scene scene = new Scene(root);
		 stage.setScene(scene);
		 stage.show();
	 }
	 @FXML
	 private void modificaRealizare()throws SQLException, Exception {
		jb.connect();
		String Idelevi = String.valueOf( combobox_eleviM.getValue());
		String Idteme = String.valueOf( combobox_temeM.getValue());
		String Termen = inputtermenM.getText().toString();
		String Tip = inputtipM.getText().toString();
		String Format = inputformatM.getText().toString();
		String[] valori = { Idelevi, Idteme ,Termen, Tip, Format };
		String[] campuri = { "idelevi", "idteme","termen", "tip", "format" };
		jb.modificaTabela("realizare", "idrealizare", index_of_modified_object, campuri, valori);
		jb.disconnect();
	 }
	 @FXML
	 private void startModificaRealizare() throws IOException{
		 index_of_modified_object=dateRealizare.get(tabela_Realizare.getSelectionModel().getSelectedIndex()).getIdRealizare();
		 Stage stage = new Stage();
		 AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("ModificaRealizare.fxml"));
		 Scene scene = new Scene(root);
		 stage.setScene(scene);
		 stage.show();
	 }
	
	 
}

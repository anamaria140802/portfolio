package application;

import java.io.IOException;
import java.net.URL;
import java.net.http.HttpRequest;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AplicatieController implements Initializable{
	private static Integer index_of_modified_object=0;
	@FXML TabPane tabPane;
	@FXML
	private TableView<Client> tabela_Clienti;
	@FXML
	private Label label;
	 @FXML
	 private Tab tab_Clienti;
	 @FXML
	 private Button buton_IncarcaClient;
	 @FXML
	 private TableColumn<Client, Integer> atribut_idclient;
	 @FXML
	 private TableColumn<Client, String> atribut_numeC;
	 @FXML
	 private TableColumn<Client, String> atribut_prenumeC;
	 @FXML
	 private TableColumn<Client, String> atribut_adresaC;
	 @FXML
	 private TableColumn<Client, String> atribut_email;
	 @FXML
	 private TextField inputNumeC;
	 @FXML
	 private TextField inputPrenumeC;
	 @FXML
	 private TextField inputAdresaC;
	 @FXML
	 private TextField inputEmailC;
	 @FXML
	 private TextField inputPrenumeCM;
	 @FXML
	 private TextField inputAdresaCM;
	 @FXML
	 private TextField inputNumeCM;
	 @FXML
	 private TextField inputEmailCM;
	 @FXML
	private TableView<Produs> tabela_Produse;
	 @FXML
	 private Tab tab_Produse;
	 @FXML
	 private Button buton_IncarcaProduse;
	 @FXML
	 private TableColumn<Produs, Integer> atribut_idprodus;
	 @FXML
	 private TableColumn<Produs, String> atribut_denumire;
	 @FXML
	 private TableColumn<Produs, String> atribut_descriere;
	 @FXML
	 private TableColumn<Produs, Integer> atribut_cantitate;
	 @FXML
	 private TextField inputDenumire;
	 @FXML
	 private TextField inputDescriere;
	 @FXML
	 private TextField inputCantitate;
	 @FXML
	 private TextField inputDenumireM;
	 @FXML
	 private TextField inputDescriereM;
	 @FXML
	 private TextField inputCantitateM;
	 @FXML
	 private TableView<Furnizor> tabela_Furnizori;
	 @FXML
	 private Tab tab_Furnizori;
	 @FXML
	 private Button buton_IncarcareFurnizori;
	 @FXML
	 private TableColumn<Furnizor, Integer> atribut_idfurnizor;
	 @FXML
	 private TableColumn<Furnizor, String> atribut_numeF;
	 @FXML
	 private TableColumn<Furnizor, String> atribut_prenumeF;
	 @FXML
	 private TableColumn<Furnizor, String> atribut_adresaF;
	 @FXML
	 private TextField inputNumeF;
	 @FXML
	 private TextField inputPrenumeF;
	 @FXML
	 private TextField inputAdresaF;
	 @FXML
	 private TextField inputPrenumeFM;
	 @FXML
	 private TextField inputAdresaFM;
	 @FXML
	 private TextField inputNumeFM;
	 @FXML
	 private Tab tab_Comanda;
	 @FXML
	 private TableView<Comanda> tabela_Comenzi;
	 @FXML
	 private Button buton_IncarcaComanda;
	 @FXML
	 private TableColumn<Comanda, Integer> atribut_idcomanda;
	 @FXML
	 private TableColumn<Comanda, Integer> atribut_idfurnizorC;
	 @FXML
	 private TableColumn<Comanda, Integer> atribut_idclientC;
	 @FXML
	 private TableColumn<Comanda, Date> atribut_dataComanda;
	 @FXML
	 private TableColumn<Comanda, String> atribut_status;
	 @FXML
	 private TableColumn<Comanda, Double> atribut_valoareComanda;
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
	 @FXML
	 private Tab tab_Distribuitor;
	 @FXML
	 private TableView<Distribuitor> tabela_Distribuitori;
	 @FXML
	 private Button buton_IncarcaDistribuitor;
	 @FXML
	 private TableColumn<Distribuitor, Integer> atribut_iddistribuitor;
	 @FXML
	 private TableColumn<Distribuitor, Integer> atribut_idprodusD;
	 @FXML
	 private TableColumn<Distribuitor, Integer> atribut_idfurnizorD;
	 @FXML
	 private TableColumn<Distribuitor, String> atribut_numeDistribuitor;
	 @FXML
	 private TableColumn<Distribuitor, Double> atribut_pretUnitar;
	 @FXML
	 private TableColumn<Distribuitor, Integer> atribut_stocDisponibil;
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
	 private ObservableList<Client> dateClienti;
	 private ObservableList<Comanda> dateComenzi;
	 private ObservableList<Distribuitor> dateDistribuitor;
	 private ObservableList<Furnizor> dateFurnizor;
	 private ObservableList<Produs> dateProduse;
	 private DBOperations jb;
	 @Override
	 public void initialize(URL url, ResourceBundle rb) {
		 jb = new DBOperations();
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
	 
	 @FXML void incarcaClienti() throws SQLException, Exception{
		 atribut_idclient.setCellValueFactory(new PropertyValueFactory<>("idclient"));
		 atribut_numeC.setCellValueFactory(new PropertyValueFactory<>("nume"));
		 atribut_prenumeC.setCellValueFactory(new PropertyValueFactory<>("prenume"));
		 atribut_adresaC.setCellValueFactory(new PropertyValueFactory<>("adresa"));
		 atribut_email.setCellValueFactory(new PropertyValueFactory<>("email"));
		 jb.connect();
		 dateClienti = FXCollections.observableArrayList();
		 ResultSet rs = jb.vedeTabela("clienti");
		 while(rs.next()) {
			 dateClienti.add(new Client(rs.getInt("idclient"), rs.getString("nume"), rs.getString("prenume"), rs.getString("adresa"), rs.getString("email")));
			 
		 }
		 jb.disconnect();
		 
		 tabela_Clienti.setItems(null);
		 tabela_Clienti.setItems(dateClienti);
	 }
	 
	 @FXML
	 private void startAdaugaClient() throws IOException{
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("AdaugaClient.fxml"));

		 AnchorPane root = loader.load();

		 AdaugaClientController controller = loader.getController();

		 controller.setMainController(this);

		 Stage stage = new Stage();

		 stage.setScene(new Scene(root));

		 stage.show();
	 }
	 
	 @FXML void incarcaProduse() throws SQLException, Exception{
		 jb.connect();
		 dateProduse = FXCollections.observableArrayList();
		 ResultSet rs = jb.vedeTabela("produse");
		 while(rs.next()) {
			 dateProduse.add(new Produs(rs.getInt("idprodus"), rs.getString("denumire"), rs.getString("descriere"),rs.getInt("cantitate")));
		 }
		 atribut_idprodus.setCellValueFactory(new PropertyValueFactory<>("idprodus"));
		 atribut_denumire.setCellValueFactory(new PropertyValueFactory<>("denumire"));
		 atribut_descriere.setCellValueFactory(new PropertyValueFactory<>("descriere"));
		 atribut_cantitate.setCellValueFactory(new PropertyValueFactory<>("cantitate"));
		 
		 tabela_Produse.setItems(null);
		 tabela_Produse.setItems(dateProduse);
		 jb.disconnect();
	 }
	 
	 @FXML
	 private void startAdaugaProdus() throws IOException{
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("AdaugaProdus.fxml"));

		 AnchorPane root = loader.load();

		 AdaugaProdusController controller = loader.getController();

		 controller.setMainController(this);

		 Stage stage = new Stage();

		 stage.setScene(new Scene(root));

		 stage.show();
	 }
	 
	 @FXML void incarcaFurnizori() throws SQLException, Exception{
		 jb.connect();
		 dateFurnizor = FXCollections.observableArrayList();
		 ResultSet rs = jb.vedeTabela("furnizori");
		 while(rs.next()) {
			 dateFurnizor.add(new Furnizor(rs.getInt("idfurnizor"), rs.getString("nume"), rs.getString("prenume"),rs.getString("adresa")));
		 }
		 atribut_idfurnizor.setCellValueFactory(new PropertyValueFactory<>("idfurnizor"));
		 atribut_numeF.setCellValueFactory(new PropertyValueFactory<>("nume"));
		 atribut_prenumeF.setCellValueFactory(new PropertyValueFactory<>("prenume"));
		 atribut_adresaF.setCellValueFactory(new PropertyValueFactory<>("adresa"));
		 
		 tabela_Furnizori.setItems(null);
		 tabela_Furnizori.setItems(dateFurnizor);
		 jb.disconnect();
	 }
	 
	 @FXML
	 private void startAdaugaFurnizor() throws IOException{
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("AdaugaFurnizor.fxml"));

		 AnchorPane root = loader.load();

		 AdaugaFurnizorController controller = loader.getController();

		 controller.setMainController(this);

		 Stage stage = new Stage();

		 stage.setScene(new Scene(root));

		 stage.show();
	 }
	 
	 @FXML void incarcaComanda() throws SQLException, Exception{
		 jb.connect();
		 dateComenzi =FXCollections.observableArrayList();
		 ResultSet rs = jb.vedeTabela("comenzi");
		 
		 while(rs.next()) {
			 dateComenzi.add(new Comanda(rs.getInt("idcomanda"),rs.getInt("idclient"),
					 rs.getInt("idfurnizor"),Date.valueOf(rs.getString("dataComanda")),rs.getString("status"),rs.getDouble("valoareComanda")));
			 
		 }
		 atribut_idcomanda.setCellValueFactory(new PropertyValueFactory<>("idcomanda"));
		 atribut_idfurnizorC.setCellValueFactory(new PropertyValueFactory<>("idclientC"));
		 atribut_idclientC.setCellValueFactory(new PropertyValueFactory<>("idfurnizorC"));
		 atribut_dataComanda.setCellValueFactory(new PropertyValueFactory<>("dataComanda"));
		 atribut_status.setCellValueFactory(new PropertyValueFactory<>("status"));
		 atribut_valoareComanda.setCellValueFactory(new PropertyValueFactory<>("valoareComanda"));
		 
		 tabela_Comenzi.setItems(null);
		 tabela_Comenzi.setItems(dateComenzi);
		 jb.disconnect();
	 }
	 
	 @FXML
	 private void startAdaugaComanda() throws IOException{
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("AdaugaComanda.fxml"));

		 AnchorPane root = loader.load();

		 AdaugaComandaController controller = loader.getController();

		 controller.setMainController(this);

		 Stage stage = new Stage();

		 stage.setScene(new Scene(root));

		 stage.show();
	 }
	 
	 
	 @FXML void incarcaDistribuitori() throws SQLException, Exception{
		 jb.connect();
		 dateDistribuitor =FXCollections.observableArrayList();
		 ResultSet rs = jb.vedeTabela("distribuitor");
		 
		 while(rs.next()) {
			 dateDistribuitor.add(new Distribuitor(rs.getInt("iddistribuitor"),rs.getInt("idprodus"),
					 rs.getInt("idfurnizor"),rs.getString("numeDistribuitor"),rs.getDouble("pretUnitar"),rs.getInt("stocDisponibil")));
			 
		 }
		 atribut_iddistribuitor.setCellValueFactory(new PropertyValueFactory<>("iddistribuitor"));
		 atribut_idprodusD.setCellValueFactory(new PropertyValueFactory<>("idprodusD"));
		 atribut_idfurnizorD.setCellValueFactory(new PropertyValueFactory<>("idfurnizorD"));
		 atribut_numeDistribuitor.setCellValueFactory(new PropertyValueFactory<>("numeDistribuitor"));
		 atribut_pretUnitar.setCellValueFactory(new PropertyValueFactory<>("pretUnitar"));
		 atribut_stocDisponibil.setCellValueFactory(new PropertyValueFactory<>("stocDisponibil"));
		 
		 tabela_Distribuitori.setItems(null);
		 tabela_Distribuitori.setItems(dateDistribuitor);
		 jb.disconnect();
	 }
	 
	 @FXML
	 private void startAdaugaDistribuitor() throws IOException{
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("AdaugaDistribuitor.fxml"));

		 AnchorPane root = loader.load();

		 AdaugaDistribuitorController controller = loader.getController();

		 controller.setMainController(this);

		 Stage stage = new Stage();

		 stage.setScene(new Scene(root));

		 stage.show();
	 }
	 
	 
	 @FXML
	 private void stergeClient()throws SQLException, Exception {
		 String delete=String.valueOf(dateClienti.get(tabela_Clienti.getSelectionModel().getSelectedIndex()).getIdClient());
		 dateClienti.remove(tabela_Clienti.getSelectionModel().getSelectedIndex());
		 jb.connect();
		 jb.stergeDateTabela(delete, "clienti", "idclient");
		 jb.disconnect();
	 }
	 
	 @FXML
	 private void stergeComanda()throws SQLException, Exception {
		 String delete=String.valueOf(dateComenzi.get(tabela_Comenzi.getSelectionModel().getSelectedIndex()).getIdComanda());
		 dateComenzi.remove(tabela_Comenzi.getSelectionModel().getSelectedIndex());
		 jb.connect();
		 jb.stergeDateTabela(delete, "comenzi", "idcomanda");
		 jb.disconnect();
	 }
	 
	 @FXML
	 private void stergeDistribuitor()throws SQLException, Exception {
		 String delete=String.valueOf(dateDistribuitor.get(tabela_Distribuitori.getSelectionModel().getSelectedIndex()).getIdDistribuitor());
		 dateDistribuitor.remove(tabela_Distribuitori.getSelectionModel().getSelectedIndex());
		 jb.connect();
		 jb.stergeDateTabela(delete, "distribuitor", "iddistribuitor");
		 jb.disconnect();
	 }
	 
	 @FXML
	 private void stergeFurnizor()throws SQLException, Exception {
		 String delete=String.valueOf(dateFurnizor.get(tabela_Furnizori.getSelectionModel().getSelectedIndex()).getIdFurnizor());
		 dateFurnizor.remove(tabela_Furnizori.getSelectionModel().getSelectedIndex());
		 jb.connect();
		 jb.stergeDateTabela(delete, "furnizori", "idfurnizor");
		 jb.disconnect();
	 }
	 @FXML
	 private void stergeProdus()throws SQLException, Exception {
		 String delete=String.valueOf(dateProduse.get(tabela_Produse.getSelectionModel().getSelectedIndex()).getIdProdus());
		 dateProduse.remove(tabela_Produse.getSelectionModel().getSelectedIndex());
		 jb.connect();
		 jb.stergeDateTabela(delete, "produse", "idprodus");
		 jb.disconnect();
	 }
	 
	 @FXML

	 private void startModificaClient() throws IOException {

	 Client selectedClient = tabela_Clienti.getSelectionModel().getSelectedItem();

	 if (selectedClient == null) {
	 
	return;

	 }

	 FXMLLoader loader = new FXMLLoader(getClass().getResource("ModificaClient.fxml"));

	 AnchorPane root = loader.load();

	 ModificaClientController controller = loader.getController();

	 controller.initData(selectedClient, this); // Pass the main controller reference

	 Stage stage = new Stage();

	 stage.setScene(new Scene(root));

	 stage.show();

	 }
	 
	 @FXML
	 private void startModificaProdus() throws IOException{
		 Produs produs=tabela_Produse.getSelectionModel().getSelectedItem();

		 FXMLLoader loader = new FXMLLoader(getClass().getResource("ModificaProdus.fxml"));

		 AnchorPane root = loader.load();

		 ModificaProdusController controller = loader.getController();

		 controller.initData(produs, this); // Pass the main controller reference

		 Stage stage = new Stage();

		 stage.setScene(new Scene(root));

		 stage.show();
	 }
	 
	 @FXML
	 private void startModificaFurnizor() throws IOException{
		 Furnizor furnizor=tabela_Furnizori.getSelectionModel().getSelectedItem();
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("ModificaFurnizor.fxml"));

		 AnchorPane root = loader.load();

		 ModificaFurnizorController controller = loader.getController();

		 controller.initData(furnizor, this); // Pass the main controller reference

		 Stage stage = new Stage();

		 stage.setScene(new Scene(root));

		 stage.show();
	 }
	 @FXML
	 private void startModificaComanda() throws IOException{
		 Comanda comanda=tabela_Comenzi.getSelectionModel().getSelectedItem();
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("ModificaComanda.fxml"));

		 AnchorPane root = loader.load();

		 ModificaComandaController controller = loader.getController();

		 controller.initData(comanda, this); // Pass the main controller reference

		 Stage stage = new Stage();

		 stage.setScene(new Scene(root));

		 stage.show();
	 }
	 @FXML
	 private void startModificaDistribuitor() throws IOException{
		 Distribuitor distribuitor=tabela_Distribuitori.getSelectionModel().getSelectedItem();
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("ModificaDistribuitor.fxml"));

		 AnchorPane root = loader.load();

		 ModificaDistribuitorController controller = loader.getController();

		 controller.initData(distribuitor, this); // Pass the main controller reference

		 Stage stage = new Stage();

		 stage.setScene(new Scene(root));

		 stage.show();
	 }
	 @FXML
	    private void handleLogout(ActionEvent event) {
	        try {
	            // Închide fereastra curentă
	            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	            currentStage.close();
	            
	            // Deschide fereastra de login
	            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Login.fxml"));
	            Parent root = loader.load();
	            Stage loginStage = new Stage();
	            loginStage.setScene(new Scene(root));
	            loginStage.setTitle("Login");
	            loginStage.show();
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	            System.out.println("Eroare la deschiderea ecranului de login");
	        }
	    }
	 
}

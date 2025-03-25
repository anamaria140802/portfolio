package application;

import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
import javafx.stage.Stage;

public class AplicatieClientController {
	private static Integer index_of_modified_object=0;
	@FXML TabPane tabPane;
	@FXML
	private TableView<Client> tabela_Clienti;
	@FXML
	private Label label;
	 @FXML
	 private Tab tab_Clienti;
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
	 private TableView<Furnizor> tabela_Furnizori;
	 @FXML
	 private Tab tab_Furnizori;
	 @FXML
	 private TableColumn<Furnizor, Integer> atribut_idfurnizor;
	 @FXML
	 private TableColumn<Furnizor, String> atribut_numeF;
	 @FXML
	 private TableColumn<Furnizor, String> atribut_prenumeF;
	 @FXML
	 private TableColumn<Furnizor, String> atribut_adresaF;
	 @FXML
	 private Tab tab_Comenzi;
	 @FXML
	 private TableView<Comanda> tabela_Comenzi;
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
	 private Tab tab_Distribuitori;
	 @FXML
	 private TableView<Distribuitor> tabela_Distribuitori;
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
	 private ObservableList<Client> dateClienti;
	 private ObservableList<Comanda> dateComenzi;
	 private ObservableList<Distribuitor> dateDistribuitor;
	 private ObservableList<Furnizor> dateFurnizor;
	 private ObservableList<Produs> dateProduse;
	 private DBOperations jb;
	 @FXML
	 public void initialize() throws SQLException, Exception {
		 jb = new DBOperations();
		 incarcaClienti();
	     // Adăugăm listener pe tabPane pentru a detecta schimbările de tab
	     tabPane.getSelectionModel().selectedItemProperty().addListener((observable, oldTab, newTab) -> {
	         if (newTab == tab_Clienti) {
	             try {
					incarcaClienti();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	         } else if (newTab == tab_Produse) {
	             try {
					incarcaProduse();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	         } else if (newTab == tab_Furnizori) {
	             try {
					incarcaFurnizori();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	         } else if (newTab == tab_Comenzi) {
	             try {
					incarcaComanda();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	         } else if (newTab == tab_Distribuitori) {
	             try {
					incarcaDistribuitori();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	         }
	     });
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
	 private void incarcaProduse() throws SQLException, Exception{
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
	 private void incarcaFurnizori() throws SQLException, Exception{
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
	 private void incarcaComanda() throws SQLException, Exception{
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
	 private void incarcaDistribuitori() throws SQLException, Exception{
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

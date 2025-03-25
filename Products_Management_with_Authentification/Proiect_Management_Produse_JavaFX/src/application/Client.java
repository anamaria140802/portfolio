package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Client {
	 private final IntegerProperty idclient;
	 private final StringProperty Nume;
	 private final StringProperty Prenume;
	 private final StringProperty Adresa;
	 private final StringProperty Email;
	 
	 public Client(Integer idclient, String Nume, String Prenume, String Adresa,String Email) {
		 this.idclient = new SimpleIntegerProperty(idclient);
		 this.Nume = new SimpleStringProperty(Nume);
		 this.Prenume = new SimpleStringProperty(Prenume);
		 this.Adresa = new SimpleStringProperty(Adresa);
		 this.Email=new SimpleStringProperty(Email);
	 }
	 public Integer getIdClient() {
		 return idclient.get();
	 }
	 public String getNume() {
		 return Nume.get();
	 }
	 public String getPrenume() {
		 return Prenume.get();
	 }
	 public String getAdresa() {
		 return Adresa.get();
	 }
	 public String getEmail() {
		 return Email.get();
	}
	 public void setIdClient(Integer valoare) {
		 idclient.set(valoare);
	 }
	 public void setNume(String valoare) {
		 Nume.set(valoare);
	 }
	 public void setPrenume(String valoare) {
		 Prenume.set(valoare);
	 }
	 public void setAdresa(String valoare) {
		 Adresa.set(valoare);
	 }
	 public void setEmail(String valoare) {
		 Email.set(valoare);
		 }
	 public IntegerProperty idclientProperty() {
		 return idclient;
	 }
	 public StringProperty NumeProperty() {
		 return Nume;
	 }
	 public StringProperty PrenumeProperty() {
		 return Prenume;
	 }
	 public StringProperty AdresaProperty() {
		 return Adresa;
	 }
	 public StringProperty EmailProperty() {
		 return Email;
		}
}


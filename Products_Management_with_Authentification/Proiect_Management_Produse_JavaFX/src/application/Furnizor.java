package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Furnizor {
	 private final IntegerProperty idfurnizor;
	 private final StringProperty Nume;
	 private final StringProperty Prenume;
	 private final StringProperty Adresa;
	 
	 public Furnizor(Integer idfurnizor, String Nume, String Prenume, String Adresa) {
		 this.idfurnizor = new SimpleIntegerProperty(idfurnizor);
		 this.Nume = new SimpleStringProperty(Nume);
		 this.Prenume = new SimpleStringProperty(Prenume);
		 this.Adresa = new SimpleStringProperty(Adresa);
	 }
	 public Integer getIdFurnizor() {
		 return idfurnizor.get();
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
	 public void setIdClient(Integer valoare) {
		 idfurnizor.set(valoare);
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
	 public IntegerProperty idfurnizorProperty() {
		 return idfurnizor;
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
}


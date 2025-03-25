package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Produs {
	 private final IntegerProperty idprodus;
	 private final StringProperty Denumire;
	 private final StringProperty Descriere;
	 private final IntegerProperty Cantitate;
	 
	 public Produs(Integer idprodus, String Denumire, String Descriere, Integer Cantitate) {
		 this.idprodus = new SimpleIntegerProperty(idprodus);
		 this.Denumire = new SimpleStringProperty(Denumire);
		 this.Descriere = new SimpleStringProperty(Descriere);
		 this.Cantitate = new SimpleIntegerProperty(Cantitate);
	 }
	 public Integer getIdProdus() {
		 return idprodus.get();
	 }
	 public String getDenumire() {
		 return Denumire.get();
	 }
	 public String getDescriere() {
		 return Descriere.get();
	 }
	 public Integer getCantitate() {
		 return Cantitate.get();
	 }
	 public void setIdProdus(Integer valoare) {
		 idprodus.set(valoare);
	 }
	 public void setDenumire(String valoare) {
		 Denumire.set(valoare);
	 }
	 public void setDescriere(String valoare) {
		 Descriere.set(valoare);
	 }
	 public void setCantitate(Integer valoare) {
		 Cantitate.set(valoare);
	 }
	 public IntegerProperty idprodusProperty() {
		 return idprodus;
	 }
	 public StringProperty DenumireProperty() {
		 return Denumire;
	 }
	 public StringProperty DescriereProperty() {
		 return Descriere;
	 }
	 public IntegerProperty CantitateProperty() {
		 return Cantitate;
	 }
}


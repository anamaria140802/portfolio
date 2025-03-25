package application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
public class Tema {

	 private final IntegerProperty idteme;
	 private final StringProperty Materie;
	 private final StringProperty Subiect;
	 private final IntegerProperty Punctaj;
	 
	 public Tema(Integer idteme, String Materie, String Subiect, Integer Punctaj) {
		 this.idteme = new SimpleIntegerProperty(idteme);
		 this.Materie = new SimpleStringProperty(Materie);
		 this.Subiect = new SimpleStringProperty(Subiect);
		 this.Punctaj = new SimpleIntegerProperty(Punctaj);
	 }
	 public Integer getIdTeme() {
		 return idteme.get();
	 }
	 public String getMaterie() {
		 return Materie.get();
	 }
	 public String getSubiect() {
		 return Subiect.get();
	 }
	 public Integer getPunctaj() {
		 return Punctaj.get();
	 }
	 public void setIdTeme(Integer valoare) {
		 idteme.set(valoare);
	 }
	 public void setMaterie(String valoare) {
		 Materie.set(valoare);
	 }
	 public void setSubiect(String valoare) {
		 Subiect.set(valoare);
	 }
	 public void setPunctaj(Integer valoare) {
		 Punctaj.set(valoare);
	 }
	 public IntegerProperty idtemeProperty() {
		 return idteme;
	 }
	 public StringProperty MaterieProperty() {
		 return Materie;
	 }
	 public StringProperty SubiectProperty() {
		 return Subiect;
	 }
	 public IntegerProperty PunctajProperty() {
		 return Punctaj;
	 }
	
}

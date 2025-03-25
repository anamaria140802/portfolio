package application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Elev {
	 private final IntegerProperty idelev;
	 private final StringProperty Nume;
	 private final StringProperty Prenume;
	 private final StringProperty Clasa;
	 private final IntegerProperty Media;
	 
	 public Elev(Integer idelev, String Nume, String Prenume, String Clasa,Integer Media) {
		 this.idelev = new SimpleIntegerProperty(idelev);
		 this.Nume = new SimpleStringProperty(Nume);
		 this.Prenume = new SimpleStringProperty(Prenume);
		 this.Clasa = new SimpleStringProperty(Clasa);
		 this.Media=new SimpleIntegerProperty(Media);
	 }
	 public Integer getIdElev() {
		 return idelev.get();
	 }
	 public String getNume() {
		 return Nume.get();
	 }
	 public String getPrenume() {
		 return Prenume.get();
	 }
	 public String getClasa() {
		 return Clasa.get();
	 }
	 public Integer getMedia() {
		 return Media.get();
	}
	 public void setIdElev(Integer valoare) {
		 idelev.set(valoare);
	 }
	 public void setNume(String valoare) {
		 Nume.set(valoare);
	 }
	 public void setPrenume(String valoare) {
		 Prenume.set(valoare);
	 }
	 public void setClasa(String valoare) {
		 Clasa.set(valoare);
	 }
	 public void setMedia(Integer valoare) {
		 Media.set(valoare);
		 }
	 public IntegerProperty idelevProperty() {
		 return idelev;
	 }
	 public StringProperty NumeProperty() {
		 return Nume;
	 }
	 public StringProperty PrenumeProperty() {
		 return Prenume;
	 }
	 public StringProperty ClasaProperty() {
		 return Clasa;
	 }
	 public IntegerProperty MediaProperty() {
		 return Media;
		}
}

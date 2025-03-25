package application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Realizare {
	 private final IntegerProperty ideleviR;
	 private final IntegerProperty idrealizare;
	 private final IntegerProperty idtemeR;
	 private final StringProperty Termen;
	 private final StringProperty Tip;
	 private final StringProperty Format;
	 public Realizare(Integer idrealizare, Integer ideleviR,Integer idtemeR,String Termen, String Tip, String Format) {
		 this.ideleviR= new SimpleIntegerProperty(ideleviR);
		 this.idrealizare = new SimpleIntegerProperty(idrealizare);
		 this.idtemeR = new SimpleIntegerProperty(idtemeR);
		 this.Termen = new SimpleStringProperty(Termen);
		 this.Tip = new SimpleStringProperty(Tip);
		 this.Format = new SimpleStringProperty(Format);
	 }
	 public Integer getIdEleviR() {
		 return ideleviR.get();
	 }
	 public Integer getIdTemeR() {
		 return idtemeR.get();
	 }
	 public Integer getIdRealizare() {
		 return idrealizare.get();
	 }
	 public String getTermen() {
		 return Termen.get();
	 }
	 public String getTip() {
		 return Tip.get();
	 }
	 public String getFormat() {
		 return Format.get();
	 }
	 public void setIdEleviR(Integer valoare) {
		 ideleviR.set(valoare);
	 }
	 public void setIdTemeR(Integer valoare) {
		 idtemeR.set(valoare);
	 }
	 public void setIdRealizare(Integer valoare) {
		 idrealizare.set(valoare);
	 }
	 public void setTermen(String valoare) {
		 Termen.set(valoare);
	 }
	 public void setTip(String valoare) {
		 Tip.set(valoare);
	 }
	 public void setFormat(String valoare) {
		 Format.set(valoare);
	 }
	 public IntegerProperty ideleviRProperty() {
		 return ideleviR;
	 }
	 public IntegerProperty idtemeRProperty() {
		 return idtemeR;
	 }
	 public IntegerProperty idrealizareProperty() {
		 return idrealizare;
	 }
	 public StringProperty TermenProperty() {
		 return Termen;
	 }
	 public StringProperty TipProperty() {
		 return Tip;
	 }
	 public StringProperty FormatProperty() {
		 return Format;
	 }
}

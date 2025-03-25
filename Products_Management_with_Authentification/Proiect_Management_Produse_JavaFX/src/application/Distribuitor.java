package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.DoubleProperty;
import java.sql.Date;
public class Distribuitor {
	 private final IntegerProperty idfurnizorD;
	 private final IntegerProperty iddistribuitor;
	 private final IntegerProperty idprodusD;
	 private final StringProperty NumeDistribuitor;
	 private final DoubleProperty PretUnitar;
	 private final IntegerProperty StocDisponibil;
	 public Distribuitor(Integer iddistribuitor, Integer idprodusD,Integer idfurnizorD,String NumeDistribuitor, Double PretUnitar, Integer StocDisponibil) {
		 this.idfurnizorD= new SimpleIntegerProperty(idfurnizorD);
		 this.iddistribuitor = new SimpleIntegerProperty(iddistribuitor);
		 this.idprodusD = new SimpleIntegerProperty(idprodusD);
		 this.NumeDistribuitor = new SimpleStringProperty(NumeDistribuitor);
		 this.PretUnitar = new SimpleDoubleProperty(PretUnitar);
		 this.StocDisponibil = new SimpleIntegerProperty(StocDisponibil);
	 }
	 public Integer getIdFurnizorD() {
		 return idfurnizorD.get();
	 }
	 public Integer getIdProdusD() {
		 return idprodusD.get();
	 }
	 public Integer getIdDistribuitor() {
		 return iddistribuitor.get();
	 }
	 public String getNumeDistribuitor() {
		 return NumeDistribuitor.get();
	 }
	 public Double getPretUnitar() {
		 return PretUnitar.get();
	 }
	 public Integer getStocDisponibil() {
		 return StocDisponibil.get();
	 }
	 public void setIdFurnizorD(Integer valoare) {
		 idfurnizorD.set(valoare);
	 }
	 public void setIdProdusD(Integer valoare) {
		 idprodusD.set(valoare);
	 }
	 public void setIdDiustribuitor(Integer valoare) {
		 iddistribuitor.set(valoare);
	 }
	 public void setNumeDistribuitor(String valoare) {
		 NumeDistribuitor.set(valoare);
	 }
	 public void setPretUnitar(Double valoare) {
		 PretUnitar.set(valoare);
	 }
	 public void setStocDisponibil(Integer valoare) {
		 StocDisponibil.set(valoare);
	 }
	 public IntegerProperty idfurnizorDProperty() {
		 return idfurnizorD;
	 }
	 public IntegerProperty idprodusDProperty() {
		 return idprodusD;
	 }
	 public IntegerProperty iddistribuitorProperty() {
		 return iddistribuitor;
	 }
	 public StringProperty NumeDistribuitorProperty() {
		 return NumeDistribuitor;
	 }
	 public DoubleProperty PretUnitarProperty() {
		 return PretUnitar;
	 }
	 public IntegerProperty StocDisponibilProperty() {
		 return StocDisponibil;
	 }
}


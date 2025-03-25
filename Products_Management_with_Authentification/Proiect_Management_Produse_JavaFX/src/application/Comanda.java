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
public class Comanda {
	 private final IntegerProperty idfurnizorC;
	 private final IntegerProperty idcomanda;
	 private final IntegerProperty idclientC;
	 private final ObjectProperty<Date> DataComanda;
	 private final StringProperty Status;
	 private final DoubleProperty ValoareComanda;
	 public Comanda(Integer idfurnizorC, Integer idcomanda,Integer idclientC,Date DataComanda, String Status, Double ValoareComanda) {
		 this.idfurnizorC= new SimpleIntegerProperty(idfurnizorC);
		 this.idcomanda = new SimpleIntegerProperty(idcomanda);
		 this.idclientC = new SimpleIntegerProperty(idclientC);
		 this.DataComanda = new SimpleObjectProperty<Date>(DataComanda);
		 this.Status = new SimpleStringProperty(Status);
		 this.ValoareComanda = new SimpleDoubleProperty(ValoareComanda);
	 }
	 public Integer getIdFurnizorC() {
		 return idfurnizorC.get();
	 }
	 public Integer getIdClientC() {
		 return idclientC.get();
	 }
	 public Integer getIdComanda() {
		 return idcomanda.get();
	 }
	 public Date getDataComanda() {
		 return DataComanda.get();
	 }
	 public String getStatus() {
		 return Status.get();
	 }
	 public Double getValoareComanda() {
		 return ValoareComanda.get();
	 }
	 public void setIdFurnizorC(Integer valoare) {
		 idfurnizorC.set(valoare);
	 }
	 public void setIdClientC(Integer valoare) {
		 idclientC.set(valoare);
	 }
	 public void setIdComanda(Integer valoare) {
		 idcomanda.set(valoare);
	 }
	 public void setDataComanda(Date valoare) {
		 DataComanda.set(valoare);
	 }
	 public void setStatus(String valoare) {
		 Status.set(valoare);
	 }
	 public void setValoareComanda(Double valoare) {
		 ValoareComanda.set(valoare);
	 }
	 public IntegerProperty idfurnizorCProperty() {
		 return idfurnizorC;
	 }
	 public IntegerProperty idclientCProperty() {
		 return idclientC;
	 }
	 public IntegerProperty idcomandaProperty() {
		 return idcomanda;
	 }
	 public ObjectProperty<Date> DataComandaProperty() {
		 return DataComanda;
	 }
	 public StringProperty StatusProperty() {
		 return Status;
	 }
	 public DoubleProperty ValoareComandaProperty() {
		 return ValoareComanda;
	 }
}


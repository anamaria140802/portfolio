package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBOperations {

	String error;
	Connection con;
	public DBOperations() {
	}
	public void connect() throws ClassNotFoundException, SQLException, Exception {
	try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemax?useSSL=false", "root", "haerin");
	} catch (ClassNotFoundException cnfe) {
		 error = "ClassNotFoundException: Nu s-a gasit driverul bazei de date.";
	throw new ClassNotFoundException(error);
	} catch (SQLException cnfe) {
		 error = "SQLException: Nu se poate conecta la baza de date.";
	throw new SQLException(error);
	} catch (Exception e) {
		 error = "Exception: A aparut o exceptie neprevazuta in timp ce se stabilea legatura la baza de date.";
	throw new Exception(error);
	 	}
	 }
	 
	 // end connect()
	 public ResultSet vedeTabel(String tabel) throws SQLException, Exception {
	 ResultSet rs = null;
	 try {
	 String queryString = ("select * from `schemax`.`" + tabel + "`;");
	 Statement stmt = con.createStatement();
	 rs = stmt.executeQuery(queryString);
	 } catch (SQLException sqle) {
	 error = "SQLException: Interogarea nu a fost posibila.";
	 throw new SQLException(error);
	 } catch (Exception e) {
	 error = "A aparut o exceptie in timp ce se extrageau datele.";
	 throw new Exception(error);
	 }
	 return rs;
	 }
	 // end vedeTabel()
	 public void disconnect() throws SQLException {
	 try {
		 if (con != null) {
			 	con.close();
		 }
	 } catch (SQLException sqle) {
		 error = ("SQLException: Nu se poate inchide conexiunea la baza de date.");
	 throw new SQLException(error);
	 }
	 } // disconnect()
	 public void adaugaElev(String Nume, String Prenume,String Clasa, int Media) throws SQLException {
	 try {
		 // create a prepared SQL statement
		 Statement stmt;
		 stmt = con.createStatement();
		 stmt.executeUpdate("insert into `schemax`.`elevi`(nume, prenume, clasa, media) values('" + Nume + "', '" + Prenume + 
	"', '" + Clasa +"', '" +Media+ "');");
	 } catch (SQLException sqle) {
	 error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
	 throw new SQLException(error);
	 }
	 }
	 // end adaugaClient()
	 
	 public void adaugaRealizare(int idelevi, int idteme, String termen, String tip, String format) throws SQLException {
	 try {
		 // create a prepared SQL statement
		 Statement stmt;
		 stmt = con.createStatement();
		 stmt.executeUpdate("insert into `schemax`.`realizare`(idelevi, idteme, termen, tip,format) values('" + idelevi + "', '" + idteme +"', '" 
		 +termen+"', '" +tip +"', '"+ format+ "');");
	 } catch (SQLException sqle) {
		 error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
	 throw new SQLException(error);
	 }
	 }
	 public void adaugaTema(String Materie, String Subiect, int Punctaj) throws SQLException {
		 try {
			 // create a prepared SQL statement
			 Statement stmt;
			 stmt = con.createStatement();
			 stmt.executeUpdate("insert into `schemax`.`teme`(materie, subiect, punctaj) values('" + Materie + "', '" + Subiect +"', '" +Punctaj + "');");
		 } catch (SQLException sqle) {
			 error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
		 throw new SQLException(error);
		 }
		 }
	 public ResultSet vedeTabela(String tabel) throws SQLException, Exception {
			ResultSet rs = null;
			try {
				String queryString = ("select * from `schemax`.`" + tabel + "`;");
				Statement stmt = con.createStatement(/*ResultSet.TYPE_SCROLL_INSENSITIVE, 
	ResultSet.CONCUR_READ_ONLY*/);
				rs = stmt.executeQuery(queryString);
			} catch (SQLException sqle) {
				error = "SQLException: Interogarea nu a fost posibila.";
				throw new SQLException(error);
			} catch (Exception e) {
				error = "A aparut o exceptie in timp ce se extrageau datele.";
				throw new Exception(error);
			}
			return rs;
		}		
		public ResultSet vedeRealizare() throws SQLException, Exception {
			ResultSet rs = null;
			try {
				String queryString = ("select a.nume numeelev, a.prenume prenumeelev, a.clasa clasaelev, a.media mediaelev, "
						+ "b.materie materietema, b.subiect subiecttema, b.punctaj punctajtema, c.idrealizare, "
						+ "c.idelevi ideleviR, c.idteme idtemeR, c.termen, c.tip , "
						+ "c.format from elevi a, teme b, realizare c where a.idelevi = c.idelevi and b.idteme = c.idteme;");
						Statement stmt = con.createStatement(/*ResultSet.TYPE_SCROLL_INSENSITIVE, 
	ResultSet.CONCUR_READ_ONLY*/);
						rs = stmt.executeQuery(queryString);
			} catch (SQLException sqle) {
				error = "SQLException: Interogarea nu a fost posibila.";
				throw new SQLException(error);
			} catch (Exception e) {
				error = "A aparut o exceptie in timp ce se extrageau datele.";
				throw new Exception(error);
			}
			return rs;
		}
	public void stergeDateTabela(String primaryKeys, String tabela, String dupaID) throws
		SQLException, Exception {
			if (con != null) {
				try {
					// creaza un "prepared SQL statement"
					long aux;
					PreparedStatement delete;
					delete = con.prepareStatement("DELETE FROM " + tabela + " WHERE " + dupaID + "=?;");
					aux = java.lang.Long.parseLong(primaryKeys);
					delete.setLong(1, aux);
					delete.execute();
					
				} catch (SQLException sqle) {
					error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
					throw new SQLException(error);
				} catch (Exception e) {
					error = "A aparut o exceptie in timp ce erau sterse inregistrarile.";
					throw new Exception(error);
				}
			} else {
				error = "Exceptie: Conexiunea cu baza de date a fost pierduta.";
				throw new Exception(error);
			}
		}	
		
	 public void stergeTabela(String tabela, String denumirePK, long id) throws SQLException, Exception {
		 if (con != null) {
			 try {
				 // create a prepared SQL statement
				 Statement stmt;
				 stmt = con.createStatement();
				 stmt.executeUpdate("delete from " + tabela + " where " + denumirePK + " = '" + id + "';");
			 } catch (SQLException sqle) {
				 error = "ExceptieSQL: Stergere nereusita; este posibil sa existe duplicate.";
				 throw new SQLException(error);
			 }
		 } else {
			 error = "Exceptie: Conexiunea cu baza de date a fost pierduta.";
			 throw new Exception(error);
		 }
	 } // end of stergeTabela()
	 
	 public void modificaTabela(String tabela, String primarykey, long ID, String[] campuri, String[] valori)
			 throws SQLException, Exception {
		 String update = "update " + tabela + " set ";
		 String temp = "";
		 if (con != null) {
			 try {
				 for (int i = 0; i < campuri.length; i++) {
					 if (i != (campuri.length - 1)) {
						 temp = temp + campuri[i] + "='" + valori[i] + "', ";
					 } else {
						 temp = temp + campuri[i] + "='" + valori[i] + "' where " + primarykey + " = '" + ID + "';";
					 }
				 }
				 update = update + temp;
				 // create a prepared SQL statement
				 Statement stmt;
				 stmt = con.createStatement();
				 stmt.executeUpdate(update);
			 } catch (SQLException sqle) {
				 error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
				 throw new SQLException(error);
			 }
		 } else {
			 error = "Exceptie: Conexiunea cu baza de date a fost pierduta.";
			 throw new Exception(error);
		 }
	 } // end of modificaTabela()
	 public ResultSet intoarceLinie(String tabela, int ID) throws SQLException, Exception {
			ResultSet rs = null;
			try {
				// Executa interogarea
				String queryString = ("SELECT * FROM " + tabela + " where idelevi=" + ID + ";");
				Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				rs = stmt.executeQuery(queryString); //sql exception
			} catch (SQLException sqle) {
				error = "SQLException: Interogarea nu a fost posibila.";
				throw new SQLException(error);
			} catch (Exception e) {
				error = "A aparut o exceptie in timp ce se extrageau datele.";
				throw new Exception(error);
			}
			return rs;
		} // end of intoarceLinie()
		public ResultSet intoarceLinieDupaId(String tabela, String denumireId, int ID) throws
		SQLException, Exception {
			ResultSet rs = null;
			try {
				// Executa interogarea
				String queryString = ("SELECT * FROM " + tabela + " where " + denumireId + "=" + ID
						+ ";");
				Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				rs = stmt.executeQuery(queryString); //sql exception
			} catch (SQLException sqle) {
				error = "SQLException: Interogarea nu a fost posibila.";
				throw new SQLException(error);
			} catch (Exception e) {
				error = "A aparut o exceptie in timp ce se extrageau datele.";
				throw new Exception(error);
			}
			return rs;
		} // end of intoarceLinieDupaId()
		public ResultSet intoarceRealizareId(int ID) throws SQLException, Exception {
			ResultSet rs = null;
			try {
				// Executa interogarea
				String queryString = ("SELECT a.nume numeelev, a.prenume prenumeelev, a.clasa clasaelev, a.media mediaelev, "
						+ "b.materie materietema, b.subiect subiecttema, b.punctaj punctajtema, c.idrealizare, "
						+ "c.idteme idteme_1, c.idelevi idelevi_1, c.termen, c.tip , "
						+ "c.format from elevi a, teme b, realizare c where a.idelevi = c.idelevi and b.idteme = c.idteme and idrealizare = '"
						+ID + "';");
						Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
						ResultSet.CONCUR_READ_ONLY);
				rs = stmt.executeQuery(queryString); //sql exception
			} catch (SQLException sqle) {
				System.out.println(sqle.getMessage());
				error = "SQLException: Interogarea nu a fost posibila.";
				throw new SQLException(error);
			} catch (Exception e) {
				error = "A aparut o exceptie in timp ce se extrageau datele.";
				throw new Exception(error);
			}
			return rs;
		} // end of intoarceLinieDupaId()
	 
	/*public void afisare(ResultSet rs) throws ClassNotFoundException, SQLException, Exception{
	int idPacient;
	String Nume, Prenume, Adresa;
	while(rs.next()){
	idPacient = rs.getInt("idPacient");
	Nume = rs.getString("Nume");
	Prenume = rs.getString("Prenume");
	Adresa = rs.getString("Adresa");
	 System.out.println("idPacient = " + idPacient + ", Nume = " + Nume + ", Prenume = " + Prenume + ", Adresa = " + Adresa);
	}
	}
	*/
	
}

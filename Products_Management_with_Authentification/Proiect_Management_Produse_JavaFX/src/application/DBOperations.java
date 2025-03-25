package application;
import java.sql.Connection;
import java.sql.Date;
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
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect3?useSSL=false", "root", "haerin");
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
			String queryString = ("select * from `proiect3`.`" + tabel + "`;");
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
	public void adaugaClient(String Nume, String Prenume,String Adresa, String Email) throws SQLException {
		try {
			// create a prepared SQL statement
			Statement stmt;
			stmt = con.createStatement();
			stmt.executeUpdate("insert into `proiect3`.`clienti`(nume, prenume, adresa, email) values('" + Nume + "', '" + Prenume + 
					"', '" + Adresa +"', '" +Email+ "');");
		} catch (SQLException sqle) {
			error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
			throw new SQLException(error);
		}
	}
	public void adaugaClient(String Nume, String Prenume,String Adresa, String Email,Integer idutilizator) throws SQLException {
		try {
			// create a prepared SQL statement
			Statement stmt;
			stmt = con.createStatement();
			stmt.executeUpdate("insert into `proiect3`.`clienti`(nume, prenume, adresa, email,idutilizator) values('" + Nume + "', '" + Prenume + 
					"', '" + Adresa +"', '" +Email+"', '" +idutilizator+ "');");
		} catch (SQLException sqle) {
			error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
			throw new SQLException(error);
		}
	}
	// end adaugaClient()
	public void adaugaUtilizator(String User, String Parola,String Rol) throws SQLException {
		try {
			// create a prepared SQL statement
			Statement stmt;
			stmt = con.createStatement();
			stmt.executeUpdate("insert into `proiect3`.`utilizatori`(username, parola, rol) values('" + User + "', '" + Parola + 
					"', '" + Rol + "');");
		} catch (SQLException sqle) {
			error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
			throw new SQLException(error);
		}
	}
	public void adaugaComanda(int idfurnizor, int idclient,Date DataComanda, String Status,Double ValoareComanda) throws SQLException {
		try {
			// create a prepared SQL statement
			Statement stmt;
			stmt = con.createStatement();
			stmt.executeUpdate("insert into `proiect3`.`comenzi`(idfurnizor,idclient,dataComanda, status, valoareComanda) values('" + idfurnizor + "', '" + idclient +"', '" + DataComanda + "', '" + Status + 
					"', '" + ValoareComanda+ "');");
		} catch (SQLException sqle) {
			error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
			throw new SQLException(error);
		}
	}

	public void adaugaDistribuitor(int idprodus, int idfurnizor,String Nume, double PretUnitar,int StocDisponibil) throws SQLException {
		try {
			// create a prepared SQL statement
			Statement stmt;
			stmt = con.createStatement();
			stmt.executeUpdate("insert into `proiect3`.`distribuitor`(idprodus,idfurnizor,numeDistribuitor, pretUnitar, stocDisponibil) values('" + idprodus + "', '" + idfurnizor +"', '" + Nume + "', '" + PretUnitar + 
					"', '" + StocDisponibil+ "');");
		} catch (SQLException sqle) {
			error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
			throw new SQLException(error);
		}
	}

	public void adaugaFurnizor(String Nume, String Prenume,String Adresa) throws SQLException {
		try {
			// create a prepared SQL statement
			Statement stmt;
			stmt = con.createStatement();
			stmt.executeUpdate("insert into `proiect3`.`furnizori`(nume, prenume, adresa) values('"+ Nume + "', '" + Prenume + 
					"', '" + Adresa+ "');");
		} catch (SQLException sqle) {
			error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
			throw new SQLException(error);
		}
	}
	public void adaugaFurnizor(String Nume, String Prenume,String Adresa,Integer idutilizator) throws SQLException {
		try {
			// create a prepared SQL statement
			Statement stmt;
			stmt = con.createStatement();
			stmt.executeUpdate("insert into `proiect3`.`furnizori`(nume, prenume, adresa,idutilizator) values('"+ Nume + "', '" + Prenume + 
					"', '" + Adresa+ "', '" + idutilizator+"');");
		} catch (SQLException sqle) {
			error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
			throw new SQLException(error);
		}
	}
	public void adaugaProdus(String Denumire, String Descriere, int Cantitate) throws SQLException {
		try {
			// create a prepared SQL statement
			Statement stmt;
			stmt = con.createStatement();
			stmt.executeUpdate("insert into `proiect3`.`produse`(denumire, descriere, cantitate) values('" + Denumire + "', '" + Descriere +"', '" +Cantitate + "');");
		} catch (SQLException sqle) {
			error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
			throw new SQLException(error);
		}
	}
	public ResultSet vedeTabela(String tabel) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String queryString = ("select * from `proiect3`.`" + tabel + "`;");
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
	public ResultSet vedeComanda() throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String queryString = ("select a.nume numeclient, a.prenume prenumeclient, a.adresa adresa, a.email email, "
					+ "b.nume numefurnizor, b.prenume prenumefurnizor, b.adresa adresafurnizor, c.idcomanda, "
					+ "c.idfurnizor idfurnizorC, c.idclient idclientC, c.datacomanda, c.status , "
					+ "c.valoareComanda from produs a, furnizori b, distribuitor c where a.idclient = c.idclient and b.idfurnizor = c.idfurnizor;");
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
	
	public ResultSet vedeDistribuitor() throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String queryString = ("select a.denumire, a.descriere, a.cantitate ,"
					+ "b.nume numefurnizor, b.prenume prenumefurnizor, b.adresa adresafurnizor, c.idcomanda, "
					+ "c.idprodus idprodusD, c.idfurnizor idfurnizorD, c.numeDistribuitor, c.pretUnitar , "
					+ "c.stocDisponibil from produse a, furnizori b, distribuitor c where a.idprodus = c.idprodus and b.idfurnizor = c.idfurnizor;");
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

	
	public void createUser(String username, String hashedPassword, boolean isAdmin) throws SQLException {
	    String sql = "INSERT INTO utilizatori (username, password, is_admin) VALUES (?, ?, ?)";
	    try (PreparedStatement pstmt = con.prepareStatement(sql)) {
	        pstmt.setString(1, username);
	        pstmt.setString(2, hashedPassword);
	        pstmt.setBoolean(3, isAdmin);
	        pstmt.executeUpdate();
	    }
	}

	public ResultSet getUserByUsername(String username) throws SQLException,Exception {
		ResultSet rs = null;
		try {
			// Executa interogarea
			String queryString = ("SELECT * FROM " + "utilizatori" + " WHERE " + "username " + "= \"" + username
					+ "\";");
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
	}
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

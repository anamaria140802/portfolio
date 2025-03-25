package db;
import java.sql.*;
/**
 *
 * @author AnaD
 */
public class JavaBean {
	String error;
	Connection con;
	public JavaBean() {
	}
	public void connect() throws ClassNotFoundException, SQLException, Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schemax?useSSL=false", 
					"root", "haerin");
		} catch (ClassNotFoundException cnfe) {
			error = "ClassNotFoundException: Nu s-a gasit driverul bazei de date.";
			throw new ClassNotFoundException(error);
		} catch (SQLException cnfe) {
			System.out.println(cnfe.getMessage());
			error = "SQLException: Nu se poate conecta la baza de date.";
			throw new SQLException(error);
		} catch (Exception e) {
			error = "Exception: A aparut o exceptie neprevazuta in timp ce se stabilea legatura la baza de date.";
			throw new Exception(error);
		}
	} // connect()
	public void connect(String bd) throws ClassNotFoundException, SQLException, Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + bd, "root", 
					"haerin");
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
	} // connect(String bd)
	public void connect(String bd, String ip) throws ClassNotFoundException, SQLException, 
	Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + bd, "root", 
					"haerin");
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
	} // connect(String bd, String ip)
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
	public void adaugaElev(String Nume, String Prenume,String Clasa, int Media)
			throws SQLException, Exception {
		if (con != null) {
			try {
				// creaza un "prepared SQL statement"
				Statement stmt;
				stmt = con.createStatement();
				stmt.executeUpdate("insert into elevi(nume, prenume, clasa, media) values('" + Nume
						+ "' , '" + Prenume + "', '" + Clasa + "', '"+Media+"');");
			} catch (SQLException sqle) {
				error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
				throw new SQLException(error);
			}
		} else {
			error = "Exceptie: Conexiunea cu baza de date a fost pierduta.";
			throw new Exception(error);
		}
	} // end of adaugaTema()
	public void adaugaTema(String Materie, String Subiect, int Punctaj)
			throws SQLException, Exception {
		if (con != null) {
			try {
				// creaza un "prepared SQL statement"
				Statement stmt;
				stmt = con.createStatement();
				stmt.executeUpdate("insert into teme(materie, subiect, punctaj) values('" + Materie + 
						"' , '" + Subiect + "', '" + Punctaj + "');");
			} catch (SQLException sqle) {
				System.out.println(sqle);
				error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
				throw new SQLException(error);
			}
		} else {
			error = "Exceptie: Conexiunea cu baza de date a fost pierduta.";
			throw new Exception(error);
		}
	} // end of adaugaRealizare()
	public void adaugaRealizare(int idelevi, int idteme, String termen, String tip, String format  )
					throws SQLException, Exception {
		if (con != null) {
			try {
				// creaza un "prepared SQL statement"
				Statement stmt;
				stmt = con.createStatement();
				stmt.executeUpdate(
						"insert into realizare(idelevi, idteme, termen, tip,"
						+ " format) values('" + idelevi + "' , '" + idteme + "', '" + termen + 
								"', '" + tip+ "', '" +format + "');");
			} catch (SQLException sqle) {
				System.out.println(sqle.getMessage());
				error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
				throw new SQLException(error);
			}
		} else {
			error = "Exceptie: Conexiunea cu baza de date a fost pierduta.";
			throw new Exception(error);
		}
	} // end of adaugaConsultatie()
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
	} // vedeTabela()
	public ResultSet vedeRealizare() throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String queryString = ("select a.nume numeelev, a.prenume prenumeelev, a.clasa clasaelev, a.media mediaelev, "
					+ "b.materie materietema, b.subiect subiecttema, b.punctaj punctajtema, c.idrealizare, "
					+ "c.idelevi idelevi_1, c.idteme idteme_1, c.termen, c.tip , "
					+ "c.format from elevi a, teme b, realizare c where a.idelevi = c.idelevi and b.idteme = c.idteme;");
					Statement stmt = con.createStatement(/*ResultSet.TYPE_SCROLL_INSENSITIVE, 
ResultSet.CONCUR_READ_ONLY*/);
					rs = stmt.executeQuery(queryString);
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
			error = "SQLException: Interogarea nu a fost posibila.";
			throw new SQLException(error);
		} catch (Exception e) {
			error = "A aparut o exceptie in timp ce se extrageau datele.";
			throw new Exception(error);
		}
		return rs;
	} // vedeConsultatie()
	public void stergeDateTabela(String[] primaryKeys, String tabela, String dupaID) throws
	SQLException, Exception {
		if (con != null) {
			try {
				// creaza un "prepared SQL statement"
				long aux;
				PreparedStatement delete;
				delete = con.prepareStatement("DELETE FROM " + tabela + " WHERE " + dupaID + "=?;");
				for (int i = 0; i < primaryKeys.length; i++) {
					aux = java.lang.Long.parseLong(primaryKeys[i]);
					delete.setLong(1, aux);
					delete.execute();
				}
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
	} // end of stergeDateTabela()
	public void stergeTabela(String tabela) throws SQLException, Exception {
		if (con != null) {
			try {
				// creaza un "prepared SQL statement"
				Statement stmt;
				stmt = con.createStatement();
				stmt.executeUpdate("delete from " + tabela + ";");
			} catch (SQLException sqle) {
				error = "ExceptieSQL: Stergere nereusita; este posibil sa existe duplicate.";
				throw new SQLException(error);
			}
		} else {
			error = "Exceptie: Conexiunea cu baza de date a fost pierduta.";
			throw new Exception(error);
		}
	} // end of stergeTabela()
	public void modificaTabela(String tabela, String IDTabela, int ID, String[] campuri, String[] 
			valori) throws SQLException, Exception {
		String update = "update " + tabela + " set ";
		String temp = "";
		if (con != null) {
			try {
				for (int i = 0; i < campuri.length; i++) {
					if (i != (campuri.length - 1)) {
						temp = temp + campuri[i] + "='" + valori[i] + "', ";
					} else {
						temp = temp + campuri[i] + "='" + valori[i] + "' where " + IDTabela + " = '" + ID + "';";
					}
				}
				update = update + temp;
				// creaza un "prepared SQL statement"
				Statement stmt;
				stmt = con.createStatement();
				stmt.executeUpdate(update);
			} catch (SQLException sqle) {
				System.out.println(sqle.getMessage());
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
}
package jdbcLiveCoding.src.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		//
		// Creo il database dipendenti
		// creo la tabella
		// CREATE TABLE dip(
		// id INT PRIMARY KEY,
		//nome VARCHAR(20),
		//cognome VARCHAR(20),
		//stipendio DOUBLE
		// );
		
		
		//aggiungiDipendente(1, "Mario", "Rossi", 1000);
		//aggiungiDipendente(2, "Marco", "Bianchi", 1600);
		//aggiungiDipendenteByPreparedStatement(3, "Giovanna", "Neri", 3000);
		//stampaDipendenti();

		
		eliminaDipendenti(2);
		
		stampaDipendenti();
		stampaSingoloDipendente(3);

	}

	public static void aggiungiDipendente(int id, String nome, String cognome, double stipendio) {
		Connection conn = null;
		Statement stmt = null;

		String url = "jdbc:mysql://localhost:3306/dipendenti";
		String username = "root";
		String password = "";

		try {
			// caricamento del driver relativo a mysql
			// può sollevare un'eccezione di tipo ClassNotFoundException
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Con getConnection creo la connessione
			// I seguenti metodi getConnection, createStatement ed exacuteUpdate()
			// possono lanciare un'eccezione di tipo SQLException
			conn = DriverManager.getConnection(url, username, password);

			// Creazione dello statement
			stmt = conn.createStatement();

			// INSERT INTO dip VALUES (id, "nome", "cognome", stipendio);
			String insert = "INSERT INTO dip VALUES(" + id + ", '" + nome + "', '" + cognome + "', " + stipendio + ");";

			// Eseguo l'inserimento nel db
			int result = stmt.executeUpdate(insert);
			
			// se result > 0 significa che l'inserimento è andato a buon fine
			// result contiene il valore delle righe inserite nella tabella dip del DB
			// dipendenti
			if (result > 0) {
				System.out.println(result);
			} else {
				System.out.println("Problemi durante l'inserimento");
			}

		} catch (ClassNotFoundException e) {
			System.out.println("Classe non trovata");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Eccezione specifica per SQL");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Eccezione generica");
		} finally {

			// Chiusura dello statement
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (SQLException e) {
					System.out.println("Errore durante la chiusura dello Statement");
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
					conn = null;
				} catch (SQLException e) {
					System.out.println("Errore durante la chiusura di Connection");
					e.printStackTrace();
				}
			}
		}

	}
	
	
	public static void aggiungiDipendenteByPreparedStatement(int id, String nome, String cognome, double stipendio) {
		Connection conn = null;
		PreparedStatement stmt = null;

		String url = "jdbc:mysql://localhost:3306/dipendenti";
		String username = "root";
		String password = "";

		try {
			// caricamento del driver relativo a mysql
			// può sollevare un'eccezione di tipo ClassNotFoundException
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Con getConnection creo la connessione
			// I seguenti metodi getConnection, createStatement ed exacuteUpdate()
			// possono lanciare un'eccezione di tipo SQLException
			conn = DriverManager.getConnection(url, username, password);

			stmt = conn.prepareStatement("INSERT INTO dip (id, nome, cognome, stipendio) VALUES (?,?,?,?);");
			
			stmt.setInt(1, id);
			stmt.setString(2, nome);
			stmt.setString(3, cognome);
			stmt.setDouble(4, stipendio);
			
			//effettua l'inserimento in base al preparedStatement scritto precedentemente
			stmt.execute();
			System.out.println("Inserimento effettuato");
			

		} catch (ClassNotFoundException e) {
			System.out.println("Classe non trovata");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Eccezione specifica per SQL");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Eccezione generica");
		} finally {

			// Chiusura dello statement
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (SQLException e) {
					System.out.println("Errore durante la chiusura dello Statement");
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
					conn = null;
				} catch (SQLException e) {
					System.out.println("Errore durante la chiusura di Connection");
					e.printStackTrace();
				}
			}
		}

	}
	
	
	
	public static void eliminaDipendenti(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;

		String url = "jdbc:mysql://localhost:3306/dipendenti";
		String username = "root";
		String password = "";

		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");

			
			conn = DriverManager.getConnection(url, username, password);

			String delete = "DELETE FROM dip WHERE id = ?";
			
			stmt = conn.prepareStatement(delete);
			
			stmt.setInt(1, id);
			stmt.executeUpdate();
			
			

		} catch (ClassNotFoundException e) {
			System.out.println("Classe non trovata");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Eccezione specifica per SQL");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Eccezione generica");
		} finally {

			try {
			if (stmt != null) {
				System.out.println("Chiusura statement");
					stmt.close();
					stmt = null;
				} else {
					System.out.println("Errore durante la chiusura dello Statement");
				}
			if (conn != null) {
				System.out.println("Chiusura connection");
					conn.close();
					conn = null;
				} else {
					System.out.println("Errore durante la chiusura di Connection");

				}
			} catch(SQLException e) {
				System.out.println("Eccezione specifica SQL");
				e.printStackTrace();
			}
		}

	}
	
	
	public static void stampaDipendenti() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String url = "jdbc:mysql://localhost:3306/dipendenti";
		String username = "root";
		String password = "";

		try {
	
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(url, username, password);

			stmt = conn.createStatement();

			//Result Set è simile ad un cursore 
			rs = stmt.executeQuery("SELECT * FROM dip");
			
			//con rs.next() mi sposto di riga in riga sulla tabella del DB
			//con rs.getTipo(indice) leggo il valore associato a quello dell'indice della colonna
			//Le colonne della tabella partono da indice = 1
			while(rs.next()) {
				System.out.println("Dipendente: id=" + rs.getInt(1) + ", nome=" + rs.getString(2) + ", cognome=" + rs.getString(3)
				+ ", stipendio=" + rs.getDouble(4));
			}
		

		} catch (ClassNotFoundException e) {
			System.out.println("Classe non trovata");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Eccezione specifica per SQL");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Eccezione generica");
		} finally {
			
			if(rs != null) {
				try {
					rs.close();
					rs = null;
					System.out.println("Chiusura ResultSet");
				} catch(SQLException e) {
					System.out.println("Errore durante la chiusura di ResultSet");
					e.printStackTrace();
				}
				
				
			}
			

			// Chiusura dello statement
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
					System.out.println("Chiusura dello Statement");
				} catch (SQLException e) {
					System.out.println("Errore durante la chiusura dello Statement");
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
					conn = null;
					System.out.println("Chiusura Connection");
				} catch (SQLException e) {
					System.out.println("Errore durante la chiusura di Connection");
					e.printStackTrace();
				}
			}
		}

	}
	
	public static void stampaSingoloDipendente(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		

		String url = "jdbc:mysql://localhost:3306/dipendenti";
		String username = "root";
		String password = "";

		try {
	
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(url, username, password);

			String query = "SELECT * FROM dip WHERE id = ?";
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, id);
			//metto un oggetto dentro resultset
			rs = stmt.executeQuery();
			
			
			while(rs.next()) {
				System.out.println("Dipendente: id=" + rs.getInt(1) + ", nome=" + rs.getString(2) + ", cognome=" + rs.getString(3)
				+ ", stipendio=" + rs.getDouble(4));
			}
		

		} catch (ClassNotFoundException e) {
			System.out.println("Classe non trovata");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Eccezione specifica per SQL");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Eccezione generica");
		} finally {
			
			if(rs != null) {
				try {
					rs.close();
					rs = null;
					System.out.println("Chiusura ResultSet");
				} catch(SQLException e) {
					System.out.println("Errore durante la chiusura di ResultSet");
					e.printStackTrace();
				}
				
				
			}
			

			// Chiusura dello statement
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
					System.out.println("Chiusura dello Statement");
				} catch (SQLException e) {
					System.out.println("Errore durante la chiusura dello Statement");
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
					conn = null;
					System.out.println("Chiusura Connection");
				} catch (SQLException e) {
					System.out.println("Errore durante la chiusura di Connection");
					e.printStackTrace();
				}
			}
		}

	}

}

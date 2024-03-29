package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {

		// aggiungiDipendente(1, "Mario", "Rossi",1000);
		// aggiungiDipendente(2, "Marco", "Bianchi", 1600);
		// aggiungiDipendenteByPreparedStatement(3, "Giovanna", "Neri", 3000);

		//eliminaDipendenti(2);

		//stampaDipendenti();
		
		stampaSingoloDipendente(3);

	}

	public static void aggiungiDipendente(int id, String nome, String cognome, double stipendio) {

		Connection conn = null;
		Statement stmt = null;

		String url = "jdbc:mysql://localhost:3306/dipendenti";
		String username = "root";
		String password = "";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(url, username, password);

			stmt = conn.createStatement();

			String insert = "INSERT INTO dip VALUES (" + id + ", '" + nome + "', '" + cognome + "', " + stipendio
					+ ");";

			int result = stmt.executeUpdate(insert);

			if (result > 0)
				System.out.println(result);
			else
				System.out.println("Problemi durante l'inserimento");

		} catch (ClassNotFoundException e) {
			System.out.println("Classe non trovata");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Eccezione specifica SQL");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Eccezione generica");
			e.printStackTrace();
		} finally {

			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (SQLException e2) {
					System.out.println("Errore durante la chiusura dello statement");
					e2.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
					conn = null;
				} catch (SQLException e2) {
					System.out.println("Errore durante la chiusura di Connection");
					e2.printStackTrace();
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

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(url, username, password);

			stmt = conn.prepareStatement("INSERT INTO dip (id, nome, cognome, stipendio) VALUES (?, ?, ?, ?);");

			stmt.setInt(1, id);
			stmt.setString(2, nome);
			stmt.setString(3, cognome);
			stmt.setDouble(4, stipendio);

			stmt.execute();
			System.out.println("Inserimento effettuato");

		} catch (ClassNotFoundException e) {
			System.out.println("Classe non trovata");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Eccezione specifica SQL");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Eccezione generica");
			e.printStackTrace();
		} finally {

			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (SQLException e2) {
					System.out.println("Errore durante la chiusura dello statement");
					e2.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
					conn = null;
				} catch (SQLException e2) {
					System.out.println("Errore durante la chiusura di Connection");
					e2.printStackTrace();
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

			rs = stmt.executeQuery("SELECT * FROM dip;");

			while (rs.next()) {

				System.out.println("Dipendente: " + rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getString(3)
						+ ", " + rs.getDouble(4));

			}

		} catch (ClassNotFoundException e) {
			System.out.println("Classe non trovata");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Eccezione specifica SQL");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Eccezione generica");
			e.printStackTrace();
		} finally {

			if (rs != null) {

				try {
					rs.close();
					rs = null;
				} catch (SQLException e2) {
					System.out.println("Errore durante la chiusura del ResultSet");
					e2.printStackTrace();
				}

			}

			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (SQLException e2) {
					System.out.println("Errore durante la chiusura dello statement");
					e2.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
					conn = null;
				} catch (SQLException e2) {
					System.out.println("Errore durante la chiusura di Connection");
					e2.printStackTrace();
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
			
			String query = "SELECT * FROM dip WHERE dip.id = ?";

			stmt = conn.prepareStatement(query);
			
			stmt.setInt(1, id);
			
			rs = stmt.executeQuery();
			
			while (rs.next()) {

				System.out.println("Dipendente: " + rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getString(3)
						+ ", " + rs.getDouble(4));

			}

		} catch (ClassNotFoundException e) {
			System.out.println("Classe non trovata");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Eccezione specifica SQL");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Eccezione generica");
			e.printStackTrace();
		} finally {

			if (rs != null) {

				try {
					rs.close();
					rs = null;
				} catch (SQLException e2) {
					System.out.println("Errore durante la chiusura del ResultSet");
					e2.printStackTrace();
				}

			}

			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (SQLException e2) {
					System.out.println("Errore durante la chiusura dello statement");
					e2.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
					conn = null;
				} catch (SQLException e2) {
					System.out.println("Errore durante la chiusura di Connection");
					e2.printStackTrace();
				}
			}

		}

	}

}

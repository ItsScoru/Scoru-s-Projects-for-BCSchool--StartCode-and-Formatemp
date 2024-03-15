import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        // CREATE DATABASE IF NOT EXISTS studenti;

        // USE DATABASE studenti;

        /*
         * CREATE TABLE studente (
         * matricola INT(8) PRIMARY KEY,
         * nome VARCHAR(32) NOT NULL,
         * cognome VARCHAR(32) NOT NULL,
         * anni INT(4) NOT NULL,
         * data_di_nascita VARCHAR(16) NOT NULL,
         * nome_corso VARCHAR(64) NOT NULL,
         * esami_sostenuti INT(32) NOT NULL
         * );
         */

    }

    public static void aggiungiStudente(int numMatricola, String nome, String cognome, int età,
            String dataDiNascita, String nomeCorso, int esamiSostenuti) {

        Connection conn = null;
        Statement stmt = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(url, username, password);

            stmt = conn.createStatement();

            String insert = "INSERT INTO studente VALUES("
                    + numMatricola + ", '" + nome + "', '" + cognome + "', " + età
                    + ", '" + dataDiNascita + "', '" + nomeCorso + "', " + esamiSostenuti + ");";

        } catch (ClassNotFoundException e) {
            System.out.println("Classe non trovata");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Eccezione specifica per SQL");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Eccezione generica");
        } finally {

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

    public static void stampaStudente(int matricola) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://localhost:3306/dipendenti";
        String username = "root";
        String password = "";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(url, username, password);

            String query = "SELECT * FROM studente WHERE studente.matricola = ?";

            stmt = conn.prepareStatement(query);

            stmt.setInt(1, matricola);

            rs = stmt.executeQuery();

            while (rs.next()) {

                System.out.println("Studente: " + rs.getInt(1) + ", " + rs.getString(2)
                        + ", " + rs.getString(3) + ", " + rs.getInt(4) + ", "
                        + rs.getString(5) + ", " + rs.getString(6) + ", "
                        + rs.getInt(7));

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

    public static void stampaStudenti() {

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

            rs = stmt.executeQuery("SELECT * FROM studente;");

            while (rs.next()) {

                System.out.println("Studente: " + rs.getInt(1) + ", " + rs.getString(2)
                        + ", " + rs.getString(3) + ", " + rs.getInt(4) + ", "
                        + rs.getString(5) + ", " + rs.getString(6) + ", "
                        + rs.getInt(7));

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

    public static void eliminaStudente(int matricola) {

        Connection conn = null;
        PreparedStatement stmt = null;

        String url = "jdbc:mysql://localhost:3306/dipendenti";
        String username = "root";
        String password = "";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(url, username, password);

            String query = "DELETE FROM studente WHERE studente.matricola = ?";

            stmt = conn.prepareStatement(query);

            stmt.setInt(1, matricola);

            stmt.executeQuery();

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

    public static void eliminaAll() {

        Connection conn = null;
        PreparedStatement stmt = null;

        String url = "jdbc:mysql://localhost:3306/dipendenti";
        String username = "root";
        String password = "";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(url, username, password);

            stmt = conn.prepareStatement("DELETE FROM studente");

            stmt.executeQuery();

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

    public static void aggiornaStudente(String nomeDaModificare, String cognomeDaModificare, int numMatricola,
            String nome, String cognome, int età, String dataDiNascita, String nomeCorso, int esamiSostenuti) {

        Connection conn = null;
        Statement stmt = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(url, username, password);

            stmt = conn.createStatement();

            String insert = "UPDATE studente SET studente.matricola = " + numMatricola
                    + ", studente.nome = '" + nome + "', studente.cognome =  '" + cognome
                    + "', studente.anni = " + età + ", studente.data_di_nascita = '" + dataDiNascita
                    + "', studente.nome_corso = '" + nomeCorso
                    + "', studente.esammi_sostenuti = " + esamiSostenuti
                    + " WHERE studente.nome LIKE '" + nomeDaModificare
                    + "' AND studente.cognome LIKE '" + cognomeDaModificare + "';";

        } catch (ClassNotFoundException e) {
            System.out.println("Classe non trovata");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Eccezione specifica per SQL");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Eccezione generica");
        } finally {

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

    public static void aggiornaStudenteByMatricola(int matricolaStudenteDaModificare, int numMatricola, String nome,
            String cognome, int età, String dataDiNascita, String nomeCorso, int esamiSostenuti) {

        Connection conn = null;
        Statement stmt = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(url, username, password);

            stmt = conn.createStatement();

            String insert = "UPDATE studente SET studente.matricola = " + numMatricola
                    + ", studente.nome = '" + nome + "', studente.cognome =  '" + cognome
                    + "', studente.anni = " + età + ", studente.data_di_nascita = '" + dataDiNascita
                    + "', studente.nome_corso = '" + nomeCorso
                    + "', studente.esammi_sostenuti = " + esamiSostenuti
                    + " WHERE studente.matricola = " + matricolaStudenteDaModificare + ";";

        } catch (ClassNotFoundException e) {
            System.out.println("Classe non trovata");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Eccezione specifica per SQL");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Eccezione generica");
        } finally {

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

}

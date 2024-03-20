package entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table
public class Partecipante {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nome;

    @Column
    private String cognome;

    @Column
    private int eta;

    @ManyToOne
    @JoinColumn(name = "nome_gioco", referencedColumnName = "nome")
    private GiocoDaTavolo ttg;

    public Partecipante() {
        super();
    }

    public Partecipante(int id, String nome, String cognome, int eta) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
    }

    public Partecipante(int id, String nome, String cognome, int eta, GiocoDaTavolo ttg) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.ttg = ttg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public GiocoDaTavolo getTtg() {
        return ttg;
    }

    public void setTtg(GiocoDaTavolo ttg) {
        this.ttg = ttg;
    }

    @Override
    public String toString() {
        return "Partecipante [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + ", ttg=" + ttg
                + "]";
    }
    
}

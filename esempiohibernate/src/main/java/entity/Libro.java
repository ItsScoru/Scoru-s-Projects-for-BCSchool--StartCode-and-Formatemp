package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Libro {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String titolo;

    @Column
    private String descrizione;

    @ManyToOne
    @JoinColumn(name = "id_autore")
    private Autore autore;

    public Libro() {
        super();
    }

    public Libro(Integer id, String titolo, String descrizione, Autore autore) {
        this.id = id;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.autore = autore;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Autore getAutore() {
        return autore;
    }

    public void setAutore(Autore autore) {
        this.autore = autore;
    }

    @Override
    public String toString() {
        return "Libro [id=" + id + ", titolo=" + titolo + ", descrizione=" + descrizione + ", autore=" + autore + "]";
    }
    
}

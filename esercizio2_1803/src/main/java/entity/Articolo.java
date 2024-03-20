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
public class Articolo {

    @Id
    @Column(name = "codice_articolo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codArt;

    @Column
    private String descrizione;

    @ManyToOne
    @JoinColumn(name = "fam_assort", referencedColumnName = "id")
    private FamAssort famAssort;

    @ManyToOne
    @JoinColumn(name = "id_iva", referencedColumnName = "id")
    private Iva idIva;

    public Articolo() {
        super();
    }

    public Articolo(int codArt, String descrizione) {
        this.codArt = codArt;
        this.descrizione = descrizione;
    }

    public Articolo(int codArt, String descrizione, FamAssort famAssort, Iva idIva) {
        this.codArt = codArt;
        this.descrizione = descrizione;
        this.famAssort = famAssort;
        this.idIva = idIva;
    }

    public int getCodArt() {
        return codArt;
    }

    public void setCodArt(int codArt) {
        this.codArt = codArt;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public FamAssort getFamAssort() {
        return famAssort;
    }

    public void setFamAssort(FamAssort famAssort) {
        this.famAssort = famAssort;
    }

    public Iva getIdIva() {
        return idIva;
    }

    public void setIdIva(Iva idIva) {
        this.idIva = idIva;
    }

    @Override
    public String toString() {
        return "Articolo [codArt=" + codArt + ", descrizione=" + descrizione + "]";
    }
    
}

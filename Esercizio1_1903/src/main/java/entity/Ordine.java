package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class Ordine {

    @Id
    @Column(name = "id_ordine")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "data_richiesta")
    @Temporal(TemporalType.DATE)
    private Date dataRichiesta;

    @Column(name = "prezzo_totale")
    private int prezzoTotale;

    @Column(name = "numero_articoli")
    private int numeroArticoli;

    @ManyToOne
    @JoinColumn(name = "id_acquirente", referencedColumnName = "id_acquirente")
    private Acquirente acquirente;

    public Ordine() {
        super();
    }

    public Ordine(int id, Date dataRichiesta, int prezzoTotale, int numeroArticoli, Acquirente acquirente) {
        this.id = id;
        this.dataRichiesta = dataRichiesta;
        this.prezzoTotale = prezzoTotale;
        this.numeroArticoli = numeroArticoli;
        this.acquirente = acquirente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataRichiesta() {
        return dataRichiesta;
    }

    public void setDataRichiesta(Date dataRichiesta) {
        this.dataRichiesta = dataRichiesta;
    }

    public int getPrezzoTotale() {
        return prezzoTotale;
    }

    public void setPrezzoTotale(int prezzoTotale) {
        this.prezzoTotale = prezzoTotale;
    }

    public int getNumeroArticoli() {
        return numeroArticoli;
    }

    public void setNumeroArticoli(int numeroArticoli) {
        this.numeroArticoli = numeroArticoli;
    }

    public Acquirente getAcquirente() {
        return acquirente;
    }

    public void setAcquirente(Acquirente acquirente) {
        this.acquirente = acquirente;
    }

    @Override
    public String toString() {
        return "Ordine [id=" + id + ", dataRichiesta=" + dataRichiesta + ", prezzoTotale=" + prezzoTotale
                + ", numeroArticoli=" + numeroArticoli + ", acquirente=" + acquirente + "]";
    }

}

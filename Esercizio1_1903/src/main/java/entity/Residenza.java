package entity;

import javax.persistence.Embeddable;

@Embeddable
public class Residenza {

    private String indirizzo;

    private int cap;

    private String citta;

    public Residenza() {
        super();
    }

    public Residenza(String indirizzo, int cap, String citta) {
        this.indirizzo = indirizzo;
        this.cap = cap;
        this.citta = citta;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    @Override
    public String toString() {
        return "Residenza [indirizzo=" + indirizzo + ", cap=" + cap + ", citta=" + citta + "]";
    }

}

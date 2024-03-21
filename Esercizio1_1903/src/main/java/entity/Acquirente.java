package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Acquirente {

    @Id
    @Column(name = "codice_fiscale")
    private String codiceFiscale;

    private String nome;

    private String cognome;

    private String tel;

    @Embedded
    private Residenza residenza;

    @OneToMany(mappedBy = "acquirente", cascade = CascadeType.ALL)
    private List<Ordine> listaOrdini;

    public Acquirente() {
        super();
        this.listaOrdini = new ArrayList<>();
    }

    public Acquirente(String codiceFiscale, String nome, String cognome, String tel, Residenza residenza) {
        this.codiceFiscale = codiceFiscale;
        this.nome = nome;
        this.cognome = cognome;
        this.tel = tel;
        this.residenza = residenza;
        this.listaOrdini = new ArrayList<>();
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Residenza getResidenza() {
        return residenza;
    }

    public void setResidenza(Residenza residenza) {
        this.residenza = residenza;
    }

    public List<Ordine> getListaOrdini() {
        return listaOrdini;
    }

    public void setListaOrdini(List<Ordine> listaOrdini) {
        this.listaOrdini = listaOrdini;
    }

    @Override
    public String toString() {
        return "Acquirente [codiceFiscale=" + codiceFiscale + ", nome=" + nome + ", cognome=" + cognome + ", tel=" + tel
                + ", residenza=" + residenza + "]";
    }

}

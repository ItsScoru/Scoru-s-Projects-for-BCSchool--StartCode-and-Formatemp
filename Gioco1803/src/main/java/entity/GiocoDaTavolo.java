package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class GiocoDaTavolo {

    @Id
    @Column
    private String nome;

    @Column(name = "casa_produttrice")
    private String casaProduttrice;

    @Column(name = "num_min_giocatori")
    private int numeroMinGiocatori;

    @Column(name = "num_max_giocatori")
    private int numeroMacGiocatori;

    @Column(name = "eta_minima")
    private int etaMinima;

    @OneToMany(mappedBy = "ttg", cascade = CascadeType.ALL)
    List<Partecipante> listaGiocatori;

    public GiocoDaTavolo() {
        super();
        this.listaGiocatori = new ArrayList<>();
    }

    public GiocoDaTavolo(String nome, String casaProduttrice, int numeroMinGiocatori, int numeroMacGiocatori,
            int etaMinima) {
        this.nome = nome;
        this.casaProduttrice = casaProduttrice;
        this.numeroMinGiocatori = numeroMinGiocatori;
        this.numeroMacGiocatori = numeroMacGiocatori;
        this.etaMinima = etaMinima;
        this.listaGiocatori = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCasaProduttrice() {
        return casaProduttrice;
    }

    public void setCasaProduttrice(String casaProduttrice) {
        this.casaProduttrice = casaProduttrice;
    }

    public int getNumeroMinGiocatori() {
        return numeroMinGiocatori;
    }

    public void setNumeroMinGiocatori(int numeroMinGiocatori) {
        this.numeroMinGiocatori = numeroMinGiocatori;
    }

    public int getNumeroMacGiocatori() {
        return numeroMacGiocatori;
    }

    public void setNumeroMacGiocatori(int numeroMacGiocatori) {
        this.numeroMacGiocatori = numeroMacGiocatori;
    }

    public int getEtaMinima() {
        return etaMinima;
    }

    public void setEtaMinima(int etaMinima) {
        this.etaMinima = etaMinima;
    }

    public List<Partecipante> getListaGiocatori() {
        return listaGiocatori;
    }

    public void setListaGiocatori(List<Partecipante> listaGiocatori) {
        this.listaGiocatori = listaGiocatori;
    }

    @Override
    public String toString() {
        return "GiocoDaTavolo [nome=" + nome + ", casaProduttrice=" + casaProduttrice + ", numeroMinGiocatori="
                + numeroMinGiocatori + ", numeroMacGiocatori=" + numeroMacGiocatori + ", etaMinima=" + etaMinima + "]";
    }
    
}

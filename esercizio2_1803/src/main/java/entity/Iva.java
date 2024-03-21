package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Iva {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String descrizione;

    @Column
    private double aliquota;

    @OneToMany
    @JoinColumn(name = "id_iva")
    private List<Articolo> listaArticoli;

    public Iva() {
        super();
    }

    public Iva(int id, String descrizione, double aliquota) {
        this.id = id;
        this.descrizione = descrizione;
        this.aliquota = aliquota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public double getAliquota() {
        return aliquota;
    }

    public void setAliquota(double aliquota) {
        this.aliquota = aliquota;
    }

    public List<Articolo> getListaArticoli() {
        return listaArticoli;
    }

    public void setListaArticoli(List<Articolo> listaArticoli) {
        this.listaArticoli = listaArticoli;
    }

    @Override
    public String toString() {
        return "Iva [id=" + id + ", descrizione=" + descrizione + ", aliquota=" + aliquota + "]";
    }
    
}

package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Iva {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idIva;

    @Column
    private String descrizione;

    @Column
    private double aliquota;

    @OneToMany(mappedBy = "cod_articoli")
    private List<Articolo> listaArticoli;

    public Iva() {
        super();
    }

    public Iva(int idIva, String descrizione, double aliquota) {
        this.idIva = idIva;
        this.descrizione = descrizione;
        this.aliquota = aliquota;
    }

    public Iva(int idIva, String descrizione, double aliquota, List<Articolo> listaArticoli) {
        this.idIva = idIva;
        this.descrizione = descrizione;
        this.aliquota = aliquota;
        this.listaArticoli = listaArticoli;
    }

    public int getIdIva() {
        return idIva;
    }

    public void setIdIva(int idIva) {
        this.idIva = idIva;
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
        return "Iva [idIva=" + idIva + ", descrizione=" + descrizione + ", aliquota=" + aliquota + "]";
    }
    
}

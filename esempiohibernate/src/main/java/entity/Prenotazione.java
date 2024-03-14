package entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Prenotazione {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_cliente")
    private Integer idCliente;

    @OneToOne
    @JoinColumn(name = "id_libro")
    private Integer idLibro;

    @Column
    private Date dataInizio;

    @Column
    private Date dataFine;

    public Prenotazione() {
        super();
    }

    public Prenotazione(Integer id, Integer idCliente, Integer idLibro, Date dataInizio, Date dataFine) {
        this.id = id;
        this.idCliente = idCliente;
        this.idLibro = idLibro;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public Date getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(Date dataInizio) {
        this.dataInizio = dataInizio;
    }

    public Date getDataFine() {
        return dataFine;
    }

    public void setDataFine(Date dataFine) {
        this.dataFine = dataFine;
    }

    @Override
    public String toString() {
        return "Prenotazione [id=" + id + ", idCliente=" + idCliente + ", idLibro=" + idLibro + ", dataInizio="
                + dataInizio + ", dataFine=" + dataFine + "]";
    }
    
}

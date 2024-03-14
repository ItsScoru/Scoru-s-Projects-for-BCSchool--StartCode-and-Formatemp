package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "codice_fiscale")
public class CodiceFiscale {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String cf;

    public CodiceFiscale() {
        super();
    }

    public CodiceFiscale(Integer id, String cf) {
        this.id = id;
        this.cf = cf;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    @Override
    public String toString() {
        return "CodiceFiscale [id=" + id + ", cf=" + cf + "]";
    }
    
}

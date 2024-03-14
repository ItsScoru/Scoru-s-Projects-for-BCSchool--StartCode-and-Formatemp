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
public class Autore {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nome;

    @Column
    private String cognome;

    @OneToMany(mappedBy = "autore")
    List<Libro> Libri;

    public Autore() {
        super();
    }

    public Autore(Integer id, String nome, String cognome) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
    }

    public Autore(Integer id, String nome, String cognome, List<Libro> libri) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        Libri = libri;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<Libro> getLibri() {
        return Libri;
    }

    public void setLibri(List<Libro> libri) {
        Libri = libri;
    }

    @Override
    public String toString() {
        return "Autore [id=" + id + ", nome=" + nome + ", cognome=" + cognome + "]";
    }

    

}
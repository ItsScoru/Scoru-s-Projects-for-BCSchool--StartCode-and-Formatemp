package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Corso {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String descrizione;
	
	@Column
	private String denominazione;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "corso_studente", joinColumns = @JoinColumn(name = "id_corso", referencedColumnName = "Id"),
	inverseJoinColumns = @JoinColumn(name = "id_studente", referencedColumnName = "Id"))
	private List<Studente> listaStudenti;

	public Corso() {
		super();
	}

	public Corso(Integer id, String descrizione, String denominazione) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.denominazione = denominazione;
	}

	public Corso(Integer id, String descrizione, String denominazione, List<Studente> listaStudenti) {
		this.id = id;
		this.descrizione = descrizione;
		this.denominazione = denominazione;
		this.listaStudenti = listaStudenti;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getDenominazione() {
		return denominazione;
	}

	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}

	public List<Studente> getListaStudenti() {
		return listaStudenti;
	}

	public void setListaStudenti(List<Studente> listaStudenti) {
		this.listaStudenti = listaStudenti;
	}

	@Override
	public String toString() {
		return "Corso [id=" + id + ", descrizione=" + descrizione + ", denominazione=" + denominazione + "]";
	}

}

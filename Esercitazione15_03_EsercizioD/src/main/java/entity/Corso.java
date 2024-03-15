package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	public Corso() {
		super();
	}

	public Corso(Integer id, String descrizione, String denominazione) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.denominazione = denominazione;
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

	@Override
	public String toString() {
		return "Corso [id=" + id + ", descrizione=" + descrizione + ", denominazione=" + denominazione + "]";
	}

}

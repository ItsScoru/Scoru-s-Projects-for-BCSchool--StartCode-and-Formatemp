package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class RichiestaFerie {
	
	@Id
	@Column
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "data_creazione")
	private String dataCreazione;
	
	@Column(name = "data_modifica")
	private String dataModifica;
	
	@Column(name = "email_aziendale")
	private String emailAziendale;
	
	@Column(name = "data_inizio")
	private String giornoInizio;
	
	@Column(name = "data_fine")
	private String giornoFine;
	
	@Column
	private String motivazione;
	
	@Column
	private String stato;
	
	@Column(name = "motivazione_rifiuto")
	private String motivazioneRifiuto;

	public RichiestaFerie() {
		super();
	}

	public RichiestaFerie(Integer id, String dataCreazione, String dataModifica, String emailAziendale, String giornoInizio,
			String giornoFine, String motivazione, String stato, String motivazioneRifiuto) {
		super();
		this.id = id;
		this.dataCreazione = dataCreazione;
		this.dataModifica = dataModifica;
		this.emailAziendale = emailAziendale;
		this.giornoInizio = giornoInizio;
		this.giornoFine = giornoFine;
		this.motivazione = motivazione;
		this.stato = stato;
		this.motivazioneRifiuto = motivazioneRifiuto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(String dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public String getDataModifica() {
		return dataModifica;
	}

	public void setDataModifica(String dataModifica) {
		this.dataModifica = dataModifica;
	}

	public String getEmailAziendale() {
		return emailAziendale;
	}

	public void setEmailAziendale(String emailAziendale) {
		this.emailAziendale = emailAziendale;
	}

	public String getGiornoInizio() {
		return giornoInizio;
	}

	public void setGiornoInizio(String giornoInizio) {
		this.giornoInizio = giornoInizio;
	}

	public String getGiornoFine() {
		return giornoFine;
	}

	public void setGiornoFine(String giornoFine) {
		this.giornoFine = giornoFine;
	}

	public String getMotivazione() {
		return motivazione;
	}

	public void setMotivazione(String motivazione) {
		this.motivazione = motivazione;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getMotivazioneRifiuto() {
		return motivazioneRifiuto;
	}

	public void setMotivazioneRifiuto(String motivazioneRifiuto) {
		this.motivazioneRifiuto = motivazioneRifiuto;
	}

	@Override
	public String toString() {
		return "RichiestaFerie [id=" + id + ", dataCreazione=" + dataCreazione + ", dataModifica=" + dataModifica
				+ ", emailAziendale=" + emailAziendale + ", giornoInizio=" + giornoInizio + ", giornoFine=" + giornoFine
				+ ", motivazione=" + motivazione + ", stato=" + stato + ", motivazioneRifiuto=" + motivazioneRifiuto
				+ "]";
	}

}

package entity;

import javax.persistence.Embeddable;

@Embeddable
public class Indirizzo {
	
	private String via;
	
	private String citta;
	
	private String stato;
	
	private int cap;

	public Indirizzo(String via, String citta, String stato, int cap) {
		super();
		this.via = via;
		this.citta = citta;
		this.stato = stato;
		this.cap = cap;
	}

	public Indirizzo() {
		super();
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public int getCap() {
		return cap;
	}

	public void setCap(int cap) {
		this.cap = cap;
	}

	@Override
	public String toString() {
		return "Indirizzo [via=" + via + ", citta=" + citta + ", stato=" + stato + ", cap=" + cap + "]";
	}

}

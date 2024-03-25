package entity;

import javax.persistence.Embeddable;

@Embeddable
public class Ubicazione {
	
	private String indirizzo;
	
	private String città;
	
	private int cap;

	public Ubicazione() {
		super();
	}

	public Ubicazione(String indirizzo, String città, int cap) {
		super();
		this.indirizzo = indirizzo;
		this.città = città;
		this.cap = cap;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCittà() {
		return città;
	}

	public void setCittà(String città) {
		this.città = città;
	}

	public int getCap() {
		return cap;
	}

	public void setCap(int cap) {
		this.cap = cap;
	}

	@Override
	public String toString() {
		return "Ubicazione [indirizzo=" + indirizzo + ", città=" + città + ", cap=" + cap + "]";
	}

}

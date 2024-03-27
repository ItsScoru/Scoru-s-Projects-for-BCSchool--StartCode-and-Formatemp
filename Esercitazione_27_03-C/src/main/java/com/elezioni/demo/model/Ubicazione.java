package com.elezioni.demo.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Ubicazione {

	private String sede;

	private String città;

	private String provincia;

	private String regione;

	public Ubicazione() {
		super();
	}

	public Ubicazione(String sede, String città, String provincia, String regione) {
		super();
		setSede(sede);
		setCittà(città);
		setProvincia(provincia);
		setRegione(regione);
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public String getCittà() {
		return città;
	}

	public void setCittà(String città) {
		this.città = città;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getRegione() {
		return regione;
	}

	public void setRegione(String regione) {
		this.regione = regione;
	}

	@Override
	public String toString() {
		return "Ubicazione [sede=" + sede + ", città=" + città + ", provincia=" + provincia + ", regione=" + regione
				+ "]";
	}

}

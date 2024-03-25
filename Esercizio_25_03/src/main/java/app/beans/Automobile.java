package app.beans;

import java.util.Objects;

public class Automobile {
	
	private String marca;
	
	private Motore motore;

	public Automobile() {
		super();
	}
	
	public Automobile(Motore motore) {
		super();
		this.motore = motore;
	}

	public Automobile(String marca, Motore motore) {
		super();
		this.marca = marca;
		this.motore = motore;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Motore getMotore() {
		return motore;
	}

	public void setMotore(Motore motore) {
		this.motore = motore;
	}

	@Override
	public int hashCode() {
		return Objects.hash(marca, motore);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Automobile other = (Automobile) obj;
		return Objects.equals(marca, other.marca) && Objects.equals(motore, other.motore);
	}

	@Override
	public String toString() {
		return "Automobile [marca=" + marca + ", motore=" + motore + "]";
	}

}

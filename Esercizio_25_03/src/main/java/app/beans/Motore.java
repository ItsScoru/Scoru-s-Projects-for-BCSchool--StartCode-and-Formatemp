package app.beans;

import java.util.Objects;

public class Motore {
	
	private String tipo;
	
	public Motore() {
		super();
	}

	public Motore(String tipo) {
		super();
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Motore other = (Motore) obj;
		return Objects.equals(tipo, other.tipo);
	}

	@Override
	public String toString() {
		return "Motore [tipo=" + tipo + "]";
	}

}

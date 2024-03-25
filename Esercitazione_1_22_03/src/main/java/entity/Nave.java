package entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Nave {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codice;
	
	@Column
	private String nome;
	
	@Column
	private String propulsione;
	
	@Column
	private int numeroScialuppe;
	
	@OneToOne(mappedBy = "nave", cascade = CascadeType.ALL)
	private Capitano capitano;

	public Nave() {
		super();
	}

	public Nave(String nome, String propulsione, int numeroScialuppe) {
		super();
		this.nome = nome;
		this.propulsione = propulsione;
		this.numeroScialuppe = numeroScialuppe;
	}

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPropulsione() {
		return propulsione;
	}

	public void setPropulsione(String propulsione) {
		this.propulsione = propulsione;
	}

	public int getNumeroScialuppe() {
		return numeroScialuppe;
	}

	public void setNumeroScialuppe(int numeroScialuppe) {
		this.numeroScialuppe = numeroScialuppe;
	}

	public Capitano getCapitano() {
		return capitano;
	}

	public void setCapitano(Capitano capitano) {
		this.capitano = capitano;
	}

	@Override
	public String toString() {
		return "Nave [codice=" + codice + ", nome=" + nome + ", propulsione=" + propulsione + ", numeroScialuppe="
				+ numeroScialuppe + ", capitano=" + capitano + "]";
	}

}

package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Stadio {
	
	@Id
	@Column(name = "nome")
	private String nome;
	
	@Column
	private int capienza;
	
	@Column
	private String tipo;
	
	@Embedded
	private Ubicazione ubicazione;
	
	@OneToMany(mappedBy = "stadio", cascade = CascadeType.ALL)
	private List<Partita> partite;

	public Stadio() {
		super();
		this.partite = new ArrayList<>();
	}

	public Stadio(String nome, int capienza, String tipo) {
		super();
		this.nome = nome;
		this.capienza = capienza;
		this.tipo = tipo;
		this.partite = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCapienza() {
		return capienza;
	}

	public void setCapienza(int capienza) {
		this.capienza = capienza;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Ubicazione getUbicazione() {
		return ubicazione;
	}

	public void setUbicazione(Ubicazione ubicazione) {
		this.ubicazione = ubicazione;
	}

	public List<Partita> getPartite() {
		return partite;
	}

	public void setPartite(List<Partita> partite) {
		this.partite = partite;
	}

	@Override
	public String toString() {
		return "Stadio [nome=" + nome + ", capienza=" + capienza + ", tipo=" + tipo + "]";
	}

}

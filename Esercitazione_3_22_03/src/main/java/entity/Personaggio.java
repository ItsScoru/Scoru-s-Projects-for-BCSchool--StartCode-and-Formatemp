package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table
@SecondaryTable(name = "dettagli_personaggio", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id"))
public class Personaggio {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nome;
	
	@Column
	private int età;
	
	@Column(table = "dettagli_personaggio")
	private String inventario;
	
	@Column(table = "dettagli_personaggio")
	private String fazione;
	
	@Column(table = "dettagli_personaggio")
	private String razza;
	
	@ManyToOne
	@JoinColumn
	private Videogioco videogioco;

	public Personaggio() {
		super();
	}

	public Personaggio(String nome, int età, String inventario, String fazione, String razza) {
		super();
		this.nome = nome;
		this.età = età;
		this.inventario = inventario;
		this.fazione = fazione;
		this.razza = razza;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getEtà() {
		return età;
	}

	public void setEtà(int età) {
		this.età = età;
	}

	public String getInventario() {
		return inventario;
	}

	public void setInventario(String inventario) {
		this.inventario = inventario;
	}

	public String getFazione() {
		return fazione;
	}

	public void setFazione(String fazione) {
		this.fazione = fazione;
	}

	public String getRazza() {
		return razza;
	}

	public void setRazza(String razza) {
		this.razza = razza;
	}

	public Videogioco getVideogioco() {
		return videogioco;
	}

	public void setVideogioco(Videogioco videogioco) {
		this.videogioco = videogioco;
	}

	@Override
	public String toString() {
		return "Personaggio [id=" + id + ", nome=" + nome + ", età=" + età + ", inventario=" + inventario + ", fazione="
				+ fazione + ", razza=" + razza + "]";
	}

}

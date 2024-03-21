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
@SecondaryTable(name = "attrazioni_parco", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id"))
public class Parco {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nome;
	
	@Column
	private int ettari;
	
	@Column(name = "numero_alberi")
	private int numeroAlberi;
	
	@Column(table = "attrazioni_parco")
	private boolean lago;
	
	@Column(table = "attrazioni_parco")
	private boolean velodromo;
	
	@Column(name = "parco_giochi", table = "attrazioni_parco")
	private boolean parcoGiochi;
	
	@Column(table = "attrazioni_parco")
	private boolean zoo;
	
	@Column(name = "campo_bocce", table = "attrazioni_parco")
	private boolean campoBocce;
	
	@Column(name = "campo_golf", table = "attrazioni_parco")
	private boolean campoGolf;
	
	@Column(name = "giardino_botanico", table = "attrazioni_parco")
	private boolean giardinoBotanico;
	
	@ManyToOne
	@JoinColumn(name = "parco", referencedColumnName = "id")
	private Città città;

	public Parco() {
		super();
	}

	public Parco(int id, String nome, int ettari, int numeroAlberi) {
		super();
		this.id = id;
		this.nome = nome;
		this.ettari = ettari;
		this.numeroAlberi = numeroAlberi;
	}

	public Parco(int id, String nome, int ettari, int numeroAlberi, boolean lago, boolean velodromo,
			boolean parcoGiochi, boolean zoo, boolean campoBocce, boolean campoGolf, boolean giardinoBotanico,
			Città città) {
		super();
		this.id = id;
		this.nome = nome;
		this.ettari = ettari;
		this.numeroAlberi = numeroAlberi;
		this.lago = lago;
		this.velodromo = velodromo;
		this.parcoGiochi = parcoGiochi;
		this.zoo = zoo;
		this.campoBocce = campoBocce;
		this.campoGolf = campoGolf;
		this.giardinoBotanico = giardinoBotanico;
		this.città = città;
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

	public int getEttari() {
		return ettari;
	}

	public void setEttari(int ettari) {
		this.ettari = ettari;
	}

	public int getNumeroAlberi() {
		return numeroAlberi;
	}

	public void setNumeroAlberi(int numeroAlberi) {
		this.numeroAlberi = numeroAlberi;
	}

	public boolean isLago() {
		return lago;
	}

	public void setLago(boolean lago) {
		this.lago = lago;
	}

	public boolean isVelodromo() {
		return velodromo;
	}

	public void setVelodromo(boolean velodromo) {
		this.velodromo = velodromo;
	}

	public boolean isParcoGiochi() {
		return parcoGiochi;
	}

	public void setParcoGiochi(boolean parcoGiochi) {
		this.parcoGiochi = parcoGiochi;
	}

	public boolean isZoo() {
		return zoo;
	}

	public void setZoo(boolean zoo) {
		this.zoo = zoo;
	}

	public boolean isCampoBocce() {
		return campoBocce;
	}

	public void setCampoBocce(boolean campoBocce) {
		this.campoBocce = campoBocce;
	}

	public boolean isCampoGolf() {
		return campoGolf;
	}

	public void setCampoGolf(boolean campoGolf) {
		this.campoGolf = campoGolf;
	}

	public boolean isGiardinoBotanico() {
		return giardinoBotanico;
	}

	public void setGiardinoBotanico(boolean giardinoBotanico) {
		this.giardinoBotanico = giardinoBotanico;
	}

	public Città getCittà() {
		return città;
	}

	public void setCittà(Città città) {
		this.città = città;
	}

	@Override
	public String toString() {
		return "Parco [id=" + id + ", nome=" + nome + ", ettari=" + ettari + ", numeroAlberi=" + numeroAlberi
				+ ", lago=" + lago + ", velodromo=" + velodromo + ", parcoGiochi=" + parcoGiochi + ", zoo=" + zoo
				+ ", campoBocce=" + campoBocce + ", campoGolf=" + campoGolf + ", giardinoBotanico=" + giardinoBotanico
				+ ", città=" + città + "]";
	}

}

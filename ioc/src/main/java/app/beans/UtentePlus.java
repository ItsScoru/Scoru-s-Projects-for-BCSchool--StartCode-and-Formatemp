package app.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

public class UtentePlus {
	
	private String nickname;
	
	@Resource(name = "rapida")
	private Connessione connessione;
	
	public UtentePlus() {
		super();
	}
	
	public UtentePlus(String nickname, Connessione connessione) {
		this.nickname = nickname;
		this.connessione = connessione;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Connessione getConnessione() {
		return connessione;
	}

	public void setConnessione(Connessione connessione) {
		this.connessione = connessione;
	}
	
	@PostConstruct
	public void metodoPostConstructor() {
		System.out.println("Bean utentePlus appena creato");
	}
	
	@PreDestroy
	public void metodoPreDestroy() {
		System.out.println("Bean utentePlus  sta per essere distrutto");
	}
	
	public String connettiti() {
		return this.nickname + " " + connessione.login();
	}

}

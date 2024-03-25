package app.beans;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

public class UtentePlus {

	private String nickname;

	//@Resource(name = "rapida")
	private Connessione connessione;

	public UtentePlus() {
		super();
	}

	public UtentePlus(String nickname, Connessione connessione) {
		super();
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

	@Resource(name = "rapida")
	public void setConnessione(Connessione connessione) {
		this.connessione = connessione;
	}

	public String connettiti() {
		return this.nickname + " " + connessione.login();
	}
	
	@PostConstruct
	public void metodoPostConstruct() {
		System.out.println("Bean UtentePlus appena creato");
		this.setNickname("Renato");
	}

}

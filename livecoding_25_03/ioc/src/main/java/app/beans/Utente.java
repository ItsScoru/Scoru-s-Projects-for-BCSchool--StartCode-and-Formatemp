package app.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;

public class Utente {

	private String nickname;

//	@Qualifier("base")
//	@Autowired
	private Connessione connessione;

	public Utente() {
		super();
	}

	public Utente(String nickname, Connessione connessione) {
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

	@Lazy
	@Resource(name = "base")
	public void setConnessione(Connessione connessione) {
		this.connessione = connessione;
	}

	@PostConstruct
	public void metodoPostConstruct() {
		System.out.println("Bean Utente appena creato");
		this.setNickname("prova");
	}
	
	@PreDestroy
	public void metodoPreDestroy() {
		System.out.println("Bean Utente sta per essere distrutto");
		this.connessione = null;
		System.out.println("La connessione è stata interrotta");
		System.out.println("valore della connessione: " + this.connessione);
	}
	

	public String connettiti() {
		return this.nickname + " " + connessione.login();
	}

}

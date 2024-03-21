package app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import app.beans.Utente;
import app.beans.UtentePlus;

@Configuration
@Import(ConnessioneConf.class)
public class Config {
	
	@Bean
	public Utente utente() {
		return new Utente();
	}
	
	@Bean
	public UtentePlus utentePlus() {
		return new UtentePlus();
	}

}

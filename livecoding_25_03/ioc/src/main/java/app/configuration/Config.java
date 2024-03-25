package app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;

import app.beans.Utente;
import app.beans.UtentePlus;

@Configuration
@Import(ConnessionConf.class)
public class Config {
	
	@Lazy
	@Bean
	public Utente utente() {
		return new Utente();
	}
	
	
	@Bean
	public UtentePlus utentePlus() {
		return new UtentePlus();
	}
	

}

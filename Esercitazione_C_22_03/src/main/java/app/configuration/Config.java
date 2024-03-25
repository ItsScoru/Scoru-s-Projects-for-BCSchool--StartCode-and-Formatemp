package app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import app.beans.Libreria;
import app.beans.Romanzo;
import app.beans.Saggio;

@Configuration
public class Config {
	
	@Bean
	public Libreria getLibreria() {
		return new Libreria();
	}
	
	@Bean
	public Romanzo getRomanzo() {
		return new Romanzo();
	}
	
	@Lazy
	@Bean
	public Saggio getSaggio() {
		return new Saggio();
	}

}

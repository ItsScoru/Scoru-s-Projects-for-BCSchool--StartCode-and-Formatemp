package libreria.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Lazy;

import libreria.beans.Libreria;
import libreria.beans.Libro;

@Configuration
public class Config {
	
	@Lazy
	@Bean(name = "saggio")
	public Libreria getLibroS(@Qualifier("saggio") Libro libro) {
		return new Libreria(libro);
	}
	
	@Bean(name = "romanzo")
	public Libreria getLibroR(@Qualifier("romanzo") Libro libro) {
		return new Libreria(libro);
	}
	
	@Lazy
	@Bean
	@Qualifier("saggio")
	public Libro getLibroS() {
		return new Libro("saggio");
	}
	
	@Bean
	@Qualifier("romanzo")
	public Libro getLibroR() {
		return new Libro("romanzo");
	}
	

}

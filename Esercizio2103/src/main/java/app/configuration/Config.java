package app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import app.beans.Ordinazione;

@Configuration
@Import(PizzeConfig.class)
public class Config {
	
	@Bean
	public Ordinazione ordinazione() {
		return new Ordinazione();
	}

}

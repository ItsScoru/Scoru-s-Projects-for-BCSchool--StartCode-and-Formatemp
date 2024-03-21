package app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import app.beans.Connessione;

@Configuration
public class ConnessioneConf {

	@Lazy
	@Bean(name = "base")
	public Connessione getConnessioneBase() {
		return new Connessione();
	}

	@Bean(name = "rapida")
	public Connessione getConnessioneRapida() {
		return new Connessione("velocissima");
	}

}

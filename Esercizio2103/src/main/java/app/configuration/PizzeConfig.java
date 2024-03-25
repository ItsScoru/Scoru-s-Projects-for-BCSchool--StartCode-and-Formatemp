package app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import app.beans.Pizza;

@Configuration
public class PizzeConfig {
	
	@Bean(name = "rossa")
	public Pizza getPizzaRossa() {
		return new Pizza();
	}
	
	@Lazy
	@Bean(name = "bianca")
	public Pizza getPizzaBianca() {
		return new Pizza();
	}

}
